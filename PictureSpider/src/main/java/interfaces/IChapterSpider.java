package interfaces;

import java.util.List;

import entitys.Chapter;

public interface IChapterSpider {
	/**
	 * 给我们一个url地址 返回所有的图片文章列表
	 * @param url
	 * @return
	 * 2016年10月16日下午2:16:21
	 */
	public List<Chapter> getsChapter(String url);
}
