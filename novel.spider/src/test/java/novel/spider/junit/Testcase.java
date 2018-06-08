package novel.spider.junit;


import net.sf.json.JSON;
import net.sf.json.xml.XMLSerializer;
import novel.spider.NovelSiteEnum;
import novel.spider.config.Configuration;
import novel.spider.entitys.Chapter;
import novel.spider.entitys.ChapterDetail;
import novel.spider.entitys.Novel;
import novel.spider.impl.chapter.DefaultChapterDetailSpider;
import novel.spider.impl.chapter.DefaultChapterSpider;
import novel.spider.impl.download.NovelDownload;
import novel.spider.impl.novel.BxwxNovelSpider;
import novel.spider.interfaces.IChapterDetailSpider;
import novel.spider.interfaces.IChapterSpider;
import novel.spider.interfaces.INovelDownload;
import novel.spider.interfaces.INovelSpider;
import novel.spider.util.FileUtil;
import novel.spider.util.NovelSpiderUtil;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Testcase {


	@Test
	public void testXML2Json() throws Exception {
		XMLSerializer serializer = new XMLSerializer();
		String xml = FileUtil.file2String("conf/Spider-Rule.xml");
		JSON read = serializer.read(xml);
		System.out.println("read = " + read);
	}
	
	//测试瞎说爬虫能抓下一页小说
	@Test
	public void testNovelSpiderIterator(){
		INovelSpider novelSpider = new BxwxNovelSpider();
		Iterator<List<Novel>> iterator = novelSpider.iterator("https://www.bxwx9.org/binitialM/0/1.htm", 5);
		
		while(iterator.hasNext()){
			List<Novel> next = iterator.next();
			System.out.println(next);
		}
		
		
		
	}

	//测试文件合并
	@Test
	public void testMergeMutilFile(){
		NovelSpiderUtil.mergeMultiFile("D:\\1\\bxwx9.org", null);
	}
	
	//测试下载小说
	@Test
	public void testDownload(){
		INovelDownload download = new NovelDownload();
		download.download("https://www.bxwx9.org/b/6/6347/index.html", new Configuration("d://1",100));
	}
    //测试顶点小说爬虫
    @Test
    public void testNovelSpider(){
        INovelSpider novelSpider = new BxwxNovelSpider();
        List<Novel> novels = novelSpider.getsNovel("http://www.23wx.cc/quanben/1",5);
        for (Novel novel : novels) {
            System.out.println(novel);
        }
    }

	//测试顶点小说章节详情爬取
	@Test
	public void testGetChapterDetail() {
		IChapterDetailSpider spider = new DefaultChapterDetailSpider();
		System.out.println(spider.getChapterDetail("http://www.23wx.cc/du/54/54407/298727.html"));
	}

	//测试顶点小说网章节爬取
	@Test
	public void testGetChapterSpider(){
		IChapterSpider spider = new DefaultChapterSpider();
		List<Chapter> chapters = spider.getsChapter("http://www.23wx.cc/du/54/54407/");
		for(int i = 0;i<chapters.size();i++){
			System.out.println("i:"+i+"--"+chapters.get(i));
		}

	}
	//测试笔趣阁网章节爬取
	@Test
	public void testBQGChapterSpider(){
		IChapterSpider spider = new DefaultChapterSpider();
		List<Chapter> chapters = spider.getsChapter("https://www.xs.la/0_233333/");
		for(int i = 0;i<chapters.size();i++){
			System.out.println("i:"+i+"--"+chapters.get(i));
		}

	}//测试笔趣阁网章节详情爬取
	@Test
	public void testBQGChapterDetailSpider(){
		IChapterDetailSpider spider = new DefaultChapterDetailSpider();
		ChapterDetail detail = spider.getChapterDetail("https://www.xs.la/233_233333/1269793.html");

			System.out.println(detail);

	}
	
	@Test
	public void testNovelSpiderUtil(){
		Map<String, String> context = NovelSpiderUtil.getContext(NovelSiteEnum.getEnumByUrl("www.bxwx9.org/b/58/58522/index.html"));
		Set<Entry<String,String>> entrySet = context.entrySet();
		for (Entry<String, String> entry : entrySet) {
			String name = entry.getKey();
			String value = entry.getValue();
			System.out.println("name:"+name+",value:"+value);
		}
	}
}
