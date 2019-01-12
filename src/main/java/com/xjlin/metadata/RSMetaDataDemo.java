package com.xjlin.metadata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 结果集元数据
 */
public class RSMetaDataDemo {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ComboPooledDataSource source = new ComboPooledDataSource();
		try{
			conn = source.getConnection();
			ps = conn.prepareStatement("select * from account");
			rs = ps.executeQuery();
			//--获取结果集元数据
			ResultSetMetaData metaData = rs.getMetaData();
			//----获取结果集中的列数
			int cc = metaData.getColumnCount();
			System.out.println(cc);
//			----获取结果集中指定列的名称
			String cn1 = metaData.getColumnName(2);
			System.out.println(cn1);
//			----获取结果集中指定列的类型的名称
			String ct1 = metaData.getColumnTypeName(3);
			System.out.println(ct1);
			
			System.out.println("-------------------------------------------------------");
			for(int i = 1;i<=cc;i++){
				String cn = metaData.getColumnName(i);
				String ct = metaData.getColumnTypeName(i);
				System.out.print(cn+":"+ct+"\t\t");
			}
			System.out.println();
			System.out.println("-------------------------------------------------------");
			while(rs.next()){
				for(int i =1 ;i<=cc;i++){
					Object obj = rs.getObject(i);
					System.out.print(obj+"\t\t\t");
				}
				System.out.println();
			}
			
			System.out.println("-------------------------------------------------------");
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtils.closeQuietly(conn, ps, rs);
		}
	}
}
