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
    <h1 class="pagetitle">考勤记录</h1>                    
    </div><!--pageheader-->
    </div>
    <div id="contentwrapper" class="contentwrapper">  
    <form>
    <table cellpadding="0" cellspacing="0" border="0" id="table2" class="stdtable stdtablecb">
                    <colgroup>
                        <col class="con0"/>
                        <col class="con1"/>
                        <col class="con0"/>
                        <col class="con1"/>
                        <col class="con0"/>
                        <col class="con1"/>
                    </colgroup>
                    <thead>
                        <tr>
                        	<th class="head0">员工id</th>
                            <th class="head1">姓名</th>
                            <th class="head0">发包方</th>
                            <th class="head1">项目名称</th>
                            <th class="head0">开始时间</th>
                            <th class="head1">结束时间</th>
                            <th class="head0">请假天数</th>
                            <th class="head1">状态</th>
                        </tr>
                    </thead>
                   <s:iterator value="leave">
                    <tbody>
                        <tr>
                        	<td><s:property value="employee_id"/></td>
                            <td><s:property value="employee_name"/></td>
                            <td><s:property value="boss_name"/></td>
                            <td><s:property value="project_name"/></td>
                            <td><s:property value="start_time"/></td>
                            <td><s:property value="end_time"/></td>
                            <td><s:if test="days < 0">0</s:if>
                            <s:else><s:property value="days"/></s:else></td>
                            <td><s:if test="flag==1">请假中</s:if>
                            <s:else>已销假</s:else>
                            </td>
                        </tr>
                    </tbody>
                    </s:iterator>
                <a href="employee/addHoliday.jsp"><button type="button" class="submit radius2">添加请假记录</button></a>
                <a href="employee-stopHoliday"><button type="button" class="submit radius2">添加销假记录</button></a>   
                </table>
                
    </form>
    </div><!--contentwrapper-->
    <br clear="all" />
	</div><!-- centercontent -->
	</body>
  </html>