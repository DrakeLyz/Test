<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>Document</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>styles/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>styles/MessageMain/DivOpacity.css">
    <script type="text/javascript" src="<%=basePath%>scripts/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>scripts/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>scripts/jquery.FormValidate_DG.js"></script>
    <script type="text/javascript" src="<%=basePath%>scripts/User/Register.js"></script>
    <style type="text/css">
        .form-ground {
            padding: 5px;
        }
    </style>
</head>
<body style="padding:50px;">
<input type="hidden" id="ipt_V_mark_DG" value="0"/>
<div class="container" style="text-align:center;"><span
        style="text-decoration:underline;font-size:24px;font-weight:bolder;">欢迎注册</span></div>
<div class="container" style="border:1px solid black;padding:50px;">
    <form class="form-horizontal">
        <!-- 用户名 -->
        <div class="form-ground row">
            <label for="loginId" class="col-md-2 control-label">用户名*</label>
            <div class="col-md-7">
                <input type="text" id="loginId" placeholder="请输入用户名"
                       class="form-control ipt_V_DG ipt_V_null_DG ipt_V_user_DG" maxlength="11">
                <span class="sp_V_msg_DG col-md-7" id="sp_V_msg_DG_userExist"></span>
            </div>

        </div>
        <!-- 昵称-->
        <div class="form-ground row">
            <label for="userName" class="col-md-2 control-label">昵称*</label>
            <div class="col-md-7">
                <input type="text" id="userName" placeholder="请输入昵称"
                       class="form-control ipt_V_DG ipt_V_null_DG" maxlength="11">
                <span class="sp_V_msg_DG col-md-7"></span>
            </div>

        </div>
        <!-- 密码 -->
        <div class="form-ground row">
            <label for="password" class="col-md-2 control-label">密码*</label>
            <div class="col-md-7">
                <input type="password" id="password" placeholder="请输入密码"
                       class="form-control ipt_V_DG ipt_V_null_DG ipt_V_pwd1_DG">
                <span class="sp_V_msg_DG col-md-7"></span>
            </div>
        </div>
        <div class="form-ground row">
            <label for="passwordagain" class="col-md-2 control-label">再次密码*</label>
            <div class="col-md-7">
                <input type="password" id="passwordagain" placeholder="请再次输入密码"
                       class="form-control ipt_V_DG ipt_V_null_DG ipt_V_pwd2_DG">
                <span class="sp_V_msg_DG col-md-7"></span>
            </div>
        </div>
        <!-- 性别 -->
        <div class="form-ground row">
            <label class="col-md-2 control-label">性别*</label>
            <div class="radio col-md-3">
                <label class="radio-inline"><input type="radio" name="radio" value="">女</label>
                <label class="radio-inline"><input type="radio" name="radio" value="">男</label>
            </div>
        </div>
        <!-- 出生日期 -->
        <div class="form-ground row">
            <label class="col-md-2 control-label">出生日期</label>
            <div class="radio col-md-2">
                <select class="form-control">
                    <option>年</option>
                    <option>1994</option>
                    <option>1996</option>
                    <option>1997</option>
                    <option>1998</option>
                    <option>2000</option>
                </select>
            </div>
            <div class="radio col-md-2">
                <select class="form-control">
                    <option>月</option>
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                </select>
            </div>
            <div class="radio col-md-2">
                <select class="form-control">
                    <option>日</option>
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                </select>
            </div>
        </div>

        <!-- 选择头像 -->
        <div class="form-ground row">
            <label class="col-md-2 control-label">选择头像</label>
            <img class="col-mod-2 img_choose" style="cursor:pointer;width:40px;height:40px;"
                 src="/images/User/UserImage/1.gif">
            <img class="col-mod-2 img_choose" style="cursor:pointer;width:40px;height:40px;"
                 src="/images/User/UserImage/2.gif">
            <img class="col-mod-2 img_choose" style="cursor:pointer;width:40px;height:40px;"
                 src="/images/User/UserImage/3.gif">
            <img class="col-mod-2 img_choose" style="cursor:pointer;width:40px;height:40px;"
                 src="/images/User/UserImage/4.gif">
            <img class="col-mod-2 img_choose" style="cursor:pointer;width:40px;height:40px;"
                 src="/images/User/UserImage/5.gif">
            <img class="col-mod-2 img_choose" style="cursor:pointer;width:40px;height:40px;"
                 src="/images/User/UserImage/6.gif">
            <img class="col-mod-2 img_choose" style="cursor:pointer;width:40px;height:40px;"
                 src="/images/User/UserImage/7.gif">
            <img class="col-mod-2 img_choose" style="cursor:pointer;width:40px;height:40px;"
                 src="/images/User/UserImage/8.gif">
            <img class="col-mod-2 img_choose" style="cursor:pointer;width:40px;height:40px;"
                 src="/images/User/UserImage/9.gif">
            <img class="col-mod-2 img_choose" style="cursor:pointer;width:40px;height:40px;"
                 src="/images/User/UserImage/10.gif">
        </div>
        <div class="form-ground row">
            <label class="col-md-2 control-label">您选择的头像为：</label>
            <img class="col-mod-2 img_choose" id="img_choosed" style="cursor:pointer;width:40px;height:40px;"
                 src="/images/User/UserImage/.gif">
        </div>

        <!-- 个人简介 -->
        <div class="form-ground row">
            <label class="control-label col-md-2">个人简介</label>
            <div class="checkbox col-md-7">
                <textarea rows="3" class="form-control" placeholder="请输入你的个人介绍"></textarea>
            </div>
        </div>
        <div class="form-ground col-md-10 col-md-offset-2">
            <input type="button" name="" class="btn btn-danger" id="form_sub" value="注册">
        </div>
    </form>
</div>
<div class="TBox_white_big"></div>
<div class="TBox_white_small">
    <div class="TBox_content">
        <img src="<%=basePath%>images/MessageMain/MessageMain/DataWait.gif" />
        <span id="TBox_msg"></span>
    </div>
</div>
</body>
</html>