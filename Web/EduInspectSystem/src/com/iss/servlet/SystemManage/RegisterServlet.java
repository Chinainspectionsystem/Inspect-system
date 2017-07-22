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

import com.iss.pojo.SysCheck;
import com.iss.service.SysCheckService;
import com.iss.service.Impl.SysCheckServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/logic/registerServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SysCheckService sysCheckService = new SysCheckServiceImpl();
		SysCheck sysCheck = new SysCheck();
		String username = request.getParameter("username"); 
		String password = request.getParameter("password"); 
		String teacher_id = request.getParameter("teacher_id"); 
		String realname = request.getParameter("realname"); 
		String gender = request.getParameter("gender"); 
		String telephone = request.getParameter("telephone"); 
		String email = request.getParameter("email"); 
		String exist_teacher = "´æÔÚ";
		sysCheck.setUsername(username);
		sysCheck.setPassword(password);
		sysCheck.setTeacher_id(teacher_id);
		sysCheck.setRealname(realname);
		sysCheck.setGender(gender);
		sysCheck.setTelephone(telephone);
		sysCheck.setEmail(email);
		boolean result = sysCheckService.IsAddSysCheck(sysCheck);
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
		out.close();
		SimpleDateFormat df = new SimpleDateFormat("MM-dd,HH:mm:ss");		
		System.out.println("register:"+result+" "+request.getParameter("username")+","+df.format(new Date()));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
