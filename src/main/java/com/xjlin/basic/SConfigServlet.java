package com.xjlin.basic;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;


/**
 * ServletConfig -- 代表当前Servlet在web.xml中的配置信息
 *          String getServletName()  -- 获取当前Servlet在web.xml中配置的名字
 *          String getInitParameter(String name) -- 获取当前Servlet指定名称的初始化参数的值
 *          Enumeration getInitParameterNames()  -- 获取当前Servlet所有初始化参数的名字组成的枚举
 *          ServletContext getServletContext()  -- 获取代表当前web应用的ServletContext对象
 */
//@WebServlet("/servlet/SConfigServlet")
public class SConfigServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletConfig config = this.getServletConfig();
		//--获取当前Servlet 在web.xml中配置的名称
		String sName = config.getServletName();
		System.out.println(sName);

		//--获取当前Servlet中配置的初始化参数
		String value1 = config.getInitParameter("name1");
		System.out.println(value1);
		
		Enumeration enumration = config.getInitParameterNames();
		while(enumration.hasMoreElements()){
			String name = (String) enumration.nextElement();
			String value = config.getInitParameter(name);
			System.out.println(name+":"+value);
		}
		//--获取ServletContext对象, 代表
		ServletContext context = config.getServletContext();
		this.getServletContext();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
