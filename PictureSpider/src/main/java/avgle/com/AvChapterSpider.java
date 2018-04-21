package avgle.com;

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
			Elements elements = doc.select(".col-sm-6.col-md-4.col-lg-4");
			List<Chapter> chapters = new ArrayList<>();
			
			for (Element element : elements) {
				Chapter chapter = new Chapter();
				chapter.setTitle(element.select("a").select("span").eq(1).text());
				chapter.setUrl(element.select("a").attr("abs:href"));
				chapter.setTorrentImgUrl(element.select("img").attr("src"));
				chapters.add(chapter);
			}
			
			return chapters;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
	
}
