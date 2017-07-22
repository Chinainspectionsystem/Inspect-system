package com.iss.service;

import java.util.List;

import java.util.Map;

import com.iss.pojo.TeacherInfo;

public interface ITeacherInfoService {
	List<Map<String, Object>> getTeacherInfo(int page, int pagesize);

	int editTeacherInfo(TeacherInfo teacherInfo);

	int deleteTeacherInfo(TeacherInfo teacherInfo);

	List<Map<String, Object>> searchTeacherInfo(TeacherInfo teacherInfo, int page, int pagesize);

	int addTeachersInfo(TeacherInfo teacherInfo);
}
