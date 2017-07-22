package com.iss.dao;

import java.util.List;
import java.util.Map;

import com.iss.pojo.JobTitleInfo;

public interface IJobTitleInfoDAO {
	List<Map<String, Object>> getJobTitleInfo(int page, int pagesize);

	int editJobTitleInfo(JobTitleInfo jobtitleInfo);

	int deleteJobTilteInfo(JobTitleInfo jobtitleInfo);

	List<Map<String, Object>> searchJobTitleInfo(JobTitleInfo jobtitleInfo, int page, int pagesize);
}
