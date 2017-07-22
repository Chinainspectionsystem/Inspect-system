package com.iss.servlet.InspectRecordManage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.iss.pojo.InspectRecord;
import com.iss.service.InspectRecordService;
import com.iss.service.TeachingService;
import com.iss.service.Impl.InspectRecordServiceImpl;
import com.iss.service.Impl.TeachingServiceImpl;

/**
 * Servlet implementation class GetInspectAverageScoreForAndriodServlet
 */
@WebServlet("/logic/getInspectAverageScoreForAndriodServlet")
public class GetInspectAverageScoreForAndriodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Map<String,Object>> list= new ArrayList<Map<String,Object>>();
		String choice = request.getParameter("choice");
		System.out.println(choice);
		InspectRecord inspectRecord = new InspectRecord();
		InspectRecordService inspectRecordService = new InspectRecordServiceImpl();
		TeachingService teachingService = new TeachingServiceImpl();
		if(choice.equals("teacher")){
			list = inspectRecordService.getInspectAverageScoreByTeacherId(inspectRecord);
		} else if(choice.equals("collage")){
			list = inspectRecordService.getInspectAverageScoreByDepartmentId(inspectRecord);
		} else if(choice.equals("class")){
			list = inspectRecordService.getInspectAverageScoreByCourseId(inspectRecord);
		} else{
			
		}
		PrintWriter out = response.getWriter();
		if (list.size()<1) {
			out.print("false");
			System.out.println("false");
		} else {
			out.print(JSON.toJSONString(list));
			System.out.println(JSON.toJSONString(list));
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
