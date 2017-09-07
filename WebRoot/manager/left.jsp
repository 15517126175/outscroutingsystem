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
    

	<link rel="stylesheet" href="css/style.default.css" type="text/css" />
<script type="text/javascript" src="js/plugins/jquery-1.7.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery.cookie.js"></script>
<script type="text/javascript" src="js/plugins/jquery.uniform.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery.tagsinput.min.js"></script>
<script type="text/javascript" src="js/plugins/charCount.js"></script>
<script type="text/javascript" src="js/plugins/ui.spinner.min.js"></script>
<script type="text/javascript" src="js/plugins/chosen.jquery.min.js"></script>
<script type="text/javascript" src="js/custom/general.js"></script>
<script type="text/javascript" src="js/custom/forms.js"></script>



<script src="http://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>


  </head>
  
  <body class="withvernav">
<div class="bodywrapper">
    
    
    
   
    <div class="vernav2 iconmenu">
    	<ul>
        	
            <!--<li><a href="filemanager.html" class="gallery">文件管理</a></li>-->
            <li class="current"><a href="manager-empList" class="editor">人员管理</a>
            <li class="current"><a  class="editor">培训管理</a></li>  
             <li><a href="manager-trainplanlist" class="editor">培训计划</a>
            <li><a href="manager-trainList" class="editor">培训信息</a>
            <li ><a href="manager/addTrain.jsp" class="editor">发起新培训</a> 
            <li><a href="manager-trainticklingList" class="editor">培训反馈</a>
            <li class="current"><a  class="editor">公告管理</a></li>       
            <li ><a href="manager-noticeList" class="editor">公告显示</a>
            <li ><a href="manager/addContent.jsp" class="editor">添加公告</a></li>                  
            <!--   <li ><a href="manager-toupContent" class="editor">公告文件管理</a></li> 
           -->
           
            <li class="current"><a  class="editor">关于我们</a>
            <li><a href="manager-synopsis">公司简介</a></li>
            <li><a href="manager-institutionList">规章制度</a></li>	
            
            <li><a href="manager-resumeList">简历管理</a></li>
            <li><a href="manager-forumList">论坛</a></li>
            	
               		
                    
                    
               
            
           
        </ul>
        <a class="togglemenu"></a>
        <br /><br />
    </div><!--leftmenu-->
        
   
        
        <br clear="all" />
        

    
</div><!--bodywrapper-->

</body>
</html>
