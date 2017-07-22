package com.iss.service;

import java.util.List;
import java.util.Map;

import com.iss.pojo.SysUser;

public interface SysUserService {
	//系统用户
	int getSysUserTablePageCount(int pagesize);
	List<Map<String,Object>> getAllSysUserByPage(int page, int pagesize);
	List<Map<String,Object>> getSysUserByBlurry(SysUser sysUser, int page, int pagesize);
	List<Map<String,Object>> getSysUserByUsername(SysUser sysUser);
	boolean IsUpdateSysUser(SysUser sysUser);
	boolean IsUpdateSysUserRole(SysUser sysUser);
	boolean IsDeleteSysUserByUsername(SysUser sysUser);
	boolean IsAddSysUserFromSysUserTable(SysUser sysUser);
}
