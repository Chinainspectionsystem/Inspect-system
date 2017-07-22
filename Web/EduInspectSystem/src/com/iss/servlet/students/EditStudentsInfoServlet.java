package com.iss.servlet.students;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iss.pojo.StudentInfo;
import com.iss.service.IStudentInfoService;
import com.iss.service.Impl.StudentInfoServiceImpl;

/**
 * Servlet implementation class EditStudentsInfoServlet
 */
@WebServlet("/servlet/EditStudentsInfoServlet")
public class EditStudentsInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditStudentsInfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String student_id = request.getParameter("student_id");
		String student_name = request.getParameter("student_name");
		String department_id = request.getParameter("department_id");
		String class_name = request.getParameter("class_name");
		String gender = request.getParameter("gender");
		StudentInfo siBean = new StudentInfo();
		siBean.setStudent_id(student_id);
		siBean.setStudent_name(student_name);
		siBean.setDepartment_id(department_id);
		siBean.setClass_name(class_name);
		siBean.setGender(gender);
		IStudentInfoService sis = new StudentInfoServiceImpl();
		int result = sis.editStudentInfo(siBean);
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
		out.close();
	}

}
