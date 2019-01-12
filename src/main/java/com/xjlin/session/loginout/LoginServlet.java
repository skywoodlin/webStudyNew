package com.xjlin.session.loginout;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * xjlin修改版
 *
 * 实现需求： 浏览器关闭后， 重新打开， 用户可以自动登录
 */
@WebServlet("/day05/login")
public class LoginServlet extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username = null;
        if(request.getSession(false) == null){
            //第一次进入网站首页
            HttpSession session = request.getSession();

            Cookie cookie = new Cookie("JSESSIONID", request.getSession().getId());
            cookie.setPath(request.getContextPath() + "/");
            cookie.setMaxAge(30 * 60);
            response.addCookie(cookie);
            response.sendRedirect(request.getContextPath() + "/day05/login.jsp");
            return;
        }else{
            username = (String) request.getSession().getAttribute("user");
            //第一种情况， 填写登录信息， 已经带入Session
            if(username == null){
                //1.获取用户名密码
                username = request.getParameter("username");
                if(username == null){
                    response.sendRedirect(request.getContextPath() + "/day05/login.jsp");
                    return;
                }

                String password = request.getParameter("password");
                //2.查询数据库检查用户名密码
                if(UserDao.valiNamePsw(username, password)){
                    //3.如果正确登录后重定向到主页
                    request.getSession().setAttribute("user", username);
                    response.sendRedirect(request.getContextPath() + "/day05/index.jsp");
                    return;
                }else{
                    //4.如果错误提示
                    response.getWriter().write("用户名密码不正确");
                    return;
                }
            }else{
                //第二种情况， 已经有session了
                response.sendRedirect(request.getContextPath() + "/day05/index.jsp");
            }
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        doGet(request, response);
    }

}
