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
<script type="text/javascript" src="js/plugins/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery.uniform.min.js"></script>
<script type="text/javascript" src="js/custom/general.js"></script>
<script type="text/javascript" src="js/custom/tables.js"></script>
<!--[if IE 9]>
    <link rel="stylesheet" media="screen" href="css/style.ie9.css"/>
<![endif]-->
<!--[if IE 8]>
    <link rel="stylesheet" media="screen" href="css/style.ie8.css"/>
<![endif]-->
<!--[if lt IE 9]>
	<script src="js/plugins/css3-mediaqueries.js"></script>
<![endif]-->


  </head>
  		
  <body class="withvernav">

    <jsp:include page="mainframe.jsp"></jsp:include>
    <jsp:include page="left.jsp"></jsp:include>
  
        
    <div class="centercontent">
 
        <div id="contentwrapper" class="contentwrapper">
        
        	  <div class="contenttitle2">
                	<h3>员工薪资管理</h3>
                </div><!--contenttitle-->
                <div class="tableoptions">
                	 
             
            	<form id="query" action="outmanager-queryEmpSalary" method="post">
            	<table>
            	<tr>
            		<td><input type="text" placeholder="输入员工名称或id" style="width:200px; height:30px;" name="inport" id="inport"></td>
                	<td><button type="button" class="stdbtn" onclick="form_submit()">查 询</button></td>
                </tr>
                </table>	
                </form>
                </div><!--tableoptions-->
                
               <table cellpadding="0" cellspacing="0" border="0" class="stdtable">
                    <colgroup>
                        <col class="con0" />
                        <col class="con1" />
                        <col class="con0" />
                        <col class="con1" />
                        <col class="con0" />
                        <col class="con1" />
                       
                    </colgroup>
                    <thead>
                        <tr>
                            <th class="head1">员工id</th>
                            <th class="head0">员工名称</th>
                            <th class="head1">基本工资</th>
                            <th class="head0">项目工资</th>
                            <th class="head1">外包项目名称</th>
                           
                        </tr>
                    </thead>
                   <s:iterator value="salarylist">
                    <tbody>
                        
                        <tr>
                        	
                            <td><s:property value="employee_id" /></td>
                            <td ><s:property value="employee_name" /></td>
                           
                           	<td><s:property value="basicSalary" /></td>
                           	<td><s:property value="employee_sex" /></td>
                           	<td><s:property value="employee_email" /></td>    
                        </tr>
                    </tbody>
                    </s:iterator>
                    
                </table>
                
                <div align="right">
                ${pagerinfo }<br/>
            	</div>
        
        <br clear="all" />
        </div>
	</div><!-- centercontent -->
 <script language="javascript" type="text/javascript">
 function form_submit(){
	 if(document.getElementById("inport").value==""){
		 alert("请输入查询信息！");
		    return false;
	 }else{
		 document.getElementById("query").submit();
	 }

}
     
</script>
</body>

</html>
