package com.iss.service.Impl;

import java.util.List;
import java.util.Map;

import com.iss.dao.ICourseInfoDAO;
import com.iss.dao.impl.CourseInfoDAOImpl;
import com.iss.pojo.CourseInfo;
import com.iss.service.ICourseInfoService;

public class CourseInfoServiceImpl implements ICourseInfoService {

	ICourseInfoDAO courseidao = new CourseInfoDAOImpl();

	@Override
	public List<Map<String, Object>> getCourseInfo(int page, int pagesize) {
		List<Map<String, Object>> list = courseidao.getCourseInfo(page, pagesize);
		return list;
	}

	@Override
	public int editCourseInfo(CourseInfo courseInfo) {
		int count = courseidao.editCourseInfo(courseInfo);
		return count;
	}

	@Override
	public int deleteCourseInfo(CourseInfo courseInfo) {
		int count = courseidao.deleteCourseInfo(courseInfo);
		return count;
	}

	@Override
	public List<Map<String, Object>> searchCourseInfo(CourseInfo courseInfo, int page, int pagesize) {
		List<Map<String, Object>> list = courseidao.searchCourseInfo(courseInfo, page, pagesize);
		return list;
	}

}
