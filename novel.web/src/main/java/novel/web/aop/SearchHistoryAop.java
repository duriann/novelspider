package novel.web.aop;



import novel.web.dao.SearchHistoryDao;
import novel.web.entitys.SearchHistory;
import novel.web.utils.HttpHeaderUtil;
import novel.web.utils.RequestHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Order(2)
@Aspect
@Component
public class SearchHistoryAop {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private SearchHistoryDao searchHistoryDao;

    @Pointcut("execution(* novel.web.service.impl.NovelServiceImpl.getNovelByPage(*,*,*))")
    public void LogAspect() {
    }

    @After("LogAspect()")
    public void doafter(JoinPoint point) {
        //获取方法参数
        Object[] args = point.getArgs();
        String keyword = (String)args[0];
        SearchHistory history = searchHistoryDao.getByKeyword(keyword);
        if (history!=null){
            searchHistoryDao.updateByKeyword(keyword);
            return;
        }
        HttpServletRequest request = RequestHolder.getRequest();
        try {
            SearchHistory searchHistory = new SearchHistory();
            searchHistory.setKeyword(keyword);
            searchHistory.setIp(HttpHeaderUtil.getIpAddress(request));
            searchHistory.setCreateDate(new Date());
            searchHistory.setCount(1);
            logger.info("插入: "+searchHistory.toString());
            searchHistoryDao.insert(searchHistory);
        } catch (Throwable e) {
            logger.error("异常信息:{}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

}