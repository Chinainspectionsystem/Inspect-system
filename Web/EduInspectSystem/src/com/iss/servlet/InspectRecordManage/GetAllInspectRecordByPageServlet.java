package com.iss.servlet.InspectRecordManage;

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
import com.iss.service.InspectRecordService;
import com.iss.service.Impl.InspectRecordServiceImpl;

/**
 * Servlet implementation class GetAllInspectRecordByPageServlet
 */
@WebServlet("/logic/getAllInspectRecordByPageServlet")
public class GetAllInspectRecordByPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * String username=request.getParameter("username");
		 * System.out.println(username);
		 */
		InspectRecordService inspectRecordService = new InspectRecordServiceImpl();
		List<Map<String, Object>> list = inspectRecordService.getAllInspectRecordByPage(0, 11);

		PrintWriter out = response.getWriter();
		if (list.size() < 1) {
			out.print("false");
		} else {
			out.print(JSON.toJSONString(list));
		}
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
