package novel.web.controller;

import novel.spider.entitys.ChapterDetail;
import novel.web.constants.Constants;
import novel.web.entitys.JSONResponse;
import novel.web.entitys.Page;
import novel.web.entitys.ReadHistory;
import novel.web.entitys.User;
import novel.web.service.UserService;
import novel.web.utils.RequestHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author
 * @create 2018-06-30 23:38
 **/
@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/admin/getAllReadHistory")
    @ResponseBody
    public JSONResponse getAllReadHistory(int page, int limit){
        User user = (User) RequestHolder.getRequest().getSession().getAttribute(Constants.CURRENT_USER);
        if (user!=null){
            Page<ReadHistory> readHistory = userService.getReadHistory(user, page, limit);
            if (readHistory!=null){
                return JSONResponse.success(readHistory.getPages(),readHistory.getTotalCount());
            }

        }
        return JSONResponse.error("获取历史阅读失败!");
    }
}
