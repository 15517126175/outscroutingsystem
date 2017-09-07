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
                	<h3>论坛回复</h3>
                </div><!--contenttitle-->
                <div class="tableoptions">
                	 
             
            	<form action="" method="post" id="query">
            	<table>
            	<tr>
            		
            		
                	
                </tr>
                </table>	
                </form>
                </div><!--tableoptions-->
                
               <table cellpadding="0" cellspacing="0" border="0" class="stdtable" width="100%">
                  
                    <thead>
                        <tr>
                        	
                            <th class="head"  width="20%" style="background:yellow">发表人</th>
                            <th class="head1" width="80%" style="background:yellow">${forum.forum_title}</th>
                            

                            
                        </tr>
                        <tr>
                    <th class="head"  width="20%">${forum.forum_peoname}</th>
                     <th class="head1" width="80%">${forum.forum_content}</th>
                    </tr>
                     <tr>
                    <th class="head"  width="20%" style="padding: 0px">${forum.forum_puttime}</th>
                     <th class="head1" width="80%"></th>
                    </tr>
                    </thead>
                    
                  
                    
                    
                   <s:iterator value="replylist">
                    <tbody>
                        
                        <tr>
                        	
                            <td width="20%"><s:property value="reply_empname" /></td>
                            <td width="80%"><s:property value="reply_content" /></td>
                 			
                        </tr>             			     
                       
                    </tbody>
                    <tbody>
                     <tr>
                        	
                            <td width="20%" height="3px" style="padding: 0px"><span style="font-size: 4px"><s:property value="reply_time" /></span></td>
                            <td width="80%" height="3px" style="padding: 0px"><span><s:property value="" /></span></td>
                 			
                        </tr>             			     
                    </tbody>
                    </s:iterator>
                    
                </table>
                
                <div align="right">
                ${pagerinfo }<br/>
            	</div>
            	<form action="employee-sendReply" method="post">
            	
            	<div align="center">
            	<input value="${forum.forum_id}" name="forum_id" type="hidden"/>
            	<div style="float: left;width: 250px;padding: 0px;margin: 0px"><label>回复:</label></div>
            	<div style="float: left;"><textarea rows="5" cols="100" name="reply.reply_content"></textarea> </div>
            	          	
            	</div>
            	
            	<div style="float: right;width: 200px;height: 200px;"> <input type="submit" class="stdbtn" value="发送"></input> </div>
        </form>
        <br clear="all" />
        </div>
	</div><!-- centercontent -->
 <script language="javascript" type="text/javascript">
     
     
</script>
</body>

</html>
