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
import com.alibaba.fastjson.TypeReference;
import com.iss.pojo.Teaching;
import com.iss.service.TeachingService;
import com.iss.service.Impl.TeachingServiceImpl;

/**
 * Servlet implementation class GetTeachingByInspect
 */
@WebServlet("/logic/getTeachingByInspectServlet")
public class GetTeachingByInspect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String department_name = request.getParameter("collage");
		String teaching_place = request.getParameter("classroom");
		String teaching_time = request.getParameter("classtime");
		Calendar c = Calendar.getInstance();
		teaching_time = new SimpleDateFormat("E").format(c.getTime())+teaching_time;
		Teaching teaching = new Teaching();
		TeachingService teachingService = new TeachingServiceImpl();
		teaching.setDepartment_name(department_name);
		teaching.setTeaching_place(teaching_place);
		teaching.setTeaching_time(teaching_time);
		List<Map<String,Object>> list = teachingService.getTeachingByInspect(teaching);
		PrintWriter out = response.getWriter();
		if (list.size()<1) {
			out.print("false");
		} else {
			out.print(JSON.toJSONString(list.get(0)));
		}
		out.flush();
		out.close();
//		String josnStr = JSON.toJSONString(list);
//		List<Map<String,Object>> jlist = JSON.parseObject(josnStr, new TypeReference<List<Map<String,Object>>>(){});
//		System.out.println(jlist);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
