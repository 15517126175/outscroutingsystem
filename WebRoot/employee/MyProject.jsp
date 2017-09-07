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
    <h1 class="pagetitle">我的任务</h1>                    
    </div><!--pageheader-->
    </div>
    <div id="contentwrapper" class="contentwrapper">  
    <form id="query" action="employee-selectProject" method="post">
            	<table>
            	<tr>
            		<td><input type="text" placeholder="请输入项目名称" style="width:200px; height:30px;" name="name" id="name"></td>
            		<td><input type="text" placeholder="请输入工作城市" style="width:200px; height:30px;" name="city" id="city"></td>
            		<td><input type="text" placeholder="请输入项目类型" style="width:200px; height:30px;" name="type" id="type"></td>
                	<td><button type="button" class="stdbtn" onclick="form_submit()">查 询</button></td>
                	
                    <td><a href="employee-toCloseTask"><button type="button" class="submit radius2">项目完成提交</button></a></td>
                </tr>
                </table>	
        </form>
    <form>
    <table cellpadding="0" cellspacing="0" border="0" id="table2" class="stdtable stdtablecb">
                    <colgroup>
                        <col class="con0"/>
                        <col class="con1"/>
                        <col class="con0"/>
                        <col class="con1"/>
                        <col class="con0"/>
                        <col class="con1"/>
                        <col class="con0"/>
                        <col class="con1"/>
                        <col class="con0"/> 
                    </colgroup>
                    <thead>
                        <tr>
                        	<th class="head0">姓名</th>
                            <th class="head1">联系电话</th>
                            <th class="head0">项目名称</th>
                            <th class="head1">薪酬</th>
                            <th class="head0">确认时间</th>
                            <th class="head1">开始时间</th>
                            <th class="head0">结束时间</th>
                            <th class="head1">当前状态</th>
                            <th class="head0">操作</th>
                        </tr>
                    </thead>
                   <s:iterator value="oe">
                    <tbody>
                        <tr>
                        	<td><s:property value="employee_name"/></td>
                            <td><s:property value="employee_phone"/></td>
                            <td><s:property value="project_name"/></td>
                            <td><s:property value="salary"/></td>
                            <td><s:property value="enter_time"/></td>
                            <td><s:property value="star_time"/></td>
                            <td><s:property value="end_time"/></td>
                            <td><s:if test="worker_status==2">已完成</s:if>
                            <s:elseif test="worker_status==3">请假中</s:elseif>
                            <s:else>进行中</s:else>
                            </td>
                            <td >
                            <a href="employee-viewProject?proname=<s:property value="project_name"/>"><button type="button" class="submit radius2">查看明细</button></a></td>
                        </tr>
                    </tbody>
                    </s:iterator>
                   
                </table>
                
    </form>
    </div><!--contentwrapper-->
    <div align="right">
                ${pagerinfo}<br/>
            	</div>
    <br clear="all" />
	</div><!-- centercontent -->
	<script language="javascript" type="text/javascript">
	function form_submit(){
   	 if(document.getElementById("name").value == "" && document.getElementById("city").value == "" && document.getElementById("type").value == ""){
   		 alert("请输入查询信息！");
			    return false;
   	 }else{
   		 document.getElementById("query").submit();
   	 }

	}
	</script>
	</body>
  </html>