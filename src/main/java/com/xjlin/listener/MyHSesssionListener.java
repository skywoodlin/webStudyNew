package com.xjlin.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 监听Session对象的创建和销毁
 *
 * @author park
 */
public class MyHSesssionListener implements HttpSessionListener{

    public void sessionCreated(HttpSessionEvent se){
        System.out.println("session对象被创建出来了..." + se.getSession());
    }

    public void sessionDestroyed(HttpSessionEvent se){
        System.out.println("session对象被销毁了..." + se.getSession());
    }

}
