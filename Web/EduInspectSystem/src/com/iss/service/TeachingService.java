package com.iss.service;

import java.util.List;
import java.util.Map;

import com.iss.pojo.Teaching;

public interface TeachingService {
	List<Map<String,Object>> getTeachingByInspect(Teaching teaching);
	List<Map<String,Object>> getTeacherInfoByTeacherId(String teacher_id);
	List<Map<String,Object>> getCourseInfoByCourseId(String course_id);
	List<Map<String,Object>> getDepartmentInfoByDepartmentId(String department_id);
	List<Map<String,Object>> getTeacherInfoByTeacherName(String teacher_name);
	List<Map<String,Object>> getCourseInfoByCourseName(String course_name);
	List<Map<String,Object>> getDepartmentInfoByDepartmentName(String department_name);
	List<Map<String,Object>> getTeachingByTrCeId(String teacher_id, String course_id);
	List<Map<String,Object>> getTeachingByTrNameCeId(String teacher_name, String course_id);
}
