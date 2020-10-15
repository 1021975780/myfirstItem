package com.item.utils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
/**
 * ������������Ŀ��ֻ��Ҫһ������ĵ�������
 * ֻ�õ���DiskFileItemFactory����������û��
 * @author wangqun
 *
 */
public class Simple {
	private Connection connection;
	private ServletFileUpload upload;
	private DiskFileItemFactory factory;
	
	public DiskFileItemFactory getFactory() {
		return factory;
	}
	public void setFactory(DiskFileItemFactory factory) {
		this.factory = factory;
	}
	private Simple()  {
	}
	public ServletFileUpload getUpload() {
		return upload;
	}
	public void setUpload(ServletFileUpload upload) {
		this.upload = upload;
	}
	private static Simple simple = new Simple();
	public static Simple getSimple() {
		return simple;
	}
	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
}
