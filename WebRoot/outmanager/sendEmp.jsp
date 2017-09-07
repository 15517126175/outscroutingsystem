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
                	<h3>人员派遣</h3>
                </div><!--contenttitle-->
                <div class="tableoptions">
                	 
             
            	<form id="query" action="outmanager-sendProjectQuery" method="post">
            	<table>
            	<tr>
            		<td><input type="text" placeholder="请输入项目id或名称" style="width:200px; height:30px;" name="inport" id="inport"></td>
                	<td><button type="button" class="stdbtn" onclick="form_submit()">查 询</button></td>
                	<td width="65%"></td>
                	<td ><a href="outmanager/send.jsp" class="btn btn_orange btn_link"><span>面试通知</span></a></td>
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
                        	<th class="head0">项目id</th>
                            <th class="head1">项目名称</th>
                            <th class="head0">员工id</th>
                            <th class="head1">员工名称</th>
                           
                            <th class="head1">面试时间</th>
                            <th class="head0">面试地点</th>
                            <th class="head1">面试情况</th>
                            <th class="head0">操作</th>
                        </tr>
                    </thead>
                 	<s:iterator value="procatelist">
                 	<tbody>
                 		<tr>
                 			<td><s:property value="project_id" /></td>
                 			<td><s:property value="project_name" /></td>
                 			<td><s:property value="employee_id" /></td>
                 			<td><s:property value="employee_name" /></td>
                 			<td><s:property value="interview_time" /></td>
                 			<td><s:property value="interview_site" /></td>
                 			
                 			<td>
                 			<s:if test="end==0">正在面试</s:if>
                 			<s:elseif test="end==1">成功</s:elseif>
                 			<s:elseif test="end==3">已处理</s:elseif>
                 			<s:else>失败</s:else>
                 			
                 			</td>
                 		<td><s:if test="end==1"><a href="outmanager-toUpOutEmp?pro_id=<s:property value="project_id" />&emp_id=<s:property value="employee_id" />">上传</a></s:if>
                 			<s:else >无</s:else>
                 			
                 		</td>
                 		
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
