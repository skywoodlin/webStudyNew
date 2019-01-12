package com.xjlin.request;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/servlet/ParamServlet")
public class ParamServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        // --通知服务器以什么编码解码http请求中的实体内容,所以这行代码只能解决post提交的乱码
		request.setCharacterEncoding("utf-8");

		//(2018.11.04测试， 这句话已经过时)对于get提交只能手动解决请求参数中的乱码
		String username = request.getParameter("username");
//		username = new String(username.getBytes("iso8859-1"),"utf-8");
		System.out.println(username);
		
//		Enumeration<String> enumeration = request.getParameterNames();
//		while(enumeration.hasMoreElements()){
//			String name = enumeration.nextElement();
//			String value = request.getParameter(name);
//			System.out.println(name+":"+value);
//		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
