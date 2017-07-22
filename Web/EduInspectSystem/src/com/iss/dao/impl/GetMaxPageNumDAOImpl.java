package com.iss.dao.impl;

import java.util.List;
import java.util.Map;

import com.iss.dao.IGetMaxPageNumDAO;
import com.iss.dbutils.DBUtils;
import com.iss.pojo.ClassInfo;
import com.iss.pojo.CourseInfo;
import com.iss.pojo.DepartmentInfo;
import com.iss.pojo.JobTitleInfo;
import com.iss.pojo.StudentInfo;
import com.iss.pojo.TeacherInfo;

public class GetMaxPageNumDAOImpl implements IGetMaxPageNumDAO {

	DBUtils dbUtils = new DBUtils();

	@Override
	public List<Map<String, Object>> getMaxPageNumOfAll(String flag) {
		String sql = "";
		List<Map<String, Object>> list = null;
		if (flag.equals("teacher")) {
			sql = "select count(*) 'count' from tb_teacher";
			list = dbUtils.selectInfo(sql);
		}
		if (flag.equals("course")) {
			sql = "select count(*) 'count' from tb_course";
			list = dbUtils.selectInfo(sql);
		}
		if (flag.equals("student")) {
			sql = "select count(*) 'count' from tb_student";
			list = dbUtils.selectInfo(sql);

		}
		if (flag.equals("department")) {
			sql = "select count(*) 'count' from tb_department";
			list = dbUtils.selectInfo(sql);
		}
		if (flag.equals("jobtitle")) {
			sql = "select count(*) 'count' from tb_jobtitle";
			list = dbUtils.selectInfo(sql);
		}
		if (flag.equals("classes")) {
			sql = "select count(*) 'count' from tb_classes";
			list = dbUtils.selectInfo(sql);
		}
		return list;
	}

	@Override
	public List<Map<String, Object>> getMaxPageNumOfSearchClass(ClassInfo classInfo) {
		String sql = "select count(*) 'count' from tb_classes where class_name = ? or class_grade = ? or teacher_id = ?";
		List<Map<String, Object>> list = dbUtils.selectInfo(sql, classInfo.getClass_name(), classInfo.getClass_grade(),
				classInfo.getTeacher_id());
		return list;
	}

	@Override
	public List<Map<String, Object>> getMaxPageNumOfSearchCourse(CourseInfo courseInfo) {
		String sql = "select count(*) 'count' from tb_course where course_id = ? or course_name = ? or department_id = ? or course_hour = ? or course_credit = ?";
		List<Map<String, Object>> list = dbUtils.selectInfo(sql, courseInfo.getCourse_id(), courseInfo.getCourse_name(),
				courseInfo.getDepartment_id(), courseInfo.getCourse_hour(), courseInfo.getCourse_credit());
		return list;
	}

	@Override
	public List<Map<String, Object>> getMaxPageNumOfSearchDepartment(DepartmentInfo departmentInfo) {
		String sql = "select count(*) 'count' from tb_department where department_id = ? or department_name = ? or department_head = ?";
		List<Map<String, Object>> list = dbUtils.selectInfo(sql, departmentInfo.getDepartment_id(),
				departmentInfo.getDepartment_name(), departmentInfo.getDepartment_head());
		return list;
	}

	@Override
	public List<Map<String, Object>> getMaxPageNumOfSearchJobTitle(JobTitleInfo jobTitleInfo) {
		String sql = "select count(*) 'count' from tb_jobtitle where jobtitle_id = ? or jobtitle_name = ?";
		List<Map<String, Object>> list = dbUtils.selectInfo(sql, jobTitleInfo.getJobtitle_id(),
				jobTitleInfo.getJobtitle_name());
		return list;
	}

	@Override
	public List<Map<String, Object>> getMaxPageNumOfSearchStudent(StudentInfo studentInfo) {
		String sql = "select count(*) 'count' from tb_student where student_id	= ? or student_name = ? or department_id = ? or class_name = ? or gender = ?";
		List<Map<String, Object>> list = dbUtils.selectInfo(sql, studentInfo.getStudent_id(),
				studentInfo.getStudent_name(), studentInfo.getDepartment_id(), studentInfo.getClass_name(),
				studentInfo.getGender());
		return list;
	}

	@Override
	public List<Map<String, Object>> getMaxPageNumOfSearchTeacher(TeacherInfo teacherInfo) {
		String sql = "select count(*) 'count' from tb_teacher where teacher_id = ? or department_id = ? or teacher_name = ? or gender = ? or jobtitle_id = ? or teacher_inspector = ?";
		List<Map<String, Object>> list = dbUtils.selectInfo(sql, teacherInfo.getTeacher_id(),
				teacherInfo.getDepartment_id(), teacherInfo.getTeacher_name(), teacherInfo.getGender(),
				teacherInfo.getTeacher_inspector());
		return list;
	}

	/*
	 * @Override public List<Map<String, Object>> getMaxPageNumOfSearch(String flag)
	 * { String sql = ""; List<Map<String, Object>> list = null;
	 * if(flag.equals("teacher")) { TeacherInfo teacherInfo = new TeacherInfo(); sql
	 * =
	 * "select count(*) 'count' from tb_teacher where teacher_id = ? or department_id = ? or teacher_name = ? or gender = ? or jobtitle_id = ? or teacher_inspector = ?"
	 * ; list = dbUtils.selectInfo(sql, teacherInfo.getTeacher_id(),
	 * teacherInfo.getDepartment_id(), teacherInfo.getTeacher_name(),
	 * teacherInfo.getGender(), teacherInfo.getTeacher_inspector()); }
	 * if(flag.equals("course")) { CourseInfo courseInfo = new CourseInfo(); sql =
	 * "select count(*) 'count' from tb_course where course_id = ? or course_name = ? or department_id = ? or course_hour = ? or course_credit = ?"
	 * ; list = dbUtils.selectInfo(sql, courseInfo.getCourse_id(),
	 * courseInfo.getCourse_name(), courseInfo.getDepartment_id(),
	 * courseInfo.getCourse_hour(), courseInfo.getCourse_credit()); }
	 * if(flag.equals("student")) { StudentInfo studentInfo = new StudentInfo(); sql
	 * =
	 * "select count(*) 'count' from tb_student where student_id	= ? or student_name = ? or department_id = ? or class_name = ? or gender = ?"
	 * ; list = dbUtils.selectInfo(sql, studentInfo.getStudent_id(),
	 * studentInfo.getStudent_name(), studentInfo.getDepartment_id(),
	 * studentInfo.getClass_name(), studentInfo.getGender()); } if
	 * (flag.equals("department")) { DepartmentInfo departmentInfo = new
	 * DepartmentInfo(); sql =
	 * "select count(*) 'count' from tb_department where department_id = ? or department_name = ? or department_head = ?"
	 * ; list = dbUtils.selectInfo(sql, departmentInfo.getDepartment_id(),
	 * departmentInfo.getDepartment_name(), departmentInfo.getDepartment_head()); }
	 * if (flag.equals("jobtitle")) { JobTitleInfo jobTitleInfo = new
	 * JobTitleInfo(); sql =
	 * "select count(*) 'count' from tb_jobtitle where jobtitle_id = ? or jobtitle_name = ?"
	 * ; list = dbUtils.selectInfo(sql, jobTitleInfo.getJobtitle_id(),
	 * jobTitleInfo.getJobtitle_name()); } if (flag.equals("classes")) { ClassInfo
	 * classInfo = new ClassInfo(); sql =
	 * "select count(*) 'count' from tb_classes where class_name = ? or class_grade = ? or teacher_id = ?"
	 * ; list = dbUtils.selectInfo(sql, classInfo.getClass_name(),
	 * classInfo.getClass_grade(), classInfo.getTeacher_id()); } return list; }
	 */
}
