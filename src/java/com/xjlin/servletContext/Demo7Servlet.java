package com.xjlin.servletContext;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ServletContext读取资源文件
 *
 * 在Servlet中读取资源文件时:
*      如果写相对路径和绝对路径,由于路径将会相对于程序启动的目录--在web环境下,就是tomcat启动的目录即tomcat/bin--所有找不到资源
*      如果写硬盘路径,可以找到资源,但是只要一换发布环境,这个硬盘路径很可能是错误的,同样不行.
*      为了解决这样的问题ServletContext提供了getRealPath方法,在这个方法中传入一个路径,这个方法的底层会在传入的路径前拼接当前web应用的硬盘路径从而得到当前资源的硬盘路径,
*      这种方式即使换了发布环境,方法的底层也能得到正确的web应用的路径从而永远都是正确的资源的路径
*       this.getServletContext().getRealPath("config.properties")
*
*      如果在非Servlet环境下要读取资源文件时可以采用类加载器加载文件的方式读取资源
*          Service.class.getClassLoader().getResource("../../../config.properties").getPath()
 */
@WebServlet("/servlet/Demo7Servlet")
public class Demo7Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//给一个相对路径字符串， 看看它的绝对路径在哪里
        //结果：L:\IT_Software\tomcats\tomcat9.0.12_x64\bin\properties\config2.properties
        //原因：
        //1. 原理： 程序在哪里启动， 它的相对根目录就在哪里。
        //2. web启动实质上是tomcat启动， 所以， 它的根目录的绝对路径就在bin目录
		File file = new File("properties/config2.properties");
		System.out.println(file.getAbsolutePath());

		//web项目中的根目录到底在哪里
        //输出： 当前web项目的根目录在： D:\project_study\webStudyDay03_maven\target\webStudyDay03_maven\
        System.out.println("当前web项目的根目录在： " + this.getServletContext().getRealPath("/"));

		// web项目中，利用this.getServletContext().getRealPath(相对路径/绝对路径)来获取
		Properties prop = new Properties();
		prop.load(new FileReader(this.getServletContext().getRealPath("/WEB-INF/classes/config.properties")));
		
		System.out.println(prop.getProperty("username"));
		System.out.println(prop.getProperty("password"));
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
