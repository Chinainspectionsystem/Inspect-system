package com.iss.dao;

import java.util.List;
import java.util.Map;

public interface IGetLonginUserInfoDAO {
	List<Map<String, Object>> getLonginUserInfo(String username);
}
