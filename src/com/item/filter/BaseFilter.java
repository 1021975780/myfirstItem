package com.item.filter;

import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * һ��Ĭ�Ϲ�������һЩ������Ҫ�Ĳ���
 * @author wangqun
 *
 */
public class BaseFilter extends InitFilter{

	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) {
		// TODO Auto-generated method stub
		FilterConfig filterConfig = getFilterConfig();
		try {
			req.setCharacterEncoding("utf-8");
			resp.setCharacterEncoding("utf-8");
			chain.doFilter(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
