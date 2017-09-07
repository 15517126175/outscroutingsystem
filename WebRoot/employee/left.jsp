<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>员工自助平台</title>
    
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
<div class="bodywrapper">
    <div class="vernav2 iconmenu">
    	<ul>
            <s:iterator value="info">
            <li><a href="employee-selectInfo">查看个人信息</a></li>
            <li><a href="employee-findResume" >查看个人简历</a></li>
            <li><a href="employee-CheckWork">考勤查看</a></li>
            <li><a href="employee-viewSalary">我的薪资</a></li>
            <li><a href="employee-interview">我的面试</a></li>
            <li><a href="employee-selectTask">我的项目</a></li>
            <li><a href="employee-viewTrain">我的培训</a></li>
             <li><a href="employee-forumList">论坛</a></li>
			</s:iterator>
        </ul>
        <a class="togglemenu"></a>
        <br /><br />
    </div><!--leftmenu-->
        
   
        
        <br clear="all" />
        

    
</div><!--bodywrapper-->

</body>
</html>
