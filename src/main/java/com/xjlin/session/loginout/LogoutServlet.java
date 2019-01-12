package com.xjlin.session.loginout;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/day05/logout")

public class LogoutServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.杀死session
		if(request.getSession(false)!=null 
				&& request.getSession().getAttribute("user")!=null){
			request.getSession().invalidate();
		}
		//2.重定向到主页
		response.sendRedirect(request.getContextPath()+"/day05/index.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
