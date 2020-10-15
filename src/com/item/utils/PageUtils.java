package com.item.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageUtils {
	public static void paging(int count, int pageSize, HttpServletRequest req,
			HttpServletResponse resp) {
 
		/* 进行分页 */
		// 一页的商品条数
		// 将pageSize，count保存到session中
		req.getSession().setAttribute("pageSize", pageSize);
		req.getSession().setAttribute("count", count);
		// 一共多少页
		int totalpage = count / pageSize + (count % pageSize > 0 ? 1 : 0);
		System.out.println("一共多少页" + totalpage);
		req.getSession().setAttribute("totalpage", totalpage);
 
		// 获取传递过来的页数
		int pageNo = 1;
		if (req.getParameter("pageNo") != null
				&& req.getParameter("pageNo") != "") {
			pageNo = Integer.parseInt(req.getParameter("pageNo"));
		}
		if (pageNo < 1) {
			pageNo = 1;
		}
		if (pageNo >= totalpage) {
			pageNo = totalpage;
		}
 
		// 定义遍历商品开始时的序号
		int beginProduct = (pageNo - 1) * pageSize;
		req.getSession().setAttribute("beginProduct", beginProduct);
		// 定义遍历商品结束的序号
		int endProduct = pageNo * pageSize - 1;
		req.getSession().setAttribute("endProduct", endProduct);
		req.getSession().setAttribute("pageNo", pageNo);
 
	}


}
