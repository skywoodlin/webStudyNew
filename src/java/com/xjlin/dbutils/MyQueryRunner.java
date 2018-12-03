package com.xjlin.dbutils;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.DbUtils;

public class MyQueryRunner {
	private DataSource source = null;
	public MyQueryRunner() {
	}
	public MyQueryRunner(DataSource source) {
		this.source = source;
	}
	public int update(String sql, Object... params) throws SQLException{
		Connection conn = source.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		//--获取参数元数据,获取参数的个数
		ParameterMetaData metaData = ps.getParameterMetaData();
		int count = metaData.getParameterCount();
		//--循环设置参数的值
		for(int i=1;i<=count;i++){
			ps.setObject(i, params[i-1]);
		}
		//--执行update操作
		int num = ps.executeUpdate();
		DbUtils.closeQuietly(conn, ps, null);
		return num;
	}
	
	public <T> T query(String sql, MyResultSetHandler<T> rsh, Object... params)throws SQLException{
		Connection conn = source.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		//--获取参数元数据,获知参数个数
		ParameterMetaData metaData = ps.getParameterMetaData();
		int count = metaData.getParameterCount();
		//--循环设置参数
		for(int i=1;i<=count;i++){
			ps.setObject(i, params[i-1]);
		}
		
		//--执行查询获取结果集
		ResultSet rs = ps.executeQuery();
		
		//--回调处理结果集的逻辑
		T t = rsh.handle(rs);
		DbUtils.closeQuietly(conn, ps, rs);
		return t;
	}

}
