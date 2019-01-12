package com.xjlin.lob;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.xjlin.util.JDBCUtils;

/*
	create table blobdemo(
		id int primary key auto_increment,
		name varchar(100),
		content MEDIUMBLOB
	);
 */

/**
 * findBlob输出到了工程根目录下了
 */
public class BlobDemo1 {
	@Test
	public void findBlob(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement("select * from blobdemo");
			rs = ps.executeQuery();
			while(rs.next()){
				String name = rs.getString("name");
				InputStream in = rs.getBinaryStream("content");
				OutputStream out = new FileOutputStream(name);
				
				byte [] bs = new byte[1024];
				int i = 0;
				while((i=in.read(bs))!=-1){
					out.write(bs,0,i);
				}
				in.close();
				out.close();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs, ps, conn);
		}
	}
	@Test
	public void addBlob(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement("insert into blobdemo values (null,?,?)");
			ps.setString(1, "牛逼.mp3");
            URL url = this.getClass().getResource("tt.mp3");

            File file = new File(url.toURI());
			ps.setBinaryStream(2, new FileInputStream(file),(int)file.length());
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs, ps, conn);
		}
	}
}
