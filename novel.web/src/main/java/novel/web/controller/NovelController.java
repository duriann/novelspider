package novel.web.controller;

import novel.spider.entitys.Chapter;
import novel.spider.entitys.ChapterDetail;
import novel.spider.entitys.Novel;
import novel.web.constants.Constants;
import novel.web.entitys.JSONResponse;
import novel.web.entitys.Page;
import novel.web.entitys.User;
import novel.web.service.NovelService;
import novel.web.service.UserService;
import novel.web.utils.Base64Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("novel")
public class NovelController {

    @Autowired
    NovelService novelService;

    @Autowired
    UserService userService;
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
    @RequestMapping(value = "/searchByPage", method = RequestMethod.POST)
    @ResponseBody
    public JSONResponse searchByPage(String keyword,int currentPage,int pageSize) {
        Page<Novel> page = novelService.getNovelByPage(keyword,currentPage,pageSize);
        return JSONResponse.success(page);
    }


    /**
     *
     * @param page 页码
     * @param limit 每页显示条数
     * @return
     */
    @RequestMapping(value = "/getAllNovelByPage", method = RequestMethod.GET)
    @ResponseBody
    public JSONResponse getAllNovelByPage(int page, int limit) {
        Page<Novel> pages = novelService.getAllNovelByPage(page,limit);
        return JSONResponse.success(pages.getPages(),pages.getTotalCount());
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
        view.setViewName("novel/chapterList");
        view.addObject("chapters", chapters);
        view.addObject("chapterBase64Url", base64Url);
        view.addObject("isSuccess", isSuccess);
        //为了freemarker能调用base64util加密方法
        view.addObject("Base64Util", new Base64Util());
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
    public ModelAndView getChapterDetail(HttpServletRequest request,HttpServletResponse response, String url, String chapterBase64Url) {
        boolean isSuccess = false;
        ChapterDetail chapterDetail = null;
        //将前台传来的章节详情url解码
        url = Base64Util.decode(url);
        try {
            chapterDetail = novelService.getChapterDetail(url);
            chapterDetail.setPrev(Base64Util.encode(chapterDetail.getPrev()));
            chapterDetail.setNext(Base64Util.encode(chapterDetail.getNext()));
            Cookie lastReadChapterDetailUrl = new Cookie("lastReadChapterDetailUrl", Base64Util.encode(url));
            lastReadChapterDetailUrl.setPath("/");
            //设置cookie为一年
            lastReadChapterDetailUrl.setMaxAge(12*30*24*3600);
            Cookie lastReadChapterTitle = new Cookie("lastReadChapterTitle",Base64Util.encode(chapterDetail.getTitle()));
            lastReadChapterTitle.setPath("/");
            lastReadChapterTitle.setMaxAge(12*30*24*3600);
            User user = (User)request.getSession().getAttribute(Constants.CURRENT_USER);
            if (user!=null){
                user.setLastReadChapterDetailUrl(url);
                user.setLastReadChapterTitle(chapterDetail.getTitle());
                userService.update(user);
            }
            response.addCookie(lastReadChapterDetailUrl);
            response.addCookie(lastReadChapterTitle);
            isSuccess = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        ModelAndView view = new ModelAndView();
        view.setViewName("novel/chapterDetail");
        view.addObject("chapterDetail", chapterDetail);
        view.addObject("isSuccess", isSuccess);
        view.addObject("chapterBase64Url", chapterBase64Url);
        return view;
    }

    /**
     * 根据销售小说id删除小说
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteNovelById",method = RequestMethod.POST)
    @ResponseBody
    public JSONResponse deleteNovelById(long id){
        int i = novelService.deleteNovelById(id);
        if (i==1){
            return JSONResponse.success(null);
        }
        return JSONResponse.error("删除失败");
    }

    /**
     * 根据小说id修改对应小说的某个字段值
     * @param id 小说id
     * @param field 字段名
     * @param value 修改后的值
     * @return
     */
    @RequestMapping(value = "/updateNovelById",method = RequestMethod.POST)
    @ResponseBody
    public JSONResponse updateNovelById (long id,String field,String value){
        novelService.updateNovelById(id, field, value);
        return JSONResponse.success(null);
    }



}
