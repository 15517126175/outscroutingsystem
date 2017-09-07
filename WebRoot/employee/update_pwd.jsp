<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>控制台</title>
    
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
  		<%
			String name=request.getParameter("employeeId");
			
		%>
  <body class="withvernav">

    <jsp:include page="mainframe.jsp"></jsp:include>
    <jsp:include page="left.jsp"></jsp:include>
  
        
    <div class="centercontent">
    <div class="contenttitle2">
        <div class="pageheader">
            <h1 class="pagetitle">账户管理</h1>                    
        </div><!--pageheader-->
    </div>    
        <div id="contentwrapper" class="contentwrapper">
        
        	 <h3>修改密码</h3>
                   

                    <form class="stdform" id="updatePwd" action="employee-updatePwd?employeeId=${sessionScope.userid}" method="post" >
                    	<p>
                    	<label>姓名：${sessionScope.user}</label>
                    	</p>
                        <p>
                        <label>登录名:${sessionScope.userid}</label>
        				 </p>
        				 <br/>
        				 <p>
                        	<label>旧密码</label>
                            <span class="field"><input type="text"  placeholder="请输入旧密码" id="oldEmployeePwd"  name="oldEmployeePwd" class="smallinput" /></span>
                         
        				 </p>
        				  <p>
                        	<label>新密码</label>
                            <span class="field"><input type="text"  placeholder="请输入新密码" id="newEmployeePwd"  name="newEmployeePwd" class="smallinput" /></span>
        				 </p>
        				<p class="stdformbutton">
                        	<button class="submit radius2" onclick="return updatePwd()">确认</button>
                            <input type="reset" class="reset radius2" value="重置" />
                        </p>

                    </form>
	
                   
            
        
        </div><!--contentwrapper-->
        
        <br clear="all" />
        
	</div><!-- centercontent -->
    <script language="javascript" type="text/javascript">
function updatePwd(){
	if (document.getElementById("oldEmployeePwd").value=="" || document.getElementById("newEmployeePwd").value=="")
	{
		alert("新/旧密码不能为空！");
		return false;
		 
	}else if(document.getElementById("oldEmployeePwd").value==document.getElementById("newEmployeePwd").value){
		
		alert("新密码与旧密码不能与旧密码相同！");
		return false;
	}else{
		document.getElementById("updatePwd").submit();
	}
	 
	   
}

</script>
    


</body>
</html>
