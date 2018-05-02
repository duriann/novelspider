package novel.web.service.impl;

import novel.web.dao.UserDao;
import novel.web.entitys.User;
import novel.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
