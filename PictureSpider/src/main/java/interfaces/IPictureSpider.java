package interfaces;

import java.util.List;

import entitys.Picture;

public interface IPictureSpider {
	/**
	 * 给我们一个完整的图片文章url地址 返回所有的图片
	 * @param url
	 * @return
	 * 2016年10月16日下午2:16:21
	 */
	public List<Picture> getsChapter(String url);
}
