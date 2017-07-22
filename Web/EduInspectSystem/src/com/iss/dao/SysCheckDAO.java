package com.iss.dao;

import java.util.List;
import java.util.Map;

import com.iss.pojo.SysCheck;

public interface SysCheckDAO {
	//用户审核
	boolean searchSysUesrForValidateExit(SysCheck sysCheck);
	int selectSysCheckTablePageCount(int pagesize);
	List<Map<String,Object>> selectAllSysCheckByPage(int page, int pagesize);
	List<Map<String,Object>> selectSysCheckByBlurry(SysCheck sysCheck, int page, int pagesize);
	List<Map<String,Object>> selectSysCheckByUsername(SysCheck sysCheck);
	boolean addSysCheck(SysCheck sysCheck);
	boolean addSysUserFromSysCheckTable(SysCheck sysCheck,String role);
	boolean deleteSysCheckByUsername(SysCheck sysCheck);
}
