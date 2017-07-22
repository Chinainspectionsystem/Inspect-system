package com.iss.servlet.jobtitle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iss.pojo.JobTitleInfo;
import com.iss.service.IJobTitleInfoService;
import com.iss.service.Impl.JobTitleInfoServiceImpl;

/**
 * Servlet implementation class DeleteJobTitleInfoServlet
 */
@WebServlet("/servlet/DeleteJobTitleInfoServlet")
public class DeleteJobTitleInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String jobtitle_id = request.getParameter("jobtitle_id");
		JobTitleInfo jtiBean = new JobTitleInfo();
		jtiBean.setJobtitle_id(jobtitle_id);
		IJobTitleInfoService jtis = new JobTitleInfoServiceImpl();
		int result = jtis.deleteJobTitleInfo(jtiBean);
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
		out.close();
	}

}
