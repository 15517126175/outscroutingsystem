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
                	<h3>外包项目管理</h3>
                </div><!--contenttitle-->
                 <div class="tableoptions">
            	<form action="outmanager-queryProject" id="query" method="post" >
            	<table>
            	<tr>
            		
            		<td><input type="text" placeholder="选填(项目id号或项目来源)" style="width:200px; height:30px;" name="proid" id="proid"></td>
                	<td>&nbsp; &nbsp;开始时间: &nbsp;<input type="text" name="datepickfrom" id="datepickfrom" />  结束时间: &nbsp;<input type="text" name="datepickto" id="datepickto" /></td>
                	<td>
                        	<label>分配情况</label>
                            <span class="field">
                            <select name="select" class="uniformselect">
                            	<option value="all" selected="selected">所有</option>
                                <option value="yes">已分配</option>
                                <option value="no">未分配</option>
                                
                            </select>
                            
                            </span>
                        </td>
                	 
                	<td>&nbsp; &nbsp;<button type="button" class="stdbtn" onclick="form_submit()" >查询</button></td>
                	<td width="20%"></td>
                	<td ><a href="outmanager/addproject.jsp" class="btn btn_orange btn_link"><span>Add</span></a></td>
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
                        	
                            <th class="head1">项目id</th>
                            <th class="head0">项目名称</th>
                            <th class="head1">项目类型</th>
                            <th class="head0">项目来源</th>
                            <th class="head1">工作城市</th>
                            <th class="head0">创建时间</th>
                            <th class="head1">开始时间</th>
                            <th class="head0">结束时间</th>
                            <th class="head1">工时</th>
                           
                            <th class="head0">合同下载</th>
                             <th class="head1">项目进度</th>
                             <th class="head1">操作</th>
                        </tr>
                    </thead>
                 <s:iterator value="project">
                 	<tbody>
                 		<tr>
                 			<td><a href="outmanager-toEditOutPro?proid=<s:property value="project_id" />"><s:property value="project_id" /></a></td>
                 			<td><s:property value="project_name" /></td>
                 			<td><s:property value="proiect_type" /></td>
                 			<td><s:property value="boss_name" /></td>
                 			<td><s:property value="city" /></td>
                 			<td><s:property value="enter_time" /></td>
                 			<td><s:property value="star_time" /></td>
                 			<td><s:property value="end_time" /></td>
                 			<td><s:property value="woker_time" /></td>
                 			
                 			
                 		<td><s:if test="boss_contract==null">无公司合同</s:if><s:else>
                 		<a href="outmanager-download?fileName=<s:property value="boss_contract" />">公司合同下载</a></s:else>
                 		&nbsp; &nbsp;<s:if test="employee_contract==null">无员工合同</s:if><s:else>
                 			<a href="outmanager-download?fileName=<s:property value="employee_contract" />">员工合同下载</a></s:else></td>
                 		<td>
                 			<s:if test="project_flage==0">未分配</s:if>
                 			<s:elseif test="project_flage==1">已分配</s:elseif>
                 			<s:elseif test="project_flage==2">已结束</s:elseif>
                 		</td>
                 		<td>
                 		<a href="outmanager-endProject?proid=<s:property value="project_id" />"><button type="button" class="submit radius2">结束</button></a>
                 		</td>
                 		</tr>
                 	</tbody>
                 </s:iterator>
                    
                </table>
               
        <br clear="all" />
        </div>
	</div><!-- centercontent -->
 	<script language="javascript" type="text/javascript">
 	function form_submit(){
 		var start = document.getElementById("datepickfrom").value;
 		var end = document.getElementById("datepickto").value;
 		 var newst = fordate(start);
 		 var newed = fordate(end);
 		 var curDate = new Date();
 		 var d=new Date(Date.parse(end.replace(/-/g,"/")));
 		 if(document.getElementById("proid").value==""){
 			 if(start=="" || end==""){
 				 alert("时间范围与id不能同时为空！");
 			    return false;
 			    }else{
 			    	if (Date.parse(end) - Date.parse(start) <= 0) {
 				         alert("结束时间要大于开始时间");
 				         return false;
 						 }else if(d>curDate){
 							 alert("请选择小于今天的日期！");
 							 return false;
 						 } else{
 							 document.getElementById("query").submit();
 						 }
 			    }
 		 }else{
 			 document.getElementById("query").submit();
 		 }

 	}
 
 	function fordate(olddate){
 		 var st= new Array();
 		 st = olddate.split("/");
 		 var i;
 		 i = st[0];
 		 st[0] = st[2];
 		 st[2] = st[1]
 		 st[1] = i;
 		 var newstart = st.join("/");
 		 return newstart;

 	}
 	function openwindows(){ 
 		 window.open ("upContract.jsp","Sample","fullscreen=yes,toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no, copyhistory=no,width=350,height=200,left=250,top=300");
 	  } 
</script>
</body>

</html>