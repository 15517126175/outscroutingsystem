<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改发包方信息</title>
    
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
        
        	 <h3>修改员工信息</h3>
                   

                    <form class="stdform" id="editEmp" action="manager-editEmp" method="post" >
                    	
                        
        				<s:hidden name="emp.employee_id"></s:hidden>
        				 
        				 <p>
        				
                         <label>姓名</label>
                            <span class="field"><input type="text"   id="employee_name" name="emp.employee_name"  value="${emp.employee_name }" class="smallinput" /></span>
                        	
        				 </p>
        				  <p>
        				 <label>联系电话</label>
                            <span class="field"><input type="text" id="employee_phone"  name="emp.employee_phone" value="${emp.employee_phone }" class="smallinput" /></span>
        				  
        				 </p>
        				 <p>
        				 <label>邮箱</label>
                            <span class="field"><input type="text" id="employee_email"  name="emp.employee_email" value="${emp.employee_email }" class="smallinput" /> </span>
        				 
        				 </p>
        				 <p>
        				 <label>性别</label>
                            <span class="field"><select  id="employee_sex" name="emp.employee_sex" >
                            	<option value="男">---- 男 ----</option>
                                <option value="女">---- 女 ----</option>                   
                            </select> </span>
        				 
        				 </p>
        				 <p>
        				  <label>密码</label>
                            <span class="field"><input type="password" id="employee_pwd"  name="emp.employee_pwd" value="${emp.employee_pwd }" class="smallinput" disabled />&nbsp<input type="button" value="初始化" onclick="pwdstart()"/></span>
        				 
        				 </p>
        				 <p>
                        	<label>员工技能描述</label>
                            <span class="field"> <textarea cols="80" rows="10" id="employee_skill"  name="emp.employee_skill" >${emp.employee_skill }</textarea></span>
        				 </p>
        				<p class="stdformbutton">
                        	<button type="submit" class="submit radius2" >确认</button>
                            <input type="reset" class="reset radius2" value="重置" />
                        </p>

                    </form>
	
        </div><!--contentwrapper-->
        
        <br clear="all" />
        
	</div><!-- centercontent -->
    <script language="javascript" type="text/javascript">

    function form_submit(){
    	if (document.getElementById("employee_name").value=="" || document.getElementById("employee_phone").value=="")
    	{
    		alert("名称和电话不能为空！");
    		return false;
    		 
    	}
    	else{
    		document.getElementById("editEmp").submit();
    	}
    	 
    	   
    }
	  
function pwdstart(){
	document.getElementById("employee_pwd").value="0000";
	
	
}

</script>
    


</body>
</html>
