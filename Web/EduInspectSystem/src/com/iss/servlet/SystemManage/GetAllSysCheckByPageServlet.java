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
import com.iss.service.SysUserService;
import com.iss.service.Impl.SysCheckServiceImpl;
import com.iss.service.Impl.SysUserServiceImpl;

/**
 * Servlet implementation class GetAllSysCheckByPageServlet
 */
@WebServlet("/logic/getAllSysCheckByPageServlet")
public class GetAllSysCheckByPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		int pagesize = Integer.parseInt(request.getParameter("pagesize"));
		SysCheckService sysCheckService = new SysCheckServiceImpl();
		List<Map<String,Object>> list = sysCheckService.getAllSysCheckByPage(page, pagesize);
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
