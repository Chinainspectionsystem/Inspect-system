package com.iss.service;

import java.util.List;
import java.util.Map;

import com.iss.pojo.StudentInfo;

public interface IStudentInfoService {
	List<Map<String, Object>> getStudnetsInfo(int page, int pagesize);

	int editStudentInfo(StudentInfo studentInfo);

	int deleteStudentInfo(StudentInfo studentInfo);

	List<Map<String, Object>> searchStudentInfo(StudentInfo studentInfo, int page, int pagesize);
}
