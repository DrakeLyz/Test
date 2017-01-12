
$(function () {
    $("#findpass").click(function(){
        $("#modalsignIn").modal('toggle');
    })

    $('#myTab a:first').tab('show');//初始化显示哪个tab

    $('#myTab a').click(function (e) {
        e.preventDefault();//阻止a链接的跳转行为
        $(this).tab('show');//显示当前选中的链接及关联的content
    });

    $(function () {
            $('#login-user').val('');
            $('#login-user').parent().removeClass('has-success has-error');
            $('#login-userSpan').removeClass();


            $('#password').val('');
            $('#password').parent().removeClass('has-success has-error');
            $('#passwordSpan').removeClass();

            $('#login-user').blur(function () {
                $('#login-userSpan').removeClass();
                $('#login-user').parent().removeClass('has-success has-error');
                if ($('#login-user').val().length < 6) {
                    $(this).parent().addClass(' has-error');
                    $('#login-userSpan').addClass('glyphicon glyphicon-remove form-control-feedback');
                }
                else {
                    $(this).parent().addClass('has-success');
                    $('#login-userSpan').addClass('glyphicon glyphicon-ok form-control-feedback');
                }
            });

            $('#login-password').blur(function () {
                $('#login-passwordSpan').removeClass();
                $('#login-password').parent().removeClass('has-success has-error');
                if ($('#login-password').val().length < 6) {
                    $(this).parent().addClass(' has-error');
                    $('#login-passwordSpan').addClass('glyphicon glyphicon-remove form-control-feedback');
                }
                else {
                    $(this).parent().addClass('has-success');
                    $('#login-passwordSpan').addClass('glyphicon glyphicon-ok form-control-feedback');
                }
            });

    });

    $(function () {
        $('#register-user').val('');
        $('#register-user').parent().removeClass('has-success has-error');
        $('#register-userSpan').removeClass();

        $('#register-email').val('');
        $('#register-email').parent().removeClass('has-success has-error');
        $('#register-emailSpan').removeClass();

        $('#register-password').val('');
        $('#register-password').parent().removeClass('has-success has-error');
        $('#register-passwordSpan').removeClass();

        $('#register-passwordConfirm').val('');
        $('#register-passwordConfirm').parent().removeClass('has-success has-error');
        $('#register-passwordConfirmSpan').removeClass();

        $('#register-user').blur(function () {
            $('#register-userSpan').removeClass();
            $('#register-user').parent().removeClass('has-success has-error');
            if ($('#register-user').val().length < 6) {
                $(this).parent().addClass(' has-error');
                $('#register-userSpan').addClass('glyphicon glyphicon-remove form-control-feedback');
            }
            else {
                $(this).parent().addClass('has-success');
                $('#register-userSpan').addClass('glyphicon glyphicon-ok form-control-feedback');
            }
        });

        $('#register-email').blur(function () {
            $('#register-emailSpan').removeClass();
            $('#register-email').parent().removeClass('has-success has-error');
            if (checkMail($('#register-email').val())) {
                $(this).parent().addClass('has-success');
                $('#register-emailSpan').addClass('glyphicon glyphicon-ok form-control-feedback');
            }
            else {
                $(this).parent().addClass('has-error');
                $('#register-emailSpan').addClass('glyphicon glyphicon-remove form-control-feedback');
            }
        });

        $('#register-password').blur(function () {
            $('#register-passwordSpan').removeClass();
            $('#register-password').parent().removeClass('has-success has-error');
            if ($('#register-password').val().length < 6) {
                $(this).parent().addClass(' has-error');
                $('#register-passwordSpan').addClass('glyphicon glyphicon-remove form-control-feedback');
            }
            else {
                $(this).parent().addClass('has-success');
                $('#register-passwordSpan').addClass('glyphicon glyphicon-ok form-control-feedback');
            }
        });

        $('#register-passwordConfirm').blur(function () {
            $('#register-passwordConfirmSpan').removeClass();
            $('#register-passwordConfirm').parent().removeClass('has-success has-error');
            if ($('#register-passwordConfirm').val() == '' || $('#register-password').val() != $('#register-passwordConfirm').val()) {
                $(this).parent().addClass(' has-error');
                $('#register-passwordConfirmSpan').addClass('glyphicon glyphicon-remove form-control-feedback');
            }
            else {
                $(this).parent().addClass('has-success');
                $('#register-passwordConfirmSpan').addClass('glyphicon glyphicon-ok form-control-feedback');
            }
        });

    });

    $('#drag').drag();
   $("#myCarousel").carousel({
       interval:2000
   })

});
//验证邮件格式
function checkMail(str) {
    var mailArray;
    var patterns = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    mailArray = str;
    for (i = 0; i < mailArray.length; i++) {
        if (patterns.test(mailArray))//地址符合
        {
            return true;
        }
        else   //地址不符合
        {
            return false;
        }
    }
}
//滑块
(function($){
    $.fn.drag = function(options){
        var x;//鼠标按下时候的x轴的位置
        var drag = this;
        var isMove = false;//不可拖拽
        var defaults = {};
        var options = $.extend(defaults, options);
        //添加背景，文字，滑块
        var html = '<div class="drag_bg"></div>'+
            '<div class="drag_text" onselectstart="return false;" unselectable="on">拖动滑块验证</div>'+
            '<div class="handler handler_bg"></div>';
        this.append(html);

        var handler = drag.find('.handler');
        var drag_bg = drag.find('.drag_bg');
        var text = drag.find('.drag_text');
        var maxWidth = drag.width() - handler.width();  //能滑动的最大间距

        //鼠标按下时候的x轴的位置
        handler.mousedown(function(e){
            isMove = true;//可动
            x = e.pageX - parseInt(handler.css('left'), 10);//pageX鼠标指针的位置
        });

        //鼠标指针在上下文移动时，移动距离大于0小于最大间距，滑块x轴位置等于鼠标移动距离
        $(document).mousemove(function(e){
            var _x = e.pageX - x;//鼠标指针位置减去鼠标初始位置
            if(isMove){
                if(_x > 0 && _x <= maxWidth){
                    handler.css({'left': _x});//到结束 部分的宽度
                    drag_bg.css({'width': _x});//绿色背景部分宽度
                }else if(_x > maxWidth){  //鼠标指针移动距离达到最大时清空事件
                    dragOk();
                }
            }
        }).mouseup(function(e){
            isMove = false;
            var _x = e.pageX - x;
            if(_x < maxWidth){ //鼠标松开时，如果没有达到最大距离位置，滑块就返回初始位置
                handler.css({'left': 0});
                drag_bg.css({'width': 0});
            }
        });

        //清空事件
        function dragOk(){
            handler.removeClass('handler_bg').addClass('handler_ok_bg');
            text.text('验证通过');
            drag.css({'color': '#fff'});
            handler.unbind('mousedown');
            $(document).unbind('mousemove');
            $(document).unbind('mouseup');
        }
    };
})(jQuery);
