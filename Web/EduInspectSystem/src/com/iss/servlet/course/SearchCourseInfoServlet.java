package com.iss.servlet.course;

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
import com.iss.pojo.CourseInfo;
import com.iss.service.ICourseInfoService;
import com.iss.service.Impl.CourseInfoServiceImpl;

/**
 * Servlet implementation class SearchCourseInfoServlet
 */
@WebServlet("/servlet/SearchCourseInfoServlet")
public class SearchCourseInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		int pagesize = Integer.parseInt(request.getParameter("pagesize"));

		String course_id = request.getParameter("course_id");
		String course_name = request.getParameter("course_name");
		String department_id = request.getParameter("department_id");
		String course_hour = request.getParameter("course_hour");
		String course_credit = request.getParameter("course_credit");
		CourseInfo courseiBean = new CourseInfo();
		courseiBean.setCourse_id(course_id);
		courseiBean.setCourse_name(course_name);
		courseiBean.setDepartment_id(department_id);
		courseiBean.setCourse_hour(course_hour);
		courseiBean.setCourse_credit(course_credit);
		ICourseInfoService courseis = new CourseInfoServiceImpl();
		List<Map<String, Object>> result = courseis.searchCourseInfo(courseiBean, page * pagesize, pagesize);
		PrintWriter out = response.getWriter();
		out.print(JSON.toJSONString(result));
		out.flush();
		out.close();
	}

}
