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
 * Servlet implementation class DeleteCourseInfoServlet
 */
@WebServlet("/servlet/DeleteCourseInfoServlet")
public class DeleteCourseInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String course_id = request.getParameter("course_id");
		CourseInfo courseiBean = new CourseInfo();
		courseiBean.setCourse_id(course_id);
		ICourseInfoService courseis = new CourseInfoServiceImpl();
		int result = courseis.deleteCourseInfo(courseiBean);
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
		out.close();
	}

}
