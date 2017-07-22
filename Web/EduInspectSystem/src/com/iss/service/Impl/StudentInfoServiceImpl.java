package com.iss.service.Impl;

import java.util.List;
import java.util.Map;

import com.iss.dao.IStudentInfoDAO;
import com.iss.dao.impl.StudentInfoDAOImpl;
import com.iss.pojo.StudentInfo;
import com.iss.service.IStudentInfoService;

public class StudentInfoServiceImpl implements IStudentInfoService {

	IStudentInfoDAO sidao = new StudentInfoDAOImpl();

	@Override
	public List<Map<String, Object>> getStudnetsInfo(int page, int pagesize) {
		List<Map<String, Object>> list = sidao.getStudentsInfo(page, pagesize);
		return list;
	}

	@Override
	public int editStudentInfo(StudentInfo studentInfo) {
		int count = sidao.editStudentInfo(studentInfo);
		return count;
	}

	@Override
	public int deleteStudentInfo(StudentInfo studentInfo) {
		int count = sidao.deleteStudentInfo(studentInfo);
		return count;
	}

	@Override
	public List<Map<String, Object>> searchStudentInfo(StudentInfo studentInfo, int page, int pagesize) {
		List<Map<String, Object>> list = sidao.searchStudentInfo(studentInfo, page, pagesize);
		return list;
	}

}
