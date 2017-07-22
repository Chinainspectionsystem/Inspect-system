package com.iss.servlet.EduManage;

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
import com.iss.pojo.Teaching;
import com.iss.service.TeachingService;
import com.iss.service.Impl.TeachingServiceImpl;

/**
 * Servlet implementation class GetTeachingByTrCeIdServlet
 */
@WebServlet("/logic/getTeachingByTrCeIdServlet")
public class GetTeachingByTrCeIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String course_id = request.getParameter("course_id");
		String teacher_id = request.getParameter("teacher_id");
		TeachingService teachingService = new TeachingServiceImpl();
		List<Map<String,Object>> list = teachingService.getTeachingByTrCeId(teacher_id, course_id);
		PrintWriter out = response.getWriter();
		if (list.size()<1) {
			out.print("false");
		} else {
			out.print(JSON.toJSONString(list));
		}
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
