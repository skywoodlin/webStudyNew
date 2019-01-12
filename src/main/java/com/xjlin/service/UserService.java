package com.xjlin.service;

import com.xjlin.dao.MySqlUserDao;
import com.xjlin.dao.TomcatPoolDao;
import com.xjlin.dao.UserDao;
import com.xjlin.dao.XmlUserDao;
import com.xjlin.domain.User;
import com.xjlin.exception.MsgException;
import com.xjlin.factory.DaoFactory;

import javax.sql.DataSource;
import java.sql.SQLException;

public class UserService {
//	private XmlUserDao dao = new XmlUserDao();
//	private MySqlUserDao dao = new MySqlUserDao();
//    private UserDao dao = DaoFactory.getFactory().getDao();
    private DataSource dataSource = null;
    private TomcatPoolDao dao = null;
    public UserService() throws Exception{

    }

    public UserService(DataSource dataSource) throws Exception{
        setDataSource(dataSource);
        dao = new TomcatPoolDao(this.getDataSource());
    }

	/**
	 * 添加用户
	 * @param user
	 * @throws MsgException 
	 */
	public void registUser(User user) throws MsgException, SQLException{
		//1.检查用户名是否已经存在,如果已经存在则提示
		if(dao.findUserByUserName(user.getUsername())!=null){
			throw new MsgException("用户名已经存在!");
		}
		//2.如果不存在则调用dao中的方法添加用户
		dao.addUser(user);
	}
	
	/**
	 * 检查用户名密码是否正确
	 * @param username
	 * @param password
	 */
	public User isUser(String username,String password) throws SQLException{
		return dao.findUserByUNandPSW(username, password);
	}

    public DataSource getDataSource(){
        return dataSource;
    }

    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public TomcatPoolDao getDao(){
        return dao;
    }

    public void setDao(TomcatPoolDao dao){
        this.dao = dao;
    }
}
