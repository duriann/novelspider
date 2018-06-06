package novel.spider.util;

import novel.spider.NovelSiteEnum;
import novel.spider.impl.chapter.BxwxChapterSpider;
import novel.spider.impl.chapter.DefaultChapterDetailSpider;
import novel.spider.impl.chapter.DefaultChapterSpider;
import novel.spider.impl.novel.BxwxNovelSpider;
import novel.spider.impl.novel.DdxsNovelSpider;
import novel.spider.impl.novel.KanShuZhongNovelSpider;
import novel.spider.interfaces.IChapterDetailSpider;
import novel.spider.interfaces.IChapterSpider;
import novel.spider.interfaces.INovelSpider;

/**
 * 小说爬虫工厂类
 * @author pineapple
 * @time 2018年4月9日下午9:14:53
 */
public final class NovelSpiderFactory {
	private NovelSpiderFactory() {
	}
	/**
	 * 通过url返回特定的章节爬虫
	 * @param url
	 * @return
	 * 2018年4月9日下午9:15:23
	 */
	public static IChapterSpider getChapterSpider(String url){
		IChapterSpider chapterSpider = null;
		NovelSiteEnum siteEnum = NovelSiteEnum.getEnumByUrl(url);
		switch (siteEnum) {
		case BXWX:
			chapterSpider = new BxwxChapterSpider();
			break;
		default:
			chapterSpider = new DefaultChapterSpider();
			break;
		}
		return chapterSpider;
	}
	/**
	 * 通过url返回特定的章节详情爬虫
	 * @param url
	 * @return
	 * 2018年4月9日下午9:15:25
	 */
	public static IChapterDetailSpider getChapterDetailSpider(String url) {
		IChapterDetailSpider chapterDetailSpider = null;
		NovelSiteEnum siteEnum = NovelSiteEnum.getEnumByUrl(url);
		switch (siteEnum) {
		
		default:
			chapterDetailSpider = new DefaultChapterDetailSpider();
			break;
		}
		return chapterDetailSpider;
	}
	/**
	 * 通过url返回特定的小说爬虫
	 * @param url
	 * @return
	 * 2018年4月12日下午11:31:58
	 */
	public static INovelSpider getNovelSpider(String url) {
		NovelSiteEnum novelSiteEnum = NovelSiteEnum.getEnumByUrl(url);
		switch (novelSiteEnum) {
		case BXWX : return new BxwxNovelSpider();
		case KanShuZhong : return new KanShuZhongNovelSpider();
            case DingDianXiaoShuo:return new DdxsNovelSpider();
		default : throw new RuntimeException(url + "暂时不被支持");
		}
	}
}
