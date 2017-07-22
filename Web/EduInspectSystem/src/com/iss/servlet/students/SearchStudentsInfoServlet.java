package com.iss.servlet.students;

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
import com.iss.pojo.StudentInfo;
import com.iss.service.IStudentInfoService;
import com.iss.service.Impl.StudentInfoServiceImpl;

/**
 * Servlet implementation class SearchStudentsInfoServlet
 */
@WebServlet("/servlet/SearchStudentsInfoServlet")
public class SearchStudentsInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		int pagesize = Integer.parseInt(request.getParameter("pagesize"));

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
		List<Map<String, Object>> result = sis.searchStudentInfo(siBean, page * pagesize, pagesize);
		PrintWriter out = response.getWriter();
		out.print(JSON.toJSONString(result));
		out.flush();
		out.close();
	}

}
