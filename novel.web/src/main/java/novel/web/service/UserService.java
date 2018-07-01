package novel.web.service;

import novel.spider.entitys.ChapterDetail;
import novel.web.entitys.Page;
import novel.web.entitys.ReadHistory;
import novel.web.entitys.User;

import java.util.List;
import java.util.Set;

public interface UserService {

    int save(User user);

    /**
     *
     * @param user
     * @return 1:登录成功
     */
    User check(User user);
    void delete(User user);
    User getUserById(long id);
    Page<User> getAllUser(int page, int limit);
    void logout(User user);
    void update(User user);
    Set<String> getRoleByName(String username);
    Set<String> getPermissionByName(String username);
    Page<ReadHistory> getReadHistory(User user, int page, int limit);
}
