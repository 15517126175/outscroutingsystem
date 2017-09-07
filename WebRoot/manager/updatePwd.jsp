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
        
        	 <h3>修改密码</h3>
                   

                    <form class="stdform" id="updatePwd" action="manager-updatePwd?user=${sessionScope.user}" method="post" >
                    	
                        <p>
                        	<label>登录名:${sessionScope.user}</label>
                            
        				 </p>
        				 <br/>
        				 <p>
                        	<label>旧密码</label>
                            <span class="field"><input type="text"  placeholder="请输入旧密码" id="oldPwd"  name="oldPwd" class="smallinput" /></span>
                         
        				 </p>
        				  <p>
                        	<label>新密码</label>
                            <span class="field"><input type="text" id="newPwd" placeholder="请输入新密码" name="newPwd" class="smallinput" /></span>
        				 </p>
        				<p class="stdformbutton">
                        	<button class="submit radius2" onclick="form_submit()">确认</button>
                            <input type="reset" class="reset radius2" value="重置" />
                        </p>

                    </form>
	
                   
            
        
        </div><!--contentwrapper-->
        
        <br clear="all" />
        
	</div><!-- centercontent -->
    <script language="javascript" type="text/javascript">
function form_submit(){
	if (document.getElementById("oldPwd").value=="" || document.getElementById("newPwd").value=="")
	{
		alert("新旧密码不能为空！");
		return false;
		 
	}else if(document.getElementById("oldPwd").value==document.getElementById("newPwd").value){
		
		alert("新密码与旧密码不能一样！");
		return false;
	}else{
		document.getElementById("updatePwd").submit();
	}
	 
	   
}

</script>
    


</body>
</html>
