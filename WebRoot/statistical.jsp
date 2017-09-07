<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

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
	<script type="text/javascript" src="js/plugins/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
	<script type="text/javascript" src="js/plugins/jquery.cookie.js"></script>
	<script type="text/javascript" src="js/plugins/jquery.uniform.min.js"></script>
	<script type="text/javascript" src="js/plugins/jquery.flot.min.js"></script>
	<script type="text/javascript" src="js/plugins/jquery.flot.resize.min.js"></script>
	<script type="text/javascript" src="js/plugins/jquery.slimscroll.js"></script>
	<script type="text/javascript" src="js/custom/general.js"></script>
	<script type="text/javascript" src="js/custom/dashboard.js"></script>

  
    <title>ECharts</title>
    <!-- 引入 echarts.js -->
    <script src="js/plugins/echarts.js"></script>
</head>
<body>
	

	 <jsp:include page="outmanager/mainframe.jsp"></jsp:include>
    <jsp:include page="outmanager/left.jsp"></jsp:include>
  
    <div class="centercontent">
    
        
        <div id="contentwrapper" class="contentwrapper">
   				<div id="main" style="width: 600px;height:400px;"></div>
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));
 	var option = {  
                    tooltip: {  
                        show: true  
                    },  
                    legend: {  
                        data: ['数量']  
                    },  
                    xAxis: [  
                        {  
                            type: 'category',  
                            data: (function(){
                                    var arr=[];
                                        $.ajax({
                                        type : "post",
                                        async : false, //同步执行
                                        url : "public-chartsList",
                                        data : {},
                                        dataType : "json", //返回数据形式为json
                                        success : function(json) {
                                        if (json) {
                                               for(var i=0;i<json.length;i++){
                                                  console.log(json[i].context);
                                                   arr.push(json[i].user.type);
                                                }    
                                        }
                                        
                                    },
                                    error : function(errorMsg) {
                                        alert("不好意思,图表请求数据失败啦!");
                                        myChart.hideLoading();
                                    }
                                   })
                                   return arr;
                                })()   
                        }  
                    ],  
                    yAxis: [  
                        {  
                            type: 'value'  
                        }  
                    ],  
                    series: [  
                        {  
                            'name': '项目类型',  
                            'type': 'bar',  
                            'data':(function(){
                                    var arr=[];
                                        $.ajax({
                                        type : "post",
                                        async : false, //同步执行
                                        url : "public-chartsList",
                                        data : {},
                                        dataType : "json", //返回数据形式为json
                                        success : function(json) {
                                        if (json) {
                                               for(var i=0;i<json.length;i++){
                                                  console.log(json[i].context);
                                                   arr.push(json[i].user.count);
                                                }    
                                        }                                       
                                    },
                                    error : function(errorMsg) {
                                        alert("不好意思,图表请求数据失败啦!");
                                        myChart.hideLoading();
                                    }
                                   })
                                   return arr;
                                })()   
                        }  
                    ]  
                };  
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    </script>
        <div id="statistics" class="subcontent">
        	&nbsp;
        </div><!--#statistics-->
     </div><!--contentwrapper-->
        
        <br clear="all" />
    </div><!-- centercontent -->
</body>
</html>