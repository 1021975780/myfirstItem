package com.item.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.item.beans.Province;
import com.item.dao.ProvinceDao;
import com.item.utils.JDBCUtils;



public class ProvinceDaoimpl implements ProvinceDao{
	QueryRunner qr = new QueryRunner();
	/**
	 * 获得省列表
	 */
	@Override
	public List<Province> getList() {
		// TODO Auto-generated method stub
		String sql="select ProvinceID provinceId,ProvinceName provinceName from Province";
		Connection conn;
		List<Province> provinces=null;
		try {
			conn = JDBCUtils.getConnection();
			provinces = qr.query(conn, sql, new BeanListHandler<>(Province.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return provinces;
	}

	
}
