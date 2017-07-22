package com.iss.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.iss.dao.SysUserDAO;
import com.iss.dbutils.DBUtils;
import com.iss.pojo.SysUser;
import com.mysql.jdbc.Connection;

public class SysUserDAOImpl implements SysUserDAO{
	DBUtils dbUtils = new DBUtils();
	Connection conn;
	@Override
	public int selectSysUserTablePageCount(int pagesize) {
		String sql = "select count(*) from tb_sysuser ";
		return dbUtils.getPageCount(sql, pagesize);
	}

	@Override
	public List<Map<String, Object>> selectAllSysUserByPage(int page, int pagesize) {
		String sql = "select * from tb_sysuser limit ?,?";
		List<Map<String, Object>> list = dbUtils.selectDB(sql, page * pagesize, pagesize);
		dbUtils.close();
		return list;
	}

	@Override
	public List<Map<String, Object>> selectSysUserByBlurry(SysUser sysUser, int page, int pagesize) {
		if (sysUser.getUsername().equals("") && sysUser.getRealname().equals("")&&sysUser.getTeacher_id().equals("") && sysUser.getGender().equals("")&&sysUser.getRole().equals("")&&sysUser.getRegister_time().equals("")) {
			System.out.println(0);
			String sql = "select * from tb_sysuser  limit ?,?";
			List<Map<String, Object>> list = dbUtils.selectDB(sql, page * pagesize, pagesize);
			return list;
		}else if (!sysUser.getUsername().equals("") && sysUser.getRealname().equals("")&&sysUser.getTeacher_id().equals("") && sysUser.getGender().equals("")&&sysUser.getRole().equals("")&&sysUser.getRegister_time().equals("")) {
			System.out.println(1);
			String sql = "select * from tb_sysuser where username like ? limit ?,?";
			List<Map<String, Object>> list = dbUtils.selectDB(sql, "%" + sysUser.getUsername() + "%", page * pagesize, pagesize);
			return list;
		}else if (sysUser.getUsername().equals("") && !sysUser.getRealname().equals("")&&sysUser.getTeacher_id().equals("") && sysUser.getGender().equals("")&&sysUser.getRole().equals("")&&sysUser.getRegister_time().equals("")) {
			System.out.println(2);
			String sql = "select * from tb_sysuser where realname like ? limit ?,?";
			List<Map<String, Object>> list = dbUtils.selectDB(sql, "%"+sysUser.getRealname()+"%", page * pagesize, pagesize);
			return list;
		}else if (sysUser.getUsername().equals("") && sysUser.getRealname().equals("")&&!sysUser.getTeacher_id().equals("") && sysUser.getGender().equals("")&&sysUser.getRole().equals("")&&sysUser.getRegister_time().equals("")) {
			System.out.println(3);
			String sql = "select * from tb_sysuser where teacher_id like ? limit ?,?";
			List<Map<String, Object>> list = dbUtils.selectDB(sql, "%"+sysUser.getTeacher_id()+"%", page * pagesize, pagesize);
			return list;
		}else if (sysUser.getUsername().equals("") && sysUser.getRealname().equals("")&&sysUser.getTeacher_id().equals("") && !sysUser.getGender().equals("")&&sysUser.getRole().equals("")&&sysUser.getRegister_time().equals("")) {
			System.out.println(4);
			String sql = "select * from tb_sysuser where gender =? limit ?,?";
			List<Map<String, Object>> list = dbUtils.selectDB(sql,sysUser.getGender(), page * pagesize, pagesize);
			return list;
		}else if (sysUser.getUsername().equals("") && sysUser.getRealname().equals("")&&sysUser.getTeacher_id().equals("") && sysUser.getGender().equals("")&&!sysUser.getRole().equals("")&&sysUser.getRegister_time().equals("")) {
			System.out.println(5);
			String sql = "select * from tb_sysuser where role =? limit ?,?";
			List<Map<String, Object>> list = dbUtils.selectDB(sql,sysUser.getRole(), page * pagesize, pagesize);
			return list;
		}else if (sysUser.getUsername().equals("") && sysUser.getRealname().equals("")&&sysUser.getTeacher_id().equals("") && sysUser.getGender().equals("")&&sysUser.getRole().equals("")&&!sysUser.getRegister_time().equals("")) {
			System.out.println(6);
			String sql = "select * from tb_sysuser where register_time like ? limit ?,?";
			List<Map<String, Object>> list = dbUtils.selectDB(sql,"%"+sysUser.getRegister_time()+"%" ,page * pagesize, pagesize);
			return list;
		}else if (!sysUser.getUsername().equals("") && !sysUser.getRealname().equals("")&&!sysUser.getTeacher_id().equals("") && !sysUser.getGender().equals("")&&!sysUser.getRole().equals("")&&!sysUser.getRegister_time().equals("")) {
			System.out.println(7);
			String sql = "select * from tb_sysuser where username=? and realname=? and teacher_id=? and gender=? and role =? and register_time like ? limit ?,?";
			List<Map<String, Object>> list = dbUtils.selectDB(sql,sysUser.getUsername(),sysUser.getRealname(),sysUser.getTeacher_id(),sysUser.getGender(),sysUser.getRole(),"%"+sysUser.getRegister_time()+"%", page * pagesize, pagesize);
			return list;
		} else{
			System.out.println(8);
			String sql = "select * from tb_sysuser where username = ? or realname = ? or teacher_id = ? or gender = ? or role = ? or register_time = ? limit ?,?";
			List<Map<String, Object>> list = dbUtils.selectDB(sql,sysUser.getUsername(),sysUser.getRealname(),sysUser.getTeacher_id(),sysUser.getGender(),sysUser.getRole(),sysUser.getRegister_time(), page * pagesize, pagesize);
			return list;
		}
	}

	@Override
	public List<Map<String, Object>> selectSysUserByUsername(SysUser sysUser) {
		String sql = "select * from tb_sysuser where username = ?";
		List<Map<String, Object>> list = dbUtils.selectDB(sql,sysUser.getUsername());
		dbUtils.close();
		return list;
	}

	@Override
	public boolean updateSysUser(SysUser sysUser) {
		String updateSql = "update tb_sysuser set  telephone=?, email=? where username = ?";
		try {
			conn = (Connection) dbUtils.getConn();
			conn.setAutoCommit(false);
			boolean updateResult = dbUtils.cud(updateSql, sysUser.getTelephone(),sysUser.getEmail(), sysUser.getUsername());
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

	@Override
	public boolean addSysUserFromSysUserTable(SysUser sysUser) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateSysUserRole(SysUser sysUser) {
		String sysUserSql = "update tb_sysuser set  role=? where username = ?";
		String sysLoginSql = "update tb_syslogin set  role=?  where username = ?";
		try {
			conn = (Connection) dbUtils.getConn();
			conn.setAutoCommit(false);
			boolean sysUserResult = dbUtils.cud(sysUserSql, sysUser.getRole(),sysUser.getUsername());
			boolean sysLoginResult = dbUtils.cud(sysLoginSql, sysUser.getRole(), sysUser.getUsername());
			conn.commit();
			if (sysUserResult == true && sysLoginResult == true)
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
	@Override
	public boolean deleteSysUserByUsername(SysUser sysUser) {
		String sql = "delete from tb_sysuser where username = ?";
		try {
			conn = (Connection) dbUtils.getConn();
			conn.setAutoCommit(false);
			boolean deleteResult = dbUtils.cud(sql, sysUser.getUsername());
			conn.commit();
			if (deleteResult == true)
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
