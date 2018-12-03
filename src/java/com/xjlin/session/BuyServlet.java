package com.xjlin.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/session/buy")
public class BuyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String prod = request.getParameter("prod");
//		prod = new String(prod.getBytes("iso8859-1"),"utf-8");
		
		HttpSession session = request.getSession();
//		Cookie jc = new Cookie("k",session.getId());
//		Cookie jc2 = new Cookie("k2","abc");
//		jc.setPath(request.getContextPath());
//		jc.setMaxAge(1800);
//		response.addCookie(jc);
//		response.addCookie(jc2);

		session.setAttribute("prod", prod);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
