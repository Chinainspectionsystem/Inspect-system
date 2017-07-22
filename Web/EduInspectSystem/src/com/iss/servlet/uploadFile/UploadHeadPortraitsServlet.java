package com.iss.servlet.uploadFile;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.iss.service.Impl.UploadFileServiceImpl;

/**
 * Servlet implementation class UploadHeadPortraits
 */
@WebServlet("/servlet/UploadHeadPortraitsServlet")
public class UploadHeadPortraitsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uploadPath = this.getServletContext().getRealPath("/img/head_portraits");
		File file = new File(uploadPath);
		if (!file.exists() && !file.isDirectory()) {
			file.mkdirs();
		}

		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload fileUpload = new ServletFileUpload(factory);
		fileUpload.setSizeMax(3 * 1024 * 1024);
		List<FileItem> fileItemList;
		String fileName = "";

		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");

		try {
			fileItemList = (List<FileItem>) fileUpload.parseRequest(request);
			for (FileItem item : fileItemList) {
				fileName = item.getName();
				if (fileName != null) {
					int count = fileName.lastIndexOf(".");
					String extendName = fileName.substring(count + 1);
					Date date = new Date();
					long newFileName = date.getTime();
					fileName = newFileName + "." + extendName;
					File uploadFile = new File(uploadPath + "\\" + fileName);
					item.write(uploadFile);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UploadFileServiceImpl uploadFileServiceImpl = new UploadFileServiceImpl();
		String absolutePath = uploadPath + "\\" + fileName;
		int position = absolutePath.lastIndexOf("\\");
		String relativePath = absolutePath.substring(position - 18);
		int count = uploadFileServiceImpl.uploadHeadPortraits(username, relativePath);

		// 发现并没有什么用！！！！！//////////////////////
		String result = "";
		if (count > 0) {
			result = "成功";
		}
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
		out.close();
		//////////////////////////////////////////
	}
}
