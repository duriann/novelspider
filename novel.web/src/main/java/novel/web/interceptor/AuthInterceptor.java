package novel.web.interceptor;

import novel.web.annotation.Auth;
import novel.web.constants.Constants;
import novel.web.entitys.Token;
import novel.web.entitys.User;
import novel.web.service.UserService;
import novel.web.utils.CookieUtil;
import novel.web.utils.RedisTokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 管理员登录拦截器
 */
public class AuthInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisTokenManager manager;
    @Autowired
    private UserService userService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Auth拦截器...");
        //如果不是映射到方法直接通过,比如随便输入一个/admin/dadasdas
        if (!(handler instanceof HandlerMethod)) {
            System.out.println("不是映射到方法:"+handler);
            return true;
        }
        Object user = request.getSession().getAttribute(Constants.CURRENT_USER );
        if (user==null){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            //从cookie中得到token
            String authorization = CookieUtil.getCookieValue(request.getCookies(),"token");
           if (authorization==""||"".equals(authorization)||authorization==null){
                response.sendRedirect("/admin/toLogin");
                return false;
           }
            //验证token
            Token model = manager.getToken(authorization);
            if (manager.checkToken(model)) {
                //如果token验证成功，将token对应的用户id存在request中，便于之后注入
                User current_user = userService.getUserById(model.getUser_id());
                request.getSession().setAttribute(Constants.CURRENT_USER,current_user);
                return true;
            }
            //如果验证token失败，并且方法注明了Authorization，返回401错误
            if (method.getAnnotation(Auth.class) != null) {
                System.out.println("method.getAnnotation(Auth.class) = " + method.getAnnotation(Auth.class));
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
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
