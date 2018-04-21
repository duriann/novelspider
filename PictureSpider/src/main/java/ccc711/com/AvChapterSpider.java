package ccc711.com;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import entitys.Chapter;
import impl.AbstractSpider;
import interfaces.IChapterSpider;

public  class AvChapterSpider extends AbstractSpider implements IChapterSpider {

	

	public List<Chapter> getsChapter(String url) {
		try {
			String result = crawl1(url);
			Document doc = Jsoup.parse(result,url);
			Elements elements = doc.select(".channel").select("ul").select("li");
			List<Chapter> chapters = new ArrayList<>();
			
			for (Element element : elements) {
				Chapter chapter = new Chapter();
				chapter.setTitle(element.select("a").text());
				chapter.setUrl(element.select("a").attr("abs:href"));
				chapters.add(chapter);
			}
			return chapters;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
