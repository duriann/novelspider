package novel.web.utils;

import javax.servlet.http.Cookie;

/**
 * Cookie帮助类
 * author:pineapple
 * time:20180531
 */
public class CookieUtil {
    /**
     * 根据name获取value
     * @param cookies
     * @param name
     * @return
     */
    public static String getCookieValue(Cookie[] cookies,String name){
        if (isNotEmptyCookie(cookies)){
            for (Cookie cookie:cookies){
                if (cookie.getName().equals(name)){
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    /**
     * 根据name获取cookie
     * @param cookies
     * @param name
     * @return
     */
    public static Cookie getCookie(Cookie[] cookies,String name){
        if(isNotEmptyCookie(cookies)){
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)){
                    return cookie;
                }
            }
        }
        return null;
    }
    /**
     * 判断cookie是否为空
     * @param cookies
     * @return
     */
    public static boolean isNotEmptyCookie(Cookie[] cookies){
        if (cookies==null || cookies.length==0){
            return false;
        }
        return true;
    }
}
