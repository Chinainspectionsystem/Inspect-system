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
import com.iss.pojo.DepartmentInfo;
import com.iss.service.IDepartmentInfoService;
import com.iss.service.Impl.DepartmentInfoServiceImpl;

/**
 * Servlet implementation class SearchDepartmentsInfoServlet
 */
@WebServlet("/servlet/SearchDepartmentsInfoServlet")
public class SearchDepartmentsInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		int pagesize = Integer.parseInt(request.getParameter("pagesize"));

		String department_id = request.getParameter("department_id");
		String department_name = request.getParameter("department_name");
		String department_head = request.getParameter("department_head");
		DepartmentInfo diBean = new DepartmentInfo();
		diBean.setDepartment_id(department_id);
		diBean.setDepartment_name(department_name);
		diBean.setDepartment_head(department_head);
		IDepartmentInfoService dis = new DepartmentInfoServiceImpl();
		List<Map<String, Object>> result = dis.searchDeapartmentInfo(diBean, page * pagesize, pagesize);
		PrintWriter out = response.getWriter();
		out.print(JSON.toJSONString(result));
		out.flush();
		out.close();
	}

}
