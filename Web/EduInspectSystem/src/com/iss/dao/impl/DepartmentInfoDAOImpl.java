package com.iss.dao.impl;

import java.util.List;
import java.util.Map;

import com.iss.dao.IDepartmentInfoDAO;
import com.iss.dbutils.DBUtils;
import com.iss.pojo.DepartmentInfo;

public class DepartmentInfoDAOImpl implements IDepartmentInfoDAO {

	DBUtils dbutils = new DBUtils();

	@Override
	public List<Map<String, Object>> getDepartmentInfo(int page, int pagesize) {
		String sql = "select * from tb_department d left join tb_teacher t on d.department_head = t.teacher_id limit ?,?";
		List<Map<String, Object>> list = dbutils.selectInfo(sql, page, pagesize);
		return list;
	}

	@Override
	public int editDepartmentInfo(DepartmentInfo departmentInfo) {
		String sql = "update tb_department set department_name = ? , department_head = ? where department_id = ?";
		int result = dbutils.editInfo(sql, departmentInfo.getDepartment_name(), departmentInfo.getDepartment_head(),
				departmentInfo.getDepartment_id());
		return result;
	}

	@Override
	public int deleteDepartmentInfo(DepartmentInfo departmentInfo) {
		String sql = "delete from tb_department where department_id = ?";
		int count = dbutils.editInfo(sql, departmentInfo.getDepartment_id());
		return count;
	}

	@Override
	public List<Map<String, Object>> searchDepartmentInfo(DepartmentInfo departmentInfo, int page, int pagesize) {
		String sql = "select * from tb_department d left join tb_teacher t on d.department_head = t.teacher_id where d.department_id = ? or d.department_name = ? or d.department_head = ? limit ?,?";
		List<Map<String, Object>> list = dbutils.selectInfo(sql, departmentInfo.getDepartment_id(),
				departmentInfo.getDepartment_name(), departmentInfo.getDepartment_head(), page, pagesize);
		return list;
	}

}
