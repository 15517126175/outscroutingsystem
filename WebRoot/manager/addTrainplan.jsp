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
<script type="text/javascript" src="js/plugins/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery.tagsinput.min.js"></script>
<script type="text/javascript" src="js/plugins/charCount.js"></script>
<script type="text/javascript" src="js/plugins/ui.spinner.min.js"></script>
<script type="text/javascript" src="js/plugins/chosen.jquery.min.js"></script>
<script type="text/javascript" src="js/custom/general.js"></script>
<script type="text/javascript" src="js/custom/forms.js"></script>
 
<!-- 配置文件 -->

<script type="text/javascript" src="ueditor/ueditor.config.js"></script>

<!-- 编辑器源码文件 -->

<script type="text/javascript" src="ueditor/ueditor.all.js"></script>
  </head>
  		
  <body class="withvernav">

    <jsp:include page="mainframe.jsp"></jsp:include>
    <jsp:include page="left.jsp"></jsp:include>
  
        
    <div class="centercontent">
    
        <div class="pageheader">
            <h1 class="pagetitle">控制台</h1>
            <span class="pagedesc">页面的描述内容</span>
            
           
        </div><!--pageheader-->
        
        <div id="contentwrapper" class="contentwrapper">
        
        	 <h3>添加培训计划</h3>
                   

                    <form class="stdform" id="add" action="manager-addTrainplan" method="post" enctype="multipart/form-data">
                    	
                        
        				 <br/>
        				 <p>
                        	<label>培训计划年份</label>
                            <span class="field"><input type="text"   id="year"  name="trainplan.yearplan" class="smallinput" /></span>
                         
        				 </p>
        				  <p>
                        	<label>计划内容</label>
                            <span class="field"> <textarea cols="80" rows="10" id="content"  name="trainplan.content"></textarea></span>
        				 </p>
        				 
        				<p class="stdformbutton">
                        	<button type="button" class="submit radius2" onclick="form_submit()">确认</button>
                            <input type="reset" class="reset radius2" value="重置" />
                        </p>

                    </form>
	
                   
            
        
        </div><!--contentwrapper-->
        
        <br clear="all" />
        
	</div><!-- centercontent -->
    <script language="javascript" type="text/javascript">
function form_submit(){
	if (document.getElementById("year").value=="" || document.getElementById("content").value=="")
	{
		alert("不能为空！");
		return false;
		 
	}
	else{
		document.getElementById("add").submit();
	}
	 
	   
	
}
var ue = UE.getEditor("content");
</script>
    


</body>
</html>
