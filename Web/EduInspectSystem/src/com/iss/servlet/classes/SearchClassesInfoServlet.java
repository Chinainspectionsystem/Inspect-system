package com.iss.servlet.classes;

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
import com.iss.pojo.ClassInfo;
import com.iss.service.IClassInfoService;
import com.iss.service.Impl.ClassInfoServiceImpl;

/**
 * Servlet implementation class SearchClassesInfoServlet
 */
@WebServlet("/servlet/SearchClassesInfoServlet")
public class SearchClassesInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		int pagesize = Integer.parseInt(request.getParameter("pagesize"));
		String class_name = request.getParameter("class_name");
		String department_id = request.getParameter("department_id");
		String class_population = request.getParameter("class_population");
		String class_grade = request.getParameter("class_grade");
		String teacher_id = request.getParameter("teacher_id");
		ClassInfo ciBean = new ClassInfo();
		ciBean.setClass_name(class_name);
		ciBean.setDepartment_id(department_id);
		ciBean.setClass_population(class_population);
		ciBean.setClass_grade(class_grade);
		ciBean.setTeacher_id(teacher_id);
		IClassInfoService cis = new ClassInfoServiceImpl();
		List<Map<String, Object>> result = cis.searchClassInfo(ciBean, page * pagesize, pagesize);
		System.out.println("SearchClassesInfoServlet:+++++++\n" + JSON.toJSONString(result) + "\n++++++++++++++++");
		PrintWriter out = response.getWriter();
		out.print(JSON.toJSONString(result));
		out.flush();
		out.close();
	}

}
