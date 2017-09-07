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
    
    <title>信息查看</title>
    
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
    <h1 class="pagetitle">面试信息</h1>  
              
    </div><!--pageheader-->
    </div>
    <div id="contentwrapper" class="contentwrapper">  
		<div id="inbox" class="subcontent">
		<form id="query" action="employee-selectInterview" method="post">
            	<table>
            	<tr>
            		<td><input type="text" placeholder="请输入项目id或名称" style="width:200px; height:30px;" name="inport" id="inport"></td>
                	<td><button type="button" class="stdbtn" onclick="form_submit()">查 询</button></td>
                	<td width="55%"></td>
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
                    </colgroup>
                    <thead>
                        <tr>
                        	
                            <th class="head1">项目编号</th>
                            <th class="head0">项目名称</th>
                            <th class="head1">员工姓名</th>
                            <th class="head0">面试时间</th>
                            <th class="head1">面试地点</th>
                            <th class="head1">操作</th>
                        </tr>
                    </thead>
                   <s:iterator value="pjac">
                    <tbody>
                        <tr>
                        	
                            <td><s:property value="project_id"/></td>
                            <td><s:property value="project_name"/></td>
                            <td><s:property value="employee_name"/></td>
                           	<td><s:property value="interview_time"/></td>
                           	<td><s:property value="interview_site"/></td>
                            <td><s:if test="end == 0"><a href="employee-result?pid=<s:property value="project_id"/>"><button type="button" class="submit radius2">回馈</button></a></s:if>
                            <s:elseif test="end == 1">面试成功</s:elseif>
                            <s:elseif test="end == 2">面试失败</s:elseif>
                            <s:else>外派中</s:else></td> 
                        </tr>
                    </tbody>
                    </s:iterator>
                   
                </table>
                
                </form>
		</div>
    </div><!--contentwrapper-->
    <br clear="all" />
	</div><!-- centercontent -->
	<script language="javascript" type="text/javascript">
	function form_submit(){
   	 if(document.getElementById("inport").value == ""){
   		 alert("请输入查询信息！");
			    return false;
   	 }else{
   		 document.getElementById("query").submit();
   	 }

	}
	</script>
	</body>
  </html>