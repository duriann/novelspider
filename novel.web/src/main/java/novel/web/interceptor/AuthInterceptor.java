package novel.web.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import novel.web.annotation.Auth;
import novel.web.constants.Constants;
import novel.web.entitys.JSONResponse;
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
            return true;
        }
        Object user = request.getSession().getAttribute(Constants.CURRENT_USER );
        if (user==null){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            //从cookie中得到token
            String authorization = CookieUtil.getCookieValue(request.getCookies(),"token");

            //验证token
            Token model = manager.getToken(authorization);
            if (manager.checkToken(model)) {
                //如果token验证成功，将token对应的用户存在request中，便于之后注入
                User current_user = userService.getUserById(model.getUser_id());
                request.getSession().setAttribute(Constants.CURRENT_USER,current_user);
                return true;
            }
            //如果验证token失败，并且方法注明了Authorization，返回401错误
            Auth auth = method.getAnnotation(Auth.class);
            if (auth != null) {
                response.setCharacterEncoding("utf-8");
                response.setContentType("application/json; charset=utf-8");
                response.getWriter().print(JSON.toJSONString(JSONResponse.error(-1,"没有权限!")));
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
