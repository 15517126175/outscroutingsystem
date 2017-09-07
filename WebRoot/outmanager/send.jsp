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
                	<h3>面试通知</h3>
                </div><!--contenttitle-->
                 <div class="tableoptions">  

                    <form class="stdform" id="send1" action="outmanager-sendEmp" method="post" >
                 	<div id = "search"> 
        				 <table>
        				 	<tr>
        				 		<td>
        				 			项目id
        				 			<input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" id="project_id"  name="project_id"  />
        				 		</td>
        				 		
        				 		<td>
        				 			员工id
        				 			<input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" id="emp_id"  name="emp_id"  />
        				 		</td>
        				 		<td width="10%"></td>
        				 		<td><button type="button" class="stdbtn" onclick="form_submit1()" >查询</button></td>
        				 	</tr>
        				</table>

        			</div>
        		
                    </form>  
              </div>
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
                            <th class="head0">开始时间</th>
                            <th class="head1">结束时间</th>
                             <th class="head1">工时</th>
                           
                        </tr>
                        </thead>
                <s:iterator value="project">
                 	
                 		<tr>
                 			<td><s:property value="project_id" /></td>
                 			<td><s:property value="project_name" /></td>
                 			<td><s:property value="proiect_type" /></td>
                 			<td><s:property value="boss_name" /></td>
                 			<td><s:property value="city" /></td>
                 			<td><s:property value="star_time" /></td>
                 			<td><s:property value="end_time" /></td>
                 			<td><s:property value="woker_time" /></td>
                 			
                 		</tr>
                 	
                 </s:iterator>       	
                 
                    
                </table>
                <br></br>
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
                    		<th class="head1">员工id</th>
                            <th class="head0">员工名称</th>
                            <th class="head1">性别</th>
                            <th class="head0">年龄</th>
                            <th class="head1">联系电话</th>
                            <th class="head0">邮箱</th>
                            
                    	</tr>
                    	</thead>
                  <s:iterator value="salarylist">
                 	
                 		<tr>
                 			<td><s:property value="employee_id" /></td>
                 			<td><s:property value="employee_name" /></td>
                 			<td><s:property value="employee_sex" /></td>
                 			<td><s:property value="employee_age" /></td>
                 			<td><s:property value="employee_phone" /></td>
                 			<td><s:property value="employee_email" /></td>
                 			
                 			
                 		</tr>
                 	
                 </s:iterator>      
                    
                </table>
                
                <br>
                <br>
                <form class="stdform" id="send2" action="outmanager-sendEmpOk?project_id=${proid }&emp_id=${empid}" method="post" >
                <p> 
        				 <label>面试时间</label>: &nbsp;<input type="text" name="datepickfrom" id="datepickfrom" />  </p>
        				<p>
        					<label>面试地点</label>
                            <span class="field"><input type="text" id="site"  name="site" class="smallinput" /></span>
        				</p>
                <p class="stdformbutton">
                        	<button type="button" class="submit radius2" onclick="form_submit2()">确认发布</button>
                           
                        </p>
              </form>
        </div><!--contentwrapper-->
        
        <br clear="all" />
        
	</div><!-- centercontent -->
	<script language="javascript" type="text/javascript">
	function form_submit1(){
		if (document.getElementById("project_id").value=="" || document.getElementById("emp_id").value=="")
		{
			alert("员工id和项目id不能为空！");
			return false;
			 
		}else{
			document.getElementById("send1").submit();
		}
	}
	function form_submit2(){
		var start = document.getElementById("datepickfrom").value;
		
		 var newst = fordate(start);
		
		 var curDate = new Date();
		 var d=new Date(Date.parse(start.replace(/-/g,"/")));
		
			if(start==""){
				 alert("时间不能为空！");
			    return false;
			    }else{
			    	
							 document.getElementById("send2").submit();
						
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