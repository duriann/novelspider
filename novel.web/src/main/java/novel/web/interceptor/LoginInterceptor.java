package novel.web.interceptor;

import novel.web.constants.Constants;
import novel.web.entitys.User;
import novel.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * 管理员登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private UserService userService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        Object user = request.getSession().getAttribute(Constants.Sys_USER );
        if (user==null){
            Cookie[] cookies = request.getCookies();
            if (cookies.length>0&&hasCookie(cookies,"username")&&hasCookie(cookies,"password")){
                String cname = "";
                String cpwd = "";
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("username")){
                        cname = cookie.getValue();
                    }
                    if (cookie.getName().equals("password")){
                        cpwd = cookie.getValue();
                    }
                }
                User cookieUser = new User(cname,cpwd);
                User check = userService.check(cookieUser);
                if (check!=null){
                    request.getSession().setAttribute(Constants.Sys_USER,check);
                    return true;
                }else{
                    response.sendRedirect("/admin/toLogin");
                    return false;
                }
            }else {
                response.sendRedirect("/admin/toLogin");
                return false;
            }

        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    /**
     * 判断是否存在cookie
     * @param cookies
     * @param key
     * @return
     */
    private boolean hasCookie(Cookie[] cookies,String key){
        for (Cookie cookie : cookies) {
            if (cookie.getName().equalsIgnoreCase(key)){
                return true;
            }
        }
        return false;
    }
}
