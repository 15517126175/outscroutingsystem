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
            <h1 class="pagetitle">培训信息</h1>                  
        </div><!--pageheader-->
    </div>   
    
        <form action="manager-selectTrain" method="post" id="query">
            	<table>
            	<tr>
            		
            		
                </tr>
                </table>	
         </form>
        <div id="contentwrapper" class="contentwrapper"> 
        <form>                 
        <table cellpadding="0" cellspacing="0" border="0" id="table2" class="stdtable stdtablecb">
                    
                 
                    <thead>
                        <tr>
                        	
                            <th class="head1">姓名</th>
                            
                            <th class="head1">老师评价</th>
                           
                            <th class="head1">培训评价</th>
                        </tr>
                    </thead>
                  
                    <tbody>
                     <c:forEach items="${telist}" var="temp" varStatus="loop">
                        <tr>
                        	<td>${emplist[loop.count-1].employee_name}</td>
                            <td>${temp.feed_trainer}</td>
                            <td>${temp.feed_train}</td>
                            
                        </tr>
                         </c:forEach>
                    </tbody>
                  
        			</table>	 
                    </form>
	
                   
             <div align="right">
                ${pagerinfo }<br/>
            	</div>
        
        </div><!--contentwrapper-->
        
        <br clear="all" />
        
	</div><!-- centercontent -->
</body>
</html>
