package com.xjlin.response;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/servlet/RefreshServlet")
public class RefreshServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.getWriter().write(new Date().toLocaleString());
//		response.setHeader("Refresh", "1"); //不传入url， 刷新自己，

		
//		response.setContentType("text/html;charset=utf-8");
//		response.getWriter().write("恭喜您注册成功!3秒后回到主页.....");
//		response.setHeader("refresh", "3;url=/index.jsp");
        response.sendRedirect("/index2.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
