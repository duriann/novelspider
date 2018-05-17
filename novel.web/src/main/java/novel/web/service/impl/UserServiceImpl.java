package novel.web.service.impl;

import novel.web.dao.UserDao;
import novel.web.entitys.Page;
import novel.web.entitys.User;
import novel.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public int save(User user) {
        return userDao.insert(user);
    }

    @Override
    public int check(User check) {
        int status = userDao.selectByUser(check);
        return status;
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
    public void update(User user) {
       userDao.updateByPrimaryKey(user);
    }
}
