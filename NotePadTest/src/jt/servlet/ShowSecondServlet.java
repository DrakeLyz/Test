package jt.servlet;

import jt.dao.MessageDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by 彦喆 on 2016/8/22.
 */

public class ShowSecondServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        int pageNow=Integer.parseInt((String)request.getParameter("pageNow"));
        MessageDao messageDao=new MessageDao();
        ArrayList al=messageDao.showMessage(pageNow);
        int pageCount=messageDao.getPageCount();
        request.setAttribute("al", al);
        request.setAttribute("pageNow",pageNow+"");
        request.setAttribute("pageCount", pageCount+"");
        request.getRequestDispatcher("index.jsp").forward(request, response);
}
}
