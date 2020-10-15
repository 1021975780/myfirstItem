package com.item.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.item.beans.Gclass;
import com.item.dao.GclassDao;
import com.item.dao.impl.GclassDaoimpl;

public class GclassServlet extends HttpServlet {
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
	 * 通过类别的名字从数据库中查找类别
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		GclassDao dao = new GclassDaoimpl();
		List<Gclass> list = dao.getList(name);
		req.setAttribute("list", list);
		req.getRequestDispatcher("/admin/page/page/gclass/list.jsp").forward(req, resp);
	}
	/**
	 * 通过类别名字添加类别
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		GclassDao dao = new GclassDaoimpl();
		dao.addGclass(name);
		String encode_name = URLEncoder.encode(name, "utf-8");
		resp.sendRedirect(req.getContextPath()+"/gclassServlet?method=search&name="+encode_name);
	}
	/**
	 * 修改类别名字的中间跳转页面
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void forwardModify(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		GclassDao dao = new GclassDaoimpl();
		Gclass gclass = dao.getGclass(Integer.parseInt(id));
		req.setAttribute("gclass",gclass);
		req.getRequestDispatcher("/admin/page/page/gclass/modify.jsp").forward(req, resp);
	}
	/**
	 * 通过类别名字和id修改类别的名字
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void modify(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		Gclass gclass = new Gclass(Integer.parseInt(id), name);
		GclassDao dao = new GclassDaoimpl();
		dao.updateGclass(gclass);
		String encode_name = URLEncoder.encode(name, "utf-8");
		resp.sendRedirect(req.getContextPath()+"/gclassServlet?method=search&name="+encode_name);
	}
	/**
	 * 通过id移除类别
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void remove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		GclassDao dao = new GclassDaoimpl();
		dao.removeGclass(Integer.parseInt(id));
		resp.sendRedirect(req.getContextPath()+"/admin/page/page/gclass/list.jsp");
	}
}
