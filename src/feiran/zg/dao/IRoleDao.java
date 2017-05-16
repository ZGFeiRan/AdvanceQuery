package feiran.zg.dao;

import java.util.List;

import feiran.zg.domain.Role;

public interface IRoleDao {
	List<Role> findAllRole();

	void addRole(Role role);

	Role findRoleById(String roleId);

	void delMenuRelation(String roleId);//删除角色对应的菜单关系

	void addMenuRelation(String roleId, String[] mIds);////重新建立新的关系
}
