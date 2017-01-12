package jt.servlet;

import jt.Bean.UserBean;
import jt.dao.RegistDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 彦喆 on 2016/8/22.
 */

public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        String username=request.getParameter("username");
        String userpw=request.getParameter("userpw");
        String email=request.getParameter("email");
        UserBean user=new UserBean(username,userpw,email);
        System.out.println(user+"aaaaaaaaaa");
        RegistDao registDao=new RegistDao();
        if (username!=null&&!username.isEmpty()){
            if (registDao.userIsExist(username)){
                registDao.regist(user);
                out.print("<script language='JavaScript'>alert('注册成功!');location.href='login.html';</script>");
            }else {
                out.print("<script language='JavaScript'>alert('用户名已存在!');location.href='login.html';</script>");
            }
        }
//        registDao.regist(user);
//        out.print("<script language='JavaScript'>alert('注册成功!');location.href='login.html';</script>");

    }
}
