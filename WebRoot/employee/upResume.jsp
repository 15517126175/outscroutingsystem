<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'upContract.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	

  </head>
  
  <body>
  		<form action="employee-upResume" method="post" id="up" enctype="multipart/form-data">
    	<p>
        <label>上传本地简历</label>
        <span class="field"><input type="file" id="local_resume"  name="file1"/></span>
        </p>
    	<input type=button name=inputboxbt value=确定 onclick="bconfirm();">
        <input type=button name=inputboxbs value=取消 onclick="bcancel();">
    	</form>
  </body>
  <script type="text/javascript">
  	function bconfirm(){
  		if(document.getElementById("local_resume").value==""){
  			alert("请选择文件!");
  		}else{
  			document.getElementById("up").submit();
  		}
  	}
  	function bcancel(){
  	  window.close();
  	}
  
  </script>
</html>
