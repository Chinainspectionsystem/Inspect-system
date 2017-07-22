package com.iss.service.Impl;

import java.util.List;
import java.util.Map;

import com.iss.dao.SysLoginDAO;
import com.iss.dao.impl.SysLoginDAOImpl;
import com.iss.pojo.SysLogin;
import com.iss.service.SysLoginService;

public class SysLoginServiceImpl implements SysLoginService{
	SysLoginDAO sysLoginDAO = new SysLoginDAOImpl();
	@Override
	public String searchSysLoginForValidateExit(SysLogin sysLogin) {
		return sysLoginDAO.searchSysLoginForValidateExit(sysLogin);
	}

	@Override
	public int getSysLoginTablePageCount(int pagesize) {
		return sysLoginDAO.selectSysLoginTablePageCount(pagesize);
	}

	@Override
	public List<Map<String, Object>> getAllSysLoginByPage(int page, int pagesize) {
		return sysLoginDAO.selectAllSysLoginByPage(page, pagesize);
	}

	@Override
	public List<Map<String, Object>> getSysLoginByBlurry(SysLogin sysLogin, int page, int pagesize) {
		return sysLoginDAO.selectSysLoginByBlurry(sysLogin, page, pagesize);
	}

	@Override
	public List<Map<String, Object>> getSysLoginByUsername(SysLogin sysLogin) {
		return sysLoginDAO.selectSysLoginByUsername(sysLogin);
	}

	@Override
	public boolean IsUpdatePassword(String username, String oldpassword, String newpassword) {
		return sysLoginDAO.updatePassword(username, oldpassword, newpassword);
	}

	@Override
	public boolean IsUpdateIcon(String username, String icon_path) {
		return sysLoginDAO.updateIcon(username, icon_path);
	}

	@Override
	public boolean IsUpdateLoginTime(SysLogin sysLogin) {
		return sysLoginDAO.updateLoginTime(sysLogin);
	}

}
