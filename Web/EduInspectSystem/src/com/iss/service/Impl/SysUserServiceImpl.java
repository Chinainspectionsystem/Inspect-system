package com.iss.service.Impl;

import java.util.List;
import java.util.Map;

import com.iss.dao.SysUserDAO;
import com.iss.dao.impl.SysUserDAOImpl;
import com.iss.pojo.SysUser;
import com.iss.service.SysUserService;

public class SysUserServiceImpl implements SysUserService{
	SysUserDAO sysUserDAO = new SysUserDAOImpl();
	@Override
	public int getSysUserTablePageCount(int pagesize) {
		return sysUserDAO.selectSysUserTablePageCount(pagesize);
	}

	@Override
	public List<Map<String, Object>> getAllSysUserByPage(int page, int pagesize) {
		return sysUserDAO.selectAllSysUserByPage(page, pagesize);
	}

	@Override
	public List<Map<String, Object>> getSysUserByBlurry(SysUser sysUser, int page, int pagesize) {
		return sysUserDAO.selectSysUserByBlurry(sysUser, page, pagesize);
	}

	@Override
	public List<Map<String, Object>> getSysUserByUsername(SysUser sysUser) {
		return sysUserDAO.selectSysUserByUsername(sysUser);
	}

	@Override
	public boolean IsUpdateSysUser(SysUser sysUser) {
		return sysUserDAO.updateSysUser(sysUser);
	}
	@Override
	public boolean IsUpdateSysUserRole(SysUser sysUser) {
		return sysUserDAO.updateSysUserRole(sysUser);
	}
	@Override
	public boolean IsDeleteSysUserByUsername(SysUser sysUser) {
		return sysUserDAO.deleteSysUserByUsername(sysUser);
	}

	@Override
	public boolean IsAddSysUserFromSysUserTable(SysUser sysUser) {
		return sysUserDAO.addSysUserFromSysUserTable(sysUser);
	}

}
