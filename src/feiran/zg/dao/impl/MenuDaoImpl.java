package feiran.zg.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import feiran.zg.dao.IMenuDao;
import feiran.zg.domain.Menu;
import feiran.zg.exception.DaoException;
import feiran.zg.utils.DBCPUtils;

public class MenuDaoImpl implements IMenuDao {

	private QueryRunner qr = new QueryRunner(DBCPUtils.getDataSource());
	@Override
	public void addMenu(Menu m) {
		String sql = "insert into menu(id,name,uri,description) values(?,?,?,?)";
		Object[] params = {m.getId(),m.getName(),m.getUri(),m.getDescription()};
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException();
		}
	}

	@Override
	public void deleteMenu(String id) {
		String sql = "delete from menu where id=?";
		try {
			qr.update(sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException();
		}
	}

	@Override
	public void updateMen(Menu m) {
		String sql = "update menu set name=?,uri=?,description=? where id=?";
		Object[] params = {m.getName(),m.getUri(),m.getDescription()};
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException();
		}
	}

	@Override
	public Menu selectById(String id) {
		String sql = "select * from menu where id=?";
		try {
			Menu menu = qr.query(sql, new BeanHandler<Menu>(Menu.class), id);
			return menu;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException();
		}
	}

	@Override
	public List<Menu> selectAll() {
		String sql = "select * from menu";
		try {
			List<Menu> list = qr.query(sql, new BeanListHandler<Menu>(Menu.class));
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException();
		}
	}
	
}
