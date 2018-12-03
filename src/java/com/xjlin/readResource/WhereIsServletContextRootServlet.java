package com.xjlin.readResource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * Created by xjlin on 2018/11/1.
 *
 * 寻找this.getServletContext().getRealPath("/")的根目录在哪里？
 *
 * 答案： D:\project_study\webStudyDay04_maven\target\webStudyDay04_maven\
 * 其实最后部署的文件夹，WEB-INF就在这个文件夹底下
 */
@WebServlet("/servlet/WhereIsServletContextRootServlet")

public class WhereIsServletContextRootServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        /**
         * 下面语句返回：
         * D:\project_study\webStudyDay04_maven\target\webStudyDay04_maven\
         */
        System.out.println(this.getServletContext().getRealPath("/"));

        /**
         * 而下面语句返回：
         * file:/D:/project_study/webStudyDay04_maven/target/webStudyDay04_maven/
         */
        System.out.println(this.getServletContext().getResource("/"));

        /**
         * 返回inputStream直接读
         * 根目录也是web工程部署的根目录
         */
        Properties prop = new Properties();

        InputStream propStream = this.getServletContext().getResourceAsStream("/WEB-INF/abc.properties");
        prop.load(propStream);

        System.out.println(prop.getProperty("username"));
        System.out.println(prop.getProperty("password"));


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
