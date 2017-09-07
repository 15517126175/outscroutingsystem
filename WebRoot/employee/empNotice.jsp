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
    
    <title>员工控制台</title>
    
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
                	<h3>公告</h3>
                </div><!--contenttitle-->
                <div class="tableoptions">
                	 
             
            	<form action="manager-selectNotice" method="post" id="query" >
            	<table width="100%" >
            	<tr>
            		
            		
                	
                </tr>
                </table>
                
                </form>
                </div><!--tableoptions-->
                <tbody>
              <div style="width: 100%">
                  
                   
                   <h1 align="center">${notice.title}</h1> <br>
                   
                   <div  style="float: left;width:520px;text-align: right;" > 发布时间 :</div>
                   <div  style="float: left;width:300px">${notice.puttime}</div> 
                   
                    <div style="width: 80%;float: right;"><p>${notice.content } </p></div>
                   
                    
               </div>
               </tbody>
                
                <div style="position: fixed; bottom: 20px; ">
                 <s:iterator value="notice">
                <label> 附件: </label>
                <a href="manager-download?fileName=<s:property value="file_name"/>" >${notice.file_name}</a>                
                </div>
                 </s:iterator>
        <br clear="all" />
        </div>
	</div><!-- centercontent -->
        
        <br clear="all" />
        
	</div><!-- centercontent -->
    
    


</body>
</html>
