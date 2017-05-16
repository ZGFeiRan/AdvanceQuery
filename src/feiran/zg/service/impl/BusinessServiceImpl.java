package feiran.zg.service.impl;

import java.util.List;
import java.util.UUID;

import feiran.zg.dao.IMenuDao;
import feiran.zg.dao.IRoleDao;
import feiran.zg.dao.impl.MenuDaoImpl;
import feiran.zg.dao.impl.RoleDaoImpl;
import feiran.zg.domain.Menu;
import feiran.zg.domain.Role;
import feiran.zg.service.BusinessService;

public class BusinessServiceImpl implements BusinessService {
	private IMenuDao md = new MenuDaoImpl();
	private IRoleDao rd = new RoleDaoImpl();
	// ===============菜单=======================
	@Override
	public void addMenu(Menu m) {
		m.setId(UUID.randomUUID().toString());
		md.addMenu(m);
	}

	@Override
	public List<Menu> findAllMenu() {
		List<Menu> all = md.selectAll();
		return all;
	}

	@Override
	public Menu findMenuById(String menuId) {
		
		return md.selectById(menuId);
	}
	// ===============角色=======================
	@Override
	public List<Role> findAllRole() {
		List<Role> allRole = rd.findAllRole();
		return allRole;
	}

	@Override
	public void addRole(Role role) {
		role.setId(UUID.randomUUID().toString());
		rd.addRole(role);
	}

	@Override
	public Role findRoleById(String roleId) {
		Role role = rd.findRoleById(roleId);
		return role;
	}

	// ===============用户=======================

}
