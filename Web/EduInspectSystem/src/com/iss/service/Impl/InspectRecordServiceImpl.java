package com.iss.service.Impl;

import java.util.List;
import java.util.Map;

import com.iss.dao.InspectRecordDAO;
import com.iss.dao.impl.InspectRecordDAOImpl;
import com.iss.pojo.InspectRecord;
import com.iss.service.InspectRecordService;

public class InspectRecordServiceImpl implements InspectRecordService {
	InspectRecordDAO inspectRecordDAO = new InspectRecordDAOImpl();

	@Override
	public int getInspectRecordTablePageCount(int pagesize) {
		return inspectRecordDAO.selectInspectRecordTablePageCount(pagesize);
	}

	@Override
	public List<Map<String, Object>> getAllInspectRecordByPage(int page, int pagesize) {
		return inspectRecordDAO.selectAllInspectRecordByPage(page, pagesize);
	}

	@Override
	public List<Map<String, Object>> getInspectRecordByBlurry(InspectRecord inspectRecord, int page, int pagesize) {
		return inspectRecordDAO.selectInspectRecordByBlurry(inspectRecord, page, pagesize);
	}

	@Override
	public List<Map<String, Object>> getInspectRecordByUsername(InspectRecord inspectRecord) {
		return inspectRecordDAO.selectInspectRecordByUsername(inspectRecord);
	}

	@Override
	public boolean IsAddInspectRecord(InspectRecord inspectRecord) {
		return inspectRecordDAO.addInspectRecord(inspectRecord);
	}

	@Override
	public boolean IsDeleteInspectRecordByUsername(InspectRecord inspectRecord) {
		return inspectRecordDAO.deleteInspectRecordByUsername(inspectRecord);
	}

	@Override
	public List<Map<String, Object>> getNameIDByTeachingId(InspectRecord inspectRecord) {
		return inspectRecordDAO.selectNameIDByTeachingId(inspectRecord);
	}

	@Override
	public List<Map<String, Object>> getTeachingPlaceByTeachingId(InspectRecord inspectRecord) {
		return inspectRecordDAO.selectTeachingPlaceByTeachingId(inspectRecord);
	}

	@Override
	public List<Map<String, Object>> getInspectScoreByTeacherId(InspectRecord inspectRecord) {
		return inspectRecordDAO.selectInspectScoreByTeacherId(inspectRecord);
	}

	@Override
	public List<Map<String, Object>> getInspectScoreByCourseId(InspectRecord inspectRecord) {
		return inspectRecordDAO.selectInspectScoreByCourseId(inspectRecord);
	}

	@Override
	public List<Map<String, Object>> getInspectScoreByDepartmentId(InspectRecord inspectRecord) {
		return inspectRecordDAO.selectInspectScoreByDepartmentId(inspectRecord);
	}

	@Override
	public List<Map<String, Object>> getInspectAverageScoreByDepartmentId(InspectRecord inspectRecord) {
		return inspectRecordDAO.selectInspectAverageScoreByDepartmentId(inspectRecord);
	}

	@Override
	public List<Map<String, Object>> getInspectAverageScoreByTeacherId(InspectRecord inspectRecord) {
		return inspectRecordDAO.selectInspectAverageScoreByTeacherId(inspectRecord);
	}

	@Override
	public List<Map<String, Object>> getInspectAverageScoreByCourseId(InspectRecord inspectRecord) {
		return inspectRecordDAO.selectInspectAverageScoreByCourseId(inspectRecord);
	}

	@Override
	public List<Map<String, Object>> getAverageScoreByChoice(String choice) {
		return inspectRecordDAO.getAverageScoreByChoice(choice);
	}

	@Override
	public List<List<String>> getAverageScoreTitleByChoice(String choice) {
		return inspectRecordDAO.getAverageScoreTitleByChoice(choice);
	}

	@Override
	public List<Map<String, Object>> getAllInspectRecord(int page, int pagesize) {
		return inspectRecordDAO.getAllInspectRecord(page, pagesize);
	}

}
