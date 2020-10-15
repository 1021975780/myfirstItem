package com.item.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.item.beans.City;
import com.item.beans.District;
import com.item.beans.Province;
import com.item.dao.CityDao;
import com.item.dao.DistrictDao;
import com.item.dao.ProvinceDao;
import com.item.dao.impl.CityDaoimpl;
import com.item.dao.impl.DistrictDaoimpl;
import com.item.dao.impl.ProvinceDaoimpl;

public class AddressServlet extends HttpServlet{
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
	 * 城市信息
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
		public void city(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String provinceId = req.getParameter("provinceId");
			CityDao dao  = new CityDaoimpl();
			int id=Integer.parseInt(provinceId);
			List<City> list = dao.getList(id);
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(list);
			resp.getWriter().print(json);
			
		}
		/**
		 * 省信息
		 * @param req
		 * @param resp
		 * @throws ServletException
		 * @throws IOException
		 */
		public void province(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			ProvinceDao dao = new ProvinceDaoimpl();
			List<Province> list = dao.getList();
			req.setAttribute("list", list);
			req.getRequestDispatcher("/user/orderConfirm.jsp").forward(req, resp);
		}
		/**
		 * 地区信息
		 * @param req
		 * @param resp
		 * @throws ServletException
		 * @throws IOException
		 */
		public void district(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			DistrictDao dao = new DistrictDaoimpl();
			String districtId = req.getParameter("districtId");
			int id=Integer.parseInt(districtId);
			List<District> list = dao.getList(id);
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(list);
			resp.getWriter().print(json);
		}
}
