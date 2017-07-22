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

import com.iss.pojo.SysUser;
import com.iss.service.SysUserService;
import com.iss.service.Impl.SysUserServiceImpl;

/**
 * Servlet implementation class UpdateSysUserServlet
 */
@WebServlet("/logic/updateSysUserRoleServlet2")
public class UpdateSysUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		SysUserService sysUserService = new SysUserServiceImpl();
		SysUser sysUser = new SysUser();
		sysUser.setUsername(username);
		sysUser.setEmail(email);
		sysUser.setTelephone(telephone);
		boolean result = sysUserService.IsUpdateSysUser(sysUser);
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
		out.close();
		SimpleDateFormat df = new SimpleDateFormat("MM-dd,HH:mm:ss");
		System.out.println("update:"+ result + " " + username + df.format(new Date()));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
