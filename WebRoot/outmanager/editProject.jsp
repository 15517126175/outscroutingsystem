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
    
    <title>修改外包项目信息</title>
    
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
        
        	 <h3>修改外包项目信息</h3>
                   

                    <form class="stdform" id="editProject" action="outmanager-editOutPro" method="post" >
                    	
                        <s:hidden name="pro.project_id"></s:hidden>
        				
        				<s:hidden name="pro.enter_time"></s:hidden>
        				<s:hidden name="pro.boss_contract"></s:hidden>
        				<s:hidden name="pro.employee_contract"></s:hidden>
        				<s:hidden name="pro.project_flage"></s:hidden>
        				
        				 <p>
        				
                         <label>项目名称</label>
                            <span class="field"><input type="text"   id="boss_name" name="pro.project_name"  value="${pro.project_name }" class="smallinput" /></span>
                        	
        				 </p>
        				  <p>
        				 <label>项目类型</label>
                            <span class="field"><input type="text" id="proiect_type"  name="pro.proiect_type" value="${pro.proiect_type }" class="smallinput" /></span>
        				  
        				 </p>
        				 <p>
        				 <label>项目来源</label>
                            <span class="field"><input type="text" id="boss_name"  name="pro.boss_name" value="${pro.boss_name }" class="smallinput" /></span>
        				 
        				 </p>
        				  <p>
        				 <label>工作城市</label>
                            <span class="field"><input type="text" id="city"  name="pro.city" value="${pro.city }" class="smallinput" /></span>
        				 
        				 </p>
        				 <p>
                        	<label>工时</label>
                            <span class="field"><input type="text" id="woker_time"  name="pro.woker_time" value="${pro.woker_time }" class="smallinput" /></span>
        				 </p>
        				
        				<p class="stdformbutton">
                        	<button type="submit" class="submit radius2" >确认</button>
                            <input type="reset" class="reset radius2" value="重置" />
                        </p>

                    </form>
	
        </div><!--contentwrapper-->
        
        <br clear="all" />
        
	</div><!-- centercontent -->
  


</body>
</html>
