package novel.web.service;

import novel.web.entitys.Page;
import novel.web.entitys.User;

public interface UserService {

    int save(User user);

    /**
     *
     * @param user
     * @return 1:登录成功
     */
    int check(User user);
    void delete(User user);
    User getUserById(long id);
    Page<User> getAllUser(int page, int limit);

    void update(User user);
}
