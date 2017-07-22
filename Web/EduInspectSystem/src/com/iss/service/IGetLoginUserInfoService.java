package com.iss.service;

import java.util.List;
import java.util.Map;

public interface IGetLoginUserInfoService {
	List<Map<String, Object>> getLonginUserInfo(String username);
}
