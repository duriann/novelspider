package novel.storage.impl;

import novel.spider.NovelSiteEnum;
import novel.spider.entitys.Novel;
import novel.spider.interfaces.INovelSpider;
import novel.spider.util.NovelSpiderFactory;
import novel.storage.Processor;
import novel.storage.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public abstract class AbstractNovelStorage implements Processor {


    private static final Logger logger = LogManager.getLogger(AbstractNovelStorage.class.getName());
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	protected Map<String, String> tasks = new TreeMap<>();
	private static List<String> list;
	public AbstractNovelStorage() throws FileNotFoundException {

    }
    private String getfirstMapValue(Map<String,String> map){
        for (Entry<String, String> stringEntry : map.entrySet()) {
            return stringEntry.getValue();
        }
        return null;
    }
    /**
     * 根据action处理任务
     */
	public void process(String action,int maxTry) {

        String url = getfirstMapValue(tasks);
        if (url!=null){

            NovelSiteEnum novelSiteEnum = NovelSiteEnum.getEnumByUrl(url);
            Map<String,Integer> params = new HashMap<>();
            params.put("platformId",novelSiteEnum.getId());
            /*//如果是插入数据 就需要获取到全部小说(好像看书中网站有问题 以前完本的突然又变成连载)
            if (action.equals(Constants.update)&&novelSiteEnum.getId()!=4){
                //1 连载 2 完结
                params.put("status",1);
            }*/
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            list = sqlSession.selectList("selectByPlatformAndStatus",params);

        }
		ExecutorService service = Executors.newFixedThreadPool(tasks.size());
		List<Future<String>> futures = new ArrayList<>(tasks.size());
		for (Entry<String, String> entry : tasks.entrySet()) {
			final String key = entry.getKey();
			final String value = entry.getValue();
            NovelSiteEnum novelSiteEnum = NovelSiteEnum.getEnumByUrl(value);
            //判断是否是笔下文学
            boolean flag = NovelSiteEnum.BXWX.equals(novelSiteEnum)||NovelSiteEnum.KanShuZhong.equals(novelSiteEnum);

            futures.add(service.submit(new Callable<String> () {
				@Override
				public  String call() throws Exception {
					INovelSpider spider = NovelSpiderFactory.getNovelSpider(value);
					Iterator<List<Novel>> iterator = spider.iterator(value, 10);
					while (iterator.hasNext()) {
						logger.info("开始"+action+"[" + key + "] 的 URL:" + spider.next());
						int i=0;
						try {
							for (;i<maxTry;i++){
								List<Novel> novels = iterator.next();
                                SqlSession sqlSession = MybatisUtil.getSqlSession();
								if(action.equals("batchUpdate")){
                                    for (int n=novels.size()-1;n>=0;n--) {
                                        Novel item = novels.get(n);
                                        Date lastUpdateTime = item.getLastUpdateTime();
                                        Date today = new Date();
                                        logger.debug("list.contains(item) "+ list.contains(item));
                                        if (!list.contains(item.getUrl())){
                                            novels.remove(item);
                                            if(flag){
                                                item.setFirstLetter(key.charAt(0));//设置小说的名字的首字母
                                            }
                                            sqlSession.insert("insert",item);
                                        }
                                        if (lastUpdateTime.compareTo(sdf.parse(sdf.format(today)))!=0){
                                            novels.remove(item);
                                        }
                                    }
                                    logger.debug("novels:"+novels.toString());
                                    if(novels.size()>0){
                                        sqlSession.update(action,novels);
                                    }

								}
                                sqlSession.commit();
                                MybatisUtil.closeSqlSession();
								//Thread.sleep(1_000);
							}
						}catch (Exception e){
							e.printStackTrace();
							logger.error(iterator.next().get(i)+"尝试了"+i+"/"+maxTry+"次都失败了~");
						}

					}
					return key;
				}
				
			}));
		}
		service.shutdown();
		for (Future<String> future : futures) {
			try {
				logger.info(""+action+"[" + future.get() + "]结束！");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
