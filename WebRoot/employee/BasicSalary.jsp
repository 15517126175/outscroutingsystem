<%@ page language="java" import="java.util.*" pageEncoding="UTF8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>个人薪资</title>
    
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
    <div id="contentwrapper" class="contentwrapper">  
    <div class="contenttitle2">
    <div class="pageheader">
    <h1 class="pagetitle">我的薪资</h1>                    
    </div><!--pageheader-->
                </div><!--contenttitle-->
                
               <table cellpadding="0" cellspacing="0" border="0" class="stdtable">
                    <colgroup>
                        <col class="con0" />
                        <col class="con1" />
                        <col class="con0" />
                        <col class="con1" />
                        <col class="con0" />
                        <col class="con1" />
                        <col class="con0" />
                    </colgroup>
                    <thead>
                        <tr>
                            <th class="head1">员工id</th>
                            <th class="head0">员工名称</th>
                            <th class="head1">项目名称</th>
                            <th class="head0">餐补</th>
                            <th class="head1">交通补助</th>
                            <th class="head0">基本工资</th>
                            <th class="head1">项目薪酬(月)</th>
                           
                        </tr>
                    </thead>
                   <s:iterator value="oe">
                   <s:iterator value="info" id="in">
                    <tbody>
                        
                        <tr>
                        	
                            <td>${userid }</td>
                            <td>${user }</td>
                           	<td><s:property value="project_name" /></td>
                           	<td><s:property value="city" /></td>
                           	<td><s:property value="project_type" /></td> 
                           	<td>${sessionScope.basicSalary }</td>
                           	<td><s:property value="salary" /></td>   
                        </tr>
                    </tbody>
                    </s:iterator>
                    </s:iterator>
                    
                </table>
                
               
    </div><!--contentwrapper-->
    <br clear="all" />
	</div><!-- centercontent -->
	</body>
  </html>