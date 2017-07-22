package com.iss.dao.impl;

import java.util.List;
import java.util.Map;

import com.iss.dao.IClassInfoDAO;
import com.iss.dbutils.DBUtils;
import com.iss.pojo.ClassInfo;

public class ClassInfoDAOImpl implements IClassInfoDAO {
	DBUtils dbutils = new DBUtils();

	@Override
	public List<Map<String, Object>> getClassInfo(int page, int pagesize) {
		String sql = "select * from tb_classes c left join tb_department d on c.department_id = d.department_id left join tb_teacher t on c.teacher_id = t.teacher_id limit ?,?";
		List<Map<String, Object>> list = dbutils.selectInfo(sql, page, pagesize);
		return list;
	}

	@Override
	public int editClassInfo(ClassInfo classInfo) {
		String sql = "update tb_classes set class_population = ? , class_grade = ? , teacher_id = ? where class_name = ?";
		int count = dbutils.editInfo(sql, classInfo.getClass_population(), classInfo.getClass_grade(),
				classInfo.getTeacher_id(), classInfo.getClass_name());
		return count;
	}

	@Override
	public int deleteClassInfo(ClassInfo classInfo) {
		String sql = "delete from tb_classes where class_name = ?";
		int count = dbutils.editInfo(sql, classInfo.getClass_name());
		return count;
	}

	@Override
	public List<Map<String, Object>> searchClassInfo(ClassInfo classInfo, int page, int pagesize) {
		String sql = "select * from tb_classes c left join tb_department d on c.department_id = d.department_id left join tb_teacher t on c.teacher_id = t.teacher_id where c.class_name = ? or c.department_id = ? or c.class_population = ? or class_grade = ? or teacher_id = ? limit ?,?";
		List<Map<String, Object>> list = dbutils.selectInfo(sql, classInfo.getClass_name(),
				classInfo.getDepartment_id(), classInfo.getClass_population(), classInfo.getClass_grade(),
				classInfo.getTeacher_id(), page, pagesize);
		return list;
	}

}
