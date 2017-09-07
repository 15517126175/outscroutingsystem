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
                	<h3>员工信息管理</h3>
                </div><!--contenttitle-->
                <div class="tableoptions">
                	 
             
            	<form action="manager-selectEmp" method="post" id="query">
            	<table>
            	<tr>
            		
            		<td><input type="text" placeholder="" style="width:200px; height:30px;" name="inport" id="inport"></td>
                	<td><input type="submit" class="stdbtn" value="查询" /></td>
                	<td width="55%"></td>
                	<td><a href="manager/addemp.jsp" class="btn btn_orange btn_link"><span>添加</span></a></td>
                </tr>
                </table>	
                </form>
                </div><!--tableoptions-->
                
               <table cellpadding="0" cellspacing="0" border="0" class="stdtable">
                    <colgroup>
                        
                        <col class="con1" />
                        <col class="con0" />
                        <col class="con1" />
                        <col class="con0" />
                        <col class="con1" />
                         <col class="con0" />
                        <col class="con1" />
                       
                       
                    </colgroup>
                    <thead>
                        <tr>
                        	
                            <th class="head" style="display: none;" >员工id</th>
                            <th class="head1">员工姓名</th>
                            <th class="head2">员工性别</th>
                            <th class="head3">年龄</th>
                            <th class="head4">员工电话</th>
                            <th class="head5">员工邮箱</th>                       
                            <th class="head6">外派情况</th>
                            <th class="head7">操作</th>

                            
                        </tr>
                    </thead>
                   <s:iterator value="emplist">
                    <tbody>
                        
                        <tr>
                        	
                            <td style="display: none;"><s:property value="employee_id" /></td>
                            <td ><s:property value="employee_name" /></td>
                            <td><s:property value="employee_sex" /></td>
                            <td><s:property value="employee_age" /></td>
                           	<td><s:property value="employee_phone" /></td>
                           	<td><s:property value="employee_email" /></td>
                           
                           	<td><s:if test='work_status== "U" '>外派</s:if>
                 			<s:elseif test='work_status== "E" '>无</s:elseif> </td>   
                 			<td class="center"><a href="manager-toEditEmp?employee_id=<s:property value="employee_id " />" class="btn btn3 btn_link"></a> &nbsp; 
                            <a href="manager-deleteEmp?id=<s:property value="employee_id" />" onclick="return isdelete()" class="btn btn3 btn_trash" ></a></td>
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
     function isdelete(){
    	 var i=window.confirm("您确定删除吗");     
    	 return i;
	
}
     function deleteAll(){
    	 if(confirm("您确定删除所选的记录吗？")){
    		 document.getElementById("deall").submit();
    	 }
    	 
     }
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
