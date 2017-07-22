package com.iss.dao;

import java.util.List;
import java.util.Map;

import com.iss.pojo.SysUser;

public interface SysUserDAO {
	//系统用户
	int selectSysUserTablePageCount(int pagesize);
	List<Map<String,Object>> selectAllSysUserByPage(int page, int pagesize);
	List<Map<String,Object>> selectSysUserByBlurry(SysUser sysUser, int page, int pagesize);
	List<Map<String,Object>> selectSysUserByUsername(SysUser sysUser);
	boolean updateSysUser(SysUser sysUser);
	boolean updateSysUserRole(SysUser sysUser);
	boolean deleteSysUserByUsername(SysUser sysUser);
	boolean addSysUserFromSysUserTable(SysUser sysUser);	
}
