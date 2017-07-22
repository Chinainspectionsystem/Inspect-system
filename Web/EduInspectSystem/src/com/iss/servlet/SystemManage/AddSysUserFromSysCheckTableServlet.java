package com.iss.servlet.SystemManage;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iss.pojo.SysCheck;
import com.iss.service.SysCheckService;
import com.iss.service.Impl.SysCheckServiceImpl;

/**
 * Servlet implementation class AddSysUserFromSysCheckTableServlet
 */
@WebServlet("/logic/addSysUserFromSysCheckTableServlet")
public class AddSysUserFromSysCheckTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SysCheckService sysCheckService = new SysCheckServiceImpl();
		SysCheck sysCheck = new SysCheck();
		String username = request.getParameter("username"); 
		String role = request.getParameter("role"); 
		sysCheck.setUsername(username);
		List<Map<String,Object>> list = sysCheckService.getSysCheckByUsername(sysCheck);
		sysCheck.setPassword(list.get(0).get("password").toString());
		sysCheck.setTeacher_id(list.get(0).get("teacher_id").toString());
		sysCheck.setRealname(list.get(0).get("realname").toString()); 
		sysCheck.setGender(list.get(0).get("gender").toString()); 
		sysCheck.setTelephone(list.get(0).get("telephone").toString());
		sysCheck.setEmail(list.get(0).get("email").toString());
		boolean addresult = sysCheckService.IsAddSysUserFromSysCheckTable(sysCheck, role);
		boolean deletresult = sysCheckService.IsDeleteSysCheckByUsername(sysCheck);
		PrintWriter out = response.getWriter();
		if(addresult && deletresult){
			out.print(addresult && deletresult);
		}
		out.flush();
		out.close();
		SimpleDateFormat df = new SimpleDateFormat("MM-dd,HH:mm:ss");		
		System.out.println("check:"+addresult+" "+username+","+role+","+df.format(new Date()));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
