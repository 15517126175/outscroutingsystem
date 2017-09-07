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
<script type="text/javascript" src="js/plugins/jquery.uniform.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery.tagsinput.min.js"></script>
<script type="text/javascript" src="js/plugins/charCount.js"></script>
<script type="text/javascript" src="js/plugins/ui.spinner.min.js"></script>
<script type="text/javascript" src="js/plugins/chosen.jquery.min.js"></script>
<script type="text/javascript" src="js/custom/general.js"></script>
<script type="text/javascript" src="js/custom/forms.js"></script>


  </head>
  		
  <body class="withvernav">

    <jsp:include page="mainframe.jsp"></jsp:include>
    <jsp:include page="left.jsp"></jsp:include>
  
        
    <div class="centercontent">
    
        <div class="pageheader">
            <h1 class="pagetitle">控制台</h1>
            <span class="pagedesc">页面的描述内容</span>
            
           
        </div><!--pageheader-->
        
        <div id="contentwrapper" class="contentwrapper">
        
        	 <h3>新培训</h3>
                   

                    <form class="stdform" id="Train" action="manager-trainList" method="post" >
                    	
                        <s:iterator value="trainlist">
        				 <br/>
        				 <p>
                        	<label>名称</label>
                            <span class="field"><input type="text"   id="train_title"  name="train.train_title" class="smallinput" value="<s:property value="train_title" />"/></span>
                         
        				 </p>
        				  <p>
                        	<label>培训人</label>
                            <span class="field"><input type="text"   id="train_trainer"  name="train.train_trainer" class="smallinput" value="<s:property value="train_trainer" />"/></span>

        				 </p>
        				 <p>
                        	<label>开始时间</label>
                            <span class="field"><input type="text" id="train_time"  name="train.train_time" class="smallinput" value="<s:property value="train_time" />""/></span>
        				 </p>
        				 <p>
                        	<label>持续时间(天)</label>
                            <span class="field"><input type="text" id="train_days"  name="train.train_days" class="smallinput" value="<s:property value="train_days" />" "/></span>
        				 </p>
        				 <p>
                        	<label>培训地点</label>
                            <span class="field"><input type="text" id="train_place"  name="train.train_place" class="smallinput" value="<s:property value="train_place" />" "/></span>
        				 </p>
        				 
        				 	 <p>
                        	<label>培训内容</label>       				 
        				 <span class="field"> <textarea cols="80" rows="10" id="train_content"  name="train.train_content" ><s:property value="train_content" /></textarea></span>
        				 </p>
        				 </s:iterator>
        				 
        				  <p>
                        	<label>报名人数</label>       				 
        				 <span class="field"> <input type="text"  cols="80" rows="10" id="size"  name="size" value="<s:property value="size" />"></input></span>
        				 </p>
        				 <s:iterator value="trainlist">
        				 
        				 <p>
                        	<label>发布时间</label>       				 
        				 <span class="field"> <input type="text" cols="80" rows="10" id="train_puttime"  name="train.train_puttime" value="<s:property value="train_puttime" />"></input></span>
        				 </p>
        				 </s:iterator>
        				<p class="stdformbutton">
                        <input type="button" value="返回" onclick="retut()">
                           
                        </p>

                    </form>
	
                   
            
        
        </div><!--contentwrapper-->
        
        <br clear="all" />
        
	</div><!-- centercontent -->
    <script language="javascript" type="text/javascript">
function retut(){
	document.getElementById("Train").submit();
	
}
	 
	   


</script>
    


</body>
</html>
