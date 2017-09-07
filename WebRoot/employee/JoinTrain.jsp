<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>培训报名</title>
    
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
    <div class="contenttitle2">
        <div class="pageheader">
            <h1 class="pagetitle">培训报名</h1>                  
        </div><!--pageheader-->
    </div>   
        <div id="contentwrapper" class="contentwrapper"> 
        <form id="query" action="employee-selectTrain" method="post">
            	<table>
            	<tr>
            		<td><input type="text" placeholder="请输入培训课程id或名称" style="width:200px; height:30px;" name="inport" id="inport"></td>
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
                    </colgroup>
                    <thead>
                        <tr>
                        	<th class="head0">课题编号</th>
                            <th class="head1">课题名称</th>
                            <th class="head0">课题概述</th>
                            <th class="head1">开课时间</th>
                            <th class="head0">课程时长</th>
                            <th class="head1">主讲人</th>
                            <th class="head0">地点</th>
                            <th class="head1">操作</th>
                        </tr>
                    </thead>
                   <s:iterator value="t" id="t">
                    <tbody>
                        <tr>
                        	<td><s:property value="train_id"/></td>
                            <td><button type="button" class="submit radius2"><a href="employee-lookTrain?id=<s:property value="train_id"/>"><s:property value="train_title"/></a></button></td>
                            <td><s:property value="train_content"/></td>
                            <td><s:property value="train_time"/></td>
                            <td><s:property value="train_days"/></td>
                            <td><s:property value="train_trainer"/></td>
                            <td><s:property value="train_place"/></td>
                            <td><s:if test="status == 2">尚未开放</s:if>
                            <s:else><button type="button" class="submit radius2"><a href="employee-choseTitle?id=<s:property value="train_id"/>">点击报名</a></button></s:else></td>
                            
                        </tr>
                    </tbody>
                    </s:iterator>
        			</table>	 
                    </form>
	
                   
            
        
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
