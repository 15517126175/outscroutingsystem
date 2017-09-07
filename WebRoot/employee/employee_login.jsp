<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>人力资源外包服务系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="css/style.default.css" type="text/css" />
  </head>
  
  <body class="loginpage">
	<div class="loginbox">
    	<div class="loginboxinner">
        	
            <div class="logo">
            	<h1 class="logo">软件人力资源外包服务系统</h1>
				<span class="slogan">员工端</span>
            </div><!--logo-->
            
            <br clear="all" /><br />
            
           
            
            <form id="login" action="employeelogin-login" method="post">
            	
                <div class="username">
                	<div class="usernameinner">
                    	<input type="text" placeholder="请输入用户名" name="employeeId"  id="employeeId"/>
                    </div>
                </div>
                
                <div class="password">
                	<div class="passwordinner">
                    	<input type="password" placeholder="请输入密码"  name="employeePwd" id="employeePwd"/>
                    </div>
                </div>
                
                <button type="button" onclick="login()" >登陆</button>
                
                
            
            </form>
            
        </div><!--loginboxinner-->
    </div><!--loginbox-->
	 <script language="javascript" type="text/javascript">
function login(){
	if (document.getElementById("employeeId").value=="")
	{
		alert("用户名不能为空！");
		return false;
	}else if(document.getElementById("employeePwd").value==""){
		alert("密码不能为空！");
		return false;
	}else{
		 document.getElementById("login").submit();
	   	}
	
	   
}

</script>

</body>
</html>
