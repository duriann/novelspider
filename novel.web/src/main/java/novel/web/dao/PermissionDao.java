package novel.web.dao;

import novel.web.entitys.Permission;
import novel.web.entitys.User;

import java.util.List;
import java.util.Map;
public interface PermissionDao {
    public int deleteByPrimaryKey(Long id);

    int insert(User record);
    public int insertSelective(Permission record);

    public Permission selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(Permission record);

    public int updateByPrimaryKey(Permission record);

    public void batchInsert(List<Permission> Permissions);

    public Permission selectByPermission(Permission permission);

    List<Permission> getAllPermissionByPage(Map<String, Object> map);

    void deletePermissionById(long id);
    int getAllPermissionTotalCount();
}
