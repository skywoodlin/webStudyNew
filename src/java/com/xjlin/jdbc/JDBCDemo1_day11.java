package com.xjlin.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.xjlin.pool.MyPool;

/**
 * 使用连接池
 */
public class JDBCDemo1_day11 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MyPool pool = new MyPool();
		try{
			conn = pool.getConnection();
			ps = conn.prepareStatement("select * from account");
			rs = ps.executeQuery();
			while(rs.next()){
				String name = rs.getString("name");
				System.out.println(name);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					rs = null;
				}
			}
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					ps = null;
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					conn = null;
				}
			}
		}
	}
}
