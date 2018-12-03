package com.xjlin.jsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/day05/Demo1")
public class Demo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//在Servlet中输出HTML内容十分的不方便
		//并且为html增加js和css等控制时十分的不方便
		response.getWriter().write("<from action='' method='' onsubmit='checkForm()'>" +
				"<input type='text' name='username'/>"+
				"<input type='password' name='password'/>"+
				"</form>");
		response.getWriter().write("function checkForm(){" +"" +
				"" +
				""+
				"}");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
