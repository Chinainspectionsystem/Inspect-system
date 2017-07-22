package com.iss.servlet.SystemManage;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iss.pojo.SysLogin;
import com.iss.service.SysLoginService;
import com.iss.service.Impl.SysLoginServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/logic/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SysLoginService sysLoginService = new SysLoginServiceImpl();
		SysLogin sysLogin = new SysLogin();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		sysLogin.setUsername(username);
		sysLogin.setPassword(password);
		String role = sysLoginService.searchSysLoginForValidateExit(sysLogin);
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		session.setAttribute("role", role);
		PrintWriter out = response.getWriter();
		out.print(role);
		out.flush();
		out.close();
		SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		sysLogin.setLogin_time(df.format(new Date()));
		boolean updateLoginTime = sysLoginService.IsUpdateLoginTime(sysLogin);
		System.out.println("login:" + role + " " + request.getParameter("username") + "," + df.format(new Date()));
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
