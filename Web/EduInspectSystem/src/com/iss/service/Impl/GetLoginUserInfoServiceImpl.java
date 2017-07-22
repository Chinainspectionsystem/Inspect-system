package com.iss.service.Impl;

import java.util.List;
import java.util.Map;

import com.iss.dao.IGetLonginUserInfoDAO;
import com.iss.dao.impl.GetLoginUserInfoDAOImpl;
import com.iss.service.IGetLoginUserInfoService;

public class GetLoginUserInfoServiceImpl implements IGetLoginUserInfoService {

	IGetLonginUserInfoDAO getLonginUserInfoDAO = new GetLoginUserInfoDAOImpl();

	@Override
	public List<Map<String, Object>> getLonginUserInfo(String username) {
		List<Map<String, Object>> list = getLonginUserInfoDAO.getLonginUserInfo(username);
		return list;
	}

}
