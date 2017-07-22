package com.iss.servlet.classes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iss.pojo.ClassInfo;
import com.iss.service.IClassInfoService;
import com.iss.service.Impl.ClassInfoServiceImpl;

/**
 * Servlet implementation class DeleteClassesInfoServlet
 */
@WebServlet("/servlet/DeleteClassesInfoServlet")
public class DeleteClassesInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String class_name = request.getParameter("class_name");
		ClassInfo ciBean = new ClassInfo();
		ciBean.setClass_name(class_name);
		IClassInfoService cis = new ClassInfoServiceImpl();
		int result = cis.deleteClassInfo(ciBean);
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
		out.close();
	}

}
