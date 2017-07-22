package com.iss.service;

import java.util.List;
import java.util.Map;

import com.iss.pojo.JobTitleInfo;

public interface IJobTitleInfoService {
	List<Map<String, Object>> getJobTitleInfo(int page, int pagesize);

	int editJobTitleInfo(JobTitleInfo jobtitleInfo);

	int deleteJobTitleInfo(JobTitleInfo jobtitleInfo);

	List<Map<String, Object>> searchJobTitleInfo(JobTitleInfo jobtitleInfo, int page, int pagesize);
}
