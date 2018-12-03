package com.xjlin.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class MySCAttrListener implements ServletContextAttributeListener {

	public void attributeAdded(ServletContextAttributeEvent scab) {
		System.out.println("属性被加入到了SC域中"+scab.getName()+":"+scab.getValue());
	}

	public void attributeRemoved(ServletContextAttributeEvent scab) {
		System.out.println("属性被移除出了SC域中"+scab.getName()+":"+scab.getValue());
	}

	public void attributeReplaced(ServletContextAttributeEvent scab) {
		System.out.println("属性被替换在SC域中"+scab.getName()+":"+scab.getValue()+":"+scab.getServletContext().getAttribute(scab.getName()));
	}

}
