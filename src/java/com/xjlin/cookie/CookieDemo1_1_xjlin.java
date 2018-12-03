package com.xjlin.cookie;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by xjlin on 2018/11/5.
 * 测试在不set path的情况下， xjlin底下的所有请求都有带这个cookie过来
 */
@WebServlet("/xjlin/cookie1_1")
public class CookieDemo1_1_xjlin extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.setContentType("text/html;charset=utf-8");

        Cookie[] cs = req.getCookies();
        Cookie findC = null;

        if(cs != null){
            for(Cookie c : cs){
                if("lastTime".equals(c.getName())){
                    findC = c;
                    break;
                }
            }

            if(findC == null){
                resp.getWriter().write("第一次访问本网站");
            }else{
                Long lastTime = Long.parseLong(findC.getValue());
                resp.getWriter().write("上次访问时间： " + new Date(lastTime).toLocaleString());
            }
        }else{
            resp.getWriter().write("第一次访问本网站");
        }

        Date date = new Date();
        Cookie cookie = new Cookie("lastTime", date.getTime() + "");
        cookie.setMaxAge(3600 * 24 * 30);
        resp.addCookie(cookie);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        doGet(req, resp);
    }
}
