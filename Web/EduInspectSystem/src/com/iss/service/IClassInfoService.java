package com.iss.service;

import java.util.List;
import java.util.Map;

import com.iss.pojo.ClassInfo;

public interface IClassInfoService {
	List<Map<String, Object>> getClassInfo(int page, int pagesize);

	int editClassInfo(ClassInfo classInfo);

	int deleteClassInfo(ClassInfo classInfo);

	List<Map<String, Object>> searchClassInfo(ClassInfo classInfo, int page, int pagesize);
}
