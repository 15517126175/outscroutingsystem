/*
 * the first time to call
 */
//setTimeout("alert('对不起, 要你久候')", 3000 )
setTimeout("queryMessage()", 60000 )

function queryMessage(){
    $.ajax({
        type:"POST",
        url:"public-queryMessage",//why getTime and wont use
        data:{},
        //beforeSend:function(){},
        success: function(data){
            var obj=eval("("+data+")");//eval使用前要先加括号，才能得到完整的json数据
            if(obj.msg!=0){

                $("#tongzhi-content").html(obj.msg);//更新提示内容中的数量部分
               
            }else{
                $("#tongzhi-content").html(0);
            }


        }
    });
    
    setTimeout("queryMessage()",10000)
}