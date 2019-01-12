package com.xjlin.test;

import com.xjlin.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;

/**
 * Created by xjlin on 2018/11/16.
 */
public class TestInsert{
    public static void main(String[] args){
        addUser();
    }

    public static void addUser() {
        String sql = "insert into t_demo values (null,?,?,?,?,default,?,default )";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = JDBCUtils.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "xjlin");
            ps.setInt(2,1);
//            ps.setNull(2, Types.TINYINT);
            ps.setNull(3, Types.BLOB);
            ps.setNull(4, Types.INTEGER);
//            ps.setNull(5, Types.DATE);
            ps.setNull(5, Types.INTEGER);
            ps.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            JDBCUtils.close(rs, ps, conn);
        }
    }
}
