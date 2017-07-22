package com.iss.servlet.classes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iss.pojo.ClassInfo;
import com.iss.service.IClassInfoService;
import com.iss.service.Impl.ClassInfoServiceImpl;

/**
 * Servlet implementation class EditClassesInfoServlet
 */
@WebServlet("/servlet/EditClassesInfoServlet")
public class EditClassesInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String class_population = request.getParameter("class_population");
		String class_grade = request.getParameter("class_grade");
		String teacher_id = request.getParameter("teacher_id");
		String class_name = request.getParameter("class_name");
		ClassInfo ciBean = new ClassInfo();
		ciBean.setClass_population(class_population);
		ciBean.setClass_grade(class_grade);
		ciBean.setTeacher_id(teacher_id);
		ciBean.setClass_name(class_name);
		// System.out.println(class_grade + "," + class_grade + "," + class_population +
		// "," + teacher_id);
		IClassInfoService cis = new ClassInfoServiceImpl();
		int result = cis.editClassInfo(ciBean);
		/* System.out.println(result); */
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
		out.close();
	}

}
