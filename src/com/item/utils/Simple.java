package com.item.utils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
/**
 * 放入在整个项目中只需要一个对象的单例对象
 * 只用到了DiskFileItemFactory，其他两个没用
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
