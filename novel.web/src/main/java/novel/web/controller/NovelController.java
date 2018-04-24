package novel.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import novel.spider.entitys.Chapter;
import novel.spider.entitys.ChapterDetail;
import novel.spider.interfaces.IChapterDetailSpider;
import novel.spider.interfaces.IChapterSpider;
import novel.spider.util.NovelSpiderFactory;
import novel.web.entitys.JSONResponse;

@Controller
public class NovelController {
	
	@RequestMapping(value = "/chapters.action", method = RequestMethod.GET)
	@ResponseBody
	public JSONResponse getsChapter(String url) {
		IChapterSpider spider = NovelSpiderFactory.getChapterSpider(url);
		List<Chapter> chapters = spider.getsChapter(url);
		return JSONResponse.success(chapters);
	}
	
	@RequestMapping(value = "/chapterDetail.action", method = RequestMethod.GET)
	@ResponseBody
	public JSONResponse getChapterDetail(String url) {
		IChapterDetailSpider spider = NovelSpiderFactory.getChapterDetailSpider(url);
		ChapterDetail detail = spider.getChapterDetail(url);
		return JSONResponse.success(detail);
	}
}
