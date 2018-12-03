package com.xjlin.domain;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

public class Person implements Serializable, HttpSessionBindingListener, HttpSessionActivationListener{
    private String name;
    private int age;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void valueBound(HttpSessionBindingEvent event){
        System.out.println("当当前javabean对象被绑定到session域中时,javabean自己感知到自己被绑定到了session中,从而触发此方法...");
    }

    public void valueUnbound(HttpSessionBindingEvent event){
        System.out.println("当当前javabean对象被移除出session时,javabean自己感知到自己被移除出session从而触发此方法...");
    }

    public void sessionDidActivate(HttpSessionEvent se){
        System.out.println("javabean感知到自己随着session被活化了..触发此方法...");
    }

    public void sessionWillPassivate(HttpSessionEvent se){
        System.out.println("javabean感知到自己随着session被钝化了..触发此方法..");
    }

}	
