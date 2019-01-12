package com.xjlin.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Demo1Filter implements Filter {

	public void destroy() {
		System.out.println("Demo1Filter销毁了.....");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("demo1filter 前");
		chain.doFilter(request, response);
		System.out.println("demo1filter 后");
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Demo1Filter初始化了.....");
		filterConfig.getServletContext();
//		String v = filterConfig.getInitParameter("name1");
//		System.out.println(v);
		
		Enumeration<String> enumeration = filterConfig.getInitParameterNames();
		while(enumeration.hasMoreElements()){
			String name = enumeration.nextElement();
			String value = filterConfig.getInitParameter(name);
			System.out.println(name+":"+value);
		}
	}

}
