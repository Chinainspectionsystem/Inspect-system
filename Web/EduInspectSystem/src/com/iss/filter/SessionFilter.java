package com.iss.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class SessionFilter
 */
@WebFilter("/*")
public class SessionFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public SessionFilter() {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession();
		String url = ((HttpServletRequest) request).getRequestURI();
		 System.out.println(url);
		if (url.matches(".*login.*") || url.matches(".*font.*") || url.matches(".*register.*")
				|| url.matches(".*bootstrap.*") || url.matches(".*validateUserExistServlet.*")
				|| url.matches(".*website.*") || url.matches(".*img.*") || url.matches(".*lib.*")
				|| url.matches(".*canvas-nest.min.*") || url.matches(".*index.*")) {
			chain.doFilter(request, response);
		} else {
			 System.out.println("username:"+session.getAttribute("username"));
			if (session.getAttribute("username") != null) {
//				String role = (String) session.getAttribute("role");
//				if(url.matches(".*admin.*") && role.equals("管理员")){
//					chain.doFilter(request, response);
//				}else{
//					return;
//				}
				chain.doFilter(request, response);
			} else {
				((HttpServletResponse) response).sendRedirect("login.html");
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
