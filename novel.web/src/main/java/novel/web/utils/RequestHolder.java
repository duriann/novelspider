package novel.web.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取request
 * 通过spring mvc的method注入的request对象实际为MultipartHttpServletRequest
 * 而通过RequestHolder.getRequest()获取到的request对象却是org.apache.catalina.connector.RequestFacade的实例。
 * 当使用了文件上传，form表单的enctype类型为”multipart/form-data”，
 * spring mvc对文件上传的处理类实际却为spring-mvc.xml文件中配置的CommonsMultipartResolver，
 * 该类先判断当前请求是否为multipart类型，如果是的话，将request对象转为MultipartHttpServletRequet
 * 所以这时候需要直接将HttpServletRequest作为spring mvc的方法入参，即可以正确获取参数值
 */
public class RequestHolder {

    public static HttpServletRequest getRequest(){
        return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public static HttpServletResponse getResponse(){
        return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
    }
}
