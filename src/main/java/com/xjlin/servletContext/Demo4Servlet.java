package com.xjlin.servletContext;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取web应用的初始化信息
 * ServletContext -- 代表当前web应用
 *
 * 2.用来获取web应用的初始化参数（注意是整个web的初始化参数， 区别于servletConfig,
 *      ServletConfig是配置在<servlet></servlet>标签中的）
 *      <context-param>
 *         <param-name>username</param-name>
 *         <param-value>xjlin</param-value>
 *     </context-param>
 *     <context-param>
 *         <param-name>password</param-name>
 *         <param-value>123</param-value>
 *     </context-param>
 *
 适用： 整个工程的编码， 连接数据库的用户名密码等
 *       请求参数 parameter --- 浏览器发送过来的请求中的参数信息
 *       初始化参数 initparameter --- 在web.xml中为Servlet或ServletContext配置的初始化时带有的基本参数
 *       域属性 attribute --- 四大作用于中存取的键值对
 */
@WebServlet("/servlet/Demo4Servlet_old")
public class Demo4Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext context = this.getServletContext();
		Enumeration enumeration = context.getInitParameterNames();
		while(enumeration.hasMoreElements()){
			String name = (String) enumeration.nextElement();
			String value = context.getInitParameter(name);
			System.out.println(name+":"+value);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
