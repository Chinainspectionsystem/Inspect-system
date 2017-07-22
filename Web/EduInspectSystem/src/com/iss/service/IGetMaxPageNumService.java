package com.iss.service;

import java.util.List;
import java.util.Map;

import com.iss.pojo.ClassInfo;
import com.iss.pojo.CourseInfo;
import com.iss.pojo.DepartmentInfo;
import com.iss.pojo.JobTitleInfo;
import com.iss.pojo.StudentInfo;
import com.iss.pojo.TeacherInfo;

public interface IGetMaxPageNumService {
	List<Map<String, Object>> getMaxPageNumOfAll(String flag);

	List<Map<String, Object>> getMaxPageNumOfSeacherClass(ClassInfo classInfo);

	List<Map<String, Object>> getMaxPageNumOfSeacherCourse(CourseInfo courseInfo);

	List<Map<String, Object>> getMaxPageNumOfSearchDepartment(DepartmentInfo departmentInfo);

	List<Map<String, Object>> getMaxPageNumOfSearchJobTitle(JobTitleInfo jobTitleInfo);

	List<Map<String, Object>> getMaxPageNumOfSearchStudent(StudentInfo studentInfo);

	List<Map<String, Object>> getMaxPageNumOfSearchTeacher(TeacherInfo teacherInfo);
}
