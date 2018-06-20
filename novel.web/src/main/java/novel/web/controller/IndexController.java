package novel.web.controller;

import novel.web.annotation.Auth;
import novel.web.constants.Constants;
import novel.web.entitys.Token;
import novel.web.entitys.User;
import novel.web.service.UserService;
import novel.web.utils.Base64Util;
import novel.web.utils.CookieUtil;
import novel.web.utils.RedisTokenManager;
import novel.web.utils.RedisUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 首页控制器
 */
@Controller
public class IndexController {
    @Autowired
    private RedisTokenManager manager;
    @Autowired
    private UserService userService;
    @Autowired
    private RedisUtil redisUtil;
    /**
     * 首页
     * @param request
     * @return
     */
    @RequestMapping(value = "/")
    public ModelAndView index(HttpServletRequest request){
        ModelAndView view = new ModelAndView();
        Cookie[] cookies = request.getCookies();
        if (CookieUtil.isNotEmptyCookie(cookies)){
            //获取客户端的readCookie
            Cookie readCookie = CookieUtil.getCookie(cookies,"rc");
            if (readCookie!=null){
                String readToken = readCookie.getValue();
                //从redis中获取对应token数据
                List<Object> list = redisUtil.lGet(readToken, 0, redisUtil.lGetListSize(readToken));
                if(list!=null){
                    view.addObject("lastReadChapterDetailUrl",list.get(0));
                    view.addObject("lastReadChapterTitle",list.get(1));
                }
            }
        }
        String token = CookieUtil.getCookieValue(cookies,"token");
        Token model = manager.getToken(token);
        if(manager.checkToken(model)){
            User user = userService.getUserById(model.getUser_id());
            if (user!=null){
                SecurityUtils.getSubject().login(new UsernamePasswordToken(user.getName(),user.getPassword()));
                request.getSession().setAttribute(Constants.CURRENT_USER,user);
                view.addObject("user",user);
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
    @Auth
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
    @Auth
    public ModelAndView novelManager(){
        ModelAndView view = new ModelAndView();
        view.setViewName("admin/novel-manager");
        return view;

    }

    @RequestMapping(value = "/admin/userManager")
    @Auth
    public ModelAndView userManager(){
        ModelAndView view = new ModelAndView();
        view.setViewName("admin/user-manager");
        return view;

    }

    @RequestMapping(value = "/admin/spiderManager")
    @Auth
    public ModelAndView spiderManager(){
        ModelAndView view = new ModelAndView();
        view.setViewName("admin/spiderRule-manager");
        return view;
    }


    @RequestMapping(value = "/admin/home")
    @Auth
    public ModelAndView home(){
        ModelAndView view = new ModelAndView();
        view.setViewName("admin/home");
        return view;

    }

}
