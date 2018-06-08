package novel.web.aop;



import novel.web.annotation.SysLog;
import novel.web.constants.Constants;
import novel.web.dao.SystemLogDao;
import novel.web.entitys.SystemLog;
import novel.web.entitys.User;
import novel.web.service.UserService;
import novel.web.utils.HttpHeaderUtil;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.*;

@Order(2)
@Aspect
@Component
public class SysLogAop {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private LocalVariableTableParameterNameDiscoverer parameterNameDiscoverer = new LocalVariableTableParameterNameDiscoverer();

    @Resource
    private SystemLogDao systemLogDao;

    @Resource
    private UserService userService;

    @Pointcut("@annotation(novel.web.annotation.SysLog)")
    public void LogAspect() {
    }

    @AfterThrowing(pointcut = "LogAspect()", throwing = "e")
    public void doAfterThrowing(JoinPoint point, Throwable e) throws Exception {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes)ra;
        HttpServletRequest request = sra.getRequest();
        SystemLog systemLog = new SystemLog();
        Map<String, Object> map = this.getMethodDescription(point);
        systemLog.setModule(map.get("module").toString());
        systemLog.setMethod("<font color=\"red\">执行方法异常:-->" + map.get("methods").toString() + "</font>");
        systemLog.setStatusDesc("<font color=\"red\">执行方法异常:-->" + e + "</font>");
        systemLog.setArgs(map.get("args").toString());
        User user = (User)request.getSession().getAttribute(Constants.CURRENT_USER );
        systemLog.setUserId(user==null?-1:user.getId());
        systemLog.setUserNickname(user==null?"no user":user.getRealName());
        systemLog.setIp(HttpHeaderUtil.getIpAddress(request));
        systemLog.setCreateTime(new Date());
        systemLogDao.insert(systemLog);
    }

    @Around("LogAspect()")
    public Object doAround(ProceedingJoinPoint point) {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes)ra;
        HttpServletRequest request = sra.getRequest();
        Object result = null;
        try {
            result = point.proceed();
            SystemLog systemLog = new SystemLog();
            Map<String, Object> map = this.getMethodDescription(point);
            systemLog.setModule(map.get("module").toString());
            systemLog.setMethod(map.get("methods").toString());
            systemLog.setStatusDesc(map.get("description").toString());
            systemLog.setArgs(map.get("args").toString());
            systemLog.setUserId(((User)request.getSession().getAttribute(Constants.CURRENT_USER )).getId());
            systemLog.setUserNickname(((User)request.getSession().getAttribute(Constants.CURRENT_USER )).getRealName());
            systemLog.setIp(HttpHeaderUtil.getIpAddress(request));
            systemLog.setCreateTime(new Date());
            systemLogDao.insert(systemLog);
        } catch (Throwable e) {
            logger.error("异常信息:{}", e.getMessage());
            throw new RuntimeException(e);
        }
        return result;
    }

    @SuppressWarnings("rawtypes")
    public Map<String, Object> getMethodDescription(JoinPoint joinPoint) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class<?> targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        for (Method method : methods) {
            //如果targetName对应的类中的方法名跟注解标注的方法名一样
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    map.put("module", method.getAnnotation(SysLog.class).module());
                    map.put("methods", method.getAnnotation(SysLog.class).methods());
                    map.put("args", this.getArgs(method, arguments));
                    String desc = method.getAnnotation(SysLog.class).description();
                    if (StringUtils.isEmpty(desc))
                        desc = "执行成功!";
                    map.put("description", desc);
                    break;
                }
            }
        }
        return map;
    }

    private String getArgs(Method method, Object[] arguments) {
        StringBuilder builder = new StringBuilder("{");
        String params[] = parameterNameDiscoverer.getParameterNames(method);
        for (int i = 0; i < params.length; i++) {
                if(arguments[i].getClass().isArray()) {
                    arguments[i] = Arrays.toString(makeArrayObject(arguments[i]).toArray());
                }
                builder.append(params[i]).append(":").append(arguments[i]);
                if(i != params.length - 1) {
                    builder.append("; ");
                }
        }
        return builder.append("}").toString();
    }

    private List<Object> makeArrayObject(Object array) {
        List<Object> tem = new ArrayList<Object>();
        for (int i = 0; i < Array.getLength(array); i++) {
            tem.add(Array.get(array, i));
        }
        return tem;
    }
}