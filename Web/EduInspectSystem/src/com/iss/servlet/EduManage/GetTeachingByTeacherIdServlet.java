package com.iss.servlet.EduManage;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
 * Servlet implementation class GetTeachingByTeacherIdServlet
 */
@WebServlet("/logic/getTeachingByTeacherIdServlet")
public class GetTeachingByTeacherIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String teacher_id = request.getParameter("teacher_id");
		System.out.println(teacher_id);
		Teaching teaching = new Teaching();
		TeachingService teachingService = new TeachingServiceImpl();
		List<Map<String,Object>> list = teachingService.getTeacherInfoByTeacherId(teacher_id);
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
