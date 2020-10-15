package com.item.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.item.beans.Admin;
import com.item.dao.AdminDao;
import com.item.dao.impl.AdminDaoimpl;
import com.item.upload.Upload;

public class AdminServlet extends HttpServlet {
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
	 * 通过email字段从数据库中查找管理员对象并且通过Json对象返回
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("开始查找");
		String email = req.getParameter("email");
		AdminDao dao = new AdminDaoimpl();
		Admin admin = dao.getAdmin(email);
		if (admin!=null) {
			String image = admin.getImage();
			if (image!=null) {
				String get_image=req.getContextPath()+"/image/"+image.substring(image.lastIndexOf("\\")+1);
				admin.setImage(get_image);	
			}
			ObjectMapper om = new ObjectMapper();
			String json = om.writeValueAsString(admin);
			resp.getWriter().print(json);
		}
	}
	/**
	 * 通过ajax判断注册信息的合理性，从而添加到数据库中
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addAdmin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("开始添加");
		Map<String, String> maps = null;
		AdminDao dao = new AdminDaoimpl();
		String email = req.getParameter("email");
		String pwd1 = req.getParameter("pwd1");
		String pwd = req.getParameter("pwd");
		String submit = req.getParameter("submit");
		Admin admin2 = dao.getAdmin(email);
		try {
			if (admin2 != null) {
				resp.getWriter().print("{\"error\":\"邮箱已经存在\"}");
			} else if (email != null && !email
					.matches("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$")) {
				resp.getWriter().print("{\"error\":\"邮箱格式不正确\"}");
				// req.setAttribute("error", "邮箱格式不正确");
			} else if (pwd1 != null && pwd != null && !pwd1.equals("") && !pwd.equals("") && !pwd1.equals(pwd)) {
				resp.getWriter().print("{\"error\":\"两次密码不相同\"}");
				// req.setAttribute("error", "两次密码不相同");
			} else {
				resp.getWriter().print("{\"error\":\" \"}");
				if ("upload".equals(submit)) {
					maps = (Map<String, String>) Upload.getItemMaps(req, true);
					String add_pwd = maps.get("pwd");
					String add_email = maps.get("email");
					String add_image = maps.get("image");
					Admin admin = new Admin(add_email, add_pwd, add_image);
					dao.addAdmin(admin);
					String encode_email = URLEncoder.encode(add_email, "utf-8");
					// resp.sendRedirect("/MyFirstItem/adminServlet?method=search&email="+encode_email);
					resp.sendRedirect(req.getContextPath()+"/admin/page/page/admin/list.jsp");
					return;
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(maps);
	}
	/**
	 * 通过管理员id移除管理员
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void remove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		AdminDao dao = new AdminDaoimpl();
		dao.removeAdmin(Integer.parseInt(id));
		resp.sendRedirect(req.getContextPath()+"/admin/page/page/admin/list.jsp");
	}
	/**
	 * 修改的中间跳转页面，因为有一专门用来修改的页面
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void forwardModify(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		req.getRequestDispatcher("/admin/page/page/admin/modify.jsp").forward(req, resp);
	}
	/**
	 * 重置管理员密码
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void modify(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		AdminDao dao = new AdminDaoimpl();
		dao.resetPwd(Integer.parseInt(id));
		resp.sendRedirect(req.getContextPath()+"/admin/page/page/admin/list.jsp");
	}
}
