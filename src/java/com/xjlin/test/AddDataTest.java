package com.xjlin.test;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.xjlin.util.DaoUtils;

public class AddDataTest {
	@Test
	public void add() throws SQLException{
		String sql = "insert into customer values (null,?,?,?,?,?,?,?,?)";
		QueryRunner runner = new QueryRunner(DaoUtils.getSource());
		for(int i=1;i<=100;i++)
			runner.update(sql,"name"+i,"男","1999-09-09","10000","aaa@qq.com","篮球,玻璃球","黑铁客户","desc"+i);
		
	}
}
