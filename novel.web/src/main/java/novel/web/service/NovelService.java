package novel.web.service;

import novel.spider.entitys.Chapter;
import novel.spider.entitys.ChapterDetail;
import novel.spider.entitys.Novel;
import novel.web.entitys.Page;

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
     * 根据关键词分页查找小说
     * @param keyword
     * @param currentPage
     * @param pageSize
     * @return
     */
    public Page<Novel> getNovelByPage(String keyword, int currentPage, int pageSize);
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

	/**
	 *  分页返回小说
	 * @param page
	 * @param limit
	 * @return
	 */
	public Page<Novel> getAllNovelByPage(String keyword,int page, int limit);

    /**
     * 根据小说id删除对应的小说
     * @param id
     * @return
     */
    public int deleteNovelById(long id);

    public int updateNovelById(long id,String field,String value);

    public List<String> searchLikeByKey(String keyword);

    /**
     * 获取热搜词
     * @return
     */
    public List<Novel> getHotNovel();
}
