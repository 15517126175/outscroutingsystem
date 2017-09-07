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
    
    <title>任务查看</title>
    
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
    <h1 class="pagetitle">任务明细</h1>                    
    </div><!--pageheader-->
    </div>
    <div id="contentwrapper" class="contentwrapper">  
    <form>
    <table cellpadding="0" cellspacing="0" border="0" id="table2" class="stdtable stdtablecb">
                    <colgroup>
                    	<col class="con1"/>
                        <col class="con0"/>
                        <col class="con1"/>
                    </colgroup>
                    <thead>
                        <tr>
                       		<th class="head1">项目id</th>
                        	<th class="head0">项目名称</th>
                            <th class="head1">项目类型</th>
                            
                        </tr>
                    </thead>
                   <s:iterator value="op">
                    <tbody>
                        <tr>
                        	<td><s:property value="project_id"/></td>
                        	<td><s:property value="project_name"/></td>
                            <td><s:property value="proiect_type"/></td>
                           
                        </tr>
                    </tbody>
                    </s:iterator>
                </table>
      <table cellpadding="0" cellspacing="0" border="0" id="table2" class="stdtable stdtablecb">
                    <colgroup>
                    	<col class="con1"/>
                        <col class="con0"/>
                        <col class="con1"/>
                    </colgroup>
                    <thead>
                        <tr>
                       		<th class="head1">发包方</th>
                        	<th class="head0">工作城市</th>
                            <th class="head1">确认时间</th>
                            
                        </tr>
                    </thead>
                   <s:iterator value="op">
                    <tbody>
                        <tr>
                        	<td><s:property value="boss_name"/></td>
                        	<td><s:property value="city"/></td>
                            <td><s:property value="enter_time"/></td>
                           
                        </tr>
                    </tbody>
                    </s:iterator>
                </table>          
         <table cellpadding="0" cellspacing="0" border="0" id="table2" class="stdtable stdtablecb">
                    <colgroup>
                    	<col class="con1"/>
                        <col class="con0"/>
                        <col class="con1"/>
                        <col class="con0"/>
                    </colgroup>
                    <thead>
                        <tr>
                       		<th class="head1">开始时间</th>
                        	<th class="head0">结束时间</th>
                            <th class="head1">预计工时</th>
                            <th class="head0">项目当前状态</th>
                        </tr>
                    </thead>
                   <s:iterator value="op">
                    <tbody>
                        <tr>
                        	<td><s:property value="star_time"/></td>
                        	<td><s:property value="end_time"/></td>
                            <td><s:property value="woker_time"/></td>
                            <td><s:if test="project_flage==2">已完成</s:if>
                            <s:else>未完成</s:else></td>
                        </tr>
                    </tbody>
                    </s:iterator>
                </table> 
                <table cellpadding="0" cellspacing="0" border="0" id="table2" class="stdtable stdtablecb">
                    <colgroup>
                    	<col class="con1"/>
                        <col class="con0"/>
                        <col class="con1"/>
                    </colgroup>
                    <thead>
                        <tr>
                       		<th class="head1">发包方</th>
                        	<th class="head0">工作城市</th>
                            <th class="head1">确认时间</th>
                            
                        </tr>
                    </thead>
                   <s:iterator value="op">
                    <tbody>
                        <tr>
                        	<td><s:property value="boss_name"/></td>
                        	<td><s:property value="city"/></td>
                            <td><s:property value="enter_time"/></td>
                           
                        </tr>
                    </tbody>
                    </s:iterator>
                </table>      
    </form>
    </div><!--contentwrapper-->
    <br clear="all" />
	</div><!-- centercontent -->
	</body>
  </html>