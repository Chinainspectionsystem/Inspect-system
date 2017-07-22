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
import com.iss.pojo.SysCheck;
import com.iss.service.SysCheckService;
import com.iss.service.Impl.SysCheckServiceImpl;

/**
 * Servlet implementation class DeleteSysCheckByUsername
 */
@WebServlet("/logic/deleteSysCheckByUsername")
public class DeleteSysCheckByUsername extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSysCheckByUsername() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String delusername = request.getParameter("delusername");
		int page = Integer.parseInt(request.getParameter("page"));
		int pagesize = Integer.parseInt(request.getParameter("pagesize"));
		SysCheckService sysCheckService = new SysCheckServiceImpl();
		SysCheck sysCheck = new SysCheck();
		sysCheck.setUsername(delusername);
		boolean result = sysCheckService.IsDeleteSysCheckByUsername(sysCheck);
		PrintWriter out = response.getWriter();
		if(result){
			List list = sysCheckService.getAllSysCheckByPage(page, pagesize);
			out.print(JSON.toJSONString(list));
		}else{
			out.print(result);
		}
		out.flush();
		out.close();
		SimpleDateFormat df = new SimpleDateFormat("MM-dd,HH:mm:ss");		
		System.out.println("delete:"+result+" "+delusername+","+df.format(new Date()));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
