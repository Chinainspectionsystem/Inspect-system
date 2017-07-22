package com.iss.servlet.SystemManage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iss.pojo.SysCheck;
import com.iss.service.SysCheckService;
import com.iss.service.Impl.SysCheckServiceImpl;

/**
 * Servlet implementation class ValidateSysUsernameExistServlet
 */
@WebServlet("/logic/validateSysUsernameExistServlet")
public class ValidateSysUsernameExistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateSysUsernameExistServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SysCheckService sysCheckService = new SysCheckServiceImpl();
		SysCheck sysCheck = new SysCheck();
		String username = request.getParameter("username");
		sysCheck.setUsername(username);
		boolean result = sysCheckService.searchSysUesrForValidateExit(sysCheck);
		PrintWriter out = response.getWriter();
		out.print(result);
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
