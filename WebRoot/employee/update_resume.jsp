<%@ page language="java" import="java.util.*" pageEncoding="UTF8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>个人信息维护</title>
    
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
    <jsp:include page="mainframe.jsp"></jsp:include>
    <jsp:include page="left.jsp"></jsp:include>
    <div class="centercontent">
    <div class="contenttitle2">
    <div class="pageheader">
    <h1 class="pagetitle">我的简历</h1>                    
    </div><!--pageheader-->
    </div>
    <div id="contentwrapper" class="contentwrapper">
     <h3>维护</h3>
     <form class="stdform" id="edit" action="employee-editResume" method="post">
     <s:iterator value="resume1" id="re">
     <input type="hidden" name="resume1.employee_id" value="${resume1.employee_id}">
     <input type="hidden" name="resume1.resume_id" value="${resume1.resume_id}">
                        <p>
                    	<label>姓名</label>
                            <span class="field"><input type="text" id="name" name="resume1.resume_name"  value="${resume1.resume_name}" class="smallinput" /></span>	
        				</p>
                        <p>
        				<label>性别</label>
        				    <span class="field"><select type="text" id="sex" name="resume1.resume_sex" value="${resume1.resume_sex}" class="smallinput" />  
                        
                 		<option selected="selected">${resume1.resume_sex}</option> 
        				<s:if test="#re.resume_sex == '男'.toString()"><option value="女">女</option></s:if>
        				<s:else><option value="男">男</option></s:else>
                        </select>  
                        </span>
        				</p>
                        <p>
                    	<label>年龄</label>
                            <span class="field"><input type="text" id="age" name="resume1.resume_age"  value="${resume1.resume_age}" class="smallinput" /></span>	
        				</p>
                        <p>
                    	<label>联系电话</label>
                            <span class="field"><input type="text"   id="phone" name="resume1.resume_phone"  value="${resume1.resume_phone}" class="smallinput" /></span>
                        	
        				</p>
                        <p>
                    	<label>电子邮箱</label>
                            <span class="field"><input type="text"   id="email" name="resume1.resume_email"  value="${resume1.resume_email}" class="smallinput" /></span>
                        	
        				</p>
                        <p>
                    	<label>学习经历</label>
                            <span class="field"><input type="text"   id="study" name="resume1.resume_study"  value="${resume1.resume_study}" class="smallinput" /></span>
                        	
        				</p>
        				<p>
        				<label>其他项目经历</label>
                            <span class="field"><input type="text" id="outhistory"  name="resume1.resume_outhistory" value="${resume1.resume_outhistory}" class="smallinput" /></span>
        				  
        				</p>
        				<p>
        				<label>第三方评价</label>
                            <span class="field"><input type="text" id="assess"  name="resume1.resume_assess" value="${resume1.resume_assess}" class="smallinput" /></span>
        				 
        				</p>
        				<p class="stdformbutton">
                        	<button class="submit radius2" onclick="return check()">确认</button>
                            <input type="reset" class="reset radius2" value="重置" />
                        </p>
                        </s:iterator>
        				</form>
    </div><!--contentwrapper-->
    <br clear="all" />
	</div><!-- centercontent -->
	<script language="javascript" type="text/javascript">
	function check(){
	if(document.getElementById("name").value == "" || document.getElementById("age").value == "" || document.getElementById("phone") == "" || document.getElementById("email") == "" ||
			document.getElementById("study").value == "" || document.getElementById("outhistory").value == "" ||
			document.getElementById("assess").value == ""){
		alert("保存出错，出现空值！");
		return false;
	}else{
		document.getElementById("edit").submit();
	}
	}
	</script>
	</body>
  </html>