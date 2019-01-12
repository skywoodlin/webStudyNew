package com.xjlin.basic;

import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 潜在的线程安全问题
 * 1. 使用synchronized效率不好
 */
@WebServlet("/servlet/Demo1Servlet_old")
public class Demo1Servlet extends HttpServlet{
    int i = 0;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
//        synchronized(this){  效率不好, 但也没办法， 尽量在核心的部分锁
            i++;
            try{
                Thread.sleep(4 * 1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            response.getWriter().write(i + "");

//        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        doGet(request, response);
    }

}
