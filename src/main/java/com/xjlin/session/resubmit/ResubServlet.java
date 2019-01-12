package com.xjlin.session.resubmit;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResubServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			Thread.sleep(4*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		String username = request.getParameter("username");
		String valinum = request.getParameter("valinum");
		String valinum2 = (String) request.getSession().getAttribute("valinum");
		if(valinum2!=null && !"".equals(valinum2) && valinum.equals(valinum2)){
			request.getSession().removeAttribute("valinum");
			System.out.println("向数据库中注册一次:"+username);
		}else{
			response.getWriter().write("from web:不要重复提交!!");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
