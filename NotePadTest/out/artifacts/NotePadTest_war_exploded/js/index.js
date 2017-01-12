$(function(){
$("#myreply-btn").click(function(){
        $("#my-reply").modal('toggle');
    });
    $("#mymessage-btn").click(function(){
        $("#my-message").modal('toggle');
    })

})
function  reply_btn_Click()
{
    $("#reply").modal('toggle');
}
function  message_btn_Click()
{
    var id=document.getElementById("hiddenid").value;
    //alert(id);
    var url="ShowRMServlet?id="+id+"&pageNow=1";
    window.location.href=url;
    $("#message").modal('toggle');
}