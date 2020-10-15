package com.item.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * �ж��Ƿ�Ϊ����Ա�Ĺ�����
 * @author wangqun
 *
 */
public class LoginFilter extends InitFilter {

	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		String mod = (String) session.getAttribute("user");
		if ("admin".equals(mod)) {
			try {
				chain.doFilter(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			String contextPath = req.getContextPath();
			try {
				req.getRequestDispatcher("/WEB-INF/errorPage/modError.jsp").forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			sendRedirect(contextPath+"/WEB-INF/errorPage/modError.jsp");
		}

	}

}
