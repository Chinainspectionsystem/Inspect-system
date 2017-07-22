package com.iss.service;

import java.util.List;
import java.util.Map;

import com.iss.pojo.SysLogin;

public interface SysLoginService {
	//系统登录
	String searchSysLoginForValidateExit(SysLogin sysLogin);
	int getSysLoginTablePageCount(int pagesize);
	List<Map<String,Object>> getAllSysLoginByPage(int page, int pagesize);
	List<Map<String,Object>> getSysLoginByBlurry(SysLogin sysLogin, int page, int pagesize);
	List<Map<String,Object>> getSysLoginByUsername(SysLogin sysLogin);
	boolean IsUpdatePassword(String username,String oldpassword, String newpassword);	
	boolean IsUpdateIcon(String username,String icon_path);
	boolean IsUpdateLoginTime(SysLogin sysLogin);
}
