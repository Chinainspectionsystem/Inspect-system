package com.iss.servlet.jobtitle;

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
import com.iss.pojo.JobTitleInfo;
import com.iss.service.IJobTitleInfoService;
import com.iss.service.Impl.JobTitleInfoServiceImpl;

/**
 * Servlet implementation class GetJobTitleInfoServlet
 */
@WebServlet("/servlet/GetJobTitleInfoServlet")
public class GetJobTitleInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		int pagesize = Integer.parseInt(request.getParameter("pagesize"));
		String jobtitle_id = request.getParameter("jobtitle_id");
		String jobtitle_name = request.getParameter("jobtitle_name");
		JobTitleInfo jti = new JobTitleInfo();
		jti.setJobtitle_id(jobtitle_id);
		jti.setJobtitle_name(jobtitle_name);
		IJobTitleInfoService jtis = new JobTitleInfoServiceImpl();
		List<Map<String, Object>> result = jtis.getJobTitleInfo(page * pagesize, pagesize);
		PrintWriter out = response.getWriter();
		out.print(JSON.toJSONString(result));
		out.flush();
		out.close();
	}

}
