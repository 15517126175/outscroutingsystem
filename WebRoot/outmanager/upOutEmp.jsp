<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加外派员工信息</title>
    
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
        
        	 <h3>上传外派员工</h3>
                    <form class="stdform" id="upOutEmp" action="outmanager-upOutEmp" method="post" >
            			
        				 <p>
        				
                         <label>员工id</label>
                            <span class="field"><input type="text"   id="employee_id" name="outEmp.employee_id"  value="${outEmp.employee_id }" class="smallinput" readonly="readonly" /></span>
                        	
        				 </p>
        				  <p>
        				 <label>员工姓名</label>
                            <span class="field"><input type="text" id="employee_name"  name="outEmp.employee_name" value="${outEmp.employee_name }" class="smallinput" readonly="readonly" /></span>
        				  
        				 </p>
        				 <p>
        				 <label>员工电话</label>
                            <span class="field"><input type="text" id="employee_phone"  name="outEmp.employee_phone" value="${outEmp.employee_phone }" class="smallinput" readonly="readonly" /></span>
        				 
        				 </p>
        				 <p>
                        	<label>发包方</label>
                            <span class="field"><input type="text" id="boss_name"  name="outEmp.boss_name" value="${outEmp.boss_name}" class="smallinput" readonly="readonly" /></span>
        				 </p>
        				 <p>
                        	<label>项目名称</label>
                            <span class="field"><input type="text" id="project_name"  name="outEmp.project_name" value="${outEmp.project_name}" class="smallinput" readonly="readonly" /></span>
        				 </p>
        				  <p>
                        	<label>工作城市</label>
                            <span class="field"><input type="text" id="city"  name="outEmp.city" value="${outEmp.city}" class="smallinput" readonly="readonly" /></span>
        				 </p>
        				 <p>
                        	<label>项目类型</label>
                            <span class="field"><input type="text" id=project_type  name="outEmp.project_type" value="${outEmp.project_type}" class="smallinput" readonly="readonly" /></span>
        				 </p>
        				 <p>
                        	<label>工作时长（天）</label>
                            <span class="field"><input type="text" id=woker_time  name="outEmp.woker_time" value="${outEmp.woker_time}" class="smallinput" readonly="readonly" /></span>
        				 </p>
        				  <p>
                        	<label>开始时间</label>
                            <span class="field"><input type="text" id="star_time"  name="outEmp.star_time" value="${outEmp.star_time}" class="smallinput" readonly="readonly" /></span>
        				 </p>
        				 <p>
                        	<label>结束时间</label>
                            <span class="field"><input type="text" id="end_time"  name="outEmp.end_time" value="${outEmp.end_time}" class="smallinput" readonly="readonly" /></span>
        				 </p>
        				 <p>
                        	<label>任务类型</label>
                            <span class="field"><select  id="work_type" name="outEmp.work_type" class="uniformselect">
                            	<option seleted="seleted">---请选择---</option>
                            	<option value="前端">前端</option>
                                <option value="后台">后台</option>
                                <option value="数据库">数据库</option>                  
                            </select>
						</span>
        				 </p>
        				<p>
                        	<label>请输入外包项目工资</label>
                            <span class="field"><input type="text" id="salary"  name="outEmp.salary" class="smallinput" /></span>
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
	if (document.getElementById("salary").value=="" )
	{
		alert("外包工资不能为空！");
		return false;
		 
	}
	else{
		document.getElementById("upOutEmp").submit();
	}
	 
}

</script>
    


</body>
</html>
