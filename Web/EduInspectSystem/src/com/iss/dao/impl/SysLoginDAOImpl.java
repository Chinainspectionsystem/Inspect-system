package com.iss.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.iss.dao.SysLoginDAO;
import com.iss.dbutils.DBUtils;
import com.iss.pojo.SysLogin;
import com.mysql.jdbc.Connection;

public class SysLoginDAOImpl implements SysLoginDAO{
	DBUtils dbUtils = new DBUtils();
	Connection conn;
	@Override
	public String searchSysLoginForValidateExit(SysLogin sysLogin) {
		String sql = "select role from tb_syslogin where username = ? and password = ?";
		List<Map<String, Object>> list = dbUtils.selectDB(sql, sysLogin.getUsername(), sysLogin.getPassword());
		if (list.size() > 0) {
			return list.get(0).get("role").toString();
		} else {
			return "无";
		}
	}
	@Override
	public int selectSysLoginTablePageCount(int pagesize) {
		String sql = "select count(*) from tb_syslogin ";
		return dbUtils.getPageCount(sql, pagesize);
	}
	@Override
	public List<Map<String, Object>> selectAllSysLoginByPage(int page, int pagesize) {
		String sql = "select * from tb_syslogin limit ?,?";
		List<Map<String, Object>> list = dbUtils.selectDB(sql, page * pagesize, pagesize);
		dbUtils.close();
		return list;
	}

	@Override
	public List<Map<String, Object>> selectSysLoginByBlurry(SysLogin sysLogin, int page, int pagesize) {
		if (sysLogin.getUsername().equals("")&&!sysLogin.getRole().equals("")&&!sysLogin.getLogin_time().equals("")) {
			System.out.println(6);
			String sql = "select * from tb_syslogin where login_time like ? limit ?,?";
			List<Map<String, Object>> list = dbUtils.selectDB(sql,"%"+sysLogin.getLogin_time()+"%" ,page * pagesize, pagesize);
			return list;
		}else if (!sysLogin.getUsername().equals("")&&!sysLogin.getRole().equals("")&&sysLogin.getLogin_time().equals("")) {
			System.out.println(1);
			String sql = "select * from tb_syslogin where username like ? limit ?,?";
			List<Map<String, Object>> list = dbUtils.selectDB(sql, "%" + sysLogin.getUsername() + "%", page * pagesize, pagesize);
			return list;
		}
		if (sysLogin.getUsername().equals("") &&!sysLogin.getRole().equals("")&&sysLogin.getLogin_time().equals("")) {
			System.out.println(2);
			String sql = "select * from tb_syslogin where role= ? limit ?,?";
			List<Map<String, Object>> list = dbUtils.selectDB(sql, sysLogin.getRole(), page * pagesize, pagesize);
			return list;
		}
		
		if (!sysLogin.getUsername().equals("") &&!sysLogin.getRole().equals("")&&!sysLogin.getLogin_time().equals("")) {
			System.out.println(5);
			String sql = "select * from tb_syslogin where username=? and role =? limit ?,?";
			List<Map<String, Object>> list = dbUtils.selectDB(sql,sysLogin.getUsername(),sysLogin.getRole(), page * pagesize, pagesize);
			return list;
		}
		System.out.println(0);
		return null;
	}

	@Override
	public List<Map<String, Object>> selectSysLoginByUsername(SysLogin sysLogin) {
		String sql = "select * from tb_syslogin where username = ?";
		List<Map<String, Object>> list = dbUtils.selectDB(sql, sysLogin.getUsername());
		dbUtils.close();
		return list;
	}


	@Override
	public boolean updatePassword(String username, String oldpassword, String newpassword) {
		String validateOldSql = "select password from tb_syslogin where username = ?";
		String updateSql = "update tb_syslogin set password=? where username = ?";
		List<Map<String, Object>> list = dbUtils.selectDB(validateOldSql, username);
		if (list.size() > 0) {
			// System.out.println(list.get(0).get("password"));
			if (list.get(0).get("password").equals(oldpassword)) {
				try {
					conn = (Connection) dbUtils.getConn();
					conn.setAutoCommit(false);
					boolean updateResult = dbUtils.cud(updateSql, newpassword, username);
					conn.commit();
					if (updateResult == true)
						return true;
					else
						return false;

				} catch (SQLException e) {
					try {
						e.printStackTrace();
						conn.rollback();
					} catch (SQLException e1) {
						System.out.println("回滚失败");
					}
				}
				return false;
			}

		} else {
			return false;
		}
		return false;
	}

	@Override
	public boolean updateIcon(String username, String icon_path) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean updateLoginTime(SysLogin sysLogin) {
		String updateSql = "update tb_syslogin set login_time = ? where username = ?";
		try {
			conn = (Connection) dbUtils.getConn();
			conn.setAutoCommit(false);
			boolean updateResult = dbUtils.cud(updateSql, sysLogin.getLogin_time(), sysLogin.getUsername());
			conn.commit();
			if (updateResult == true)
				return true;
			else
				return false;
		} catch (SQLException e) {
			try {
				e.printStackTrace();
				conn.rollback();
			} catch (SQLException e1) {
				System.out.println("回滚失败");
			}
		}
		return false;
	}

	

}
