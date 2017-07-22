package com.iss.dao.impl;

import java.util.List;
import java.util.Map;

import com.iss.dao.ITeacherInfoDAO;
import com.iss.dbutils.DBUtils;
import com.iss.pojo.TeacherInfo;

public class TeacherInfoDAOImpl implements ITeacherInfoDAO {

	DBUtils dbutils = new DBUtils();

	@Override
	public List<Map<String, Object>> getTeacherInfo(int page, int pagesize) {
		String sql = "select * from (tb_teacher t left join tb_department d on t.department_id = d.department_id) left join tb_jobtitle j on t.jobtitle_id = j.jobtitle_id limit ?,?";
		List<Map<String, Object>> list = dbutils.selectInfo(sql, page, pagesize);
		return list;
	}

	@Override
	public int editTeacherInfo(TeacherInfo teacherInfo) {
		String sql = "update tb_teacher set department_id = ? , teacher_name = ? , gender = ? , jobtitle_id = ? , teacher_inspector = ? where teacher_id = ?";
		int count = dbutils.editInfo(sql, teacherInfo.getDepartment_id(), teacherInfo.getTeacher_name(),
				teacherInfo.getGender(), teacherInfo.getJobtitle_id(), teacherInfo.getTeacher_inspector(),
				teacherInfo.getTeacher_id());
		return count;
	}

	@Override
	public List<Map<String, Object>> searchTeacherInfo(TeacherInfo teacherInfo, int page, int pagesize) {
		String sql = "select * from (tb_teacher t left join tb_department d on t.department_id = d.department_id) left join tb_jobtitle j on t.jobtitle_id = j.jobtitle_id where t.department_id = ? and t.gender = ? and t.jobtitle_id = ? and t.teacher_inspector = ? or t.teacher_id = ? or t.teacher_name = ? limit ?,?";
		List<Map<String, Object>> list = dbutils.selectInfo(sql, teacherInfo.getDepartment_id(),
				teacherInfo.getGender(), teacherInfo.getJobtitle_id(), teacherInfo.getTeacher_inspector(),
				teacherInfo.getTeacher_id(), teacherInfo.getTeacher_name(), page, pagesize);
		return list;
	}

	@Override
	public int deleteTeacherInfo(TeacherInfo teacherInfo) {
		String sql = "delete from tb_teacher where teacher_id = ?";
		int count = dbutils.editInfo(sql, teacherInfo.getTeacher_id());
		return count;
	}

	@Override
	public int addTeacherInfo(TeacherInfo teacherInfo) {
		String sql = "insert into tb_teacher values(?,?,?,?,?,?)";
		int count = dbutils.editInfo(sql, teacherInfo.getTeacher_id(), teacherInfo.getDepartment_id(),
				teacherInfo.getTeacher_name(), teacherInfo.getGender(), teacherInfo.getJobtitle_id(),
				teacherInfo.getTeacher_inspector());
		return count;
	}

}
