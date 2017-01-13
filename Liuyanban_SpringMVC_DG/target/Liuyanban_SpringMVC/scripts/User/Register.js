/**
 * Created by Administrator on 2016/8/26.
 */
jQuery(function($){
    $(document).ready(function(e) {


        $(".ipt_V_DG").blur(function(){
            $(this).ipt_V_all_DG();//全部验证函数 可列举内部单,里面参数可以省略,原函数为默认参数条
        });

        $("#form_sub").click(function(){
            //判断是否全部通过验证
            if($("#ipt_V_mark_DG").val()=="1")
            {
                //验证成功
               if (confirm("确定信息无误，提交？"))
               {
                   $.ajax({
                       type: 'post',
                       url: '/User/addUser',
                       async: true,//异步
                       data: {loginId: $("#loginId").val(), Pwd: $("#password").val(), userName: $("#userName").val(), Image: $("#img_choosed").attr("src")},
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
                               TBox_show(1, "注册成功！");
                               setTimeout(function () {
                                   TBox_show(0, null);//关闭提示窗
                                   window.location="/Views/MessageMain/MessageMain.jsp";
                               }, 500);//过一秒关闭
                           }
                           else if (data.isExist)
                           {
                               $("#sp_V_msg_DG_userExist").css("color","red");
                               $("#sp_V_msg_DG_userExist").html("用户名已存在!")
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

            }
            else
            {
                $(".ipt_V_DG").ipt_V_all_DG();
            }
        });

        //图片选择
        $(".img_choose").click(function () {
           $("#img_choosed").attr("src",$(this).attr("src"));
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
