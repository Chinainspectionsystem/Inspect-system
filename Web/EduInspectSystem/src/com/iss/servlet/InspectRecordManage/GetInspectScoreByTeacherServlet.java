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
import com.iss.pojo.Teaching;
import com.iss.service.InspectRecordService;
import com.iss.service.TeachingService;
import com.iss.service.Impl.InspectRecordServiceImpl;
import com.iss.service.Impl.TeachingServiceImpl;

/**
 * Servlet implementation class GetInspectScoreByTeacherServlet
 */
@WebServlet("/logic/getInspectScoreByTeacherServlet")
public class GetInspectScoreByTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Map<String,Object>> list= new ArrayList<Map<String,Object>>();
		String choice = request.getParameter("choice");
		String choice_name = request.getParameter("text");
		System.out.println(choice);
		System.out.println(choice_name);
		InspectRecord inspectRecord = new InspectRecord();
		InspectRecordService inspectRecordService = new InspectRecordServiceImpl();
		TeachingService teachingService = new TeachingServiceImpl();
		if(choice.equals("teacher")){
			List<Map<String, Object>> list1 = teachingService.getTeacherInfoByTeacherName(choice_name);
			inspectRecord.setTeacher_id(list1.get(0).get("teacher_id").toString());
			list = inspectRecordService.getInspectScoreByTeacherId(inspectRecord);
		} else if(choice.equals("collage")){
			List<Map<String, Object>> list2 = teachingService.getDepartmentInfoByDepartmentName(choice_name);
			inspectRecord.setDepartment_id(list2.get(0).get("department_id").toString());
			list = inspectRecordService.getInspectScoreByDepartmentId(inspectRecord);
		} else if(choice.equals("class")){
			List<Map<String, Object>> list3 = teachingService.getCourseInfoByCourseName(choice_name);
			inspectRecord.setCourse_id(list3.get(0).get("course_id").toString());
			list = inspectRecordService.getInspectScoreByCourseId(inspectRecord);
		} else{
			
		}
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
