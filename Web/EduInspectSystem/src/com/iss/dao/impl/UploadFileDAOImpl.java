package com.iss.dao.impl;

import com.iss.dao.IUploadFileDAO;
import com.iss.dbutils.DBUtils;

public class UploadFileDAOImpl implements IUploadFileDAO {

	DBUtils dbUtils = new DBUtils();

	@Override
	public int uploadHeanPortraits(String username, String path) {
		String sql = "update tb_sysuser set icon_path = ? where username = ?";
		int count = dbUtils.editInfo(sql, path, username);
		return count;
	}

}
