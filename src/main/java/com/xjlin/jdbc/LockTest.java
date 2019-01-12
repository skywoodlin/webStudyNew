package com.xjlin.jdbc;

import com.xjlin.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.Statement;

/**
 * Created by xjlin on 2018/11/19.
 */
public class LockTest{
    @Test
    public void add(){
        Connection conn = null;
        Statement stat = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            // 1.注册数据库驱动
            // 2.获取连接
            conn = JDBCUtils.getConn();

            //关闭自动提交，开启事务
            conn.setAutoCommit(false);

            // 4.执行sql语句
            ps = conn.prepareStatement("select * from users where id = ? for update");

            ps.setInt(1, 1);
            rs = ps.executeQuery();

            //处理查询结果集
            while(rs.next()){
                System.out.println(rs.getString("username"));
            }

            conn.commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            //6.关闭资源
            JDBCUtils.close(null, ps, conn);
        }
    }
}
