package com.iss.servlet.SystemManage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iss.service.SysCheckService;
import com.iss.service.Impl.SysCheckServiceImpl;

/**
 * Servlet implementation class GetSysCheckTablePageCountServlet
 */
@WebServlet("/logic/getSysCheckTablePageCountServlet")
public class GetSysCheckTablePageCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSysCheckTablePageCountServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagesize = request.getParameter("pagesize");
		SysCheckService sysCheckService = new SysCheckServiceImpl();
		int pageCount=	sysCheckService.getSysCheckTablePageCount(Integer.parseInt(pagesize));
		PrintWriter out = response.getWriter();
		out.print(pageCount);
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
