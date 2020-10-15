package com.item.utils;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	private static ComboPooledDataSource cpds = null;
	static {
		cpds = new ComboPooledDataSource("wangqun");
	}
	/**
	 * 获得一个Connection数据库连接对象
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return cpds.getConnection();
	}
	/**
	 * 关闭Connection连接
	 * @param connection
	 * @throws SQLException
	 */
	public static void closeCon(Connection connection) throws SQLException {
		connection.close();
	}
}
