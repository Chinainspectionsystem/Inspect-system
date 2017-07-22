package com.iss.service;

import java.util.List;
import java.util.Map;

import com.iss.pojo.InspectRecord;

public interface InspectRecordService {
	int getInspectRecordTablePageCount(int pagesize);

	List<Map<String, Object>> getAllInspectRecordByPage(int page, int pagesize);

	List<Map<String, Object>> getInspectRecordByBlurry(InspectRecord inspectRecord, int page, int pagesize);

	List<Map<String, Object>> getInspectRecordByUsername(InspectRecord inspectRecord);

	List<Map<String, Object>> getNameIDByTeachingId(InspectRecord inspectRecord);

	List<Map<String, Object>> getTeachingPlaceByTeachingId(InspectRecord inspectRecord);

	List<Map<String, Object>> getInspectScoreByTeacherId(InspectRecord inspectRecord);

	List<Map<String, Object>> getInspectScoreByCourseId(InspectRecord inspectRecord);

	List<Map<String, Object>> getInspectScoreByDepartmentId(InspectRecord inspectRecord);

	List<Map<String, Object>> getInspectAverageScoreByDepartmentId(InspectRecord inspectRecord);

	List<Map<String, Object>> getInspectAverageScoreByTeacherId(InspectRecord inspectRecord);

	List<Map<String, Object>> getInspectAverageScoreByCourseId(InspectRecord inspectRecord);

	List<Map<String, Object>> getAverageScoreByChoice(String choice);

	List<List<String>> getAverageScoreTitleByChoice(String choice);

	boolean IsAddInspectRecord(InspectRecord inspectRecord);

	boolean IsDeleteInspectRecordByUsername(InspectRecord inspectRecord);

	//////////// 获取巡查记录及其所有信息
	List<Map<String, Object>> getAllInspectRecord(int page, int pagesize);
}
