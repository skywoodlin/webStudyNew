package com.xjlin.request;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * request获取请求头信息
 */
@WebServlet("/servlet/HeaderServlet")
public class HeaderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String value = request.getHeader("Host");
		System.out.println(value);

		//遍历请求头
		Enumeration<String> enumeration = request.getHeaderNames();
		while(enumeration.hasMoreElements()){
			String name = enumeration.nextElement();
			String value2 = request.getHeader(name);
			System.out.println(name+":"+value2);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
