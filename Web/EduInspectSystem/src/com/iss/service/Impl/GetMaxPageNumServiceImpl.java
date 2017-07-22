package com.iss.service.Impl;

import java.util.List;
import java.util.Map;

import com.iss.dao.IGetMaxPageNumDAO;
import com.iss.dao.impl.GetMaxPageNumDAOImpl;
import com.iss.pojo.ClassInfo;
import com.iss.pojo.CourseInfo;
import com.iss.pojo.DepartmentInfo;
import com.iss.pojo.JobTitleInfo;
import com.iss.pojo.StudentInfo;
import com.iss.pojo.TeacherInfo;
import com.iss.service.IGetMaxPageNumService;

public class GetMaxPageNumServiceImpl implements IGetMaxPageNumService {

	IGetMaxPageNumDAO getMaxPageNumDAO = new GetMaxPageNumDAOImpl();

	@Override
	public List<Map<String, Object>> getMaxPageNumOfAll(String flag) {
		List<Map<String, Object>> list = getMaxPageNumDAO.getMaxPageNumOfAll(flag);
		return list;
	}

	@Override
	public List<Map<String, Object>> getMaxPageNumOfSeacherClass(ClassInfo classInfo) {
		List<Map<String, Object>> list = getMaxPageNumDAO.getMaxPageNumOfSearchClass(classInfo);
		return list;
	}

	@Override
	public List<Map<String, Object>> getMaxPageNumOfSeacherCourse(CourseInfo courseInfo) {
		List<Map<String, Object>> list = getMaxPageNumDAO.getMaxPageNumOfSearchCourse(courseInfo);
		return list;
	}

	@Override
	public List<Map<String, Object>> getMaxPageNumOfSearchDepartment(DepartmentInfo departmentInfo) {
		List<Map<String, Object>> list = getMaxPageNumDAO.getMaxPageNumOfSearchDepartment(departmentInfo);
		return list;
	}

	@Override
	public List<Map<String, Object>> getMaxPageNumOfSearchJobTitle(JobTitleInfo jobTitleInfo) {
		List<Map<String, Object>> list = getMaxPageNumDAO.getMaxPageNumOfSearchJobTitle(jobTitleInfo);
		return list;
	}

	@Override
	public List<Map<String, Object>> getMaxPageNumOfSearchStudent(StudentInfo studentInfo) {
		List<Map<String, Object>> list = getMaxPageNumDAO.getMaxPageNumOfSearchStudent(studentInfo);
		return list;
	}

	@Override
	public List<Map<String, Object>> getMaxPageNumOfSearchTeacher(TeacherInfo teacherInfo) {
		List<Map<String, Object>> list = getMaxPageNumDAO.getMaxPageNumOfSearchTeacher(teacherInfo);
		return list;
	}

}
