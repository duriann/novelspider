package novel.web.service;

import novel.web.entitys.Page;
import novel.web.entitys.User;

public interface UserService {

    int save(User user);
    int check(User user);

    Page<User> getAllUser(int page, int limit);
}
