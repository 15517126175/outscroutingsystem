<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>创建个人简历</title>
    
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
            <h1 class="pagetitle">简历创建</h1>                  
        </div><!--pageheader-->
        
        <div id="contentwrapper" class="contentwrapper">
        
        	 <h3>创建个人简历</h3>                   
                    <form class="stdform" id="addresume" action="employee-addResume" enctype="multipart/form-data" method="post" >
        				 <input type="hidden" name="resume1.employee_id" value="${sessionScope.userid}"/>
        				 <p>
                        	<label>姓名</label>
                            <span class="field"><input type="text"   id="resume_name"  name="resume1.resume_name" value="${resumename}"/></span> 
        				 </p>
        				  <p>
                        	<label>性别</label>
                            <span class="field"><input type="text" id="resume_sex"  name="resume1.resume_sex" value="${resumesex}"/>
                            
                            </span>
        				 </p>
        				 <p>
                        	<label>年龄</label>
                            <span class="field"><input type="text" id="resume_age"  name="resume1.resume_age" value="${resumeage}"/></span>
        				 </p>
        				 <p>
                        	<label>联系电话</label>
                            <span class="field"><input type="text" id="resume_phone"  name="resume1.resume_phone" value="${resumephone}"/></span>
        				 </p>
        				 <p>
                        	<label>电子邮箱</label>
                            <span class="field"><input type="text" id="resume_email"  name="resume1.resume_email" value="${resumeemail}"/></span>
        				 </p>
        				 <p>
                        	<label>学习经历</label>
                            <span class="field"><input type="text" id="resume_study"  name="resume1.resume_study"/></span>
        				 </p>
        				 <p>
                        	<label>其他工作经验：</label>
                            <span class="field"><input type="text" id="resume_outhistory" name="resume1.resume_outhistory" placeholder="请填写曾经的项目经历"/></span>
        				 </p>
        				 <p>
                        	<label>第三方评价</label>
                            <span class="field"><input type="text" id="resume_assess"  name="resume1.resume_assess"/></span>
        				 </p>
        				 <p>
                        	<label>上传本地简历</label>
                            <span class="field"><input type="file" id="local_resume"  name="file1"/></span>
        				 </p>
        				 <p class="stdformbutton">
                        	<button type="button" class="submit radius2" onclick="isnull()">确认</button>
                            <input type="reset" class="reset radius2" value="重置" />
                         </p>

                    </form>
	
                   
            
        
        </div><!--contentwrapper-->
        
        <br clear="all" />
        
	</div><!-- centercontent -->
    <script language="javascript" type="text/javascript">
function isnull(){
	if (document.getElementById("resume_study").value=="" || document.getElementById("resume_outhistory").value=="" || document.getElementById("resume_assess").value=="")
	{
		alert("出现空值！");
		return false;		 
	}
	else{
		document.getElementById("addresume").submit();
	}	   
}
</script>
</body>
</html>
