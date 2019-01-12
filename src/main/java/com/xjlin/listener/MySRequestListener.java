package com.xjlin.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * 监听request对象创建和销毁
 * @author park
 *
 */
public class MySRequestListener implements ServletRequestListener {

	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("request对象被销毁了. ..."+sre.getServletRequest());
		
	}

	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("request对象被创建出来了. ..."+sre.getServletRequest());
		
	}

}
