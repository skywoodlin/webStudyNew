package com.xjlin.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/servlet/OutServlet")
public class OutServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    //getOutputStream方式
//		response.getOutputStream().write("中国".getBytes("utf-8"));
//		response.getOutputStream().write("中国".getBytes());  //默认为gbk
//		response.setHeader("Content-Type", "text/html;charset=utf-8");
		
		//response.setCharacterEncoding("utf-8");
		//response.setHeader("Content-Type", "text/html;charset=utf-8");
		
        //用writer的时候， 注意下面的描述：
        //不设置字符集的话， 默认去字符字符集： iso-8859-1， 去查“中国”的时候发现找不到，所以直接用“?”的编码代替
        //所以浏览器不管这么设置编码， 都是"?"
        //解决：在调用之前设置字符集
		response.setContentType("text/html;charset=utf-8"); //终极简化成这句！！
		response.setCharacterEncoding("utf-8"); //为了让看代码的人懂， 勉强加上这一句吧！ 其实不必要
		response.getWriter().write("中国");//
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
