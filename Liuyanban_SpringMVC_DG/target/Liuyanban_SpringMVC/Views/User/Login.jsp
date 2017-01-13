<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Index</title>
    <style type="text/css">
    </style>
    <script src="<%=basePath%>scripts/jquery-1.8.2.min.js"></script>
    <link href="<%=basePath%>styles/User/loginStyle.css" rel="stylesheet" type="text/css"/>
    <link href="<%=basePath%>styles/MessageMain/DivOpacity.css" rel="stylesheet" type="text/css"/>
    <link href="<%=basePath%>styles/User/DragValidationCodeCss.css" rel="stylesheet" type="text/css"/>
    <script src="<%=basePath%>scripts/User/DrogValidationCode.js" charset="UTF-8"></script>
    <script>
        jQuery(function ($) {
            $(document).ready(function () {
                $("#bt_formSub").click(function () {
                    if (IsValidSuccess) {
                        $.ajax({
                            type: 'post',
                            url: '/User/Login',
                            async: true,//异步
                            data: {'loginId': $("#loginId").val(), "loginPwd": $("#loginPwd").val()},
                            dataType: 'json',
                            beforeSend: function () {
                                //发送前事件
                            },
                            success: function (data) {
                                //请求成功部分代码
                                if (data.TFMark) {
                                    TBox_show(1, data.Msg);
                                    setTimeout(function () {
                                        TBox_show(0, null);//关闭提示窗
                                        window.location = "/Views/MessageMain/MessageMain.jsp";
                                    }, 1000);//过一秒关闭

                                }
                                else if (!data.TFMark) {
                                    alert(data.Msg);
                                }
                            },
                            error: function (data) {
                                //请求失败部分代码
                                alert("与服务器的链接断开，请重试...");
                            }
                        });
                    }else
                    {alert("请通过验证码验证！");}
                });

            });
        });

        //是否显示TBox 0= hidden 1=visible 直接调用即可 msg 弹窗的内容
        function TBox_show(isShow, msg) {
            $("#TBox_msg").html(msg);//设置弹窗内容
            if (isShow == 0) {
                $(".TBox_white_big").css("visibility", "hidden");
                $(".TBox_white_small").css("visibility", "hidden");
            }
            else if (isShow == 1) {
                $(".TBox_white_big").css("visibility", "visible");
                $(".TBox_white_small").css("visibility", "visible");
            }
        }
    </script>
</head>
<body>
<form id="form1" action="/" method="post">
    <div>
        <div id="login">
            <div id="maintop">
                <div id="top"></div>
                <div id="input">
                    <br/> 用户名： <input id="loginId" type="text" name="loginId"
                                      class="input" placeholder="please input loginId"/><br/> <br/> 密码：&nbsp; <input
                        id="loginPwd"
                        type="password" name="loginPwd" value="" class="input"
                        placeholder="please input password"/><br/>
                    <br/>
                </div>
            </div>
            <div class="d_DragValidAssistant">
                <div class="d_BackImageBox">
                    <div class="d_BackImage">
                        <div class="d_back"></div>
                        <div class="d_move"></div>
                    </div>
                    <div class="d_Operation">
                        <div class="d_reset"></div>
                        <span class="sp_Time"></span>
                    </div>
                </div>
            </div>
            <div class="d_DragValidMain">
                <div class="d_Slider"></div>
            </div>
            <div id="bottom">
                <br/> <br/> <br/> &nbsp;&nbsp;&nbsp; <input id="Checkbox1"
                                                            type="checkbox" name="RecordMe" checked="checked"/>记住密码&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="#">忘记密码？</a><br/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <div id="btn">
                    <input id="bt_formSub" class="button" type="button" value="登录"/> <input
                        id="Button2" type="button" class="button" value="注册"
                        onclick="javascript: window.location = '/Views/User/Register.jsp'"/>&nbsp; <br/>
                    <br/> <a href="/index.jsp">--> 返回主页</a>
                </div>
            </div>
        </div>
    </div>
</form>
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