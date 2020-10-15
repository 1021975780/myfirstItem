package com.item.listener;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.item.upload.Upload;
import com.item.utils.JDBCUtils;
import com.item.utils.Simple;

public class ConnectionListener implements ServletContextListener{
	/**
	 * ��ʼ������������һ���������з���һ���ļ��ϴ�����
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("����������");
		DiskFileItemFactory factory=null;
		
		try {
			factory = Upload.getUpload();
			factory.setDefaultCharset("utf-8");
			Simple.getSimple().setFactory(factory);
//			Properties properties = new Properties(); 
//			InputStream is = this.getClass().getClassLoader().getResourceAsStream("uploadInfo.properties");
//			properties.load(is);
//			int sizeThreshold =Integer.parseInt(properties.getProperty("sizeThreshold"));
//			int fileSizeMax = Integer.parseInt(properties.getProperty("fileSizeMax"));
//			int sizeMax=Integer.parseInt(properties.getProperty("sizeMax"));
//			factory.setSizeThreshold(sizeThreshold);
//			upload.setFileSizeMax(fileSizeMax);
//			upload.setSizeMax(sizeMax);
			//Connection connection = JDBCUtils.getConnection();
			//Simple.getSimple().setConnection(connection);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("����������");
	}

}
