package novel.web.controller;

import novel.spider.entitys.Chapter;
import novel.spider.entitys.ChapterDetail;
import novel.spider.entitys.Novel;
import novel.spider.interfaces.IChapterDetailSpider;
import novel.spider.interfaces.IChapterSpider;
import novel.spider.util.NovelSpiderFactory;
import novel.web.entitys.JSONResponse;
import novel.web.service.NovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/novel")
public class NovelController {

    @Autowired
	NovelService novelService;

	@RequestMapping(value = "/test/chapters.action", method = RequestMethod.GET)
	@ResponseBody
	public JSONResponse getsChapter(String url) {
		IChapterSpider spider = NovelSpiderFactory.getChapterSpider(url);
		List<Chapter> chapters = spider.getsChapter(url);
		return JSONResponse.success(chapters);
	}
	
	@RequestMapping(value = "/test/chapterDetail.action", method = RequestMethod.GET)
	@ResponseBody
	public JSONResponse getChapterDetail(String url) {
		IChapterDetailSpider spider = NovelSpiderFactory.getChapterDetailSpider(url);
		ChapterDetail detail = spider.getChapterDetail(url);
		return JSONResponse.success(detail);
	}

	@RequestMapping(value = "/search.action",method = RequestMethod.POST)
    @ResponseBody
	public JSONResponse search(String keyword){
        List<Novel> novels = novelService.getsNovelByKeyword(keyword);
        return JSONResponse.success(novels);
    }

    @RequestMapping(value = "/getChapters.action",method = RequestMethod.GET)
    public ModelAndView getChapters(String base64Url){
        List<Chapter> chapters = null;
        boolean isSuccess = false;
        try {
            chapters  = novelService.getChapters(base64Url);
            isSuccess = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        ModelAndView view = new ModelAndView();
        view.setViewName("chapterList");
        view.addObject("chapters",chapters);
        view.addObject("chapterBase64Url", base64Url);
        view.addObject("isSuccess",isSuccess);

        return view;
    }

}
