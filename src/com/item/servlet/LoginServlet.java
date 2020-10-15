package com.item.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.item.beans.Admin;
import com.item.dao.AdminDao;
import com.item.dao.impl.AdminDaoimpl;
import com.item.utils.GetipAddress;

public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = req.getParameter("method");
		try {
			Method method2 = this.getClass().getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
			method2.invoke(this, req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 管理员登录，通过ajax判断验证码等信息，正确之后往session中放入管理员信息，从jsp用js重定向到登录成功界面，中间设置了过滤器。
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void adminLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String code = (String) session.getAttribute("code");
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		String user_code = req.getParameter("code");
		AdminDao dao = new AdminDaoimpl();
		Admin admin = dao.getAdmin(email);
		System.out.println(code);
		if (!code.equals(user_code)) {
			String err = "{" + "\"error\":\"错误的验证码\"" + "}";
			resp.getWriter().print(err);
			return;
		}
		if (admin == null) {
			String err = "{" + "\"error\":\"账号无效或密码错误\"" + "}";
			resp.getWriter().print(err);
			return;
		}
		// String in_pwd = admin.getPwd();
		if (admin != null && !admin.getPwd().equals(pwd)) {
			String err = "{" + "\"error\":\"账号无效或密码错误\"" + "}";
			resp.getWriter().print(err);
			return;
		} else {
			String success = "{" + "\"success\":\"../../admin/page/main/main.jsp\"" + "}";
			String ipAddress = GetipAddress.getIPAddress(req);
			session.setAttribute("user", "admin");
			session.setAttribute("userName", email);
			session.setAttribute("ip", ipAddress);
			session.setAttribute("path", req.getContextPath());
			String date = GetipAddress.getDate();
			session.setAttribute("date", date);
			resp.getWriter().print(success);
			// resp.sendRedirect("admin/page/main/main.jsp");
		}
	}
	/**
	 * 登出界面，使session失效
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
//		session.removeAttribute("user");
//		session.removeAttribute("userName");
//		session.removeAttribute("ip");
//		session.removeAttribute("path");
//		session.removeAttribute("date");
		session.invalidate();
		//System.out.println(session.getAttribute("user"));
		String path=req.getContextPath()+"/admin/login/login.jsp";
		//req.getRequestDispatcher(path).forward(req, resp);
		resp.sendRedirect(path);
	}
}
