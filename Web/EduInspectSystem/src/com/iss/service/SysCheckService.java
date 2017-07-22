package com.iss.service;

import java.util.List;
import java.util.Map;

import com.iss.pojo.SysCheck;

public interface SysCheckService {
	//用户审核
	boolean searchSysUesrForValidateExit(SysCheck sysCheck);
	int getSysCheckTablePageCount(int pagesize);
	List<Map<String,Object>> getAllSysCheckByPage(int page, int pagesize);
	List<Map<String,Object>> getSysCheckByBlurry(SysCheck sysCheck, int page, int pagesize);
	List<Map<String,Object>> getSysCheckByUsername(SysCheck sysCheck);
	boolean IsAddSysCheck(SysCheck sysCheck);
	boolean IsAddSysUserFromSysCheckTable(SysCheck sysCheck,String role);
	boolean IsDeleteSysCheckByUsername(SysCheck sysCheck);
}
