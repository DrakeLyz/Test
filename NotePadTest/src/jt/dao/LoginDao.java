package jt.dao;

import jt.util.DBconn;

import java.sql.*;

/**
 * Created by 彦喆 on 2016/8/21.
 */
public class LoginDao {
    private Connection ct;
    private Statement sm;
    private ResultSet rs;
    private PreparedStatement ps;
    public void close() {
        try {
            if (!ct.isClosed()) {
                ct.close();
            }
            if (!sm.isClosed()) {
                sm.close();
            }
            if (!rs.isClosed()) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean usercheck(String uname,String pw){
        boolean b=false;
        ct= new DBconn().getconn();
        try {
            String sql="select userPassword from users where userName='"+uname+"'";
            sm=ct.createStatement();
            rs=sm.executeQuery(sql);
            if (rs.next()){
                if (rs.getString(1).equals(pw)){
                    b=true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return b;
    }
}
