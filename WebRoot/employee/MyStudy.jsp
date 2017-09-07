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
    
    <title>培训查看</title>
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
    <h1 class="pagetitle">我的培训</h1>                    
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
                    </colgroup>
                    <thead>
                        <tr>
                        	<th class="head0">编号</th>
                            <th class="head1">课题名称</th>
                            <th class="head1">计划开始时间</th>
                            <th class="head1">操作</th>
                        </tr>
                    </thead>
                   <s:iterator value="tr">
                    <tbody>
                        <tr>
                        	<td><s:property value="train_id"/></td>
                            <td><a href="employee-lookTrain?id=<s:property value="train_id"/>"><button type="button" class="submit radius2"><s:property value="train_title"/></button></a></td>
                            <td><s:property value="train_time"/></td>
                            <td>
                            <a href="employee-remove?id=<s:property value="train_id"/>" onclick="return isremove()"><button type="button" class="submit radius2">取消</button></a>
                            
                            &nbsp; &nbsp;<a href="employee-tofeedback?id=<s:property value="train_id"/>"><button type="button" class="submit radius2">评价</button></a>
                            </td>
                            
                   
                           
                        </tr>
                    </tbody>  
                   </s:iterator>
                </table>
                <a href="employee-joinTrain"><button type="button" class="submit radius2">报名新的培训</button></a>&nbsp;&nbsp;&nbsp;
                
    </form>
    
    </div><!--contentwrapper-->
    <div align="right">
                ${pagerinfo}<br/>
            	</div>
    <br clear="all" />
	</div><!-- centercontent -->
	<script language="javascript" type="text/javascript">
     function isremove(){
    	 var i=window.confirm("您确定取消本次培训吗?");     
    	 return i;
     } 
     </script>
	</body>
  </html>