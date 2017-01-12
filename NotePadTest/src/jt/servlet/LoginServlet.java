package jt.servlet;

import jt.dao.LoginDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 彦喆 on 2016/8/21.
 */

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        String u=request.getParameter("Username");
        String p=request.getParameter("Password");
        HttpSession session=request.getSession();
        LoginDao loginDao=new LoginDao();
        PrintWriter out=response.getWriter();
        if (loginDao.usercheck(u,p)){
            System.out.println("登陆成功!");
            session.setAttribute("name",u);
            request.getRequestDispatcher("ShowServlet").forward(request,response);
        }else {
            System.out.println("登录失败!");
            //out.print("<script>alert('账号或密码错误,请重新登陆!')</script>");
            //request.getRequestDispatcher("login.html").forward(request,response);
            out.print("<script language='JavaScript'>alert('账号或密码错误,请重新登陆!');location.href='login.html';</script>");
        }
    }
}
