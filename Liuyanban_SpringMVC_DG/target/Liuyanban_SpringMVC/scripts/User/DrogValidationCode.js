/**
 * 
 */
var IsValidSuccess = false;//初始值为false 当验证成功才回编程true
jQuery(function ($) {

    $(document).ready(function (e) {
       // alert(1);
		//定义一个全局的判断验证是否成功的变量
		
		//var IsInValidAreas=false;//设置指针是否在判断区域里
		var validTime=0.0;//验证码操作计时
		var interval;//定义一个定时器
		//var tof
		//刷新页面初始化验证码
		randomValid();//重置验证码图片
		$(function(){
			var IsValidClick=false;//判断是否在拖动按钮上按下鼠标
			var x1= 0;//鼠标按下时的坐标x1,y1		
			//鼠标按下抬起的事件		
			$(".d_Slider").mousedown(function(e){
				//如果拖动按钮在初始位置，才可以进行拖动
				if($(".d_Slider").position().left==10)
				{
					IsValidClick=true;
					x1 = e.pageX;
					interval=setInterval(function(){
						validTime+=100;
						},100);
				}
				});
			$(this).mouseup(function(){
				IsValidClick=false;
				//如果拖动按钮不在初始位置，才可以验证
				if($(".d_Slider").position().left>10)
				{
				var d_moveLeft=$(".d_move").position().left;
				var d_backLeft=$(".d_back").position().left;
				var check=d_moveLeft-d_backLeft;
				
				if(check>=-2&&check<=2)//有容错差值 为+-2
				{
					IsValidSuccess=true;//验证成功！
					$(".d_DragValidMain").css("background", "url(/images/User/Login/valid_success.png)");
				    $(".sp_Time").html("验证成功！ 共用时:"+validTime/1000+"秒");
					//$(".sp_Time").html("验证成功！");
					/*
					//验证成功需要写的代码写在这里
					例如：
					*/
					$("#sp1").html("验证成功！");
					
				}else
				{
				    $(".d_DragValidMain").css("background", "url(/images/User/Login/valid_error.png)");
					setTimeout(function(){
						resetValidation();//过一会重置
						validTime=0;//重置时间
						/*
						//验证失败需要写的代码写在这里
						例如：
						*/
						$("#sp1").html("验证失败！");
						},500);
				}
				validTime=0;//重置计时
				clearInterval(interval);
			}
			});
			//当鼠标移动到块上时显示
			$(".d_DragValidMain,.d_Slider,.d_BackImageBox").mouseenter(function(){
				//设置图片显示块的位置
				$(".d_DragValidAssistant").css("top",$(".d_DragValidMain").position().top-200+"px");
				$(".d_DragValidAssistant").css("left",$(".d_DragValidMain").position().left+"px");
				$(".d_DragValidAssistant").css("visibility","visible");
				});
			//当鼠标移开后消失
			$(".d_DragValidMain,.d_BackImageBox").mouseleave (function(){
				if(!IsValidClick){
							  $(".d_DragValidAssistant").css("visibility","hidden");
					}
				});
				
			//鼠标拖动移动部分
			$(this).mousemove(function(e){
				//如果是拖动按钮上鼠标按下的状态
					if(IsValidClick)
					{
					    $(".d_Slider").css("background", "url(/images/User/Login/button_run.png)");//移动时候换成移动的标识图片
					    $(".d_DragValidMain").css("background", "url(/images/User/Login/valid_run.png)");
						//鼠标移动时的动态坐标
						x2 = e.pageX;
						x = x2 - x1;
						if(x>=10&&x<=240)
						{
							$(".d_Slider").css("left",x+"px");
							$(".d_move").css("left",x+"px");
						}
					}
				});
				
			$(".d_reset").click(function(){
				resetValidation();//重置按钮
				randomValid();//初始化验证码图片
				});
			});
		//$(".d_BackImage").css("background", "url(/images/User/Login/validPic1.png)");
    });
});

//配合验证代码的重置函数
//重置验证码的事件
function resetValidation(){
	//重置验证码的设置属性
	$(".sp_Time").html("");//验证提示
	IsValidSuccess=false;//验证成功标识变为false;
	$(".d_move,.d_Slider").animate({left:'10px'},"slow");
	$(".d_Slider").css("background", "url(/images/User/Login/button_stop.png)");//移动时候换成移动的标识图片
	$(".d_DragValidMain").css("background", "url(/images/User/Login/valid_0.png)");
	}
	//重置验证码控件
function randomValid()
{
	changeImage();//重置图片
	changeValidPosition();//重置验证位置
}
	//重置图片
function changeImage()
{
	try{
		var ran=getrandom();
		if(ran<=0.2)
		{
		    $(".d_BackImage").css("background", "url(/images/User/Login/validPic1.png)");
		    $(".d_move").css("background", "url(/images/User/Login/validPic1.png)");
		}
		else if(ran>0.2&&ran<=0.4)
		{
		    $(".d_BackImage").css("background", "url(/images/User/Login/validPic2.png)");
		    $(".d_move").css("background", "url(/images/User/Login/validPic2.png)");
		}
		else if(ran>0.4&&ran<=0.6)
		{
		    $(".d_BackImage").css("background", "url(/images/User/Login/validPic3.png)");
		    $(".d_move").css("background", "url(/images/User/Login/validPic3.png)");
		}
		else if(ran>0.6&&ran<=0.8)
		{
		    $(".d_BackImage").css("background", "url(/images/User/Login/validPic4.png)");
		    $(".d_move").css("background", "url(/images/User/Login/validPic4.png)");
		}
		else if(ran>0.8)
		{
		    $(".d_BackImage").css("background", "url(/images/User/Login/validPic5.png)");
		    $(".d_move").css("background", "url(/images/User/Login/validPic5.png)");
		}
	}
	catch(e)
	{}
	}
function changeValidPosition()
{
	try{
		var ran=getrandom();
		if(ran<=0.2)
		{
			$(".d_move").css("background-position","80px 110px");
			$(".d_back").css("left","200px");
			$(".d_back,.d_move").css("top","50px");
		}
		else if(ran>0.2&&ran<=0.4)
		{
			$(".d_move").css("background-position","50px 60px");
			$(".d_back").css("left","230px");
			$(".d_back,.d_move").css("top","100px");
		}
		else if(ran>0.4&&ran<=0.6)
		{
			$(".d_move").css("background-position","180px 130px");
			$(".d_back").css("left","100px");
			$(".d_back,.d_move").css("top","30px");
		}
		else if(ran>0.6&&ran<=0.8)
		{
			$(".d_move").css("background-position","130px 120px");
			$(".d_back").css("left","150px");
			$(".d_back,.d_move").css("top","40px");
		}
		else if(ran>0.8)
		{
			$(".d_move").css("background-position","200px 80px");
			$(".d_back").css("left","80px");
			$(".d_back,.d_move").css("top","80px");
		}
	}
	catch(e)
	{}
	}
function getrandom()
{	var ran=Math.random();return ran;
}
function form_sub() {
    if (IsValidSuccess) {
        $("#form1").submit();
    }
    else {
        alert("请拖动滑块完成验证！");
    }

}
function ajaxRegister() {
    alert(1);
    $.ajax({
        dataType:"script",
        url:"/Accout/Register",
        success:function(msg){}
    });
} 