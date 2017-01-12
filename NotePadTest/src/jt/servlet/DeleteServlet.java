package jt.servlet;

import jt.dao.MessageDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 彦喆 on 2016/8/22.
 */

public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        int id= Integer.parseInt(request.getParameter("id"));
        MessageDao messageDao=new MessageDao();
        messageDao.deleteuser(id);
        request.getRequestDispatcher("ShowServlet").forward(request,response);
    }
}
