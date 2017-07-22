package com.iss.servlet.SystemManage;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.iss.pojo.SysUser;
import com.iss.service.SysUserService;
import com.iss.service.Impl.SysUserServiceImpl;

/**
 * Servlet implementation class UpdateSysUserRoleServlet
 */
@WebServlet("/logic/updateSysUserRoleServlet")
public class UpdateSysUserRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String role = request.getParameter("role");
		SysUserService sysUserService = new SysUserServiceImpl();
		SysUser sysUser = new SysUser();
		sysUser.setUsername(username);
		sysUser.setRole(role);
		boolean result = sysUserService.IsUpdateSysUserRole(sysUser);
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
		out.close();
		SimpleDateFormat df = new SimpleDateFormat("MM-dd,HH:mm:ss");
		System.out.println("updateRole:" + role + "," + result + " " + username + "," + df.format(new Date()));
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
