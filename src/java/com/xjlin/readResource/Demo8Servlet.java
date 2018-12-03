package com.xjlin.readResource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 类加载器方式读取资源文件
 *
 * 调用的Service类不是一个servlet
 */
@WebServlet("/servlet/Demo8Servlet")
public class Demo8Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        GetCloassLoaderTestService service = new GetCloassLoaderTestService();
		service.methdo1();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
