package com.xjlin.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/servlet/Demo5")
public class Demo5 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    //设置
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("from demo5....1");
		response.getWriter().flush();
//		response.getWriter().write("from demo5....2");
//		response.getWriter().write("from demo5....3");
//		response.getWriter().flush();
		System.out.println("看看 before 5");
		response.getWriter().write("out from 5 bef我.。。4");

		//加了下面这一行， tomcat log报错，  什么也不会输出
		request.getRequestDispatcher("/servlet/Demo6").forward(request, response);

		System.out.println(Thread.currentThread().getName() + "after 5");
		response.getWriter().write("out from 5 aft...5");
		response.getWriter().flush();

		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
