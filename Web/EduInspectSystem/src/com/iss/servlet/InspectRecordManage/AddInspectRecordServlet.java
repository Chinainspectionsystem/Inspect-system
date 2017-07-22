package com.iss.servlet.InspectRecordManage;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iss.pojo.InspectRecord;
import com.iss.service.InspectRecordService;
import com.iss.service.Impl.InspectRecordServiceImpl;

/**
 * Servlet implementation class AddInspectRecordServlet
 */
@WebServlet("/logic/addInspectRecordServlet")
public class AddInspectRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InspectRecord inspectRecord = new InspectRecord();
		InspectRecordService inspectRecordService = new InspectRecordServiceImpl();
		String username = request.getParameter("username");
		String teaching_id = request.getParameter("teaching_id");
		System.out.println(teaching_id);
		inspectRecord.setTeaching_id(teaching_id);
		List<Map<String,Object>> listNameId = inspectRecordService.getNameIDByTeachingId(inspectRecord);
		String course_id = listNameId.get(0).get("course_id").toString();
		String teacher_id = listNameId.get(0).get("teacher_id").toString();
		String department_id = listNameId.get(0).get("department_id").toString();
		String department_name = listNameId.get(0).get("department_name").toString();
		Calendar c = Calendar.getInstance();
		String  teaching_time = new SimpleDateFormat("E").format(c.getTime())+request.getParameter("teaching_time");
		String inspection_time = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date());
		List<Map<String,Object>> listPlace = inspectRecordService.getTeachingPlaceByTeachingId(inspectRecord);
		String inspection_place = department_name+listPlace.get(0).get("teaching_place").toString();
		int num_absent = Integer.parseInt(request.getParameter("num_absent"));
		int num_sleep = Integer.parseInt(request.getParameter("num_sleep"));
		int num_phone = Integer.parseInt(request.getParameter("num_phone"));
		double teacherscore1 = Double.parseDouble(request.getParameter("teacherscore1"));
		double teacherscore2 = Double.parseDouble(request.getParameter("teacherscore2"));
		double studentscore1 = Double.parseDouble(request.getParameter("studentscore1"));
		double studentscore2 = Double.parseDouble(request.getParameter("studentscore2"));
		double totalscore = ((teacherscore2+studentscore2)*10+teacherscore1+studentscore1-num_absent*6-(num_sleep+num_phone)*3)/3;
		if (totalscore<0) totalscore=0;
		else totalscore= new BigDecimal(totalscore).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		String inspect_remark = request.getParameter("other");
		inspectRecord.setUsername(username);
		inspectRecord.setTeaching_id(teaching_id); 
		inspectRecord.setCourse_id(course_id); 
		inspectRecord.setTeacher_id(teacher_id);
		inspectRecord.setDepartment_id(department_id);
		inspectRecord.setTeaching_time(teaching_time);
		inspectRecord.setInspection_time(inspection_time); 
		inspectRecord.setInspection_place(inspection_place);
		inspectRecord.setNum_absent(num_absent);
		inspectRecord.setNum_sleep(num_sleep); 
		inspectRecord.setNum_phone(num_phone);
		inspectRecord.setTeacherscore1(teacherscore1);
		inspectRecord.setTeacherscore2(teacherscore2);
		inspectRecord.setStudentscore1(studentscore1);
		inspectRecord.setStudentscore2(studentscore2);
		inspectRecord.setTotalscore(totalscore); 
		inspectRecord.setInspect_remark(inspect_remark);
		boolean result = inspectRecordService.IsAddInspectRecord(inspectRecord);
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
		out.close();
		SimpleDateFormat df = new SimpleDateFormat("MM-dd,HH:mm:ss");		
		System.out.println("addInspectRecord:"+result+" "+username+","+df.format(new Date()));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
