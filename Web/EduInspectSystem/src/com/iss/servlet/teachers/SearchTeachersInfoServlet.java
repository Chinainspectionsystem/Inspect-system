package com.iss.servlet.teachers;

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
import com.iss.pojo.TeacherInfo;
import com.iss.service.ITeacherInfoService;
import com.iss.service.Impl.TeacherInfoServiceImpl;

/**
 * Servlet implementation class SearchTeachersInfoServlet
 */
@WebServlet("/servlet/SearchTeachersInfoServlet")
public class SearchTeachersInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		int pagesize = Integer.parseInt(request.getParameter("pagesize"));

		String teacher_id = request.getParameter("teacher_id");
		String department_id = request.getParameter("department_id");
		String teacher_name = request.getParameter("teacher_name");
		String gender = request.getParameter("gender");
		String jobtitle_id = request.getParameter("jobtitle_id");
		String teacher_inspector = request.getParameter("teacher_inspector");
		TeacherInfo tiBean = new TeacherInfo();
		tiBean.setTeacher_id(teacher_id);
		tiBean.setDepartment_id(department_id);
		tiBean.setTeacher_name(teacher_name);
		tiBean.setGender(gender);
		tiBean.setJobtitle_id(jobtitle_id);
		tiBean.setTeacher_inspector(teacher_inspector);
		ITeacherInfoService tis = new TeacherInfoServiceImpl();
		List<Map<String, Object>> result = tis.searchTeacherInfo(tiBean, page * pagesize, pagesize);

		System.out.println("SearchTeachersInfoServlet:" + result);

		PrintWriter out = response.getWriter();
		out.print(JSON.toJSONString(result));
		out.flush();
		out.close();
	}

}
