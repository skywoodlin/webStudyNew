package com.xjlin.servletContext;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ServletContext域演示
 *ServletContext -- 代表当前web应用
 *     1.做为域对象可以在整个web应用范围内共享数据
 *         域对象：在一个可以被看见的范围内共享数据用到对象
 *
 *         作用范围：整个web应用范围内共享数据
 *         生命周期：当服务器启动web应用加载后创建出ServletContext对象后，域产生。
 *         当web应用被移除出容器或服务器关闭，随着web应用的销毁域销毁。
 *
 *         void setAttribute(String,Object);
 *        Object getAttribute(String);
 *        void removeAttribute(String);

 *
 *
 *
 * 在整个web启动期间， 同一个web工程里的所有servlet都可以拿到它，
 * 是在各个servlet之间共享的对象
 *
 * 在Demo2Servlet里set后， 在Demo3Servlet可以取出来
 */
public class Demo2Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	    //两种获取ServletContext的方式
		ServletContext context = this.getServletContext();

		ServletContext context2 = this.getServletConfig().getServletContext();
        System.out.println(context == context2); //true

		context.setAttribute("apple", "red apple");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
