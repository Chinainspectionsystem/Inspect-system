package com.iss.service.Impl;

import java.util.List;
import java.util.Map;

import com.iss.dao.IJobTitleInfoDAO;
import com.iss.dao.impl.JobTitleInfoDAOImpl;
import com.iss.pojo.JobTitleInfo;
import com.iss.service.IJobTitleInfoService;

public class JobTitleInfoServiceImpl implements IJobTitleInfoService {

	IJobTitleInfoDAO jtidao = new JobTitleInfoDAOImpl();

	@Override
	public List<Map<String, Object>> getJobTitleInfo(int page, int pagesize) {
		List<Map<String, Object>> list = jtidao.getJobTitleInfo(page, pagesize);
		return list;
	}

	@Override
	public int editJobTitleInfo(JobTitleInfo jobtitleInfo) {
		int count = jtidao.editJobTitleInfo(jobtitleInfo);
		return count;
	}

	@Override
	public int deleteJobTitleInfo(JobTitleInfo jobtitleInfo) {
		int count = jtidao.deleteJobTilteInfo(jobtitleInfo);
		return count;
	}

	@Override
	public List<Map<String, Object>> searchJobTitleInfo(JobTitleInfo jobtitleInfo, int page, int pagesize) {
		List<Map<String, Object>> list = jtidao.searchJobTitleInfo(jobtitleInfo, page, pagesize);
		return list;
	}

}
