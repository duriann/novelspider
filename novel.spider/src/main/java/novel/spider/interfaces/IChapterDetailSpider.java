package novel.spider.interfaces;

import novel.spider.entitys.ChapterDetail;

public interface IChapterDetailSpider {
	/**
	 * 根据章节url返回对应章节内容
	 * @param url
	 * @return
	 */
	public ChapterDetail getChapterDetail(String url);
}
