package com.iss.dao.impl;

import java.util.List;
import java.util.Map;

import com.iss.dao.IJobTitleInfoDAO;
import com.iss.dbutils.DBUtils;
import com.iss.pojo.JobTitleInfo;

public class JobTitleInfoDAOImpl implements IJobTitleInfoDAO {

	DBUtils dbutils = new DBUtils();

	@Override
	public List<Map<String, Object>> getJobTitleInfo(int page, int pagesize) {
		String sql = "select * from tb_jobtitle limit ?,?";
		List<Map<String, Object>> list = dbutils.selectInfo(sql, page, pagesize);
		return list;
	}

	@Override
	public int editJobTitleInfo(JobTitleInfo jobtitleInfo) {
		String sql = "update tb_jobtitle set jobtitle_name = ? where jobtitle_id = ?";
		int count = dbutils.editInfo(sql, jobtitleInfo.getJobtitle_name(), jobtitleInfo.getJobtitle_id());
		return count;
	}

	@Override
	public int deleteJobTilteInfo(JobTitleInfo jobtitleInfo) {
		String sql = "delete from tb_jobtitle where jobtitle_id = ?";
		int count = dbutils.editInfo(sql, jobtitleInfo.getJobtitle_id());
		return count;
	}

	@Override
	public List<Map<String, Object>> searchJobTitleInfo(JobTitleInfo jobtitleInfo, int page, int pagesize) {
		String sql = "select * from tb_jobtitle where jobtitle_id = ? or jobtitle_name = ? limit ?,?";
		List<Map<String, Object>> list = dbutils.selectInfo(sql, jobtitleInfo.getJobtitle_id(),
				jobtitleInfo.getJobtitle_name(), page, pagesize);
		return list;
	}

}
