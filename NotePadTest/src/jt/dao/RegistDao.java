package jt.dao;

import jt.Bean.UserBean;
import jt.util.DBconn;

import java.sql.*;

/**
 * Created by 彦喆 on 2016/8/22.
 */
public class RegistDao {
    private Connection ct;
    private PreparedStatement ps;
    private  ResultSet rs;
    public void regist(UserBean user){

        ct=new DBconn().getconn();
        String sql="insert into users values(?,?,?,?)";
        try {
            ps=ct.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,null);
            ps.setString(3,user.getUserpw());
            ps.setString(4,user.getEmail());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                ct.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    public boolean userIsExist(String name){
        ct=new DBconn().getconn();
        String sql="select * from users where userName= ?";
        try {
            ps=ct.prepareStatement(sql);
            ps.setString(1,name);
            rs=ps.executeQuery();
            if (!rs.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                ct.close();
                rs.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
