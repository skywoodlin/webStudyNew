package com.xjlin.web;

import com.xjlin.domain.User;
import com.xjlin.exception.MsgException;
import com.xjlin.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/RegistServlet")
public class RegistServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			UserService service = new UserService();
			//1.检验验证码
			String valistr = request.getParameter("valistr");
			String valistr2 = (String) request.getSession().getAttribute("valistr");
			if(valistr == null || valistr2==null || !valistr.equals(valistr2)){
//				request.setAttribute("msg", "验证码不正确!");
				request.setAttribute("msg", "验证码不正确");
				request.getRequestDispatcher("/day07/user/regist.jsp").forward(request, response);
				return;
			}
			//2.封装数据校验数据
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());
			user.checkValue();
			//3.调用Service中的方法添加用户
			service.registUser(user);
			//4.登录用户
			request.getSession().setAttribute("user", user);
			//5.提示注册成功3秒回到主页
//			response.getWriter().write("恭喜您注册成功!3秒回到主页....");
			response.getWriter().write("恭喜注册成功， 回到主页。。。。。");
			response.setHeader("refresh", "3;url="+request.getContextPath()+"/day07/user/index.jsp");
		}catch (MsgException e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/day07/user/regist.jsp").forward(request, response);
			return;
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
