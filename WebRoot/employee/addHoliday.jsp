<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix ="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>项目完成提交</title>
    
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
    <div class="pageheader">
    <h1 class="pagetitle">我的项目</h1>                    
    </div><!--pageheader-->
    <div id="contentwrapper" class="contentwrapper">
     <form>
            	<table>
            	<tr>
                	<td><a href="employee-Task"><button type="button" class="submit radius2">检索项目信息</button></a></td>
                </tr>
                </table>	
     </form> 
     <form class="stdform" id="addholiday" action="employee-addholiday" method="post">  
      <s:iterator value="oe"></s:iterator>
                    	<p>
                        <label>项目名称</label>
                        <span class="field"><input type="text" id="info" name="projectname" value='<s:property value="project_name"/>' class="smallinput" onfocus=this.blur()></span>
        				</p>
                    	<p>
                    	<label>发包方</label>
                    	<span class="field"><input type="text" name="bossname" value='<s:property value="boss_name"/>' class="smallinput" onfocus=this.blur()></span>
                    	</p>
        				<p>
                        <label>任务人编号</label>
                        <span class="field"><input type="text" name="employeeid" value='<s:property value="employee_id"/>' class="smallinput" onfocus=this.blur()></span>
        				</p>
        				<p>
                    	<label>任务人</label>
                    	<span class="field"><input type="text" name="employeename" value='<s:property value="employee_name"/>' class="smallinput" onfocus=this.blur()></span>
                    	</p>
                    	<p>
                    	<label>当前时间</label>
                    	<span class="field"><input type="text" name="nowtime" value="${nowtime}" class="smallinput" onfocus=this.blur()></span>
                    	</p>
                        <p>
                        <label>请假开始时间</label>
                        <span class="field"><input type="text" name="datepickfrom" id="datepickfrom" class="smallinput" /></span>
        				</p>
        				<p>
                        <label>请假结束时间</label>
                        <span class="field"><input type="text" name="datepickto" id="datepickto" class="smallinput" /></span>
        				</p>
        				<p class="stdformbutton">
                        <button type="button" class="submit radius2" onclick="closetask()">提交</button>
                        </p>
      </form>
    </div><!--contentwrapper-->
    <br clear="all" />
	</div><!-- centercontent -->
	<script language="javascript" type="text/javascript">
	function closetask(){
		var start = document.getElementById("datepickfrom").value;
 		var end = document.getElementById("datepickto").value;
 		var newst = fordate(start);
		var newed = fordate(end);
 		var nowtime = new Date();
 		var starttime = new Date(Date.parse(start.replace(/-/g,"/")));
 		if(document.getElementById("info").value == ""){
 			alert("请先获取请假人与项目信息");
 			return false;
 		}else{
 			if(start=="" || end==""){
 				 alert("请选择请销假时间");
 			    return false;
 			    }else{
 			    	if (Date.parse(end) - Date.parse(start) <= 0) {
 				         alert("结束时间要在开始时间之后！");
 				         return false;
 						 }else if(starttime<nowtime){
 							 alert("请至少以明天作为请假开始日期！");
 							 return false;
 						 } else{
 							 document.getElementById("addholiday").submit();
 						 }
 			    }
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

</script>
</body>
 </html>