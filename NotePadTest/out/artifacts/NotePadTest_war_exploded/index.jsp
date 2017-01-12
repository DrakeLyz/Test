<%--
  Created by IntelliJ IDEA.
  User: 彦喆
  Date: 2016/8/21
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@page import="jt.Bean.MessageBean"%>
<%@page import="jt.Bean.ReMessageBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head lang="en">
  <meta http-equiv="Content-Type"content="text/html;charset=utf-8">
  <title></title>
  <link rel="stylesheet" href="css/bootstrap.css" type="text/css">
  <link rel="stylesheet" href="css/index.css" type="text/css">
  <script src="js/jquery-3.0.0.min.js" type="text/javascript"></script>
  <script src="js/bootstrap.min.js" type="text/javascript"></script>
  <script src="js/index.js" type="text/javascript"></script>
</head>
<body>
<%
  String name=request.getParameter("name");
%>
<div class=" container-fluid message-nav">
  <div class="navbar navbar-default navbar-fixed-top">
    <div class="navbar-brand title">留言板</div>
    <div class="reply-btn">
      <button type="button" class="btn btn-primary" id="myreply-btn"><span class="glyphicon glyphicon-pencil"></span>留言</button>
    </div>

  </div>

  <div class="modal fade" id="my-reply">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="close">&times;</button>
          <h2 class="modal-title">发表留言</h2>
        </div>
        <div class="modal-body">
          <form class="form-horizontal" action="WriteServlet" method="get">
            <div class="form-group reply-input">
              <!--<label ><h3>发表回复</h3></label>-->
              <textarea class="form-control" rows="8" name="content"></textarea>
              <button class="btn btn-info reply-show">发表</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>


<div class="wrapper">
  <div class="container">
    <div class="personal">
      <div class="personal-info">
        <div class="info">
          <ul >
            <li>
              <div class="person-pic">
                <img src="image/image 001.jpg"width="50%" height="50%">
              </div>
            </li>
            <li >
              <a href="">刘彦喆</a>
            </li>
          </ul>
        </div>
      </div>
      <div class="my-message">
        <div class="mymessage-wrapper">
          <div class="mymessage-header"><h2>主人寄语：</h2></div>
          &nbsp;&nbsp;&nbsp;&nbsp;<h2>留言板测试</h2>
          <div class="mymessage-editor">
          </div>
          <div class="modal fade" id="my-message">
            <div class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-label="close">&times;</button>
                  <h2 class="modal-title">说点什么</h2>
                </div>
                <div class="modal-body">
                  <form class="form-horizontal">
                    <div class="form-group reply-input">
                      <!--<label ><h3>发表回复</h3></label>-->
                      <textarea class="form-control" rows="8"></textarea>
                      <button class="btn btn-info reply-show">发表</button>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <%
      int pageNow = Integer.parseInt((String) request
              .getAttribute("pageNow"));
      int pageCount = Integer.parseInt((String) request
              .getAttribute("pageCount"));
      ArrayList al=(ArrayList)request.getAttribute("al");
    %>
    <%
      for (int i = 0; i < al.size(); i++) {
        MessageBean messageBean= (MessageBean) al.get(i);
    %>
    <div class="message">
      <div class="message-content">
        <div class="other-info">
          <div class="info">
            <ul>
              <li>
                <div class="person-pic">
                  <img src="image/image 001.jpg"width="50%" height="50%">
                </div>
              </li>
              <li>
                <a href=""><%=messageBean.getUserName()%></a>
              </li>
            </ul>
          </div>
        </div>
        <div class="message-right">
            <div id="hidden" style="visibility: hidden "><input type="text" id="hiddenid" value="<%=messageBean.getId()%>"><%=messageBean.getId()%></div>
          <div class="message-text">
            <%=messageBean.getContent()%>
          </div>
          <div class="delete-btn"><a href="delete?id=<%=messageBean.getId() %>"><span class="glyphicon glyphicon-remove"></span>删除</a></div>
          <div class="message-part">
            <span><%=messageBean.getDate()%></span>
            <button type="button" class="btn btn-default message-btn" id="message-btn" onclick="message_btn_Click()">查看评论</button>
            <button type="button" class="btn btn-default reply-btn" id="reply-btn" onclick="reply_btn_Click()">回复</button>
          </div>

          <div class="modal fade" id="reply">
            <div class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-label="close">&times;</button>
                  <h2 class="modal-title">发表回复</h2>
                </div>
                <div class="modal-body">
                  <form class="form-horizontal" action="ReplyServlet?rid=<%=messageBean.getId()%>" method="post">
                    <div class="form-group reply-input">
                      <!--<label ><h3>发表回复</h3></label>-->
                      <textarea class="form-control" rows="8" name="rcontent"></textarea>
                      <button class="btn btn-info reply-show" >发表</button>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>

          <div class="modal fade" id="message" style="visibility: hidden">
            <div class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-label="close">&times;</button>
                  <h2 class="modal-title">回复评论</h2>
                </div>
                <div class="modal-body">
                  <form class="form-horizontal" target="submitFrame" action="" method="post">
                      <iframe src="" name="submitFrame" width="0" height="0"></iframe>
                    <div class="form-group reply-input">
                      <!--<label ><h3>发表回复</h3></label>-->

                      <table width="100%" border="0" >
                        <c:forEach items="${ral}" var="a" >
                        <tr>
                          <td width="17%">:${a.name}</td>
                          <td width="69%">${a.content}</td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                          <td width="14%">${a.date}</td>
                        </tr>
                        </c:forEach>
                            </table>
                      <%--<button class="btn btn-info reply-show" >发表</button>--%>
                    </div>
                  </form>
                </div>
              </div>
            </div>
        </div>
      </div>
      <%
        }
      %>
      <%
        for(int i=1;i<=pageCount;i++){
        out.print("<a href=showSecondServlet?pageNow="+i+">["+i+"]</a>");
        }
      %>

      <div class="reply">
      <div class="reply-board reply-text">
        <form role="form" action="WriteServlet" method="get">
          <div class="form-group">
            <label class="reply-title" >发表留言<img src="image/image7.png"></label>
            <textarea class="form-control" rows="8" name="content"></textarea>
            <button class="btn btn-info reply-show">发表</button>
          </div>
        </form>
      </div>
      </div>
    </div>
  </div>
</div>
</div>
</body>
</html>
