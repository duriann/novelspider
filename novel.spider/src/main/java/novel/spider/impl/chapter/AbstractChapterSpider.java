package novel.spider.impl.chapter;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import novel.spider.NovelSiteEnum;
import novel.spider.entitys.Chapter;
import novel.spider.impl.AbstractSpider;
import novel.spider.interfaces.IChapterSpider;
import novel.spider.util.NovelSpiderUtil;

/**
 * 章节爬虫
 * @author pineapple
 * @time 2018年4月7日下午4:40:11
 */
public abstract class AbstractChapterSpider extends AbstractSpider implements IChapterSpider {
	
	@Override
	public List<Chapter> getsChapter(String url) {
		try {
			String result = super.crawl(url);
			Document doc = Jsoup.parse(result,url);
			Elements elements = doc.select(NovelSpiderUtil.getContext(NovelSiteEnum.getEnumByUrl(url)).get("chapter-list-selector"));
			List<Chapter> chapters = new ArrayList<>();
			for (Element a : elements) {
				Chapter chapter = new Chapter();
				chapter.setTitle(a.text());
				chapter.setUrl(a.absUrl("href"));
				chapters.add(chapter);
			}
			return chapters;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
