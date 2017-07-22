package com.iss.dao.impl;

import java.util.List;
import java.util.Map;

import com.iss.dao.ICourseInfoDAO;
import com.iss.dbutils.DBUtils;
import com.iss.pojo.CourseInfo;

public class CourseInfoDAOImpl implements ICourseInfoDAO {

	DBUtils dbutils = new DBUtils();

	@Override
	public List<Map<String, Object>> getCourseInfo(int page, int pagesize) {
		String sql = "select * from tb_course c,tb_department d where c.department_id = d.department_id limit ?,?";
		List<Map<String, Object>> list = dbutils.selectInfo(sql, page, pagesize);
		return list;
	}

	@Override
	public int editCourseInfo(CourseInfo courseInfo) {
		String sql = "update tb_course set course_name = ? , department_id = ? , course_hour = ? , course_credit = ? where course_id = ?";
		int count = dbutils.editInfo(sql, courseInfo.getCourse_name(), courseInfo.getDepartment_id(),
				courseInfo.getCourse_hour(), courseInfo.getCourse_credit(), courseInfo.getCourse_id());
		return count;
	}

	@Override
	public int deleteCourseInfo(CourseInfo courseInfo) {
		String sql = "delete from tb_course where course_id = ?";
		int count = dbutils.editInfo(sql, courseInfo.getCourse_id());
		return count;
	}

	@Override
	public List<Map<String, Object>> searchCourseInfo(CourseInfo courseInfo, int page, int pagesize) {
		String sql = "select * from tb_course c left join tb_department d on c.department_id = d.department_id where c.course_id = ? or c.course_name = ? or c.course_hour =? or c.course_credit = ? or c.department_id = ? limit ?,?";
		List<Map<String, Object>> list = dbutils.selectInfo(sql, courseInfo.getCourse_id(), courseInfo.getCourse_name(),
				courseInfo.getCourse_hour(), courseInfo.getCourse_credit(), courseInfo.getDepartment_id(), page,
				pagesize);
		return list;
	}

}
