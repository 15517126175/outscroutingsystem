<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改发包方信息</title>
    
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
        
        	 <h3>修改发包方信息</h3>
                   

                    <form class="stdform" id="editBoss" action="outmanager-editBoss" method="post" >
                    	
                        
        				<s:hidden name="boss1.boss_id"></s:hidden>
        				 
        				 <p>
        				
                         <label>发包方名称</label>
                            <span class="field"><input type="text"   id="boss_name" name="boss1.boss_name"  value="${boss1.boss_name }" class="smallinput" /></span>
                        	
        				 </p>
        				  <p>
        				 <label>发包方负责人</label>
                            <span class="field"><input type="text" id="linkman"  name="boss1.linkman" value="${boss1.linkman }" class="smallinput" /></span>
        				  
        				 </p>
        				 <p>
        				 <label>电话</label>
                            <span class="field"><input type="text" id="phone_number"  name="boss1.phone_number" value="${boss1.phone_number }" class="smallinput" /></span>
        				 
        				 </p>
        				<p class="stdformbutton">
                        	<button type="submit" class="submit radius2" >确认</button>
                            <input type="reset" class="reset radius2" value="重置" />
                        </p>

                    </form>
	
        </div><!--contentwrapper-->
        
        <br clear="all" />
        
	</div><!-- centercontent -->
    <script language="javascript" type="text/javascript">
function form_submit(){
	if (document.getElementById("boss_name").value=="" || document.getElementById("phone_number").value=="")
	{
		alert("名称和电话不能为空！");
		return false;
		 
	}
	else{
		document.getElementById("editBoss").submit();
	}
	 
	   
}

</script>
    


</body>
</html>
