package com.iss.servlet.InspectRecordManage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
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
import com.iss.service.Impl.InspectRecordServiceImpl;

/**
 * Servlet implementation class GetAverageScoreByChoiceServlet
 */
@WebServlet("/logic/getAverageScoreByChoiceServlet")
public class GetAverageScoreByChoiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String choice = request.getParameter("choice");
		String choiceName = request.getParameter("choiceName");
		System.out.println(choice);
		InspectRecordService inspectRecordService = new InspectRecordServiceImpl();
		InspectRecord inspectRecord = new InspectRecord();
		List<Map<String,Object>> list = inspectRecordService.getAverageScoreByChoice(choice);
		List<List<String>> list2 = inspectRecordService.getAverageScoreTitleByChoice(choice);
		List<String> list3 = list2.get(1);
		Map map = new HashMap();
		map.put("all", list);
		map.put("title", list3);
		PrintWriter out = response.getWriter();
		if (list.size()<1) {
			out.print("false");
		} else {
			out.print(JSON.toJSONString(map));
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
