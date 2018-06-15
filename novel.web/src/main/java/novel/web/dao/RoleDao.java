package novel.web.dao;

import novel.web.entitys.Role;

import java.util.List;
import java.util.Map;
public interface RoleDao {
    public int deleteByPrimaryKey(Long id);

    int insert(Role record);
    public int insertSelective(Role record);

    public Role selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(Role record);

    public int updateByPrimaryKey(Role record);

    public void batchInsert(List<Role> Roles);

    public Role selectByRole(Role role);

    List<Role> getAllRoleByPage(Map<String, Object> map);

    void deleteRoleById(long id);
    int getAllRoleTotalCount();
}
