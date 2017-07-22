package com.iss.dao.impl;

import java.util.List;
import java.util.Map;

import com.iss.dao.TeachingDAO;
import com.iss.dbutils.DBUtils;
import com.iss.pojo.Teaching;
import com.mysql.jdbc.Connection;

public class TeachingDAOImpl implements TeachingDAO{
	DBUtils dbUtils = new DBUtils();
	Connection conn;
	@Override
	public List<Map<String, Object>> selectTeachingByInspect(Teaching teaching) {
		String sql = "select tg.teaching_id,tr.teacher_name,ce.course_name,tg.teaching_time,tg.student_population,tg.teaching_remark from tb_teaching tg,tb_teacher tr,tb_department dt,tb_course ce where   tg.teacher_id=tr.teacher_id and tg.department_id=dt.department_id and tg.course_id=ce.course_id and dt.department_name = ? and tg.teaching_place = ? and tg.teaching_time like ?";
		List<Map<String, Object>> list = dbUtils.selectDB(sql,teaching.getDepartment_name(),teaching.getTeaching_place(),"%" +teaching.getTeaching_time()+"%");
		dbUtils.close();
		return list;
	}
	@Override
	public List<Map<String, Object>> selectTeacherInfoByTeacherId(String teacher_id) {
		String sql = "select * from tb_teaching tg,tb_teacher tr,tb_department dt,tb_course ce where   tg.teacher_id=tr.teacher_id and tg.department_id=dt.department_id and tg.course_id=ce.course_id and tr.teacher_id=?";
		List<Map<String, Object>> list = dbUtils.selectDB(sql,teacher_id);
		if(list.size()>0){
			return list;
		}else{
			return null;
		}
	}
	@Override
	public List<Map<String, Object>> selectCourseInfoByCourseId(String course_id) {
		String sql = "select * from tb_teaching tg,tb_teacher tr,tb_department dt,tb_course ce where   tg.teacher_id=tr.teacher_id and tg.department_id=dt.department_id and tg.course_id=ce.course_id and ce.course_id=?";
		List<Map<String, Object>> list = dbUtils.selectDB(sql,course_id);
		if(list.size()>0){
			return list;
		}else{
			return null;
		}
	}
	@Override
	public List<Map<String, Object>> selectDepartmentInfoByDepartmentId(String department_id) {
		String sql = "select * from tb_teaching tg,tb_teacher tr,tb_department dt,tb_course ce where   tg.teacher_id=tr.teacher_id and tg.department_id=dt.department_id and tg.course_id=ce.course_id and dt.department_id=?";
		List<Map<String, Object>> list = dbUtils.selectDB(sql,department_id);
		if(list.size()>0){
			return list;
		}else{
			return null;
		}
	}
	@Override
	public List<Map<String, Object>> selectTeacherInfoByTeacherName(String teacher_name) {
		String sql = "select * from tb_teaching tg,tb_teacher tr,tb_department dt,tb_course ce where   tg.teacher_id=tr.teacher_id and tg.department_id=dt.department_id and tg.course_id=ce.course_id and tr.teacher_name=?";
		List<Map<String, Object>> list = dbUtils.selectDB(sql,teacher_name);
		if(list.size()>0){
			return list;
		}else{
			return null;
		}
	}
	@Override
	public List<Map<String, Object>> selectCourseInfoByCourseName(String course_name) {
		String sql = "select * from tb_teaching tg,tb_teacher tr,tb_department dt,tb_course ce where   tg.teacher_id=tr.teacher_id and tg.department_id=dt.department_id and tg.course_id=ce.course_id and ce.course_name=?";
		List<Map<String, Object>> list = dbUtils.selectDB(sql,course_name);
		if(list.size()>0){
			return list;
		}else{
			return null;
		}
	}
	@Override
	public List<Map<String, Object>> selectDepartmentInfoByDepartmentName(String department_name) {
		String sql = "select * from tb_teaching tg,tb_teacher tr,tb_department dt,tb_course ce where   tg.teacher_id=tr.teacher_id and tg.department_id=dt.department_id and tg.course_id=ce.course_id and dt.department_name=?";
		List<Map<String, Object>> list = dbUtils.selectDB(sql,department_name);
		if(list.size()>0){
			return list;
		}else{
			return null;
		}

	}
	@Override
	public List<Map<String, Object>> selectTeachingByTrCeId(String teacher_id, String course_id) {
		String sql = "select * from tb_teaching tg,tb_teacher tr,tb_department dt,tb_course ce where   tg.teacher_id=tr.teacher_id and tg.department_id=dt.department_id and tg.course_id=ce.course_id and tr.teacher_id=? and ce.course_id=?";
		List<Map<String, Object>> list = dbUtils.selectDB(sql,teacher_id,course_id);
		if(list.size()>0){
			return list;
		}else{
			return null;
		}
	}
	@Override
	public List<Map<String, Object>> selectTeachingByTrNameCeId(String teacher_name, String course_id) {
		String sql = "select * from tb_teaching tg,tb_teacher tr,tb_department dt,tb_course ce where   tg.teacher_id=tr.teacher_id and tg.department_id=dt.department_id and tg.course_id=ce.course_id and tr.teacher_name=? and ce.course_id=?";
		List<Map<String, Object>> list = dbUtils.selectDB(sql,teacher_name,course_id);
		if(list.size()>0){
			return list;
		}else{
			return null;
		}
	}

}
