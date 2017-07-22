package com.iss.servlet.SystemManage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.iss.service.IGetLoginUserInfoService;
import com.iss.service.Impl.GetLoginUserInfoServiceImpl;

/**
 * Servlet implementation class GetLonginUserInfoServlet
 */
@WebServlet("/servlet/GetLonginUserInfoServlet")
public class GetLonginUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		IGetLoginUserInfoService getLoginUserInfoService = new GetLoginUserInfoServiceImpl();
		List<Map<String, Object>> result = getLoginUserInfoService.getLonginUserInfo(username);
		/*
		 * String role = (String) result.get(8).get("role"); System.out.println(role);
		 * if (role.equals("π‹¿Ì‘±")) { role = "admin"; session.setAttribute("role", role);
		 * }
		 */

		PrintWriter out = response.getWriter();
		out.print(JSON.toJSONString(result));
		out.flush();
		out.close();
	}

}
