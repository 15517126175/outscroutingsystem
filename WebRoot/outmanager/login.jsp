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
<script type="text/javascript" src="js/plugins/jquery-1.7.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery.cookie.js"></script>
<script type="text/javascript" src="js/plugins/jquery.uniform.min.js"></script>
<script type="text/javascript" src="js/custom/general.js"></script>
<script type="text/javascript" src="js/custom/index.js"></script>
<!--[if IE 9]>
    <link rel="stylesheet" media="screen" href="css/style.ie9.css"/>
<![endif]-->
<!--[if IE 8]>
    <link rel="stylesheet" media="screen" href="css/style.ie8.css"/>
<![endif]-->
<!--[if lt IE 9]>
	<script src="js/plugins/css3-mediaqueries.js"></script>
<![endif]-->
</head>
  </head>
  
  <body class="loginpage">
	<div class="loginbox">
    	<div class="loginboxinner">
        	
            <div class="logo">
            	<h1 class="logo">软件人力资源外包服务系统</h1>
				<span class="slogan">外派管理员端</span>
            </div><!--logo-->
             <div class="nousername">
				<div class="loginmsg">用户名不能为空</div>
            </div><!--nousername-->
            
            <div class="nopassword">
				<div class="loginmsg">密码不能为空</div>
			</div>
            <br clear="all" /><br />
            <form id="login" action="outlogin-login" method="post">
            	
                <div class="username">
                	<div class="usernameinner">
                    	<input type="text"  name="username"  id="username" 
                    	 />
                    </div>
                </div>
                
                <div class="password">
                	<div class="passwordinner">
                    	<input type="password"   name="password" id="password" 
                    	 />
                    </div>
                </div>
                
                <button>登陆</button>
            </form>
            
        </div><!--loginboxinner-->
    </div><!--loginbox-->
	

</body>
</html>
