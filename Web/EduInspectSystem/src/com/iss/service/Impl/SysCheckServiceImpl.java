package com.iss.service.Impl;

import java.util.List;
import java.util.Map;

import com.iss.dao.SysCheckDAO;
import com.iss.dao.impl.SysCheckDAOImpl;
import com.iss.pojo.SysCheck;
import com.iss.service.SysCheckService;

public class SysCheckServiceImpl implements SysCheckService{
	SysCheckDAO sysCheckDAO = new SysCheckDAOImpl();
	@Override
	public boolean searchSysUesrForValidateExit(SysCheck sysCheck) {
		return sysCheckDAO.searchSysUesrForValidateExit(sysCheck);
	}

	@Override
	public int getSysCheckTablePageCount(int pagesize) {
		return sysCheckDAO.selectSysCheckTablePageCount(pagesize);
	}

	@Override
	public List<Map<String, Object>> getAllSysCheckByPage(int page, int pagesize) {
		return sysCheckDAO.selectAllSysCheckByPage(page, pagesize);
	}

	@Override
	public List<Map<String, Object>> getSysCheckByBlurry(SysCheck sysCheck, int page, int pagesize) {
		return sysCheckDAO.selectSysCheckByBlurry(sysCheck, page, pagesize);
	}

	@Override
	public List<Map<String, Object>> getSysCheckByUsername(SysCheck sysCheck) {
		return sysCheckDAO.selectSysCheckByUsername(sysCheck);
	}

	@Override
	public boolean IsAddSysCheck(SysCheck sysCheck) {
		return sysCheckDAO.addSysCheck(sysCheck);
	}

	@Override
	public boolean IsAddSysUserFromSysCheckTable(SysCheck sysCheck, String role) {
		return sysCheckDAO.addSysUserFromSysCheckTable(sysCheck, role);
	}

	@Override
	public boolean IsDeleteSysCheckByUsername(SysCheck sysCheck) {
		return sysCheckDAO.deleteSysCheckByUsername(sysCheck);
	}


}
