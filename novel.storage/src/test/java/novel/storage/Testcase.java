package novel.storage;

import novel.storage.impl.BxwxNovelStorageImpl;
import novel.storage.impl.DdxsNovelStorageImpl;
import novel.storage.impl.KanShuZhongNovelStorageImpl;
import novel.storage.utils.Constants;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Testcase {
    public String insert = "batchInsert";
    public String update = "batchUpdate";

    @Test
    public void testNovelList(){
        List<String> novels = new ArrayList<>();
        novels.add("http://www.kanshuzhong.com/book/119978/");
        String s1 = "http://www.kanshuzhong.com/book/119978/";
        System.out.println("novels.contains(n2) = " + novels.contains(s1));
    }
    
    @Test
    public void testSelectByPlatformAndStatus () throws Exception {
        SqlSession session = new SqlSessionFactoryBuilder().build(getClass().getClassLoader().getResourceAsStream("conf/SqlMapConfig.xml")).openSession();
        Map<String,String> params = new HashMap<>();
        params.put("platformId","4");
        List<String> list = session.selectList("selectByPlatformAndStatus", params);
        System.out.println("list.subList(0,10) = " + list.subList(0,10));

        System.out.println("list.contains(novel) = " + list.contains("http://www.kanshuzhong.com/book/119978/"));
    }



    /**
     * 测试mybatis连接是否正常
     * @throws Exception
     */
    @Test
	public void testMybatisConnection () throws Exception {
		SqlSession session = new SqlSessionFactoryBuilder().build(getClass().getClassLoader().getResourceAsStream("conf/SqlMapConfig.xml")).openSession();
		System.out.println(session);
	}

    /**
     * 抓取看书中小说
     * @throws Exception
     */
	@Test
	public void testKanShuZhongProcess() throws Exception {
		Processor processor = new KanShuZhongNovelStorageImpl();
		processor.process(insert,5);
	}

    /**
     * 抓取顶点小说
     * @throws FileNotFoundException
     */
    @Test
    public void testDdxsProcess() throws FileNotFoundException {
        Processor processor = new DdxsNovelStorageImpl();
        processor.process(insert,5);
    }
    /**
     * 抓取笔下文学小说
     * @throws FileNotFoundException
     */
	@Test
	public void testBxwxProcess() throws FileNotFoundException {
		Processor processor = new BxwxNovelStorageImpl();
		processor.process(insert,5);
	}

    /**
     * 更新笔下文学小说 20180428 15:30 好像网站挂了 更新失败
     * 20180612 10:50 被网站屏蔽了
     * 20180619 15.02 发现又能访问了
     * @throws FileNotFoundException
     */
    @Test
	public void updateBxwxProcess() throws FileNotFoundException {
	    Processor processor = new BxwxNovelStorageImpl();
	    processor.process(update,5);
    }

    /**
     * 更新看书中小说
     * @throws FileNotFoundException
     */
    @Test
    public void updateKanShuZhongProcess() throws FileNotFoundException {
        Processor processor = new KanShuZhongNovelStorageImpl();
        processor.process(Constants.update,5);
    }

    /**
     * 更新顶点小说
     * @throws FileNotFoundException
     */
    @Test
    public void updateDdxs() throws FileNotFoundException {
        Processor processor = new DdxsNovelStorageImpl();
        processor.process(update,5);
    }
}
