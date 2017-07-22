package com.iss.service.Impl;

import java.util.List;
import java.util.Map;

import com.iss.dao.TeachingDAO;
import com.iss.dao.impl.TeachingDAOImpl;
import com.iss.pojo.Teaching;
import com.iss.service.TeachingService;

public class TeachingServiceImpl implements TeachingService{
	TeachingDAOImpl teachingDAO = new TeachingDAOImpl();
	@Override
	public List<Map<String, Object>> getTeachingByInspect(Teaching teaching) {
		return teachingDAO.selectTeachingByInspect(teaching);
	}
	@Override
	public List<Map<String, Object>> getTeacherInfoByTeacherId(String teacher_id) {
		return teachingDAO.selectTeacherInfoByTeacherId(teacher_id);
	}
	@Override
	public List<Map<String, Object>> getCourseInfoByCourseId(String course_id) {
		return teachingDAO.selectCourseInfoByCourseId(course_id);
	}
	@Override
	public List<Map<String, Object>> getDepartmentInfoByDepartmentId(String department_id) {
		return teachingDAO.selectDepartmentInfoByDepartmentId(department_id);
	}
	@Override
	public List<Map<String, Object>> getTeacherInfoByTeacherName(String teacher_name) {
		return teachingDAO.selectTeacherInfoByTeacherName(teacher_name);
	}
	@Override
	public List<Map<String, Object>> getCourseInfoByCourseName(String course_name) {
		return teachingDAO.selectCourseInfoByCourseName(course_name);
	}
	@Override
	public List<Map<String, Object>> getDepartmentInfoByDepartmentName(String department_name) {
		return teachingDAO.selectDepartmentInfoByDepartmentName(department_name);
	}
	@Override
	public List<Map<String, Object>> getTeachingByTrCeId(String teacher_id, String course_id) {
		return teachingDAO.selectTeachingByTrCeId(teacher_id, course_id);
	}
	@Override
	public List<Map<String, Object>> getTeachingByTrNameCeId(String teacher_name, String course_id) {
		return teachingDAO.selectTeachingByTrNameCeId(teacher_name, course_id);
	}

}
