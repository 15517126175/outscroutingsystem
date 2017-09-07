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
    
    <title>员工个人工作汇总</title>
    
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
    <h1 class="pagetitle">统计</h1>                    
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
                        <col class="con0"/>
                        <col class="con1"/>
                    </colgroup>
                    <thead>
                        <tr>
                            <th class="head0">员工id</th>
                            <th class="head1">姓名</th>
                        	
                        </tr>
                        <tr>
                        	<td>${userid}</td>
                            <td>${user}</td>
                        </tr>
                        <tr>
                            <th class="head0">在职时间(天)</th>
                            <th class="head1">外派任务次数</th>
                            
                        </tr>
                        <tr>
                            <td>${workday}</td>
                            <td>${worktotal}</td>
                        </tr>
                        <tr>
                            <th class="head0">项目类型分布</th>
                            <th class="head1">外派城市分布</th>
                            
                        </tr>
                        <tr>
                        
                            <td>${worktypelist}</td>
                            <td>${workcitylist}</td>
                        </tr>
                        <tr>
                            <th class="head0">总工时(天)</th>
                            <th class="head1">总休假(天)</th>
                        </tr>
                        
                        <tr>
                            <td>${workdays}</td>
                            <td>${holiday}</td>
                        </tr>
                    </thead>
                    <tbody>
                        
                        
                    </tbody>
                      
                </table>
                
    </form>
    </div><!--contentwrapper-->
    <br clear="all" />
	</div><!-- centercontent -->
	</body>
  </html>