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
                	<h3>规章信息</h3>
                </div><!--contenttitle-->
                <div class="tableoptions">
                	 
             
            	<form action="manager-selectinstitution" method="post" id="query">
            	<table>
            	<tr>
            		                	
                	<td><a href="manager/addInsitution.jsp" class="btn btn_orange btn_link"><span>添加</span></a></td>
                </tr>
                </table>	
                </form>
                </div><!--tableoptions-->
                
              <div>
                   <table width="100%" style="border-collapse: separate;border-spacing: 10px">
                   <s:iterator value="institutionlist">
                    <tbody>
                        
                        <tr >
                        	<td width="80%"><div style="width:80%;"><a href="manager-selectInstitution?institution_id=<s:property value="institution_id" />"><s:property value="institution_name" /></a></div>	</td>              	
                        	                      
                        </tr>             			     
                       
                    </tbody>
                    </s:iterator>
                    </table>
               </div>
                
                <div align="right">
                ${pagerinfo }<br/>
            	</div>
        
        <br clear="all" />
        </div>
	</div><!-- centercontent -->
 <script language="javascript" type="text/javascript">

     
</script>
</body>

</html>
