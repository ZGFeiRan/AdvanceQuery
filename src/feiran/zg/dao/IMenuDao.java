package feiran.zg.dao;

import java.util.List;

import feiran.zg.domain.Menu;

public interface IMenuDao {
	
	void addMenu(Menu m);
	void deleteMenu(String id);
	void updateMen(Menu m);
	Menu selectById(String id);
	List<Menu> selectAll();
	
	
}
