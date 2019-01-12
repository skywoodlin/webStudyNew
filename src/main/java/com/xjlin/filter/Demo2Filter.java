package com.xjlin.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Demo2Filter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("demo2filter 前");
		chain.doFilter(request, response);
		System.out.println("demo2filter 后");
	}

	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
