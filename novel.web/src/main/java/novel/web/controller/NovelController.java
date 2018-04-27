package novel.web.controller;

import novel.spider.entitys.Chapter;
import novel.spider.entitys.ChapterDetail;
import novel.spider.entitys.Novel;
import novel.spider.interfaces.IChapterDetailSpider;
import novel.spider.interfaces.IChapterSpider;
import novel.spider.util.NovelSpiderFactory;
import novel.web.entitys.JSONResponse;
import novel.web.entitys.Page;
import novel.web.service.NovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("novel")
public class NovelController {

    @Autowired
    NovelService novelService;

    @RequestMapping(value = "/test/chapters", method = RequestMethod.GET)
    @ResponseBody
    public JSONResponse getsChapter(String url) {
        IChapterSpider spider = NovelSpiderFactory.getChapterSpider(url);
        List<Chapter> chapters = spider.getsChapter(url);
        return JSONResponse.success(chapters);
    }

    @RequestMapping(value = "/test/chapterDetail", method = RequestMethod.GET)
    @ResponseBody
    public JSONResponse getChapterDetail2(String url) {
        IChapterDetailSpider spider = NovelSpiderFactory.getChapterDetailSpider(url);
        ChapterDetail detail = spider.getChapterDetail(url);
        return JSONResponse.success(detail);
    }

    /**
     * 根据关键词查找小说
     * @param keyword
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public JSONResponse search(String keyword) {
        List<Novel> novels = novelService.getsNovelByKeyword(keyword);
        return JSONResponse.success(novels);
    }

    /**
     * 根据关键词分页查找小说
     * @param keyword
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public JSONResponse searchByPage(String keyword,int currentPage,int pageSize) {
        Page<Novel> novels = novelService.getNovelByPage(keyword,currentPage,pageSize);
        return JSONResponse.success(novels);
    }

    /**
     * 根据base64编码过的url查找小说章节
     *
     * @param base64Url
     * @return
     */
    @RequestMapping(value = "/getChapters", method = RequestMethod.GET)
    public ModelAndView getChapters(String base64Url) {
        List<Chapter> chapters = null;
        boolean isSuccess = false;
        try {
            chapters = novelService.getChapters(base64Url);
            isSuccess = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        ModelAndView view = new ModelAndView();
        view.setViewName("chapterList");
        view.addObject("chapters", chapters);
        view.addObject("chapterBase64Url", base64Url);
        view.addObject("isSuccess", isSuccess);
        return view;
    }

    /**
     * 根据章节url查找对应章节内容
     *
     * @param url              章节url
     * @param chapterBase64Url 返回章节列表
     * @return
     */
    @RequestMapping("getChapterDetail")
    public ModelAndView getChapterDetail(String url, String chapterBase64Url) {
        boolean isSuccess = false;
        ChapterDetail chapterDetail = null;
        try {
            chapterDetail = novelService.getChapterDetail(url);
            isSuccess = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        ModelAndView view = new ModelAndView();
        view.setViewName("chapterDetail");
        view.addObject("chapterDetail", chapterDetail);
        view.addObject("isSuccess", isSuccess);
        view.addObject("chapterBase64Url", chapterBase64Url);
        return view;
    }

}