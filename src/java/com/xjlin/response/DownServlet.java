package com.xjlin.response;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/servlet/DownServlet")
public class DownServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        /**
         *   没写下面这句话， 会在浏览器中直接打开图片， 写了的话， 会以文件形式下载
         */
		response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode("美女.jpg", "utf-8"));

        /**
         * 下面这句话会造成下载时文件名乱码
         * 原因：http请求头中只能包含iso-8859-1字符！！！
         * 解决： url编码， 又叫百分号编码
         */
//        response.setHeader("Content-Disposition", "attachment;filename=美女.jpg");

		InputStream in = new FileInputStream(this.getServletContext().getRealPath("1.jpg"));
		OutputStream out = response.getOutputStream();
		
		byte[]bs = new byte[1024];
		int i = 0;
		while((i=in.read(bs))!=-1){
			out.write(bs,0,i);
		}
		
		in.close();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
