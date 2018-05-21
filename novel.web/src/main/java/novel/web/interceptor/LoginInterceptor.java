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
            String cname = "";
            String cpwd = "";
            Cookie[] cookies = request.getCookies();
            if (cookies.length>0){
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("username")){
                        cname = cookie.getValue();
                    }
                    if (cookie.getName().equals("password")){
                        cpwd = cookie.getValue();
                    }
                }
            }
            int check = userService.check(new User(cname,cpwd));
            if (check==1){
                return true;
            }else{
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
}
