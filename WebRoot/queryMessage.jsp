<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员控制台</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/style.default.css" type="text/css" />
	<script type="text/javascript" src="js/plugins/jquery-1.7.min.js"></script>
	<script type="text/javascript" src="js/plugins/jquery-1.7.min.js"></script>
	<script type="text/javascript" src="js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
	<script type="text/javascript" src="js/plugins/jquery.cookie.js"></script>
	<script type="text/javascript" src="js/plugins/jquery.uniform.min.js"></script>
	<script type="text/javascript" src="js/plugins/jquery.flot.min.js"></script>
	<script type="text/javascript" src="js/plugins/jquery.flot.resize.min.js"></script>
	<script type="text/javascript" src="js/plugins/jquery.slimscroll.js"></script>
	<script type="text/javascript" src="js/custom/general.js"></script>
	<script type="text/javascript" src="js/custom/dashboard.js"></script>

  </head>
  
  <body class="withvernav">

    <jsp:include page="outmanager/mainframe.jsp"></jsp:include>
    <jsp:include page="outmanager/left.jsp"></jsp:include>
  
        
    <div class="centercontent">
    
        <div class="pageheader">
            <h1 class="pagetitle">消息中心</h1> 
            <ul class="hornav">
                <li class="current"><a href="#inbox">收件箱</a></li>
                <li><a href="#compose">写消息</a></li>
            </ul>
        </div><!--pageheader-->
        
        
       <div id="contentwrapper" class="contentwrapper">
             
             <div id="inbox" class="subcontent">
             
                
                <table cellpadding="0" cellspacing="0" border="0" class="stdtable mailinbox">
                    <colgroup>
                        <col class="con0" width="4%"/>
                        <col class="con1" width="15%"/>
                        <col class="con0" width="63%"/>
                        <col class="con1" width="10%"/>
                    </colgroup>
                    <thead>
                    <tr>
                        <th width="20" class="head1 aligncenter"><input type="checkbox" name="checkall" class="checkall" /></th>
                      	<th class="head0">发送人账号</th>
                        <th class="head1">发送人</th>
                        <th class="head0">内容</th>
                        <th class="head1">时间</th>
                        <th class="head0">操作</th>
                    </tr>
                    </thead>
                   <s:iterator value="message">
                    <tbody>
                        <tr class="unread">
                        	<td align="center"><input type="checkbox" name="" value="" /></td>
                         	 <td><s:property value="send_id"/></td>
                         	  <td><s:property value="send_name" /></td> 
                         	  <td><s:property value="message" /></td>
                         	  <td><s:property value="send_date" /></td>
                         	  <td> <a href="public-deleteMessage?id=<s:property value="id"/>">删除</a></td>  
                        </tr>
                   </tbody>
                   </s:iterator>
                </table>             
             </div>
             <div id="compose" class="subcontent" style="display: none">
             	 <form class="stdform" id="sendmessage" action="public-sendAdminMessage" method="post" >
	           		<label>收件人编号</label>
					<input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" id="id"  name="me.receive_id"  />
					<br><br><br>
					<p>
                        	<label>消息内容</label>
                            <span class="field">
                                <textarea cols="80" rows="5" id="textarea2" name="me.message" class="longinput"></textarea>
                            </span> 
                        </p>
                        <p class="stdformbutton">
                        	<button type="button" class="submit radius2" onclick="form_submit()" >确认</button>
                            <input type="reset" class="reset radius2" value="重置" />
                        </p>
                 </form>       
             </div>
        </div><!--contentwrapper-->
        
        
        
	</div><!-- centercontent -->
  <script language="javascript" type="text/javascript">
function form_submit(){
	if (document.getElementById("id").value=="" )
	{
		alert("收件人不能为空！");
		return false;
		 
	}
	else{
		document.getElementById("sendmessage").submit();
	}
	 
}

</script>   
    


</body>
</html>
