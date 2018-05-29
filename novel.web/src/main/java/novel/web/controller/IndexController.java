package novel.web.controller;

import novel.web.constants.Constants;
import novel.web.entitys.User;
import novel.web.utils.Base64Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * 首页控制器
 */
@Controller
public class IndexController {
    /**
     * 首页
     * @param request
     * @return
     */
    @RequestMapping(value = "/")
    public ModelAndView index(HttpServletRequest request){
        ModelAndView view = new ModelAndView();
        Cookie[] cookies = request.getCookies();
        if (cookies!=null && cookies.length>0){
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("lastReadChapterDetailUrl")){
                    view.addObject("lastReadChapterDetailUrl",cookie.getValue());
                }
                if(cookie.getName().equals("lastReadChapterTitle")){
                    view.addObject("lastReadChapterTitle",cookie.getValue());
                }
            }
        }
        //为了freemarker能调用base64util加密方法
        view.addObject("Base64Util", new Base64Util());
        view.setViewName("index");
        return view;
    }

    /**
     * 后台管理首页
     * @param request
     * @return
     */
    @RequestMapping(value = "/admin/index")
    public ModelAndView admin(HttpServletRequest request){
        ModelAndView view = new ModelAndView();
        view.setViewName("admin/admin");
        User user = (User)request.getSession().getAttribute(Constants.CURRENT_USER);
        if(user!=null){
            view.addObject("user",user);
        }
        return view;

    }

    @RequestMapping(value = "/admin/toLogin")
    public ModelAndView toLogin(){
        ModelAndView view = new ModelAndView();
        view.setViewName("admin/login");
        return view;

    }

    @RequestMapping(value = "/admin/novelManager")
    public ModelAndView novelManager(){
        ModelAndView view = new ModelAndView();
        view.setViewName("admin/novel-manager");
        return view;

    }

    @RequestMapping(value = "/admin/userManager")
    public ModelAndView userManager(){
        ModelAndView view = new ModelAndView();
        view.setViewName("admin/user-manager");
        return view;

    }

    @RequestMapping(value = "/admin/spiderManager")
    public ModelAndView spiderManager(){
        ModelAndView view = new ModelAndView();
        view.setViewName("admin/spiderRule-manager");
        return view;
    }


    @RequestMapping(value = "/admin/home")
    public ModelAndView home(){
        ModelAndView view = new ModelAndView();
        view.setViewName("admin/home");
        return view;

    }

}
