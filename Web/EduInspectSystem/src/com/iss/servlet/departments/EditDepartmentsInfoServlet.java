package com.iss.servlet.departments;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iss.pojo.DepartmentInfo;
import com.iss.service.IDepartmentInfoService;
import com.iss.service.Impl.DepartmentInfoServiceImpl;

/**
 * Servlet implementation class EditDepartmentsInfoServlet
 */
@WebServlet("/servlet/EditDepartmentsInfoServlet")
public class EditDepartmentsInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditDepartmentsInfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String department_id = request.getParameter("department_id");
		String department_name = request.getParameter("department_name");
		String department_head = request.getParameter("department_head");
		DepartmentInfo diBean = new DepartmentInfo();
		diBean.setDepartment_id(department_id);
		diBean.setDepartment_name(department_name);
		diBean.setDepartment_head(department_head);
		IDepartmentInfoService dis = new DepartmentInfoServiceImpl();
		int result = dis.editDepartmentInfo(diBean);
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
		out.close();
	}

}
