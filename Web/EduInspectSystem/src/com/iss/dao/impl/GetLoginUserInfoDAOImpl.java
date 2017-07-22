package com.iss.dao.impl;

import java.util.List;
import java.util.Map;

import com.iss.dao.IGetLonginUserInfoDAO;
import com.iss.dbutils.DBUtils;

public class GetLoginUserInfoDAOImpl implements IGetLonginUserInfoDAO {

	DBUtils dbUtils = new DBUtils();

	@Override
	public List<Map<String, Object>> getLonginUserInfo(String username) {
		String sql = "select * from tb_sysuser where username = ?";
		List<Map<String, Object>> list = dbUtils.selectInfo(sql, username);
		return list;
	}

}
