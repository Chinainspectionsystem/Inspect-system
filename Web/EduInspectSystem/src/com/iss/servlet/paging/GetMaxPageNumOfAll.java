package com.iss.servlet.paging;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iss.service.IGetMaxPageNumService;
import com.iss.service.Impl.GetMaxPageNumServiceImpl;

/**
 * Servlet implementation class GetMaxPageNumOfAll
 */
@WebServlet("/servlet/GetMaxPageNumOfAll")
public class GetMaxPageNumOfAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String flag = request.getParameter("flag");
		IGetMaxPageNumService getMaxPageNumService = new GetMaxPageNumServiceImpl();
		List<Map<String, Object>> list = getMaxPageNumService.getMaxPageNumOfAll(flag);
		double pagesize = (double) Integer.parseInt(request.getParameter("pagesize"));
		double count = Double.parseDouble(list.get(0).get("count").toString());
		int result = (int) Math.ceil(count / pagesize);
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
		out.close();
	}

}
