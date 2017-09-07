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
      
     <form class="stdform" id="closetask" action="employee-closeTask" method="post">               
      <s:iterator value="oe">
                    	<p>
                        <label>项目名称</label>
                        <span class="field"><input type="text" value='<s:property value="project_name"/>' onfocus=this.blur() class="smallinput"/></span>
        				</p>
                    	<p>
                    	<label>发包方</label>
                    	<span class="field"><input type="text" value='<s:property value="boss_name"/>' onfocus=this.blur() class="smallinput"/></span>
                    	</p>
                    	<p>
                    	<label>项目类型</label>
                    	<span class="field"><input type="text" value='<s:property value="project_type"/>' onfocus=this.blur() class="smallinput"/></span>
                    	</p>
                    	<p>
                    	<label>我完成的内容</label>
                    	<span class="field"><input type="text" value='<s:property value="work_type"/>' onfocus=this.blur() class="smallinput"/></span>
                    	</p>
        				<p>
                        <label>任务人编号</label>
                        <span class="field"><input type="text" value='<s:property value="employee_id"/>' onfocus=this.blur() class="smallinput"/></span>
        				</p>
        				<p>
                    	<label>任务人</label>
                    	<span class="field"><input type="text" value='<s:property value="employee_name"/>' onfocus=this.blur() class="smallinput"/></span>
                    	</p>
                    	<p>
                        <label>提交时间</label>
                        <span class="field"><input type="text" value="${nowtime}" onfocus=this.blur() class="smallinput"/></span>
        				</p>
        				<p class="stdformbutton">
                        <button type="submit" class="submit radius2" onclick="return closetask()">提交</button>
                        </p>
       </s:iterator>                 
      </form>
    </div><!--contentwrapper-->
    <br clear="all" />
	</div><!-- centercontent -->
	<script language="javascript" type="text/javascript">
function closetask(){
	var i=window.confirm("确定要提交吗?");     
	return i;
}

</script>
</body>
 </html>