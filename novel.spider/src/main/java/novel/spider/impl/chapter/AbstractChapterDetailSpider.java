package novel.spider.impl.chapter;

import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import novel.spider.NovelSiteEnum;
import novel.spider.entitys.ChapterDetail;
import novel.spider.impl.AbstractSpider;
import novel.spider.interfaces.IChapterDetailSpider;
import novel.spider.util.NovelSpiderUtil;

public abstract class AbstractChapterDetailSpider extends AbstractSpider implements IChapterDetailSpider{
	
	@Override
	public ChapterDetail getChapterDetail(String url) {
		try {
			String result = super.crawl(url);
			//这边不能直接把<br>换成"\n" 因为jsoup解析的时候不认
			result = result.replace("&nbsp;", "  ").replace("<br />", "huanhang").replace("<br/>", "huanhang");
			Document doc = Jsoup.parse(result);
			doc.setBaseUri(url);
			Map<String, String> contexts = NovelSpiderUtil.getContext(NovelSiteEnum.getEnumByUrl(url));
			
			//拿标题内容
			String titleSelector = contexts.get("chapter-detail-title-selector");
			String[] splits = titleSelector.split("\\,");
			splits = parseSelector(splits);
			ChapterDetail detail = new ChapterDetail();
			detail.setTitle(doc.select(splits[0]).get(Integer.parseInt(splits[1])).text());
			
			//拿章节内容
			String contentSelector = contexts.get("chapter-detail-content-selector");
			//将前面的"huanhang"替换回真正的换行
			detail.setContent(doc.select(contentSelector).first().text().replace("huanhang", "\n"));
			
			//拿前一章的地址
			String prevSelector = contexts.get("chapter-detail-prev-selector");
			splits = prevSelector.split("\\,");
			splits = parseSelector(splits);
			detail.setPrev(doc.select(splits[0]).get(Integer.parseInt(splits[1])).absUrl("href"));
			
			//拿后一章的地址
			String nextSelector = contexts.get("chapter-detail-next-selector");
			splits = nextSelector.split("\\,");
			splits = parseSelector(splits);
			detail.setNext(doc.select(splits[0]).get(Integer.parseInt(splits[1])).absUrl("href"));
			
			return detail;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 处理具体元素的下标索引
	 */
	private String[] parseSelector(String[] splits) {
		String[] newSplits = new String[2];
		if (splits.length == 1) {
			newSplits[0] = splits[0];
			newSplits[1] = "0";
			return newSplits;
		} else {
			return splits;
		}
	}

}
