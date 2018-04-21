package ccc711.com;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import entitys.Picture;
import impl.AbstractSpider;
import interfaces.IPictureSpider;

public  class AvPictureSpider extends AbstractSpider implements IPictureSpider {

	public List<Picture> getsChapter(String url) {
		try {
			String result = crawl1(url);
			Document doc = Jsoup.parse(result,url);
			Elements elements = doc.select(".content").select("img");
			List<Picture> pictures = new ArrayList<>();
			for (Element element : elements) {
				Picture picture = new Picture();
				picture.setUrl(element.attr("src"));
				pictures.add(picture);
			}
			return pictures;
		} catch (Exception e) {
			throw new RuntimeException(e);
			//e.printStackTrace();
		}
	}

}
