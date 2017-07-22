package com.iss.dao.impl;

import java.util.List;
import java.util.Map;

import com.iss.dao.IStudentInfoDAO;
import com.iss.dbutils.DBUtils;
import com.iss.pojo.StudentInfo;

public class StudentInfoDAOImpl implements IStudentInfoDAO {

	DBUtils dbutils = new DBUtils();

	@Override
	public List<Map<String, Object>> getStudentsInfo(int page, int pagesize) {
		String sql = "select * from tb_student s left join tb_department d on s.department_id = d.department_id limit ?,?";
		List<Map<String, Object>> list = dbutils.selectInfo(sql, page, pagesize);
		return list;
	}

	@Override
	public int editStudentInfo(StudentInfo studentInfo) {
		String sql = "update tb_student set student_name = ? , department_id = ? ,class_name = ?, gender = ? where student_id = ?";
		int count = dbutils.editInfo(sql, studentInfo.getStudent_name(), studentInfo.getDepartment_id(),
				studentInfo.getClass_name(), studentInfo.getGender(), studentInfo.getStudent_id());
		return count;
	}

	@Override
	public int deleteStudentInfo(StudentInfo studentInfo) {
		String sql = "delete from tb_student where student_id = ?";
		int count = dbutils.editInfo(sql, studentInfo.getStudent_id());
		return count;
	}

	@Override
	public List<Map<String, Object>> searchStudentInfo(StudentInfo studentInfo, int page, int pagesize) {
		String id = studentInfo.getStudent_id();
		String name = studentInfo.getStudent_name();
		String d_id = studentInfo.getDepartment_id();
		String c_name = studentInfo.getClass_name();
		String gender = studentInfo.getGender();
		List<Map<String, Object>> list;
		String sql = "";
		sql = "select * from tb_student s left join tb_department d on s.department_id = d.department_id where s.gender = ? and s.department_id = ? or s.student_id = ? or s.student_name = ? or s.class_name = ? limit ?,?";
		list = dbutils.selectInfo(sql, gender, d_id, id, name, c_name, page, pagesize);
		return list;
	}

}
