package com.xjlin.dao;

import com.xjlin.domain.User;

import java.sql.SQLException;

public interface UserDao {
	/**
	 * 根据用户名查找用户
	 * @param username 用户名
	 * @return 根据用户名找到的用户信息bean,如果没找到返回null
	 */
	public User findUserByUserName(String username) throws SQLException;
	
	/**
	 * 添加用户
	 * @param user 要添加的用户信息bean
	 */
	public void addUser(User user) throws SQLException;
	
	/**
	 * 根据用户名密码查找对应的用户
	 * @param username 用户名
	 * @param password 密码
	 * @return 找到的用户,如果找不到则返回null
	 */
	public User findUserByUNandPSW(String username, String password) throws SQLException;
}
