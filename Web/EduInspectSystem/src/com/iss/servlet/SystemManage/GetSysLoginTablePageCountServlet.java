package com.iss.servlet.SystemManage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iss.service.SysLoginService;
import com.iss.service.Impl.SysLoginServiceImpl;

/**
 * Servlet implementation class GetSysLoginTablePageCountServlet
 */
@WebServlet("/logic/getSysLoginTablePageCountServlet")
public class GetSysLoginTablePageCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagesize = request.getParameter("pagesize");
		SysLoginService sysLoginService = new SysLoginServiceImpl();
		int pageCount=	sysLoginService.getSysLoginTablePageCount(Integer.parseInt(pagesize));
		PrintWriter out = response.getWriter();
		out.print(pageCount);
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
