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
                	<h3>发包方信息</h3>
                </div><!--contenttitle-->
                <div class="tableoptions">
                	 
             
            	<form action="outmanager-selectBoss" id="query" method="post">
            	<table>
            	<tr>
            		<td><a onclick="deleteAll()" class="btn btn_orange btn_trash"><span>全删</span></a></td>
            		<td><input type="text" placeholder="请输入发包方id或名称" style="width:200px; height:30px;" name="inport" id="inport"></td>
                	<td><button type="button" class="stdbtn" onclick="form_submit()">查 询</button></td>
                	<td width="55%"></td>
                	<td ><a href="outmanager/addBoss.jsp" class="btn btn_orange btn_link"><span>添加</span></a></td>
                </tr>
                </table>	
                </form>
            		
            	
            
                </div><!--tableoptions-->
                <form action="outmanager-deleteAll" id="deall" method="post">	
                <table cellpadding="0" cellspacing="0" border="0" id="table2" class="stdtable stdtablecb">
                    <colgroup>
                        <col class="con0" style="width: 4%" />
                        <col class="con1" />
                        <col class="con0" />
                        <col class="con1" />
                        <col class="con0" />
                        <col class="con1" />
                       
                    </colgroup>
                    <thead>
                        <tr>
                        	<th class="head0"><input type="checkbox" class="checkall"  /></th>
                            <th class="head1">发包方id</th>
                            <th class="head0">发包方名称</th>
                            <th class="head1">发包方联系人</th>
                            <th class="head0">发包方电话</th>
                            <th class="head1">操作</th>
                        </tr>
                    </thead>
                   <s:iterator value="boss">
                    <tbody>
                        
                        <tr>
                        	<td align="center"><input type="checkbox" name="ids" value="<s:property value="boss_id" />" /></td>
                            <td><s:property value="boss_id" /></td>
                            <td ><s:property value="boss_name" /></td>
                            <td><s:property value="linkman" /></td>
                            <td><s:property value="phone_number" /></td>
                           
                            <td class="center"><a href="outmanager-toEditBoss?bossid=<s:property value="boss_id" />" class="btn btn3 btn_link"></a> &nbsp; 
                            <a href="outmanager-deleteBoss?id=<s:property value="boss_id" />" onclick="return isdelete()" class="btn btn3 btn_trash" ></a></td>
                        </tr>
                    </tbody>
                    </s:iterator>
                    
                </table>
                </form>
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
