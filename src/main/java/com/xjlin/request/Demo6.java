package com.xjlin.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/servlet/Demo6")

public class Demo6 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("before 6");
		response.getWriter().write("out from 6 bef我");
		
		//response.getWriter().write("哈哈from demo6....");
		
		System.out.println(Thread.currentThread().getName() + "after 6");
		response.getWriter().write("out from 6 aft");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
