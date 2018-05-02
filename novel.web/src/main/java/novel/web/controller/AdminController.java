package novel.web.controller;

import com.alibaba.fastjson.JSON;
import novel.web.Constants;
import novel.web.entitys.JSONResponse;
import novel.web.entitys.User;
import novel.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/index")
    public ModelAndView admin(){
        ModelAndView view = new ModelAndView();
        view.setViewName("admin/index");
        return view;

    }

    @RequestMapping(value = "/toLogin")
    public ModelAndView toLogin(){
        ModelAndView view = new ModelAndView();
        view.setViewName("admin/login");
        return view;

    }

    @RequestMapping(value = "/novelManager")
    public ModelAndView novelManager(){
        ModelAndView view = new ModelAndView();
        view.setViewName("admin/novel-manager");
        return view;

    }

    @RequestMapping(value = "/userManager")
    public ModelAndView userManager(){
        ModelAndView view = new ModelAndView();
        view.setViewName("admin/user-manager");
        return view;

    }

    @RequestMapping(value = "/home")
    public ModelAndView home(){
        ModelAndView view = new ModelAndView();
        view.setViewName("admin/home");
        return view;

    }

    /**
     * 登录
     * @param request
     * @param param
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public JSONResponse login(HttpServletRequest request, @RequestBody String param){
        Map obj = (Map)JSON.parse(param);
        User admin = new User();
        admin.setName((String) obj.get("username"));
        admin.setPassword((String) obj.get("password"));
        int status = userService.check(admin);
        if(status==1){
            request.getSession().setAttribute(Constants.CURRENT_USER,admin);
            return JSONResponse.success(admin,0);
        }
        return JSONResponse.error("登录失败");
    }

}
