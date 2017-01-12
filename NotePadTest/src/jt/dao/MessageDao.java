package jt.dao;

import jt.Bean.MessageBean;
import jt.Bean.ReMessageBean;
import jt.util.DBconn;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

/**
 * Created by 彦喆 on 2016/8/22.
 */
public class MessageDao {
    private Connection ct;
    private Statement sm;
    private ResultSet rs;
    private PreparedStatement ps;
    private ArrayList al=null;
    private int pagesize=5;
    private int rowCount=0;
    private int pageCount=0;
    //分页
    public int getPageCount(){
        ct=new DBconn().getconn();
        String sql="select count(*) from notepad";
        try {
            sm=ct.createStatement();
            rs=sm.executeQuery(sql);
            if (rs.next()){
                rowCount=rs.getInt(1);
                if(rowCount%pagesize==0){
                    pageCount=rowCount/pagesize;
                }else{
                    pageCount=rowCount/pagesize+1;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                ct.close();
                sm.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return pageCount;
    }
    //显示留言
    public ArrayList showMessage(int pageNow){
        al=new ArrayList();
        ct=new DBconn().getconn();
        String sql="select * from notepad where id limit " + (pageNow - 1)* pagesize + "," + pagesize;
        try {
            sm=ct.createStatement();
            rs=sm.executeQuery(sql);
            while (rs.next()){
                MessageBean messageBean=new MessageBean();
                messageBean.setId(rs.getInt(1));
                messageBean.setUserName(rs.getString(2));
                messageBean.setDate(rs.getString(3));
                messageBean.setContent(rs.getString(4));
                al.add(messageBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                ct.close();
                sm.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return al;
    }
    //留言
    public void writeMessage(MessageBean messageBean){
        ct=new DBconn().getconn();
        String sql="insert into notepad values(?,?,?,?)";
        try {
            ps=ct.prepareStatement(sql);
            ps.setString(1,null);
            ps.setString(2,messageBean.getUserName());
            ps.setString(3, String.valueOf(messageBean.getDate()));
            ps.setString(4,messageBean.getContent());
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
    //留言回复
    public void replyMessage(ReMessageBean messageBean){
        ct=new DBconn().getconn();
        String sql="insert into reply values(?,?,?,?)";
        try {
            ps=ct.prepareStatement(sql);
            ps.setString(1, String.valueOf(messageBean.getId()));
            ps.setString(2,messageBean.getName());
            ps.setString(3,messageBean.getContent());
            ps.setString(4,String.valueOf(messageBean.getDate()));
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
    //回复显示
    public ArrayList replyshow(int id){
        al=new ArrayList();
        ct=new DBconn().getconn();
        try {
            sm=ct.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            rs=sm.executeQuery("select * from reply where id="+id);
            while (rs.next()) {
                ReMessageBean messageBean=new ReMessageBean();
                messageBean.setId(rs.getInt(1));
                messageBean.setName(rs.getString(2));
                messageBean.setContent(rs.getString(3));
                messageBean.setDate(rs.getString(4));
                al.add(messageBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                ct.close();
                rs.close();
                sm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return al;
    }
    //删除留言
    public boolean deleteuser(int id){
        boolean b=false;
        ct = new DBconn().getconn();
        try {
            sm=ct.createStatement();
            int a=sm.executeUpdate("delete from notepad where id='"+id+"'");
            if(a==1){
                b=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return b;
    }
    //日期处理
    public String getDate(){
        Date date=new Date();
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
        String newdate = sim.format(date);
        return newdate;
    }
}
