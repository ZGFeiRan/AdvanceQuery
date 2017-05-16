package feiran.zg.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import feiran.zg.dao.IRoleDao;
import feiran.zg.domain.Role;
import feiran.zg.utils.DBCPUtils;

public class RoleDaoImpl implements IRoleDao {
	private QueryRunner qr = new QueryRunner(DBCPUtils.getDataSource());
	
	@Override
	public List<Role> findAllRole() {
		String sql = "select * from role";
		try {
			List<Role> list = qr.query(sql, new BeanListHandler<Role>(Role.class));
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addRole(Role role) {
		String sql = "insert into role(id,name,description) values(?,?,?)";
		Object[] params = {role.getId(),role.getName(),role.getDescription()};
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Role findRoleById(String roleId) {
		String sql = "select * from role where id=?";
		try {
			Role role = qr.query(sql, new BeanHandler<Role>(Role.class), roleId);
			return role;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	
	
	@Override
	public void delMenuRelation(String roleId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addMenuRelation(String roleId, String[] mIds) {
		// TODO Auto-generated method stub

	}

}
