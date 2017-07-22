package com.iss.dao;

import java.util.List;
import java.util.Map;

import com.iss.pojo.Teaching;

public interface TeachingDAO {
	List<Map<String, Object>> selectTeachingByTrCeId(String teacher_id,String course_id);
	List<Map<String, Object>> selectTeachingByTrNameCeId(String teacher_name,String course_id);
	List<Map<String, Object>> selectTeachingByInspect(Teaching teaching);

	List<Map<String, Object>> selectTeacherInfoByTeacherId(String teacher_id);

	List<Map<String, Object>> selectCourseInfoByCourseId(String course_id);

	List<Map<String, Object>> selectDepartmentInfoByDepartmentId(String department_id);

	List<Map<String, Object>> selectTeacherInfoByTeacherName(String teacher_name);

	List<Map<String, Object>> selectCourseInfoByCourseName(String course_name);

	List<Map<String, Object>> selectDepartmentInfoByDepartmentName(String department_name);
}
