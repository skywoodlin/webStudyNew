package com.xjlin.dao;

import com.xjlin.domain.User;
import com.xjlin.util.JDBCUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TomcatPoolDao implements UserDao{
    private DataSource dataSource = null;

    public TomcatPoolDao(DataSource dataSource) throws Exception{
        if(dataSource != null){
            setDataSource(dataSource);
        }else{
            throw new Exception("dataSource不存在");
        }
    }

    public void addUser(User user) throws SQLException{
        Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into users values (null,?,?,?,?)");
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getNickname());
        ps.setString(4, user.getEmail());
        int rs = ps.executeUpdate();
        if(rs > 0){
            System.out.println("插入成功！");
        }
        ps.close();
        conn.close();
    }

    public User findUserByUNandPSW(String username, String password) throws SQLException{
        User user = null;
        Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from users where username=? and password = ?");
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            user = new User();
            String name = rs.getString("username");
            user.setUsername(name);
            System.out.println(name);
            String pass = rs.getString("password");
            user.setPassword(name);
            System.out.println(pass);
            String mail = rs.getString("email");
            System.out.println(mail);
            user.setEmail(mail);
            break;
        }
        rs.close();
        ps.close();
        conn.close();

        return user;
    }

    public User findUserByUserName(String username) throws SQLException{
        Connection conn = dataSource.getConnection();
        String sql = "select * from users where username='" + username + "'";
        Statement stat = null;
        ResultSet rs = null;
        try{
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            if(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setNickname(rs.getString("nickname"));
                user.setEmail(rs.getString("email"));
                return user;
            }else{
                return null;
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            JDBCUtils.close(rs, stat, conn);
        }
    }

    public DataSource getDataSource(){
        return dataSource;
    }

    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }
}
