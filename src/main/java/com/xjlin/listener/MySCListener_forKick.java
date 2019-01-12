package com.xjlin.listener;

import com.xjlin.domain.User_forKick;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;

public class MySCListener_forKick implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent sce) {

	}

	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		context.setAttribute("usermap", new LinkedHashMap<User_forKick, HttpSession>());
	}
}
