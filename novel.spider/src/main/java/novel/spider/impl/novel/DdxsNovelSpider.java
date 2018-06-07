package novel.spider.impl.novel;

import novel.spider.NovelSiteEnum;
import novel.spider.entitys.Chapter;
import novel.spider.entitys.Novel;
import novel.spider.util.NovelSpiderFactory;
import novel.spider.util.NovelSpiderUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * 顶点小说网站的书籍列表爬取
 */
public class DdxsNovelSpider extends AbstractNovelSpider {
    private static final Logger logger = LogManager.getLogger(DdxsNovelSpider.class.getName());

    public DdxsNovelSpider() {}

	@Override
	public List<Novel> getsNovel(String url, Integer maxTryTimes) {
        logger.info("DdxsNovelSpider开始 "+url);
		List<Novel> novels = new ArrayList<>();
		try {
			Elements trs = super.getsTr(url, maxTryTimes);
			for (int index = 1, size = trs.size(); index < size; index++) {
				Element tr = trs.get(index);
				Elements tds = tr.getElementsByTag("td");
				Novel novel = new Novel();
				novel.setName(tds.first().text());
				String novelUrl = tds.first().getElementsByTag("a").first().absUrl("href").replace(".htm", "/").replace("/binfo/", "/b/");
				novel.setUrl(novelUrl);
				novel.setLastUpdateChapter(tds.get(1).text());
                novel.setLastUpdateChapterUrl(tds.get(1).getElementsByTag("a").first().absUrl("href"));
                if (!novel.getLastUpdateChapterUrl().endsWith(".html")){
                    //最后更新章节url其实是章节列表url
                    String lastUpdateChapterUrl = tds.get(1).getElementsByTag("a").first().absUrl("href");
                    //获取当前小说章节列表
                    List<Chapter> chapters = NovelSpiderFactory.getChapterSpider(url).getsChapter(lastUpdateChapterUrl);
                    //获取章节列表最后一个章节的url并且设置
                    novel.setLastUpdateChapterUrl(chapters.get(chapters.size()-1).getUrl());
                }
				novel.setAuthor(tds.get(2).text());
				novel.setLastUpdateTime(NovelSpiderUtil.getDate(tds.get(4).text(), "yy-MM-dd"));//2016-10-14 yyyy-MM-dd
				novel.setStatus(NovelSpiderUtil.getNovelStatus(tds.get(5).text()));
				novel.setPlatformId(NovelSiteEnum.getEnumByUrl(url).getId());
				novels.add(novel);
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return novels;
	}
}
