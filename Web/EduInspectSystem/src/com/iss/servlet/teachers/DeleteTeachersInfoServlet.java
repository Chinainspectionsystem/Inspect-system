package com.iss.servlet.teachers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iss.pojo.TeacherInfo;
import com.iss.service.ITeacherInfoService;
import com.iss.service.Impl.TeacherInfoServiceImpl;

/**
 * Servlet implementation class DeleteTeachersInfoServlet
 */
@WebServlet("/servlet/DeleteTeachersInfoServlet")
public class DeleteTeachersInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String teacher_id = request.getParameter("teacher_id");
		TeacherInfo tiBean = new TeacherInfo();
		tiBean.setTeacher_id(teacher_id);
		ITeacherInfoService tis = new TeacherInfoServiceImpl();
		int result = tis.deleteTeacherInfo(tiBean);
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
		out.close();
	}

}
