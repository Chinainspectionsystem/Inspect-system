package com.iss.servlet.course;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iss.pojo.CourseInfo;
import com.iss.service.ICourseInfoService;
import com.iss.service.Impl.CourseInfoServiceImpl;

/**
 * Servlet implementation class EditCourseInfoServlet
 */
@WebServlet("/servlet/EditCourseInfoServlet")
public class EditCourseInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String course_id = request.getParameter("course_id");
		String course_name = request.getParameter("course_name");
		String department_id = request.getParameter("department");
		String course_hour = request.getParameter("course_hour");
		String course_credit = request.getParameter("course_credit");
		CourseInfo courseiBean = new CourseInfo();
		courseiBean.setCourse_id(course_id);
		courseiBean.setCourse_name(course_name);
		courseiBean.setDepartment_id(department_id);
		courseiBean.setCourse_hour(course_hour);
		courseiBean.setCourse_credit(course_credit);
		ICourseInfoService courseis = new CourseInfoServiceImpl();
		int result = courseis.editCourseInfo(courseiBean);
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
		out.close();
	}

}
