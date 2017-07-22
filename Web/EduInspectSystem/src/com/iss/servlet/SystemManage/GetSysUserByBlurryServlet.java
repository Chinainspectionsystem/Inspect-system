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
import com.iss.pojo.SysUser;
import com.iss.service.SysUserService;
import com.iss.service.Impl.SysUserServiceImpl;

/**
 * Servlet implementation class GetSysUserByBlurryServlet
 */
@WebServlet("/logic/getSysUserByBlurryServlet")
public class GetSysUserByBlurryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		int pagesize = Integer.parseInt(request.getParameter("pagesize"));
		SysUser sysUser = new SysUser();
		SysUserService sysUserService = new SysUserServiceImpl();
		String username = request.getParameter("srchusername");
		String realname = request.getParameter("srchrealname");
		String teacher_id = request.getParameter("srchteacher_id");
		String gender = request.getParameter("srchgender");
		String role = request.getParameter("srchrole");
		String register_time = request.getParameter("srchregister_time");
		sysUser.setUsername(username);
		sysUser.setRealname(realname);
		sysUser.setTeacher_id(teacher_id);
		sysUser.setGender(gender);
		sysUser.setRole(role);
		sysUser.setRegister_time(register_time);
		List<Map<String,Object>> list = sysUserService.getSysUserByBlurry(sysUser, 0, 30);
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
