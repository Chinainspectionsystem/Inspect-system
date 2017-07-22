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
 * Servlet implementation class DeleteSysUserByUsername
 */
@WebServlet("/logic/deleteSysUserByUsername")
public class DeleteSysUserByUsername extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String delusername = request.getParameter("delusername");
		int page = Integer.parseInt(request.getParameter("page"));
		int pagesize = Integer.parseInt(request.getParameter("pagesize"));
		SysUserService sysUserService = new SysUserServiceImpl();
		SysUser sysUser = new SysUser();
		sysUser.setUsername(delusername);
		boolean result = sysUserService.IsDeleteSysUserByUsername(sysUser);
		PrintWriter out = response.getWriter();
		if(result){
			List list = sysUserService.getAllSysUserByPage(page, pagesize);
			out.print(JSON.toJSONString(list));
		}else{
			out.print(result);
		}
		out.flush();
		out.close();
		SimpleDateFormat df = new SimpleDateFormat("MM-dd,HH:mm:ss");		
		System.out.println("delete:"+result+" "+request.getParameter("delusername")+","+df.format(new Date()));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
