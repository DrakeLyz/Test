package jt.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by 彦喆 on 2016/8/21.
 */
public class DBconn {
    private Connection ct=null;
    String url="jdbc:mysql://localhost:3306/notepad";
    String root="root";
    String pw="1234";
    public  Connection getconn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                ct= DriverManager.getConnection(url,root,pw);
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("数据库连接失败!");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("驱动加载失败!");
        }
        return ct;
    }
}
