
$(function () {
    $("#findpass").click(function(){
        $("#modalsignIn").modal('toggle');
    })

    $('#myTab a:first').tab('show');//��ʼ����ʾ�ĸ�tab

    $('#myTab a').click(function (e) {
        e.preventDefault();//��ֹa���ӵ���ת��Ϊ
        $(this).tab('show');//��ʾ��ǰѡ�е����Ӽ�������content
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
//��֤�ʼ���ʽ
function checkMail(str) {
    var mailArray;
    var patterns = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    mailArray = str;
    for (i = 0; i < mailArray.length; i++) {
        if (patterns.test(mailArray))//��ַ����
        {
            return true;
        }
        else   //��ַ������
        {
            return false;
        }
    }
}
//����
(function($){
    $.fn.drag = function(options){
        var x;//��갴��ʱ���x���λ��
        var drag = this;
        var isMove = false;//������ק
        var defaults = {};
        var options = $.extend(defaults, options);
        //��ӱ��������֣�����
        var html = '<div class="drag_bg"></div>'+
            '<div class="drag_text" onselectstart="return false;" unselectable="on">�϶�������֤</div>'+
            '<div class="handler handler_bg"></div>';
        this.append(html);

        var handler = drag.find('.handler');
        var drag_bg = drag.find('.drag_bg');
        var text = drag.find('.drag_text');
        var maxWidth = drag.width() - handler.width();  //�ܻ����������

        //��갴��ʱ���x���λ��
        handler.mousedown(function(e){
            isMove = true;//�ɶ�
            x = e.pageX - parseInt(handler.css('left'), 10);//pageX���ָ���λ��
        });

        //���ָ�����������ƶ�ʱ���ƶ��������0С������࣬����x��λ�õ�������ƶ�����
        $(document).mousemove(function(e){
            var _x = e.pageX - x;//���ָ��λ�ü�ȥ����ʼλ��
            if(isMove){
                if(_x > 0 && _x <= maxWidth){
                    handler.css({'left': _x});//������ ���ֵĿ��
                    drag_bg.css({'width': _x});//��ɫ�������ֿ��
                }else if(_x > maxWidth){  //���ָ���ƶ�����ﵽ���ʱ����¼�
                    dragOk();
                }
            }
        }).mouseup(function(e){
            isMove = false;
            var _x = e.pageX - x;
            if(_x < maxWidth){ //����ɿ�ʱ�����û�дﵽ������λ�ã�����ͷ��س�ʼλ��
                handler.css({'left': 0});
                drag_bg.css({'width': 0});
            }
        });

        //����¼�
        function dragOk(){
            handler.removeClass('handler_bg').addClass('handler_ok_bg');
            text.text('��֤ͨ��');
            drag.css({'color': '#fff'});
            handler.unbind('mousedown');
            $(document).unbind('mousemove');
            $(document).unbind('mouseup');
        }
    };
})(jQuery);
