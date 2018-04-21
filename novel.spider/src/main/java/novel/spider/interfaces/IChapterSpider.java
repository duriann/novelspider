package novel.spider.interfaces;

import java.util.List;

import novel.spider.entitys.Chapter;

public interface IChapterSpider {
	public List<Chapter> getsChapter(String url);
}
