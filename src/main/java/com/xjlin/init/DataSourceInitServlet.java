package com.xjlin.init;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by xjlin on 2018/11/27.
 */
public class DataSourceInitServlet extends HttpServlet{
    private static DataSource dataSource = null;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        doGet(request, response);
    }

    @Override
    public void init() throws ServletException{
        try{
            Context initCtx = new InitialContext();
            Context jndi = (Context) initCtx.lookup("java:comp/env");
            DataSource source = (DataSource) jndi.lookup("mySource");
            if(source != null){
                setDataSource(source);
                this.getServletContext().setAttribute("DataSource", source);
            }

            /**
             * 以下是测试
             */
//            Connection conn = source.getConnection();
//            PreparedStatement ps = conn.prepareStatement("select * from account");
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//                String name = rs.getString("name");
//                System.out.println(name);
//            }
//            rs.close();
//            ps.close();
//            conn.close();

        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static DataSource getDataSource(){
        return dataSource;
    }

    public static void setDataSource(DataSource dataSource){
        DataSourceInitServlet.dataSource = dataSource;
    }
//
//    @Override
//    public void destroy(){
//        super.destroy();
//        System.out.println("DataSourceInitServlet 销毁了");
//        try {
//            DriverManager.deregisterDriver(DriverManager.getDrivers().nextElement());
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }

}
