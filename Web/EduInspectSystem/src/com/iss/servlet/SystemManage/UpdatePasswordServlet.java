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

import com.iss.service.SysLoginService;
import com.iss.service.Impl.SysLoginServiceImpl;

/**
 * Servlet implementation class UpdatePasswordServlet
 */
@WebServlet("/logic/updatePasswordServlet")
public class UpdatePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String oldpassword = request.getParameter("oldpassword");
		String newpassword = request.getParameter("newpassword");
		System.out.println(username+":"+oldpassword+"-"+newpassword);
		SysLoginService sysLoginService = new SysLoginServiceImpl();
		boolean result = sysLoginService.IsUpdatePassword(username, oldpassword, newpassword);
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
		out.close();
		SimpleDateFormat df = new SimpleDateFormat("MM-dd,HH:mm:ss");		
		System.out.println("updatePassword:"+result+" "+username+","+df.format(new Date()));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
