package com.iss.dao.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.iss.dao.SysCheckDAO;
import com.iss.dbutils.DBUtils;
import com.iss.pojo.SysCheck;
import com.mysql.jdbc.Connection;

public class SysCheckDAOImpl implements SysCheckDAO {
	DBUtils dbUtils = new DBUtils();
	Connection conn;

	@Override
	public boolean searchSysUesrForValidateExit(SysCheck sysCheck) {
		String sql1 = "select * from tb_sysuser where username = ?";
		String sql2 = "select * from tb_syscheck where username = ?";
		List<Map<String, Object>> list1 = dbUtils.selectDB(sql1, sysCheck.getUsername());
		List<Map<String, Object>> list2 = dbUtils.selectDB(sql2, sysCheck.getUsername());
		dbUtils.close();
		if (list1.size() > 0 || list2.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int selectSysCheckTablePageCount(int pagesize) {
		String sql = "select count(*) from tb_syscheck ";
		return dbUtils.getPageCount(sql, pagesize);
	}

	@Override
	public List<Map<String, Object>> selectAllSysCheckByPage(int page, int pagesize) {
		String sql = "select * from tb_syscheck limit ?,?";
		List<Map<String, Object>> list = dbUtils.selectDB(sql, page * pagesize, pagesize);
		dbUtils.close();
		return list;
	}

	@Override
	public List<Map<String, Object>> selectSysCheckByBlurry(SysCheck sysCheck, int page, int pagesize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> selectSysCheckByUsername(SysCheck sysCheck) {
		String sql = "select * from tb_syscheck where username = ?";
		List<Map<String, Object>> list = dbUtils.selectDB(sql, sysCheck.getUsername());
		return list;
	}

	@Override
	public boolean addSysCheck(SysCheck sysCheck) {
		String sql = "insert into tb_syscheck values (?,?,?,?,?,?,?,?)";
		try {
			conn = (Connection) dbUtils.getConn();
			conn.setAutoCommit(false);
			// .....写从老师表里查是否存在改老师
			String exist_teacher = "存在";
			sysCheck.setExist_teacher(exist_teacher);
			boolean result = dbUtils.cud(sql, sysCheck.getUsername(), sysCheck.getPassword(), sysCheck.getRealname(),
					sysCheck.getTeacher_id(), sysCheck.getGender(), sysCheck.getTelephone(), sysCheck.getEmail(),
					sysCheck.getExist_teacher());
			conn.commit();
			if (result == true)
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
	public boolean addSysUserFromSysCheckTable(SysCheck sysCheck, String role) {
		String insertSysUserSql = "insert into tb_sysuser values (?,?,?,?,?,?,?,?,?)";
		String insertSLoginSql = "insert into tb_syslogin values (?,?,?,?)";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String register_time = df.format(new Date());
		String icon_path = "img\\head_portraits\\default.gif";
		try {
			conn = (Connection) dbUtils.getConn();
			conn.setAutoCommit(false);
			boolean userResult = dbUtils.cud(insertSysUserSql, sysCheck.getUsername(), sysCheck.getRealname(),
					sysCheck.getTeacher_id(), sysCheck.getGender(), sysCheck.getTelephone(), sysCheck.getEmail(),
					icon_path, register_time, role);
			boolean loginResult = dbUtils.cud(insertSLoginSql, sysCheck.getUsername(), sysCheck.getPassword(), role,
					"-");
			conn.commit();
			if (userResult == true && loginResult == true)
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
	public boolean deleteSysCheckByUsername(SysCheck sysCheck) {
		String sql = "delete from tb_syscheck where username = ?";
		try {
			conn = (Connection) dbUtils.getConn();
			conn.setAutoCommit(false);
			boolean deleteResult = dbUtils.cud(sql, sysCheck.getUsername());
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
