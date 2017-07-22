package com.iss.servlet.SystemManage;

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
import com.iss.service.SysCheckService;
import com.iss.service.SysLoginService;
import com.iss.service.Impl.SysCheckServiceImpl;
import com.iss.service.Impl.SysLoginServiceImpl;

/**
 * Servlet implementation class GetAllSysLoginByPageServlet
 */
@WebServlet("/logic/getAllSysLoginByPageServlet")
public class GetAllSysLoginByPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		int pagesize = Integer.parseInt(request.getParameter("pagesize"));
		SysLoginService sysLoginService = new SysLoginServiceImpl();
		List<Map<String,Object>> list = sysLoginService.getAllSysLoginByPage(page, pagesize);
		System.out.println(list+"---");
		PrintWriter out = response.getWriter();
		out.print(JSON.toJSONString(list));
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
