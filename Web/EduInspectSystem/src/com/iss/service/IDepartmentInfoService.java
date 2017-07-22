package com.iss.service;

import java.util.List;
import java.util.Map;

import com.iss.pojo.DepartmentInfo;

public interface IDepartmentInfoService {
	List<Map<String, Object>> getDepartmentInfo(int page, int pagesize);

	int editDepartmentInfo(DepartmentInfo departmentInfo);

	int deleteDepartmentInfo(DepartmentInfo departmentInfo);

	List<Map<String, Object>> searchDeapartmentInfo(DepartmentInfo departmentInfo, int page, int pagesize);
}
