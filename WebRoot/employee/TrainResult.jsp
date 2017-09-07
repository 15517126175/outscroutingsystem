<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
    <div class="contenttitle2">
        <div class="pageheader">
            <h1 class="pagetitle">明细查看</h1>                  
        </div><!--pageheader-->
    </div>   
        <div id="contentwrapper" class="contentwrapper"> 
        <s:iterator value="t">
        <form>                 
        <table cellpadding="0" cellspacing="0" border="0" id="table2" class="stdtable stdtablecb">
                    
                        <colgroup>
                        <col class="con0"/>
                        <col class="con1"/>
                       
                        
                    </colgroup>
                    <thead>
                        <tr>
                        	<th class="head0">课题编号：<s:property value="train_id"/></th>
                            <th class="head1">课题名称：<s:property value="train_title"/></th>
                        </tr>
                    </thead>
        			</table>
        			<table cellpadding="0" cellspacing="0" border="0" id="table2" class="stdtable stdtablecb">
                    
                        <colgroup>
                        <col class="con0"/>
                       
                        
                    </colgroup>
                    <thead>
                    <tr>
                        	<th class="head0">课题概述：<s:property value="train_content"/></th>
                    </tbody>
                    
        			</table>	
        			<table cellpadding="0" cellspacing="0" border="0" id="table2" class="stdtable stdtablecb">
                    
                        <colgroup>
                        <col class="con0"/>
                       
                        <col class="con1"/>
                        
                    </colgroup>
                    <thead>
                    <tr>
                        	<th class="head0">开课时间：<s:property value="train_time"/></th>
                            <th class="head1">持续时长：<s:property value="days"/></th>
                    </tbody>
                    
        			</table> 
        			<table cellpadding="0" cellspacing="0" border="0" id="table2" class="stdtable stdtablecb">
                    
                        <colgroup>
                        <col class="con0"/>
                       
                        <col class="con1"/>
                        
                    </colgroup>
                    <thead>
                    <tr>
                        	<th class="head0">主讲人：<s:property value="train_trainer"/></th>
                            <th class="head1">上课地点：<s:property value="train_place"/></th>
                    </tbody>
                    
        			</table>
        			<table cellpadding="0" cellspacing="0" border="0" id="table2" class="stdtable stdtablecb">
                    
                        <colgroup>
                        <col class="con0"/>
                       
                        <col class="con1"/>
                        <col class="con0"/>
                    </colgroup>
                    <thead>
                    <tr>
                        	<th class="head0">开通状态：<s:property value="status"/></th>
                            <th class="head1">发布时间：<s:property value="train_putting"/></th>
                            <th class="head0">报名截止时间：<s:property value="end_time"/></th>
                    </tbody>
                    
        			</table> 
                    </form>
	</s:iterator>
                   
            
        
        </div><!--contentwrapper-->
        
        <br clear="all" />
        
	</div><!-- centercontent -->
</body>
</html>