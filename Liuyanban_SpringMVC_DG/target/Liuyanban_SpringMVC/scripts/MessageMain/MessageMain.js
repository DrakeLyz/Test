/**
 * Created by Administrator on 2016/8/23.
 */
//全局参数写在这里
//分页的变量写在这里-------------
var pageCount = 1;//总页码数
var pageIndex = 1;//当前页
var pageSize = 10;//页大小
jQuery(function ($) {
    $(document).ready(function () {
        getUserList();//加载用户列表数据
        getMessageByUserRootIdPaging(pageIndex);//加载消息列表

        //添加留言
        $("#bt_addPublishMsg").click(function () {
            if ($("#ta_publishMsg").val().trim() != "" && $("#ta_publishMsg").val().trim() != null) {
                addMessage($("#ta_publishMsg").val(), $("#a_MyUser").attr("title"), 0, $.trim($("#sp_userId").html()));//添加一条信息
                $("#ta_publishMsg").val("");
            }
            else {
                TBox_show(1, "提交信息不能为空！");
                setTimeout(function () {
                    TBox_show(0, null);//关闭提示窗
                }, 1500);//过一秒关闭
            }
        });


        $(".d_head").pin();
        // 滚动窗口来判断按钮显示或隐藏
        $(window).scroll(function () {
            if ($(this).scrollTop() > 150) {
                $('.back-to-top').fadeIn(300);
            }
            else {
                $('.back-to-top').fadeOut(300);
            }
        });
        // jQuery实现动画滚动

        $('.back-to-top').click(function (event) {
            event.preventDefault();
            $('html,body').animate({scrollTop: 0}, 500);
        });
        //随着浏览器的拉伸 位置移动
        window.onresize = function () {
            setbacktotop();
        }

        //设置返回顶部div的位置
        function setbacktotop() {
            var bodywidth = document.body.clientWidth;
            if (bodywidth <= 1050) {
                $(".back-to-top").css("right", "0px");
            } else {
                $(".back-to-top").css("right", ((bodywidth - 1000) / 2) - 35 + "px");
            }
        }

        //分页部分
        //获取总页码
        $.post("/Message/getMessageCountByUserRootId", {rootUserId: $.trim($("#sp_userId").html())}, function (data) {
            pageCount = Math.ceil(data.messageCount / pageSize);//为总页数赋值
            if(pageCount<=0)pageCount=1;
            if (pageIndex > pageCount) {
                pageIndex = pageCount;
                $("#sp_paging_1").html(pageIndex);
                getMessageByUserRootIdPaging(pageIndex);
            }
            $("#sp_paging_2").html(pageCount);
            isEnabled();//上下页能否点击
        });

        //修改分页部分的页大小
        $("#sel_pageSize").change(function () {
            pageSize = $("#sel_pageSize").val();
            getMessageByUserRootIdPaging(pageIndex);
        });
        //-----分页部分的点击事件
        $("#a_paging_1").click(function () {
            getMessageByUserRootIdPaging(1);//获取第一页的信息
            pageIndex = 1;
            $("#sp_paging_1").html(pageIndex);
            isEnabled();//上下页能否点击
        });
        $("#a_paging_2").click(function () {
            if (pageIndex - 1 > 0) {
                getMessageByUserRootIdPaging(pageIndex - 1);
                pageIndex--;
                $("#sp_paging_1").html(pageIndex);
                isEnabled();//上下页能否点击
            }
            else {
                //TBoxTop("已到初始页!");
            }

        });
        $("#a_paging_3").click(function () {
            if (pageIndex + 1 <= pageCount) {
                getMessageByUserRootIdPaging(pageIndex + 1);
                pageIndex++;
                $("#sp_paging_1").html(pageIndex);
                isEnabled();//上下页能否点击
            } else {
                //TBoxTop("已到最后一页！");
            }

        });
        $("#a_paging_4").click(function () {
            getMessageByUserRootIdPaging(pageCount);
            pageIndex = pageCount;
            $("#sp_paging_1").html(pageIndex);
            isEnabled();//上下页能否点击
        });

        //+++++++++++++++++++++
    });
});
//分页是否可以点击
function isEnabled() {
    //分页是否可以点击
    if (pageIndex <= 1) {
        $("#a_paging_1").css("cursor", "default");
        $("#a_paging_1").css("color", "gray");
        $("#a_paging_2").css("cursor", "default");
        $("#a_paging_2").css("color", "gray");
    } else {
        $("#a_paging_1").css("cursor", "pointer");
        $("#a_paging_1").css("color", "#266bb5");
        $("#a_paging_2").css("cursor", "pointer");
        $("#a_paging_2").css("color", "#266bb5");
    }
    if (pageIndex >= pageCount) {
        $("#a_paging_3").css("cursor", "default");
        $("#a_paging_3").css("color", "gray");
        $("#a_paging_4").css("cursor", "default");
        $("#a_paging_4").css("color", "gray");
    } else {
        $("#a_paging_3").css("cursor", "pointer");
        $("#a_paging_3").css("color", "#266bb5");
        $("#a_paging_4").css("cursor", "pointer");
        $("#a_paging_4").css("color", "#266bb5");
    }
}


//获得好友列表
function getUserList() {
    $.ajax({
        type: 'get',
        url: '/User/getUserList',
        async: true,//异步
        data: {},
        dataType: 'json',
        beforeSend: function () {
            //发送前事件
        },
        success: function (data) {
            //请求成功部分代码
            if (data.TFMark) {
                $("#u_userList").empty();
                for (var item in data.userList) {
                    if (data.userList[item]["loginId"] != "admin" && data.userList[item]["userId"] != $("#a_MyUser").attr("title")) {
                        $("#u_userList").append("<li><a href='javascript:getUserInfoByFrienduserId(" + data.userList[item]["userId"] + ");'>" + data.userList[item]["name"] + "</a></li>");
                    }
                }
            }
        },
        error: function (data) {
            //请求失败部分代码
        }
    })
}

//点击好友列表获取好友信息及留言信息
function getUserInfoByFrienduserId(userId) {
    $.ajax({
        type: 'get',
        url: '/User/getUserByUserId',
        async: true,//异步
        data: {"userId": userId},
        dataType: 'json',
        beforeSend: function () {
            //发送前事件
            TBox_show(1, "正在获取数据，请勿刷新页面...");
            setTimeout(function () {
                TBox_show(0, null);//关闭提示窗
            }, 1000);//过一秒关闭
        },
        success: function (data) {
            //请求成功部分代码
            if (data.TFMark) {
                $("#img_userImage").attr("src", data.User.image);
                $("#sp_userId").html(data.User.userId);
                $("#sp_userName,#sp_userInfo").html(data.User.name);
                getMessageByUserRootIdPaging(pageIndex);//通过userId获得留言信息;
            }
            else {
                TBox_show(1, "获取好友信息失败！");
                setTimeout(function () {
                    TBox_show(0, null);//关闭提示窗
                }, 1000);//过一秒关闭
            }
        },
        error: function (data) {
            //请求失败部分代码
            TBox_show(1, "与服务器的连接断开，请重试...");
            setTimeout(function () {
                TBox_show(0, null);//关闭提示窗
            }, 1500);//过一秒关闭
        }
    });
}

//通过用户userId获取留言消息以及回复消息
function getMessageByUserRootIdPaging(pageIndex) {
    if ($("#sp_userId").html().trim() != "--") {
        $.ajax({
            type: 'post',
            url: '/Message/getMessageByUserRootIdPaging',
            async: true,//异步
            data: {pageIndex: pageIndex, pageSize: pageSize, rootUserId: $.trim($("#sp_userId").html())},
            dataType: 'json',
            beforeSend: function () {
                //发送前事件
                TBox_show(1, "正在获取数据，请勿刷新页面...");
                setTimeout(function () {
                    TBox_show(0, null);//关闭提示窗
                }, 500);//过一秒关闭
            },
            success: function (data) {
                //请求成功部分代码
                if (data.TFMark) {
                    $(".sp_msg_count").html("留言(" + data.messageCount + ")");
                    $("#d_messageBoxs").empty();
                    for (var item in data.messagePluses_root) {
                        $("#d_messageBoxs").append(
                            "<div class='messageBox'>"
                            + "<hr/>"
                            + "<div class='d_messageBoxLeft'>"
                            + "<img src='" + data.messagePluses_root[item]["image"] + "'>"
                            + "</div>"
                            + "<div class='d_messageBoxRight'>"
                            + "<p class='p_msg_user'>"
                            + "<a href='javascript:getUserInfoByFrienduserId(" + data.messagePluses_root[item]["userId"] + ");'>" + data.messagePluses_root[item]["name"] + "</a>"
                            + "</p>"
                            + "<p class='p_msg_content'>" + data.messagePluses_root[item]["messages"] + "</p>"
                            + "<p class='p_msg_time'>"
                            + "<span>" + data.messagePluses_root[item]["time"] + "</span><a href='javascript:void(0);' onclick='clickHF(this);'>回复</a>" + isViewDelLH(data.messagePluses_root[item]["rootUserId"], data.messagePluses_root[item]["userId"], data.messagePluses_root[item]["messageId"]) + ""
                            + "</p>"
                            + "<hr>"
                            + "<div class='d_d_msgBoxRight_HF' id='d_HF_" + data.messagePluses_root[item]["messageId"] + "'>"
                            + "</div>"
                            + "<textarea class='msg_answer' onfocus='javascript:textareaFocus(this);' onblur='javascript:textareaBlur(this);'>我也说一句...</textarea>"
                            + "<br/>"
                            + "<div class='d_msg_answer' onclick='addMessage(rtmsg_answerVal(this),rtUserId(), " + data.messagePluses_root[item]["messageId"] + ",rtRootId() );'>"
                            + "<span>确定</span>"
                            + "</div>"
                            + "<a class='a_answer_cancel' href='javascript:void(0);'  onclick='HFcancelClick(this);'>取消</a>"
                            + "<br/>&nbsp;"
                            + "</div>"
                            + "<br/>"
                            + "</div>"
                        );
                    }//end for
                    for (var item in data.messagePluses) {
                        $("#d_HF_" + data.messagePluses[item]["root"] + "").append(
                            "<div class='d_hfLeft'>"
                            + "<img src='" + data.messagePluses[item]["image"] + "'>"
                            + "</div>"
                            + "<div class='d_hfRight'>"
                            + "<p class='p_hf_content'><a href='javascript:getUserInfoByFrienduserId(" + data.messagePluses[item]["userId"] + ");'>" + data.messagePluses[item]["name"] + "</a>&nbsp;" + data.messagePluses[item]["messages"] + "</p>"
                            + "<p class='p_hf_time'>"
                            + "<span>" + data.messagePluses[item]["time"] + "</span>" + isViewDelHF(data.messagePluses[item]["rootUserId"], data.messagePluses[item]["userId"], data.messagePluses[item]["messageId"]) + ""
                            + "</p>"
                            + "</div>"
                            + "<br style='clear:both;'>"
                        );
                    }
                }
                else {
                    TBox_show(1, "获取数据失败！");
                    setTimeout(function () {
                        TBox_show(0, null);//关闭提示窗
                    }, 1000);//过一秒关闭
                }
            },
            error: function (data) {
                //请求失败部分代码
                TBox_show(1, "与服务器的连接断开，请重试...");
                setTimeout(function () {
                    TBox_show(0, null);//关闭提示窗
                }, 1000);//过一秒关闭
            }
        });
    } else {
        TBox_show(1, "您还未登陆，请先登录！");
        setTimeout(function () {
            TBox_show(0, null);//关闭提示窗
            window.location = "/Views/User/Login.jsp";
        }, 2000);//过一秒关闭
    }
    ;
    //获取总页码
    $.post("/Message/getMessageCountByUserRootId", {rootUserId: $.trim($("#sp_userId").html())}, function (data) {
        pageCount = Math.ceil(data.messageCount / pageSize);//为总页数赋值
        if (pageIndex > pageCount) {
            pageIndex = pageCount;
            $("#sp_paging_1").html(pageIndex);
            getMessageByUserRootIdPaging(pageIndex);
        }
        $("#sp_paging_2").html(pageCount);
        isEnabled();//上下页能否点击
    });
}

//添加一条信息留言信息或者回复一条留言信息
function addMessage(Messages, userId, Root, rootUserId) {
    $.ajax({
        type: 'post',
        url: '/Message/addMessage',
        async: true,//异步
        data: {Messages: Messages, userId: userId, Root: Root, rootUserId: rootUserId},
        dataType: 'json',
        beforeSend: function () {
            //发送前事件
            TBox_show(1, "正在提交数据，请勿刷新页面...");
            setTimeout(function () {
                TBox_show(0, null);//关闭提示窗
            }, 1000);//过一秒关闭
        },
        success: function (data) {
            //请求成功部分代码
            if (data.TFMark) {
                TBox_show(1, "提交成功！");
                setTimeout(function () {
                    TBox_show(0, null);//关闭提示窗
                    getMessageByUserRootIdPaging(pageIndex);
                }, 500);//过一秒关闭
            }
            else {
                TBox_show(1, "提交信息有误，请检查后重新提交！");
                setTimeout(function () {
                    TBox_show(0, null);//关闭提示窗
                }, 1000);//过一秒关闭
            }
        },
        error: function (data) {
            //请求失败部分代码
            TBox_show(1, "与服务器的连接断开...");
            setTimeout(function () {
                TBox_show(0, null);//关闭提示窗
            }, 1500);//过一秒关闭
        }
    })
}

//通过 messageId 删除一条信息留言信息或者删除一条留言信息
function deleteMessage(messageId) {
    if (confirm("删除操作不可逆，确定删除此条信息？")) {
        $.ajax({
            type: 'post',
            url: '/Message/deleteMessage',
            async: true,//异步
            data: {messageId: messageId},
            dataType: 'json',
            beforeSend: function () {
                //发送前事件
                TBox_show(1, "正在提交数据，请勿刷新页面...");
                setTimeout(function () {
                    TBox_show(0, null);//关闭提示窗
                }, 1000);//过一秒关闭
            },
            success: function (data) {
                //请求成功部分代码
                if (data.TFMark) {
                    TBox_show(1, "删除成功！");
                    setTimeout(function () {
                        TBox_show(0, null);//关闭提示窗
                        getMessageByUserRootIdPaging(pageIndex);
                    }, 500);//过一秒关闭
                }
                else {
                    TBox_show(1, "删除失败！");
                    setTimeout(function () {
                        TBox_show(0, null);//关闭提示窗
                    }, 1000);//过一秒关闭
                }
            },
            error: function (data) {
                //请求失败部分代码
                TBox_show(1, "与服务器的连接断开...");
                setTimeout(function () {
                    TBox_show(0, null);//关闭提示窗
                }, 1500);//过一秒关闭
            }
        });
    }

}


//权限验证
//留言板留言删除按钮显示
function isViewDelLH(rootUserId, userId, messageId) {
    if ($.trim(rootUserId) == $("#a_MyUser").attr("title"))
        return "<a href='javascript:deleteMessage(" + messageId + ");'>删除</a>";
    else if ($.trim(userId) == $("#a_MyUser").attr("title"))
        return "<a href='javascript:deleteMessage(" + messageId + ");'>删除</a>";
    else  return "";
}
//留言板回复删除按钮显示
function isViewDelHF(rootUserId, userId, messageId) {
    if ($.trim(rootUserId) == $("#a_MyUser").attr("title"))
        return "<a href='javascript:deleteMessage(" + messageId + ");'>删除</a>";
    else if ($.trim(userId) == $("#a_MyUser").attr("title"))
        return "<a href='javascript:deleteMessage(" + messageId + ");'>删除</a>";
    else  return "";
}


//处理添加html时字符串问题的方法
function rtmsg_answerVal(th) {
    return $(th).siblings(".msg_answer").val();
}
//返回根用户id--当前展示的空间主用户
function rtRootId() {
    return $.trim($("#sp_userId").html());
}
//返回当前用户id--当前登录的用户
function rtUserId() {
    return $("#a_MyUser").attr("title");
}

//设置textarea点击默认提示信息关闭显示
function textareaFocus(th) {
    if ($(th).val() == "我也说一句...")
        $(th).val("");
    //width: 500px;height:40px
    $(th).css("width", "500px");
    $(th).css("height", "40px");
    //visibility: hidden;
    $(th).siblings(".d_msg_answer").css("visibility", "visible");
    $(th).siblings(".a_answer_cancel").css("visibility", "visible");
}
function textareaBlur(th) {
    if ($(th).val() == "") {
        $(th).val("我也说一句...");
        $(th).css("width", "300px");
        $(th).css("height", "20px");
        $(th).siblings(".d_msg_answer").css("visibility", "hidden");
        $(th).siblings(".a_answer_cancel").css("visibility", "hidden");
    }
    else {
        //;width: 500px;height:40px
        $(th).css("width", "500px");
        $(th).css("height", "40px");
    }
}
//回复栏取消按钮的实现
function HFcancelClick(th) {
    $(th).siblings(".msg_answer").val("我也说一句...");
    $(th).siblings(".msg_answer").css("width", "300px");
    $(th).siblings(".msg_answer").css("height", "20px");
    $(th).siblings(".d_msg_answer").css("visibility", "hidden");
    $(th).css("visibility", "hidden");
}
//点击回复按钮效果
function clickHF(th) {
    $(th).parent().siblings(".msg_answer").focus();
}
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
