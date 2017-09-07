<%@ page language="java" import="java.util.*" pageEncoding="UTF8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>培训</title>
    
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
    <div class="contenttitle2">
    <div class="pageheader">
    <h1 class="pagetitle">培训反馈</h1>                    
    </div><!--pageheader-->
    </div>
    <div id="contentwrapper" class="contentwrapper">
    <s:iterator value="t">
     <form class="stdform" id="feedback" action="employee-feedback?id=<s:property value="train_id"/>" method="post">
     <p>
     <label>培训名称 </label>
     <span class="field"><input type="text" value="<s:property value="train_title"/>" onfocus=this.blur() /></span>
     </p>
     <p>
     <label>主讲人</label>
     <span class="field"><input type="text" value="<s:property value="train_trainer"/>" onfocus=this.blur() /></span>
     </p>
     <p>
     <label>*请评价这次培训</label>
     <span class="field"><textarea cols="80" rows="10" id="train" name="feedtrain"></textarea></span>
     </p> 
     <p>
     <label>*请评价本次培训人</label>
     <span class="field"><textarea cols="80" rows="10" id="trainer" name="feedtrainer"></textarea></span>
     </p>              
     
     <p class="stdformbutton">
                        	<button type="button" class="submit radius2" onclick="check()">提交</button>
                            <input type="reset" class="reset radius2" value="重置" />
                        </p>
     </form>
     </s:iterator>
    </div><!--contentwrapper-->
    <br clear="all" />
	</div><!-- centercontent -->
	<script language="javascript" type="text/javascript">
	function check(){
	if(document.getElementById("train").value == "" || document.getElementById("trainer").value == ""){
		alert("请填写评价后再提交！");
		return false;
	}else{
		document.getElementById("feedback").submit();
	}
	}
	</script>
	</body>
  </html>