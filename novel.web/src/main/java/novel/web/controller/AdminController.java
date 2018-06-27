package novel.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import novel.web.annotation.Auth;
import novel.web.constants.Constants;
import novel.web.entitys.JSONResponse;
import novel.web.entitys.Page;
import novel.web.entitys.Token;
import novel.web.entitys.User;
import novel.web.service.UserService;
import novel.web.utils.RedisTokenManager;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private RedisTokenManager tokenManager;

    /**
     * 登录
     * @param request
     * @param param
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public JSONResponse login(HttpServletRequest request, HttpServletResponse response,@RequestBody String param){
        Map obj = (Map)JSON.parse(param);
        User user = new User();
        String md5Pwd = DigestUtils.md5Hex((String) obj.get("password")+(String) obj.get("username"));
        user.setName((String)obj.get("username"));
        user.setPassword(md5Pwd);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getName(), user.getPassword());
        try {
            subject.login(usernamePasswordToken);
            request.getSession().setAttribute(Constants.CURRENT_USER,user);
            String isRemember = obj.get("rememberMe")==null?"false":(String) obj.get("rememberMe");
            if (isRemember.equalsIgnoreCase("true")){
                User u = (User) subject.getPrincipal();
                System.out.println("u = " + u);
                Token token = tokenManager.createToken(u.getId());
                Cookie tk = new Cookie("token", token.getToken());
                tk.setPath("/");
                tk.setMaxAge(Constants.DEFAULT_EXPIRES_HOUR);
                response.addCookie(tk);
            }
            return JSONResponse.success(user,0);
        }catch (Exception e){
            return JSONResponse.error("登录失败");
        }

    }

    /**
     * 退出
     * @param request
     * @return
     */
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request,HttpServletResponse response){
        ModelAndView view = new ModelAndView();
        User user = (User)request.getSession().getAttribute(Constants.CURRENT_USER);
        userService.logout(user);
        view.setViewName("redirect:/");
        return view;
    }

    /**
     * 分页获取所有用户
     * @param page 页码
     * @param limit 每页显示条数
     * @return
     */
    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    @ResponseBody
    @Auth
    public JSONResponse getAllUserByPage(int page, int limit) {
        Page<User> pages = userService.getAllUser(page,limit);
        return JSONResponse.success(pages.getPages(),pages.getTotalCount());
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteUserById",method = RequestMethod.POST)
    @ResponseBody
    @Auth
    public JSONResponse deleteUserById(@RequestParam("id")long id){
        User user = userService.getUserById(id);
        if (user!=null){
            userService.delete(user);
            return JSONResponse.success(user);
        }
        return JSONResponse.error("删除失败");

    }

    /**
     * 更新用户
     * @param param
     * @return
     */
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    @ResponseBody
    @Auth
    public JSONResponse updateUser(@RequestParam("param")String param){
        System.out.println("param = " + param);
        JSONObject obj = JSONObject.parseObject(param);
        long id = obj.getLong("id");
        String name = obj.getString("name");
        String password = obj.getString("password");
        User user = new User(id,name,password);
        try {
            userService.update(user);
        }catch (Exception e){
            return JSONResponse.error("更新失败。");
        }
        return JSONResponse.success(user);
    }
}
