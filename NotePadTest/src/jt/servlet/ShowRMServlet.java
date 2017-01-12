package jt.servlet;

import jt.dao.MessageDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by 彦喆 on 2016/8/22.
 */
@WebServlet(name = "ShowRMServlet")
public class ShowRMServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session=request.getSession();
        int id= Integer.parseInt(request.getParameter("id"));
        MessageDao dao=new MessageDao();
        ArrayList ral=dao.replyshow(id);
        System.out.println(ral);
        session.setAttribute("ral",ral);
        request.getRequestDispatcher("showSecondServlet").forward(request,response);
    }
}
