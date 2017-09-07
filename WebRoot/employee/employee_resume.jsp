<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查看个人简历</title>
    
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
	<script type="text/javascript" src="js/custom/receive.js"></script>
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
     <h3>查看</h3>
                <form id="form" action="employee-deleteResume" method="post">	
                <table cellpadding="0" cellspacing="0" border="0" id="table1" class="stdtable stdtablecb">
                    <colgroup>
                        <col class="con1" />
                        <col class="con0" />
                        <col class="con1" />
                    </colgroup>
                    <thead>
                        <tr>
                            <th class="head1">姓名</th>
                            <th class="head0">性别</th>
                            <th class="head1">年龄</th>
                        </tr>
                    </thead>
                   <s:iterator value="resume">
                    <tbody>
                        <tr>
                            <td><s:property value="resume_name" /></td>
                            <td><s:property value="resume_sex" /></td>
                            <td><s:property value="resume_age" /></td>
                        </tr>
                    </tbody>
                    </s:iterator> 
                </table>
                <table cellpadding="0" cellspacing="0" border="0" id="table2" class="stdtable stdtablecb">
                <colgroup>
                        <col class="con0" />
                        <col class="con1" />
                </colgroup>
                    <thead>
                        <tr>
                            <th class="head0">联系号码</th>
                            <th class="head1">电子邮箱</th>  
                        </tr>
                    </thead>
                   <s:iterator value="resume">
                    <tbody>
                        <tr>
                            <td><s:property value="resume_phone" /></td>
                            <td ><s:property value="resume_email" /></td>   
                        </tr>
                    </tbody>
                    </s:iterator> 
                </table> 
                <table cellpadding="0" cellspacing="0" border="0" id="table2" class="stdtable stdtablecb">
                <colgroup>
                        <col class="con0" />
                        <col class="con1" />
                        <col class="con0" />
                </colgroup>
                    <thead>
                        <tr>
                            <th class="head0">技能领域</th>
                            <th class="head1">学历</th>
                            <th class="head0">毕业学校</th>  
                        </tr>
                    </thead>
                   <s:iterator value="info">
                    <tbody>
                        <tr>
                            <td><s:property value="employee_skill" /></td>
                            <td ><s:property value="education" /></td>
                            <td><s:property value="school" /></td>   
                        </tr>
                    </tbody>
                    </s:iterator> 
                </table>
                <table cellpadding="0" cellspacing="0" border="0" id="table3" class="stdtable stdtablecb">
                <colgroup>
                        <col class="con0" />
                </colgroup>
                    <thead>
                        <tr>
                            <th class="head0">学习经历</th>  
                        </tr>
                    </thead>
                   <s:iterator value="resume">
                    <tbody>
                        <tr>
                            <td><s:property value="resume_study" /></td>   
                        </tr>
                    </tbody>
                    </s:iterator> 
                </table>
                <table cellpadding="0" cellspacing="0" border="0" id="table3" class="stdtable stdtablecb">
                <colgroup>
                        <col class="con0" />
                </colgroup>
                    <thead>
                        <tr>
                            <th class="head0">在职外派经历</th>  
                        </tr>
                    </thead>
                   
                </table> 
                <table cellpadding="0" cellspacing="0" border="0" id="table4" class="stdtable stdtablecb">
     
                <colgroup>
                        <col class="con1" />
                </colgroup>
                    <thead>
                        <tr>
                            <th class="head0">外派项目名</th> 
                            <th class="head1">外派项目类型</th>
                            <th class="head0">个人负责内容</th>
                        </tr>
                    </thead>
                    <s:iterator value="oe">
                    <tbody>
                        <tr>
                            <td><s:property value="project_name" /></td>
                            <td><s:property value="project_type" /></td>
                            <td><s:property value="work_type" /></td>  
                        </tr>
                    </tbody>
                    </s:iterator> 
                </table>
                <table cellpadding="0" cellspacing="0" border="0" id="table3" class="stdtable stdtablecb">
                <colgroup>
                        <col class="con0" />
                </colgroup>
                    <thead>
                        <tr>
                            <th class="head0">其他工作经验</th>  
                        </tr>
                    </thead>
                   <s:iterator value="resume">
                    <tbody>
                        <tr>
                            <td><s:property value="resume_outhistory" /></td>   
                        </tr>
                    </tbody>
                    </s:iterator> 
                </table>
                <table cellpadding="0" cellspacing="0" border="0" id="table3" class="stdtable stdtablecb">
                <colgroup>
                        <col class="con0" />
                </colgroup>
                    <thead>
                        <tr>
                            <th class="head0">第三方评价</th>  
                        </tr>
                    </thead>
                   <s:iterator value="resume">
                    <tbody>
                        <tr>
                            <td><s:property value="resume_assess" /></td>   
                        </tr>
                    </tbody>
                    </s:iterator> 
                </table> 
                <table cellpadding="0" cellspacing="0" border="0" id="table6" class="stdtable stdtablecb">
                <s:iterator value="resume">
                <colgroup>
                        <col class="con1" />
                </colgroup>
                    <thead>
                        <tr>
                            <th class="head1"><s:if test="local_resume==null"><button type="button" onclick="openwindows()">上传本地简历</button></s:if><s:else>
                 		<a href="employee/MyHtml.html">预览本地简历</a></s:else></th>  
                        </tr>
                    </thead>
                    </s:iterator> 
                </table>  
                <button type="button" class="submit radius2" onclick="updateResume()">修改当前简历</button>
                <button type="submit" class="submit radius2" onclick="return deleteResume()">删除当前简历</button>
                <button type="button" class="submit radius2" onclick="hairResume()">上发简历至服务器</button>
                <button type="button" class="submit radius2" onclick="downResume()">下载简历至本地</button></a>
                </form>
        <br clear="all" />
        </div>
	</div><!-- centercontent -->
	
 <script language="javascript" type="text/javascript">
     function deleteResume(){
    	 var i=window.confirm("您确定删除吗?");     
    	 return i;
     } 
     function updateResume(){
    	 window.location.href='employee-toEditResume';
     }
     function downResume(){
    	 window.location.href='employee-downResume';
     }
     function hairResume(){
    	 window.location.href='employee-hairResume';
     }
     
     function openwindows(){ 
 		 window.open ("employee/upResume.jsp","Sample","fullscreen=yes,toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no, copyhistory=no,width=350,height=200,left=250,top=300");
 	  } 
</script>
</body>

</html>