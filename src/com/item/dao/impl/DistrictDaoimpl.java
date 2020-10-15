package com.item.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.item.beans.District;
import com.item.dao.DistrictDao;
import com.item.utils.JDBCUtils;



public class DistrictDaoimpl implements DistrictDao{
	QueryRunner qr = new QueryRunner();
	/**
	 * 通过市的id获得这个市对应地区的信息列表
	 */
	@Override
	public List<District> getList(int id) {
		// TODO Auto-generated method stub
		String sql="select DistrictID districtId,DistrictName districtName from District where CityID="+id;
		Connection conn;
		List<District> districts=null;
		try {
			conn = JDBCUtils.getConnection();
			districts = qr.query(conn, sql, new BeanListHandler<>(District.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return districts;
	}

}
