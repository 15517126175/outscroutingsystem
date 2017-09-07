<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/plugins/jquery-1.7.min.js"></script>
	<script>
$(document).ready(function(){
	$("button").click(function(){
		$.ajax({url:"demo_test.txt",success:function(result){
			$("#div1").html(result);
		}});
	});
});
</script>
  </head>
  
  <body>
    <div id="div1"><h2>使用 jQuery AJAX 修改文本内容</h2></div>	
    <button>获取其他内容</button>
  </body>
</html>
