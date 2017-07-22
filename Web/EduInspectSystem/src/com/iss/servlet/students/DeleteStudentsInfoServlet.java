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
 * Servlet implementation class DeleteStudentsInfoServlet
 */
@WebServlet("/servlet/DeleteStudentsInfoServlet")
public class DeleteStudentsInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteStudentsInfoServlet() {
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
		StudentInfo siBean = new StudentInfo();
		siBean.setStudent_id(student_id);
		IStudentInfoService sis = new StudentInfoServiceImpl();
		int result = sis.deleteStudentInfo(siBean);
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
		out.close();
	}

}
