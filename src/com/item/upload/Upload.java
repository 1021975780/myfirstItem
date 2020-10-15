package com.item.upload;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.item.utils.Simple;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Upload {
	/**
	 * 获得文件上传工厂
	 * @return
	 * @throws FileUploadException
	 */
	public static DiskFileItemFactory getUpload() throws FileUploadException {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setDefaultCharset("utf-8");
		return factory;
	}
	/**
	 * 通过req域解析出从客户端长传的name和value的键值对
	 * @param req
	 * @param bool
	 * @return
	 * @throws Exception
	 */
	public static Map<?,?> getItemMaps(HttpServletRequest req,boolean bool) throws Exception {
		Simple simple = Simple.getSimple();
		
		DiskFileItemFactory factory = simple.getFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		Properties properties = new Properties(); 
		InputStream iss = Upload.class.getClassLoader().getResourceAsStream("uploadInfo.properties");
		properties.load(iss);
		int sizeThreshold =Integer.parseInt(properties.getProperty("sizeThreshold"));
		int fileSizeMax = Integer.parseInt(properties.getProperty("fileSizeMax"));
		int sizeMax=Integer.parseInt(properties.getProperty("sizeMax"));
		factory.setSizeThreshold(sizeThreshold);
		upload.setFileSizeMax(fileSizeMax);
		upload.setSizeMax(sizeMax);
		List<FileItem> items=null;
		Map<String,String> maps=new HashMap();
		bool=false;
		try {
			items = upload.parseRequest(req);
			for (FileItem fileItem : items) {
				if (!fileItem.isFormField()) {
					if (fileItem.getName()!=null&&!fileItem.getName().equals("")) {
						bool=true;
					}
					if (bool) {
						String name=fileItem.getFieldName();
						String path=fileItem.getName();
						String real_path = req.getServletContext().getRealPath("/image/");
						String ext=path.substring(path.lastIndexOf("."));
						InputStream is = fileItem.getInputStream();
						String final_path=real_path+System.currentTimeMillis()+new Random().nextInt(1000000)+ext;
						OutputStream os = new FileOutputStream(final_path);
						maps.put(name, final_path);
						byte []b =new byte[1024]; 
						int len=0;
						while((len=is.read(b))!=-1) {
							os.write(b, 0, len);
						}
					}
				}
				else {
					String name=fileItem.getFieldName();
					String value = fileItem.getString();
					maps.put(name, value);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(maps);
		return maps;
	}
}
