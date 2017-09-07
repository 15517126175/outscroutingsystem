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
    
    <title>员工个人信息</title>
    
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
    <h1 class="pagetitle">我的信息</h1>                    
    </div><!--pageheader-->
    <div id="contentwrapper" class="contentwrapper">
     <h3>查看</h3>
      
     <form class="stdform" id="updateInfo" action="employee-toEditInfo?id=${sessionScope.userid}" method="post" >               
      
                    	<p>
                        <label>登&nbsp;&nbsp;录&nbsp;&nbsp;名</label>
                        <span class="field"><input type="text" value="${sessionScope.employeeId}" onfocus=this.blur()></span>
        				</p>
                    	<p>
                    	<label>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</label>
                    	<span class="field"><input type="text" value="${sessionScope.employeeName}" onfocus=this.blur()></span>
                    	</p>
                    	<p>
                    	<label>年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄</label>
                    	<span class="field"><input type="text" value="${sessionScope.employeeAge}" onfocus=this.blur()></span>
                    	</p>
                    	<p>
                    	<label>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别</label>
                    	<span class="field"><input type="text" value="${sessionScope.employeeSex}" onfocus=this.blur()></span>
                    	</p>
        				<p>
                        <label>联系电话</label>
                        <span class="field"><input type="text" value="${sessionScope.employeePhone}" onfocus=this.blur()></span>
        				</p>
        				<p>
                    	<label>电子邮箱</label>
                    	<span class="field"><input type="text" value="${sessionScope.employeeEmail}" onfocus=this.blur()></span>
                    	</p>
                        <label>入职时间</label>
                        <span class="field"><input type="text" value="${sessionScope.enterTime}" onfocus=this.blur()></span>
        				</p>
        				<p>
                        <label>我的工资(月薪)</label>
                        <span class="field"><input type="text" value="${sessionScope.basicSalary}" onfocus=this.blur()></span>
        				</p>
        				<p>
                        <label>当前状态</label>
                        <span class="field"><input type="text" value="${sessionScope.workStatus}(U为接单,E为暂不接单)" onfocus=this.blur()></span>
        				</p>
        				<p class="stdformbutton">
                        <button class="submit radius2" onclick="updateInfo()">更新个人信息</button>
                        </p>
      </form>
    </div><!--contentwrapper-->
    <br clear="all" />
	</div><!-- centercontent -->
	<script language="javascript" type="text/javascript">
function updateInfo(){	
		document.getElementById("updateInfo").submit();	   
}

</script>
</body>
 </html>