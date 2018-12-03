package com.xjlin.test;

import org.junit.Test;

import com.xjlin.dao.XmlUserDao;
import com.xjlin.domain.User;

public class XmlUserDaoTest {
	@Test
	public void testFindUserByUserName(){
		XmlUserDao dao = new XmlUserDao();
		User user = dao.findUserByUserName("adminxxx");
		System.out.println(user);
	}
	
	@Test
	public void testFindUserByNMandPSW(){
		XmlUserDao dao = new XmlUserDao();
		User user = dao.findUserByUNandPSW("admin", "adminxx");
		System.out.println(user);
	}
	
	@Test
	public void testAddUser(){
		XmlUserDao dao = new XmlUserDao();
		User user = new User();
		user.setUsername("朴乾");
		user.setPassword("123");
		user.setNickname("小朴朴");
		user.setEmail("piaoqian@itcast.cn");
		dao.addUser(user);
	}
}
