package com.iss.dao;

import java.util.List;
import java.util.Map;

import com.iss.pojo.InspectRecord;
import com.iss.pojo.SysCheck;

public interface InspectRecordDAO {
	int selectInspectRecordTablePageCount(int pagesize);

	List<Map<String, Object>> selectAllInspectRecordByPage(int page, int pagesize);

	List<Map<String, Object>> selectInspectRecordByBlurry(InspectRecord inspectRecord, int page, int pagesize);

	List<Map<String, Object>> selectInspectRecordByUsername(InspectRecord inspectRecord);

	List<Map<String, Object>> selectNameIDByTeachingId(InspectRecord inspectRecord);

	List<Map<String, Object>> selectTeachingPlaceByTeachingId(InspectRecord inspectRecord);

	List<Map<String, Object>> selectInspectScoreByTeacherId(InspectRecord inspectRecord);

	List<Map<String, Object>> selectInspectScoreByCourseId(InspectRecord inspectRecord);

	List<Map<String, Object>> selectInspectScoreByDepartmentId(InspectRecord inspectRecord);

	List<Map<String, Object>> selectInspectAverageScoreByDepartmentId(InspectRecord inspectRecord);

	List<Map<String, Object>> selectInspectAverageScoreByTeacherId(InspectRecord inspectRecord);

	List<Map<String, Object>> selectInspectAverageScoreByCourseId(InspectRecord inspectRecord);

	List<Map<String, Object>> getAverageScoreByChoice(String choice);

	List<List<String>> getAverageScoreTitleByChoice(String choice);

	boolean addInspectRecord(InspectRecord inspectRecord);

	boolean deleteInspectRecordByUsername(InspectRecord inspectRecord);

	//////// 得到所有巡查记录的所有信息
	List<Map<String, Object>> getAllInspectRecord(int page, int pagesize);
}
