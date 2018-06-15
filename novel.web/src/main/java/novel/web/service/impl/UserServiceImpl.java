package novel.web.service.impl;

import novel.web.constants.Constants;
import novel.web.dao.UserDao;
import novel.web.entitys.Page;
import novel.web.entitys.User;
import novel.web.service.UserService;
import novel.web.utils.CookieUtil;
import novel.web.utils.RedisUtil;
import novel.web.utils.RequestHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public int save(User user) {
        return userDao.insert(user);
    }

    @Override
    public User check(User check) {
        User user = userDao.selectByUser(check);
        return user;
    }

    @Override
    public void delete(User user) {
    }

    @Override
    public User getUserById(long id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    public Page<User> getAllUser(int page, int limit) {
        Map<String, Object> map = new HashMap<>();
        map.put("currentPage", page);
        map.put("pageSize", limit);
        List<User> users = userDao.getAllUserByPage(map);
        int totalCount = userDao.getAllUserTotalCount();
        Page<User> pages = new Page<User>();
        pages.setCurrentPage(page);
        pages.setPageSize(limit);
        pages.setPages(users);
        pages.setTotalCount(totalCount);
        return pages;
    }

    @Override
    public void logout(User user) {
        HttpServletRequest request = RequestHolder.getRequest();
        HttpServletResponse response = RequestHolder.getResponse();
        if (user!=null){
            request.getSession().removeAttribute(Constants.CURRENT_USER);
            redisUtil.del(user.getId()+"");
            Cookie[] cookies = request.getCookies();
            if (CookieUtil.isNotEmptyCookie(cookies)){
                Cookie token = CookieUtil.getCookie(cookies,"token");
                if (null!=token){
                    token.setValue(null);
                    token.setMaxAge(0);// 立即销毁cookie
                    token.setPath("/");
                    response.addCookie(token);
                }

            }
        }
    }

    @Override
    public void update(User user) {
       userDao.updateByPrimaryKey(user);
    }

    @Override
    public Set<String> getRoleByName(String username) {
        return userDao.getRoleByName(username);
    }

    @Override
    public Set<String> getPermissionByName(String username) {
        return userDao.getPermissionByName(username);
    }
}
