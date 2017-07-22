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
 * Servlet implementation class DeleteDepartmentsInfoServlet
 */
@WebServlet("/servlet/DeleteDepartmentsInfoServlet")
public class DeleteDepartmentsInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String department_id = request.getParameter("department_id");
		DepartmentInfo diBean = new DepartmentInfo();
		diBean.setDepartment_id(department_id);
		IDepartmentInfoService disBean = new DepartmentInfoServiceImpl();
		int result = disBean.deleteDepartmentInfo(diBean);
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
		out.close();
	}

}
