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
	 * ���һ��Connection���ݿ����Ӷ���
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return cpds.getConnection();
	}
	/**
	 * �ر�Connection����
	 * @param connection
	 * @throws SQLException
	 */
	public static void closeCon(Connection connection) throws SQLException {
		connection.close();
	}
}
