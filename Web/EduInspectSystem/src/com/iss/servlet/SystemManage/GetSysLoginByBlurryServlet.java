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
import com.iss.pojo.SysLogin;
import com.iss.service.SysLoginService;
import com.iss.service.Impl.SysLoginServiceImpl;

/**
 * Servlet implementation class GetSysLoginByBlurryServlet
 */
@WebServlet("/logic/getSysLoginByBlurryServlet")
public class GetSysLoginByBlurryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		int pagesize = Integer.parseInt(request.getParameter("pagesize"));
		SysLogin sysLogin = new SysLogin();
		SysLoginService sysLoginService = new SysLoginServiceImpl();
		String username = request.getParameter("srchusername");
		String role = request.getParameter("srchrole");
		String login_time = request.getParameter("srchlogin_time");
		System.out.println(username);
		System.out.println(role);
		System.out.println(login_time);
		sysLogin.setUsername(username);
		sysLogin.setRole(role);
		sysLogin.setLogin_time(login_time);
		List<Map<String,Object>> list = sysLoginService.getSysLoginByBlurry(sysLogin, 0, 30);
		PrintWriter out = response.getWriter();
		out.print(JSON.toJSONString(list));
		System.out.println(list);
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
