package com.xjlin.web;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xjlin.domain.User;
import com.xjlin.service.UserService;
@WebServlet("/user/LoginServlet")
public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        UserService service = null;
        try{
            service = new UserService();
        }catch(Exception e){
            e.printStackTrace();
        }
        //1.获取客户端提交的用户名密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //2.调用Service中的方法检查用户名密码
        User user = null;
        try{
            user = service.isUser(username, password);
        }catch(SQLException e){
            e.printStackTrace();
        }
        if(user == null){
            //3.如果不正确则提示
//			request.setAttribute("msg", "aaaaa用户名密码不正确!");
            request.setAttribute("msg", "用户名密码不正确");
//            request.setAttribute("msg", "中国");
            request.getRequestDispatcher("/day07/user/login.jsp").forward(request, response);
            return;
        }else{
            //4.正确则登录用户后重定向回到主页
            request.getSession().setAttribute("user", user);

            if("ok".equals(request.getParameter("remname"))){
                //如果用户勾选过记住用户则发送cookie另浏览器保存用户名
                Cookie remNameC = new Cookie("remname",URLEncoder.encode(user.getUsername(), "utf-8"));
                remNameC.setPath(request.getContextPath());
                remNameC.setMaxAge(3600*24*30);
                response.addCookie(remNameC);
            }else{
                //如果用户没有勾选记住用户名则删除记住用户名的cookie
                Cookie remNameC = new Cookie("remname","");
                remNameC.setPath(request.getContextPath());
                remNameC.setMaxAge(0);
                response.addCookie(remNameC);
            }

            response.sendRedirect(request.getContextPath()+"/day07/user/index.jsp");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
