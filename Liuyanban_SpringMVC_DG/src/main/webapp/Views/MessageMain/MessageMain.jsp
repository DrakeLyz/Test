<%@ page import="liuyanban.entity.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Message</title>
    <script src="<%=basePath%>scripts/jquery-1.8.2.min.js"></script>
    <script src="<%=basePath%>scripts/pin.js"></script>
    <script type="text/javascript" src="<%=basePath%>scripts/MessageMain/MessageMain.js"></script>
    <link href="<%=basePath%>styles/MessageMain/MessageMain.css" rel="stylesheet" type="text/css"/>
    <link href="<%=basePath%>styles/MessageMain/DivOpacity.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<%
    User user = (User) session.getAttribute("User");
%>
<div class="d_head">
    <div class="d_Welcome">
        <span class="sp_welcome">你好，</span><a id="a_MyUser" class="a_user" href="<%=user != null ? "javascript:location.reload();":"/Views/User/Login.jsp"%>" title="<%=user != null ? user.getUserId() : "请登录！"%>"><%=user != null ? user.getName(): "请登录！"%></a><a
            id="a_userExit" href="/User/LogOut">[退出]</a><a id="a_userChange" href="/Views/User/Login.jsp">[切换用户]</a>
    </div>
</div>
<div class="d_top"></div>
<div class="d_main">
    <div class="d_mian_left">
        <div class="d_left_my">
            <div class="d_left_userInfo">
                <span id="sp_userInfo">我</span><span> ~ 的留言墙</span>
            </div>
            <img id="img_userImage" class="img_my" src="<%=user!=null?user.getImage():"/"%>"/>
            <ul>
                <li><span>账号：</span><span id="sp_userId"><%=user!=null?user.getUserId():"--"%></span></li>
                <li><span>昵称：</span><span id="sp_userName"><%=user!=null?user.getName():"--"%></span></li>
            </ul>
            <ul class="ul_manage">
                <li><a href="javascript:<%=user!=null?"getUserInfoByFrienduserId("+user.getUserId()+");":"--"%>">个人主页</a></li>
                <li><a href="javascript:void(0);">与我相关</a></li>
                <li><a href="javascript:void(0);">--</a></li>
                <li><a href="javascript:void(0);">--</a></li>
            </ul>
        </div>
        <div class="d_left_user">
            <div class="d_left_userList">
                <span>好友列表</span>
            </div>
            <ul id="u_userList">
                <li><a href="javascript:void(0);">1111</a></li>
            </ul>
        </div>
    </div>
    <div class="d_main_right">
        <div class="msg_Board">
            <span class="sp_publishMsg">发表您的留言(500字以内)：</span><br/>
            <textarea id="ta_publishMsg"></textarea>
            <br/>
            <div class="msg_publish" id="bt_addPublishMsg">
                <span>发表</span>
            </div>
            <br/>
        </div>
        <span class="sp_msg_count">留言(0)</span>
        <div id="d_messageBoxs">
            <div class='messageBox' >
                <hr/>
                <div class='d_messageBoxLeft'>
                    <img src='#'>
                </div>
                <div class='d_messageBoxRight'>
                <p class='p_msg_user'>
                    <a href='javascript:void(0);'>用户名</a>
                </p>
                <p class='p_msg_content'>content</p>
                <p class='p_msg_time'>
                    <span>2016-01-01 12:21:00</span><a href='javascript:void(0);'>回复</a><a href='javascript:void(0);'>删除</a>
                </p>
                <hr>
                <div class='d_d_msgBoxRight_HF'>
                    <div class='d_hfLeft'>
                        <img src='#'>
                    </div>
                    <div class='d_hfRight'>
                        <p class='p_hf_content'><a href='javascript:void(0);'>用户名</a>&nbsp;这里是回复的信息...</p>
                        <p class='p_hf_time'>
                            <span>2016-01-01 12:21:00</span><a href='javascript:void(0);'>删除</a>
                        </p>
                    </div>
                    <br style='clear:both;'>
                </div>
                <textarea class='msg_answer' onfocus='javascript:textareaFocus(this);' onblur='javascript:textareaBlur(this);'>我也说一句...</textarea>
                <br/>
                <div class='d_msg_answer'>
                    <span>确定</span>
                </div>
                <a class='a_answer_cancel' href='javascript:void(0);'>取消</a>
                <br/>&nbsp;
                </div>
                <br/>
            </div>
        </div>
        <div class="d_paging">
            <div class="d_pagingChild">
                <select id="sel_pageSize">
                    <option value="5">5条/页</option>
                    <option value="10" selected="selected">10条/页</option>
                    <option value="20">20条/页</option>
                </select>
                第 <span class="sp_paging" id="sp_paging_1">1</span> 页 共 <span class="sp_paging" id="sp_paging_2">--</span> 页
                <a class="a_paging" id="a_paging_1" href="javascript:void(0)">首页</a>
                <a class="a_paging" id="a_paging_2" href="javascript:void(0)">上一页</a>
                <a class="a_paging" id="a_paging_3" href="javascript:void(0)">下一页</a>
                <a class="a_paging" id="a_paging_4" href="javascript:void(0)">尾页</a>
            </div>
        </div>
        <br />
    </div>
    <br style='clear:both;'/>
</div>


<div class="TBox_white_big"></div>
<div class="TBox_white_small">
    <div class="TBox_content">
        <img src="<%=basePath%>images/MessageMain/MessageMain/DataWait.gif" />
        <span id="TBox_msg"></span>
    </div>
</div>
<!--返回顶部的div-->
<div class="back-to-top" title="To Top ！"></div>
</body>
</html>
