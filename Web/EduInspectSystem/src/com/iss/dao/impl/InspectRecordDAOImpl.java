package com.iss.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.iss.dao.InspectRecordDAO;
import com.iss.dbutils.DBUtils;
import com.iss.pojo.InspectRecord;
import com.mysql.jdbc.Connection;

public class InspectRecordDAOImpl implements InspectRecordDAO {
	DBUtils dbUtils = new DBUtils();
	Connection conn;

	@Override
	public int selectInspectRecordTablePageCount(int pagesize) {
		String sql = "select count(*) from tb_inspection_record ";
		return dbUtils.getPageCount(sql, pagesize);
	}

	@Override
	public List<Map<String, Object>> selectAllInspectRecordByPage(int page, int pagesize) {
		String sql = "select course_id,teacher_id,totalscore,inspection_time from tb_inspection_record limit ?,?";
		List<Map<String, Object>> list = dbUtils.selectDBListMap(sql, new String[] { "课程", "教师", "评分", "巡查时间" },
				page * pagesize, pagesize);
		// List<Map<String, Object>> list = dbUtils.selectDB(sql, page * pagesize,
		// pagesize);
		dbUtils.close();
		return list;
	}

	@Override
	public List<Map<String, Object>> selectInspectRecordByUsername(InspectRecord inspectRecord) {
		String sql = "select * from tb_inspection_record where username = ?";
		List<Map<String, Object>> list = dbUtils.selectDB(sql, inspectRecord.getUsername());
		return list;
	}

	@Override
	public List<Map<String, Object>> selectInspectRecordByBlurry(InspectRecord inspectRecord, int page, int pagesize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addInspectRecord(InspectRecord inspectRecord) {
		String sql = "insert into tb_inspection_record values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			conn = (Connection) dbUtils.getConn();
			conn.setAutoCommit(false);
			boolean result = dbUtils.cud(sql, inspectRecord.getUsername(), inspectRecord.getTeaching_id(),
					inspectRecord.getCourse_id(), inspectRecord.getTeacher_id(), inspectRecord.getDepartment_id(),
					inspectRecord.getTeaching_time(), inspectRecord.getInspection_time(),
					inspectRecord.getInspection_place(), inspectRecord.getNum_absent(), inspectRecord.getNum_sleep(),
					inspectRecord.getNum_phone(), inspectRecord.getTeacherscore1(), inspectRecord.getTeacherscore2(),
					inspectRecord.getStudentscore1(), inspectRecord.getStudentscore2(), inspectRecord.getTotalscore(),
					inspectRecord.getInspect_remark());
			conn.commit();
			if (result == true)
				return true;
			else
				return false;
		} catch (SQLException e) {
			try {
				e.printStackTrace();
				conn.rollback();
			} catch (SQLException e1) {
				System.out.println("回滚失败");
			}
		}
		return false;
	}

	@Override
	public boolean deleteInspectRecordByUsername(InspectRecord inspectRecord) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Map<String, Object>> selectNameIDByTeachingId(InspectRecord inspectRecord) {
		String sql = "select ce.course_id,ce.course_name,tr.teacher_id,tr.teacher_name,dt.department_id,dt.department_name from tb_course ce,tb_department dt, tb_teacher tr,tb_teaching tg where tg.course_id=ce.course_id and tg.teacher_id=tr.teacher_id and tg.department_id=dt.department_id and tg.teaching_id=?  ";
		List<Map<String, Object>> list = dbUtils.selectDB(sql, inspectRecord.getTeaching_id());
		return list;
	}

	@Override
	public List<Map<String, Object>> selectTeachingPlaceByTeachingId(InspectRecord inspectRecord) {
		String sql = "select teaching_place from tb_teaching where teaching_id=? ";
		List<Map<String, Object>> list = dbUtils.selectDB(sql, inspectRecord.getTeaching_id());
		return list;
	}

	@Override
	public List<Map<String, Object>> selectInspectScoreByTeacherId(InspectRecord inspectRecord) {
		String sql = "select totalscore from tb_inspection_record where teacher_id=?  order by inspection_time desc limit 0,8";
		List<Map<String, Object>> list = dbUtils.selectDBListMapSorce(sql, inspectRecord.getTeacher_id());
		return list;
	}

	@Override
	public List<Map<String, Object>> selectInspectScoreByCourseId(InspectRecord inspectRecord) {
		String sql = "select totalscore from tb_inspection_record where course_id=?  order by inspection_time desc limit 0,8";
		List<Map<String, Object>> list = dbUtils.selectDBListMapSorce(sql, inspectRecord.getCourse_id());
		return list;
	}

	@Override
	public List<Map<String, Object>> selectInspectScoreByDepartmentId(InspectRecord inspectRecord) {
		String sql = "select totalscore from tb_inspection_record where department_id=?  order by inspection_time desc limit 0,8";
		List<Map<String, Object>> list = dbUtils.selectDBListMapSorce(sql, inspectRecord.getDepartment_id());
		return list;
	}

	@Override
	public List<Map<String, Object>> selectInspectAverageScoreByDepartmentId(InspectRecord inspectRecord) {
		String sql = "select dt.department_name,ROUND(avg(rd.totalscore),1)  as avgscore from tb_inspection_record rd, tb_department dt where rd.department_id=dt.department_id group by rd.department_id order by avgscore desc";
		List<Map<String, Object>> list = dbUtils.selectDBListMapCC(sql);
		return list;
	}

	@Override
	public List<Map<String, Object>> selectInspectAverageScoreByTeacherId(InspectRecord inspectRecord) {
		String sql = "select tr.teacher_name,ROUND(avg(rd.totalscore),1)  as avgscore from tb_inspection_record rd, tb_teacher tr where rd.teacher_id=tr.teacher_id group by rd.teacher_id order by avgscore desc";
		List<Map<String, Object>> list = dbUtils.selectDBListMapCC(sql);
		return list;
	}

	@Override
	public List<Map<String, Object>> selectInspectAverageScoreByCourseId(InspectRecord inspectRecord) {
		String sql = "select ce.course_name,ROUND(avg(rd.totalscore),1)  as avgscore from tb_inspection_record rd, tb_course ce where rd.course_id=ce.course_id group by rd.course_id order by avgscore desc";
		List<Map<String, Object>> list = dbUtils.selectDBListMapCC(sql);
		return list;
	}

	@Override
	public List<Map<String, Object>> getAverageScoreByChoice(String choice) {
		if (choice.equals("teacher")) {
			String sqlbyteacher = "select ROUND(avg(rd.totalscore),1)  as avgscore,tr.teacher_name from tb_inspection_record rd, tb_teacher tr where rd.teacher_id=tr.teacher_id group by rd.teacher_id order by avgscore desc";
			List<Map<String, Object>> list = dbUtils.selectDBListMap(sqlbyteacher, new String[] { "value", "name" });
			return list;
		} else if (choice.equals("department")) {
			String sqlbydepartment = "select ROUND(avg(rd.totalscore),1)  as avgscore,dt.department_name from tb_inspection_record rd, tb_department dt where rd.department_id=dt.department_id group by rd.department_id order by avgscore desc";
			List<Map<String, Object>> list = dbUtils.selectDBListMap(sqlbydepartment, new String[] { "value", "name" });
			return list;
		} else if (choice.equals("course")) {
			String sqlbycourse = "select ROUND(avg(rd.totalscore),1)  as avgscore,ce.course_name from tb_inspection_record rd, tb_course ce where rd.course_id=ce.course_id group by rd.course_id order by avgscore desc";
			List<Map<String, Object>> list = dbUtils.selectDBListMap(sqlbycourse, new String[] { "value", "name" });
			return list;
		} else {
			return null;
		}
	}

	@Override
	public List<List<String>> getAverageScoreTitleByChoice(String choice) {
		if (choice.equals("teacher")) {
			String sqlbyteacher = "select ROUND(avg(rd.totalscore),1)  as avgscore,tr.teacher_name from tb_inspection_record rd, tb_teacher tr where rd.teacher_id=tr.teacher_id group by rd.teacher_id order by avgscore desc";
			List<List<String>> list = dbUtils.selectDBListList(sqlbyteacher);
			return list;
		} else if (choice.equals("department")) {
			String sqlbydepartment = "select ROUND(avg(rd.totalscore),1)  as avgscore,dt.department_name from tb_inspection_record rd, tb_department dt where rd.department_id=dt.department_id group by rd.department_id order by avgscore desc";
			List<List<String>> list = dbUtils.selectDBListList(sqlbydepartment);
			return list;
		} else if (choice.equals("course")) {
			String sqlbycourse = "select ROUND(avg(rd.totalscore),1)  as avgscore,ce.course_name from tb_inspection_record rd, tb_course ce where rd.course_id=ce.course_id group by rd.course_id order by avgscore desc";
			List<List<String>> list = dbUtils.selectDBListList(sqlbycourse);
			return list;
		} else {
			return null;
		}
	}

	@Override
	public List<Map<String, Object>> getAllInspectRecord(int page, int pagesize) {
		String sql = "select * from tb_inspection_record limit ?,?";
		List<Map<String, Object>> list = dbUtils.selectInfo(sql, page, pagesize);
		return list;
	}

}
