package com.xjlin.web;

import com.xjlin.domain.User_forKick;
import com.xjlin.util.DaoUtils;
import com.xjlin.util.MD5Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

public class LoginServlet_forKick extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//1.获取用户名密码
		String name = request.getParameter("name");
//		String password  = MD5Utils.md5(request.getParameter("password"));
		String password  = request.getParameter("password");
		//2.校验用户名密码
		String sql = "select * from user_forKick where name = ? and password = ? ";
        User_forKick user = null;
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			user = runner.query(sql, new BeanHandler<>(User_forKick.class),name,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(user == null){
			response.getWriter().write("用户名密码不正确");
			return;
		}else{
			//3.登录用户
				ServletContext context = this.getServletContext();
				Map<User_forKick,HttpSession> map = (Map<User_forKick, HttpSession>) context.getAttribute("usermap");
				HttpSession session = map.get(user);
				if(session!=null)
					session.invalidate();
				request.getSession().setAttribute("user", user);
			//4.重定向到主页
				response.sendRedirect(request.getContextPath()+"/index_forKick.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
