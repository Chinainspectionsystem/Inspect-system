package com.iss.dao;

import java.util.List;
import java.util.Map;

import com.iss.pojo.SysLogin;

public interface SysLoginDAO {
	// 系统登录
	String searchSysLoginForValidateExit(SysLogin sysLogin);

	int selectSysLoginTablePageCount(int pagesize);

	List<Map<String, Object>> selectAllSysLoginByPage(int page, int pagesize);

	List<Map<String, Object>> selectSysLoginByBlurry(SysLogin sysLogin, int page, int pagesize);

	List<Map<String, Object>> selectSysLoginByUsername(SysLogin sysLogin);

	boolean updatePassword(String username, String oldpassword, String newpassword);

	boolean updateIcon(String username, String icon_path);

	boolean updateLoginTime(SysLogin sysLogin);
}
