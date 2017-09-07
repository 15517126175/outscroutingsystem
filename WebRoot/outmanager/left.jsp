<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
        	
            <!--<li><a href="filemanager.html" class="gallery">文件管理</a></li>-->
            <li><a href="outmanager-bossList" class="elements">发包方管理</a></li>
            <li><a href="outmanager/projectManage.jsp" class="widgets">外包项目管理</a></li>
            <li><a href="outmanager-sendProjectList" class="elements">人员派遣</a></li>
            <li><a href="outmanager-outEmpList" class="widgets">外派人员查询</a></li>
            <li><a href="outmanager-salaryQuery" class="elements">薪资查询</a></li>
            <li><a href="outmanager-checkWorkList" class="widgets">考勤查询</a></li>	
            	
           
        </ul>
        <a class="togglemenu"></a>
        <br /><br />
    </div><!--leftmenu-->
        
   
        
        <br clear="all" />
        

    
</div><!--bodywrapper-->

</body>
</html>
