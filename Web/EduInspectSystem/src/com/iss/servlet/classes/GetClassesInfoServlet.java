package com.iss.servlet.classes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.iss.service.IClassInfoService;
import com.iss.service.Impl.ClassInfoServiceImpl;

/**
 * Servlet implementation class GetClassesInfoServlet
 */
@WebServlet("/servlet/GetClassesInfoServlet")
public class GetClassesInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int page = Integer.parseInt(request.getParameter("page"));
		int pagesize = Integer.parseInt(request.getParameter("pagesize"));

		IClassInfoService cis = new ClassInfoServiceImpl();
		List<Map<String, Object>> result = cis.getClassInfo(page * pagesize, pagesize);
		PrintWriter out = response.getWriter();
		out.print(JSON.toJSONString(result));
		out.flush();
		out.close();
	}

}
