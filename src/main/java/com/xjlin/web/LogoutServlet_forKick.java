package com.xjlin.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet_forKick extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getSession(false)!=null){
			request.getSession().invalidate();
			
			//删除自动登陆cookie
			Cookie autologinC = new Cookie("autologin","");
			autologinC.setPath(request.getContextPath());
			autologinC.setMaxAge(0);
			response.addCookie(autologinC);
			
		}
		response.sendRedirect(request.getContextPath()+"/index_forKick.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
