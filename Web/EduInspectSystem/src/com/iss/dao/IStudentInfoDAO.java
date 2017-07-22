package com.iss.dao;

import java.util.List;
import java.util.Map;

import com.iss.pojo.StudentInfo;

public interface IStudentInfoDAO {
	List<Map<String, Object>> getStudentsInfo(int page, int pagesize);

	int editStudentInfo(StudentInfo studentInfo);

	int deleteStudentInfo(StudentInfo studentInfo);

	List<Map<String, Object>> searchStudentInfo(StudentInfo studentInfo, int page, int pagesize);
}
