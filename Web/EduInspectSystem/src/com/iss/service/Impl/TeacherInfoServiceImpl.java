package com.iss.service.Impl;

import java.util.List;
import java.util.Map;

import com.iss.dao.ITeacherInfoDAO;
import com.iss.dao.impl.TeacherInfoDAOImpl;
import com.iss.pojo.TeacherInfo;
import com.iss.service.ITeacherInfoService;

public class TeacherInfoServiceImpl implements ITeacherInfoService {

	ITeacherInfoDAO tidao = new TeacherInfoDAOImpl();

	@Override
	public List<Map<String, Object>> getTeacherInfo(int page, int pagesize) {
		List<Map<String, Object>> list = tidao.getTeacherInfo(page, pagesize);
		return list;
	}

	@Override
	public int editTeacherInfo(TeacherInfo teacherInfo) {
		int count = tidao.editTeacherInfo(teacherInfo);
		return count;
	}

	@Override
	public List<Map<String, Object>> searchTeacherInfo(TeacherInfo teacherInfo, int page, int pagesize) {
		List<Map<String, Object>> list = tidao.searchTeacherInfo(teacherInfo, page, pagesize);
		return list;
	}

	@Override
	public int deleteTeacherInfo(TeacherInfo teacherInfo) {
		int count = tidao.deleteTeacherInfo(teacherInfo);
		return count;
	}

	@Override
	public int addTeachersInfo(TeacherInfo teacherInfo) {
		int count = tidao.addTeacherInfo(teacherInfo);
		return count;
	}

}
