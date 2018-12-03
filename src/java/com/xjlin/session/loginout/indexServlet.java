package com.xjlin.session.loginout;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/day05/index")
public class indexServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession(false);
        if(session == null) {
            System.out.println("还没有session");
            response.sendRedirect(request.getContextPath()+"/day05/index.jsp");
        }else{
            response.sendRedirect(request.getContextPath()+"/day05/login");
        }
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
