package com.iss.service.Impl;

import java.util.List;
import java.util.Map;

import com.iss.dao.IDepartmentInfoDAO;
import com.iss.dao.impl.DepartmentInfoDAOImpl;
import com.iss.pojo.DepartmentInfo;
import com.iss.service.IDepartmentInfoService;

public class DepartmentInfoServiceImpl implements IDepartmentInfoService {

	IDepartmentInfoDAO didao = new DepartmentInfoDAOImpl();

	@Override
	public List<Map<String, Object>> getDepartmentInfo(int page, int pagesize) {
		List<Map<String, Object>> list = didao.getDepartmentInfo(page, pagesize);
		return list;
	}

	@Override
	public int editDepartmentInfo(DepartmentInfo departmentInfo) {
		int count = didao.editDepartmentInfo(departmentInfo);
		return count;
	}

	@Override
	public int deleteDepartmentInfo(DepartmentInfo departmentInfo) {
		int count = didao.deleteDepartmentInfo(departmentInfo);
		return count;
	}

	@Override
	public List<Map<String, Object>> searchDeapartmentInfo(DepartmentInfo departmentInfo, int page, int pagesize) {
		List<Map<String, Object>> list = didao.searchDepartmentInfo(departmentInfo, page, pagesize);
		return list;
	}

}
