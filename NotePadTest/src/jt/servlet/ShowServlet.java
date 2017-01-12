package jt.servlet;

import jt.dao.MessageDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by 彦喆 on 2016/8/22.
 */

public class ShowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession hs=request.getSession();
        //拿到3要素 pageNow array信息 pageCount
        MessageDao messageDao=new MessageDao();
        int pageCount =messageDao.getPageCount();
        ArrayList al=messageDao.showMessage(1);
        hs.setAttribute("list", al);
        request.setAttribute("pageNow", 1+"");
        request.setAttribute("al", al);
        request.setAttribute("pageCount", pageCount+"");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
