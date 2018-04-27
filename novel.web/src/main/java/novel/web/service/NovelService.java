package novel.web.service;

import novel.spider.entitys.Chapter;
import novel.spider.entitys.ChapterDetail;
import novel.spider.entitys.Novel;

import java.util.List;

public interface NovelService {
	/**
	 * 通过查询关键词，去数据库中查询结果，然后返回想要的内容
	 * @param keyword
	 * @return
	 */
	public List<Novel> getsNovelByKeyword(String keyword);
	/**
	 * 查找对应平台下面的小说
	 * @param keyword
	 * @param platformId
	 * @return
	 */
	public List<Novel> getsNovelByKeyword(String keyword, int platformId);

    /**
     * 根据小说url查找所有章节
     * @param base64Url
     * @return
     */
	public List<Chapter> getChapters(String base64Url);

    /**
     * 根据章节url返回章节详情
     * @param url
     * @return
     */
	public ChapterDetail getChapterDetail(String url);
}
