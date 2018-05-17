package novel.web.dao;

import novel.web.entitys.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    public int deleteByPrimaryKey(Long id);

    int insert(User record);
    public int insertSelective(User record);

    public User selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(User record);

    public int updateByPrimaryKey(User record);

    public void batchInsert(List<User> Users);

    public int selectByUser(User user);

    List<User> getAllUserByPage(Map<String, Object> map);

    void deleteUserById(long id);
    int getAllUserTotalCount();
}
