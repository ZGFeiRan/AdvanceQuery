package feiran.zg.service;

import java.util.List;

import feiran.zg.domain.Menu;
import feiran.zg.domain.Role;

public interface BusinessService {
	public void addMenu(Menu m);//添加菜单
	public List<Menu> findAllMenu();//查询所有菜单
	public Menu findMenuById(String menuId);//根据id查询菜单
	
	public List<Role> findAllRole();//查询所有的角色
	public void addRole(Role role);//添加角色基本信息
	public Role findRoleById(String roleId);//查询角色信息，还要查询出对应的菜单信息
}
