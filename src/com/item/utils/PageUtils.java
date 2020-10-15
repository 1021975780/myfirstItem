package com.item.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageUtils {
	public static void paging(int count, int pageSize, HttpServletRequest req,
			HttpServletResponse resp) {
 
		/* ���з�ҳ */
		// һҳ����Ʒ����
		// ��pageSize��count���浽session��
		req.getSession().setAttribute("pageSize", pageSize);
		req.getSession().setAttribute("count", count);
		// һ������ҳ
		int totalpage = count / pageSize + (count % pageSize > 0 ? 1 : 0);
		System.out.println("һ������ҳ" + totalpage);
		req.getSession().setAttribute("totalpage", totalpage);
 
		// ��ȡ���ݹ�����ҳ��
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
 
		// ���������Ʒ��ʼʱ�����
		int beginProduct = (pageNo - 1) * pageSize;
		req.getSession().setAttribute("beginProduct", beginProduct);
		// ���������Ʒ���������
		int endProduct = pageNo * pageSize - 1;
		req.getSession().setAttribute("endProduct", endProduct);
		req.getSession().setAttribute("pageNo", pageNo);
 
	}


}
