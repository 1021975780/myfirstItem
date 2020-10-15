package com.item.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.item.beans.User;
import com.item.dao.UserDao;
import com.item.dao.UserDaoimpl;

public class UserLoginServlet extends HttpServlet {
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
	 * �û���¼��ͨ��ajax��Ȼ����jsp���ض���
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("��ʼ��½");
		String phone = req.getParameter("phone");
		String pwd=req.getParameter("password");
		UserDao dao = new UserDaoimpl();
		User user = dao.getUser(phone);
		if (user==null) {
			resp.getWriter().print("{\"error\":\"1\"}");
		}
		else if (user!=null&&!pwd.equals(user.getPwd())) {
			resp.getWriter().print("{\"error\":\"1\"}");
		}
		else {
			System.out.println("��¼�ɹ�");
			resp.getWriter().print("{\"error\":\"0\"}");
		}
	}
}
