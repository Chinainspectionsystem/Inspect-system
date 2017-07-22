package com.iss.dao;

import java.util.List;
import java.util.Map;

import com.iss.pojo.CourseInfo;

public interface ICourseInfoDAO {
	List<Map<String, Object>> getCourseInfo(int page, int pagesize);

	int editCourseInfo(CourseInfo courseInfo);

	int deleteCourseInfo(CourseInfo courseInfo);

	List<Map<String, Object>> searchCourseInfo(CourseInfo courseInfo, int page, int pagesize);
}
