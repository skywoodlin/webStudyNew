package com.xjlin.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/servlet/FengjieServlet")
public class FengjieServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String ref = request.getHeader("Referer");
        System.out.println("ref= " + ref);
		if(ref==null || "".equals(ref) || !ref.startsWith("http://localhost")){
			response.sendRedirect(request.getContextPath()+"/index.html");
			return;
		}
		
		response.getWriter().write("凤姐独家回忆..我在黑马的日子..收货了很多很多......");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
