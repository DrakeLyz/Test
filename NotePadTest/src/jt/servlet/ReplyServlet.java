package jt.servlet;

import jt.Bean.ReMessageBean;
import jt.dao.MessageDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 彦喆 on 2016/8/22.
 */

public class ReplyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        HttpSession session=request.getSession();
        int id= Integer.parseInt(request.getParameter("rid"));
        String name= (String) session.getAttribute("name");
        String content=request.getParameter("rcontent");
        MessageDao dao=new MessageDao();
        String date=dao.getDate();
        ReMessageBean reMessageBean=new ReMessageBean(id,name,content,date);
        dao.replyMessage(reMessageBean);
        out.print("<script language='JavaScript'>alert('回复成功!');location.href='showSecondServlet?pageNow=1';</script>");
    }
}
