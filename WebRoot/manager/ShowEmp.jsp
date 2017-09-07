<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>

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
        
        	 <h3>员工信息</h3>
                   

                    <form class="stdform" id="addemp" action="manager-addemp" method="post" >
                    	<s:iterator value="emplist">
                        
        				 <br/>
        				  <p>
                        	<label>员工编号</label>
                            <span class="field"><input type="text"   id="employee_id"  name="employee_id" class="smallinput" value="<s:property value="employee_id" /> "disabled="disabled"/></span>
                         
        				 </p>
        				 <p>
                        	<label>姓名</label>
                            <span class="field"><input type="text"   id="employee_name"  name="emp.employee_name" class="smallinput" value="<s:property value="employee_name" />" disabled="disabled"/></span>
                         
        				 </p>
        				  <p>
                        	<label>性别</label>
                             <span class="field"><input type="text"   id="employee_sex"  name="emp.employee_sex" class="smallinput" value="<s:property value="employee_sex" />" disabled="disabled"/></span>
</span>
        				 </p>
        				 <p>
                        	<label>年龄</label>
                            <span class="field"><input type="text" id="employee_age"  name="emp.employee_age" class="smallinput" value="<s:property value="employee_age" />" disabled="disabled""/></span>
        				 </p>
        				 <p>
                        	<label>电话</label>
                            <span class="field"><input type="text" id="employee_phone"  name="emp.employee_phone" class="smallinput" value="<s:property value="employee_phone" />" disabled="disabled"/></span>
        				 </p>
        				 <p>
                        	<label>邮箱</label>
                            <span class="field"><input type="text" id="employee_email"  name="emp.employee_email" class="smallinput" value="<s:property value="employee_email" /> "disabled="disabled"/></span>
        				 </p>
        				 <p>
                        	<label>入职时间</label>
                            <span class="field"><input type="text" id="enter_time"  name="emp.enter_time" class="smallinput" value="<s:property value="enter_time" />" disabled="disabled"/></span>
        				 </p>
        				 <p>
                        	<label>基本工资 /元</label>
                            <span class="field"><input type="text" id="basicSalary"  name="emp.basicSalary" class="smallinput"  disabled="disabled" value="<s:property value="basicSalary" />" disabled="disabled"/></span>
        				 </p>
        				 
        				 <p>
                        	<label>工作状态</label>
                            <span class="field"><input type="text" id="work_status"  name="emp.work_status" class="smallinput"  disabled="disabled"   value="<s:property value="work_status" />" /></span>
        				 </p>
        				 <p>
                        	<label>学历</label>
                           <span class="field"><input type="text"   id="education"  name="emp.education" class="smallinput" value="<s:property value="education" />" disabled="disabled"/></span>     

        				 </p>
        				 <p>
                        	<label>毕业学校</label>
                            <span class="field"><input type="text" id="school"  name="emp.school" class="smallinput" value="<s:property value="school" />" disabled="disabled"/></span>
        				 </p>
        				 <p>
                        	<label>员工技能描述</label>
                            <span class="field"> <textarea cols="80" rows="10" id="employee_skill"  name="emp.employee_skill" disabled="disabled"><s:property value="employee_skill" /></textarea></span>
        				 </p>
        				</s:iterator>

                    </form>
	
                   
            
        
        </div><!--contentwrapper-->
        
        <br clear="all" />
        
	</div><!-- centercontent -->
    <script language="javascript" type="text/javascript">
function form_submit(){
	if (document.getElementById("employee_phone").value=="" || document.getElementById("employee_name").value=="")
	{
		
		return false;
		 
	}
	else{
		document.getElementById("addemp").submit();
	}
	 
	   
}

</script>
    


</body>
</html>
