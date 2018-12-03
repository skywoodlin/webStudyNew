package com.xjlin.response;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/servlet/NoCacheServlet")
public class NoCacheServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.setIntHeader("Expires", -1);

        //设置一个国企时间
//		response.setIntHeader("Expires", (int) (System.currentTimeMillis() + 30 * 24 * 60 * 60 * 1000));
//		response.setHeader("Cache-Control", "no-cache");
//		response.setHeader("Pragma", "no-cache");
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("当前时间是:"+new Date().toLocaleString());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
