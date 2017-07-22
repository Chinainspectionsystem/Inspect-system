package com.iss.service.Impl;

import java.util.List;
import java.util.Map;

import com.iss.dao.IClassInfoDAO;
import com.iss.dao.impl.ClassInfoDAOImpl;
import com.iss.pojo.ClassInfo;
import com.iss.service.IClassInfoService;

public class ClassInfoServiceImpl implements IClassInfoService {

	IClassInfoDAO cid = new ClassInfoDAOImpl();

	@Override
	public List<Map<String, Object>> getClassInfo(int page, int pagesize) {
		List<Map<String, Object>> list = cid.getClassInfo(page, pagesize);
		return list;
	}

	@Override
	public int editClassInfo(ClassInfo classInfo) {
		int count = cid.editClassInfo(classInfo);
		return count;
	}

	@Override
	public int deleteClassInfo(ClassInfo classInfo) {
		int count = cid.deleteClassInfo(classInfo);
		return count;
	}

	@Override
	public List<Map<String, Object>> searchClassInfo(ClassInfo classInfo, int page, int pagesize) {
		List<Map<String, Object>> list = cid.searchClassInfo(classInfo, page, pagesize);
		return list;
	}

}
