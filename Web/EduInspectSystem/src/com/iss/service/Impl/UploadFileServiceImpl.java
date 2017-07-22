package com.iss.service.Impl;

import com.iss.dao.impl.UploadFileDAOImpl;
import com.iss.service.IUploadFileService;

public class UploadFileServiceImpl implements IUploadFileService {

	UploadFileDAOImpl uploadFileDAO = new UploadFileDAOImpl();

	@Override
	public int uploadHeadPortraits(String username, String path) {
		int count = uploadFileDAO.uploadHeanPortraits(username, path);
		return count;
	}

}
