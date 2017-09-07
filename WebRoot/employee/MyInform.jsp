<%@ page language="java" import="java.util.*" pageEncoding="UTF8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>信息查看</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/style.default.css" type="text/css" />
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
    <jsp:include page="mainframe.jsp"></jsp:include>
    <jsp:include page="left.jsp"></jsp:include>
    <div class="centercontent">
    <div class="contenttitle2">
    <div class="pageheader">
    <h1 class="pagetitle">我的信息</h1>  
    <ul class="hornav">
                <li class="current"><a href="#inbox">收件箱</a></li>
                <li><a href="#compose">写消息</a></li>
            </ul>                  
    </div><!--pageheader-->
    </div>
    <div id="contentwrapper" class="contentwrapper">  
		<div id="inbox" class="subcontent">
		<form>
    <table cellpadding="0" cellspacing="0" border="0" id="table2" class="stdtable stdtablecb">
                    <colgroup>
                        <col class="con0"/>
                        <col class="con1"/>
                        <col class="con0"/>
                        <col class="con1"/>
                        <col class="con0"/>
                    </colgroup>
                    <thead>
                        <tr>
                        	<th class="head0">发布者账号</th>
                            <th class="head1">发布者</th>
                            <th class="head0">消息内容</th>
                            <th class="head1">发送时间</th>
                            <th class="head0">操作</th>
                        </tr>
                    </thead>
                   <s:iterator value="message" id="m">
                    <tbody>
                        <tr>
                        	<td><s:property value="send_id"/></td>
                            <td><s:property value="send_name"/></td>
                            <td><s:property value="message"/></td>
                            <td><s:property value="send_date"/></td>
                           	
                            <s:if test="flag == 2"><td class="center"><a href="employee-result?mid=<s:property value="id"/>"><button type="button" class="submit radius2">回馈</button></a></td></s:if>
                            <s:elseif test="flag == 3"><td class="center"><a href="employee-lookResult"><button type="button" class="submit radius2">已经反馈结果</button></a></td></s:elseif>
                            <%--<s:elseif test="flag == 0"><td><a href="">回复</a></td></s:elseif>--%>
                            <s:else><td><a href="public-deleteMessage?id=<s:property value="id"/>"><button type="button" class="submit radius2">删除</button></a></td></s:else> 
                        </tr>
                    </tbody>
                    </s:iterator>
                   
                </table>
                
                </form>
		</div>
		<div id="compose" class="subcontent" style="display: none">
             	 <form class="stdform" id="sendmessage" action="public-sendEmpMessage" method="post" >
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
    <br clear="all" />
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