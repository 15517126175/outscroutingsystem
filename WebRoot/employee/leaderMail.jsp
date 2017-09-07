<%@ page language="java" import="java.util.*" pageEncoding="UTF8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>领导信箱</title>
    
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
    <h1 class="pagetitle">领导信箱</h1>  
                  
    </div><!--pageheader-->
    </div>
    <div id="contentwrapper" class="contentwrapper">  
		
		
             	 <form class="stdform" id="sendmessage" action="public-leaderMassage" method="post" >
             	 <label>请选择领导：</label>
	           		<span class="field"><select  id="project_type" name="receive" class="uniformselect">
                            	<option value="manager" seleted="seleted">管理员</option>
                            	<option value="outmanager">外派管理员</option>
                                               
                            </select>
						</span>
					<br><br><br>
					<p>
                        	<label>消息内容</label>
                            <span class="field">
                                <textarea cols="80" rows="5" id="textarea2" name="me.message" class="longinput"></textarea>
                            </span> 
                        </p>
                        <p class="stdformbutton">
                        	<button type="button" class="submit radius2" onclick="form_submit()" >确认</button>
                            <input type="reset" class="reset radius2" value="重置" />
                        </p>
                 </form>       
           
    </div><!--contentwrapper-->
    <br clear="all" />
	</div><!-- centercontent -->
	<script language="javascript" type="text/javascript">
function form_submit(){
	if (document.getElementById("textarea2").value=="" )
	{
		alert("内容不能为空！");
		return false;
		 
	}
	else{
		document.getElementById("sendmessage").submit();
	}
	 
}

</script>   
	</body>
  </html>