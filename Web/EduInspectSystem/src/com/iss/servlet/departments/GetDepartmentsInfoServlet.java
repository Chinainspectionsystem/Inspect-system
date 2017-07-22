package com.iss.servlet.departments;

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
import com.iss.service.IDepartmentInfoService;
import com.iss.service.Impl.DepartmentInfoServiceImpl;

/**
 * Servlet implementation class GetDepartmentsInfoServlet
 */
@WebServlet("/servlet/GetDepartmentsInfoServlet")
public class GetDepartmentsInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetDepartmentsInfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		int pagesize = Integer.parseInt(request.getParameter("pagesize"));
		IDepartmentInfoService dis = new DepartmentInfoServiceImpl();
		List<Map<String, Object>> list = dis.getDepartmentInfo(page * pagesize, pagesize);
		PrintWriter out = response.getWriter();
		out.print(JSON.toJSONString(list));
		out.flush();
		out.close();
	}

}
