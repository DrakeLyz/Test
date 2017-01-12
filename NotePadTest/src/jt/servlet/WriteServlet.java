package jt.servlet;

import jt.Bean.MessageBean;
import jt.dao.MessageDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by 彦喆 on 2016/8/22.
 */

public class WriteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        //request.setCharacterEncoding("utf-8");
        HttpSession hs=request.getSession();
        String name=(String)hs.getAttribute("name");
        String content=request.getParameter("content");
        content = new String(content.getBytes("iso-8859-1"),"utf-8");
        MessageDao messageDao=new MessageDao();
        String date=messageDao.getDate();
        MessageBean messageBean=new MessageBean(name,date,content);
        messageDao.writeMessage(messageBean);
        request.getRequestDispatcher("showSecondServlet?pageNow=1").forward(request, response);
    }
}
