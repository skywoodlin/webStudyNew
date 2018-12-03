package com.xjlin.listener;

import com.xjlin.init.DataSourceInitServlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

/**
 * 监听ServletContext对象创建和销毁的监听器
 *
 * @author park
 */
public class MySCListener implements ServletContextListener{

    public void contextDestroyed(ServletContextEvent sce){
        System.out.println("ServletContext对象被销毁了...." + sce.getServletContext());
        // ... First close any background tasks which may be using the DB ...
        // ... Then close any DB connection pools ...

        // Now deregister JDBC drivers in this context's ClassLoader:
        // Get the webapp's ClassLoader
/*        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        // Loop through all drivers
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            if (driver.getClass().getClassLoader() == cl) {
                // This driver was registered by the webapp's ClassLoader, so deregister it:
                try {
                    System.out.println("Deregistering JDBC driver: " + driver);

                    DriverManager.deregisterDriver(driver);
                } catch (SQLException ex) {
                    System.out.println("Error Deregistering JDBC driver: " + driver + ex.getMessage());
                }
            } else {
                // driver was not registered by the webapp's ClassLoader and may be in use elsewhere
                System.out.println("Not deregistering JDBC driver {} as it does not belong to this webapp's ClassLoader: " +
                driver);
            }
        }*/
    }

    public void contextInitialized(ServletContextEvent sce){
        System.out.println("ServletContext对象被创建出来了...." + sce.getServletContext());
    }
}
