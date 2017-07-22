package com.iss.dao;

import java.util.List;
import java.util.Map;

import com.iss.pojo.TeacherInfo;

public interface ITeacherInfoDAO {
	List<Map<String, Object>> getTeacherInfo(int page, int pagesize);

	int editTeacherInfo(TeacherInfo teacherInfo);

	int deleteTeacherInfo(TeacherInfo teacherInfo);

	List<Map<String, Object>> searchTeacherInfo(TeacherInfo teacherInfo, int page, int pagesize);

	int addTeacherInfo(TeacherInfo teacherInfo);
}
