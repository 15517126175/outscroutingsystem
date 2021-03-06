<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
        
        	 <h3>添加员工</h3>
                   

                    <form class="stdform" id="addemp" action="manager-addemp" method="post" >
                    	
                        
        				 <br/>
        				  <p>
                        	<label>员工编号</label>
                            <span class="field"><input type="text"   id="employee_id"  name="employee_id" class="smallinput" value="${employee_id}" disabled="disabled"/></span>
                         
        				 </p>
        				 <p>
                        	<label>姓名</label>
                            <span class="field"><input type="text"   id="employee_name"  name="emp.employee_name" class="smallinput" /></span>
                         
        				 </p>
        				  <p>
                        	<label>性别</label>
                            <span class="field"><select  id="employee_sex" name="emp.employee_sex" >
                            	<option value="男">男 </option>
                                <option value="女">女 ----</option>                   
                            </select>
</span>
        				 </p>
        				 <p>
                        	<label>年龄</label>
                            <span class="field"><input type="text" id="employee_age"  name="emp.employee_age" class="smallinput" /></span>
        				 </p>
        				 <p>
                        	<label>电话</label>
                            <span class="field"><input type="text" id="employee_phone"  name="emp.employee_phone" class="smallinput" /></span>
        				 </p>
        				 <p>
                        	<label>邮箱</label>
                            <span class="field"><input type="text" id="employee_email"  name="emp.employee_email" class="smallinput" /></span>
        				 </p>
        				 <p>
        				<label>居住城市</label>
        				<span class="field"><select type="text" id="province" name="province" class="smallinput" onchange="getCity()"/> </span>
        				<option seleted="seleted">---请选择省级信息---</option>
        				<option value= "北京" >北京</option> 
                        <option value= "上海" >上海</option> 
                        <option value= "天津" >天津</option> 
                        <option value= "重庆" >重庆</option> 
                        <option value= "河北" >河北</option> 
                        <option value= "山西" >山西</option> 
                        <option value= "内蒙古" >内蒙古</option> 
                        <option value= "辽宁" >辽宁</option> 
                        <option value= "吉林" >吉林</option> 
                        <option value= "黑龙江" >黑龙江</option> 
                        <option value= "江苏" >江苏</option> 
                        <option value= "浙江" >浙江</option> 
                        <option value= "安徽" >安徽</option> 
                        <option value= "福建" >福建</option> 
                        <option value= "江西" >江西</option> 
                        <option value= "山东" >山东</option> 
                        <option value= "河南" >河南</option> 
                        <option value= "湖北" >湖北</option> 
                        <option value= "湖南" >湖南</option> 
                        <option value= "广东" >广东</option> 
                        <option value= "广西" >广西</option> 
                        <option value= "海南" >海南</option> 
                        <option value= "四川" >四川</option> 
                        <option value= "贵州" >贵州</option> 
                        <option value= "云南" >云南</option> 
                        <option value= "西藏" >西藏</option> 
                        <option value= "陕西" >陕西</option> 
                        <option value= "甘肃" >甘肃</option> 
                        <option value= "宁夏" >宁夏</option> 
                        <option value= "青海" >青海</option> 
                        <option value= "新疆" >新疆</option> 
                        <option value= "香港" >香港</option> 
                        <option value= "澳门" >澳门</option> 
                        <option value= "台湾" >台湾</option> 
                        </select>
                        </br>
                        <select type="text" id="city" name="city"  class="smallinput"/>
                        </select>
        				</p>
        				 
        				 <p>
                        	<label>基本工资 /元</label>
                            <span class="field"><input type="text" id="basicSalary"  name="emp.basicSalary" class="smallinput" value="${basicSalary}" disabled="disabled"/></span>
        				 </p>
        				 
        				 <p>
                        	<label>工作状态</label>
                            <span class="field"><input type="text" id="work_status"  name="work_status" class="smallinput" value="${Work_status }" disabled="disabled"/></span>
        				 </p>
        				 <p>
                        	<label>学历</label>
                            <span class="field"><select  id="education" name="emp.education" >
                                <option>请选择</option>
                            	<option value="专科">专科</option>
                                <option value="本科"> 本科 </option> 
                                <option value="研究生">研究生</option>
                                <option value="博士">博士 </option>
                                <option value="其他">其他 </option>                  
                            </select>
</span>
        				 </p>
        				 <p>
                        	<label>毕业学校</label>
                            <span class="field"><input type="text" id="school"  name="emp.school" class="smallinput" value=""/></span>
        				 </p>
        				 <p>
                        	<label>员工技能描述</label>
                            <span class="field"> <textarea cols="80" rows="10" id="employee_skill"  name="emp.employee_skill"></textarea></span>
        				 </p>
        				<p class="stdformbutton">
                        	<button type="button" class="submit radius2" onclick="form_submit()">确认</button>
                            <input type="reset" class="reset radius2" value="重置" />
                        </p>

                    </form>
	
                   
            
        
        </div><!--contentwrapper-->
        
        <br clear="all" />
        
	</div><!-- centercontent -->
    <script language="javascript" type="text/javascript">
function form_submit(){
	if (document.getElementById("employee_phone").value=="" || document.getElementById("employee_name").value=="")
	{
		
		return false;
		 
	}
	else{
		document.getElementById("addemp").submit();
	}
	 
	   
}
var arr = new  Array();
arr[0 ]="---请选择地市信息---"
arr[1 ]="东城,西城,崇文,宣武,朝阳,丰台,石景山,海淀,门头沟,房山,通州,顺义,昌平,大兴,平谷,怀柔,密云,延庆" 
arr[2 ]="黄浦,卢湾,徐汇,长宁,静安,普陀,闸北,虹口,杨浦,闵行,宝山,嘉定,浦东,金山,松江,青浦,南汇,奉贤,崇明" 
arr[3 ]="和平,东丽,河东,西青,河西,津南,南开,北辰,河北,武清,红挢,塘沽,汉沽,大港,宁河,静海,宝坻,蓟县" 
arr[4 ]="万州,涪陵,渝中,大渡口,江北,沙坪坝,九龙坡,南岸,北碚,万盛,双挢,渝北,巴南,黔江,长寿,綦江,潼南,铜梁,大足,荣昌,壁山,梁平,城口,丰都,垫江,武隆,忠县,开县,云阳,奉节,巫山,巫溪,石柱,秀山,酉阳,彭水,江津,合川,永川,南川" 
arr[5 ]="石家庄,邯郸,邢台,保定,张家口,承德,廊坊,唐山,秦皇岛,沧州,衡水" 
arr[6 ]="太原,大同,阳泉,长治,晋城,朔州,吕梁,忻州,晋中,临汾,运城" 
arr[7 ]="呼和浩特,包头,乌海,赤峰,呼伦贝尔盟,阿拉善盟,哲里木盟,兴安盟,乌兰察布盟,锡林郭勒盟,巴彦淖尔盟,伊克昭盟" 
arr[8 ]="沈阳,大连,鞍山,抚顺,本溪,丹东,锦州,营口,阜新,辽阳,盘锦,铁岭,朝阳,葫芦岛" 
arr[9 ]="长春,吉林,四平,辽源,通化,白山,松原,白城,延边" 
arr[10 ]="哈尔滨,齐齐哈尔,牡丹江,佳木斯,大庆,绥化,鹤岗,鸡西,黑河,双鸭山,伊春,七台河,大兴安岭" 
arr[11 ]="南京,镇江,苏州,南通,扬州,盐城,徐州,连云港,常州,无锡,宿迁,泰州,淮安" 
arr[12 ]="杭州,宁波,温州,嘉兴,湖州,绍兴,金华,衢州,舟山,台州,丽水" 
arr[13 ]="合肥,芜湖,蚌埠,马鞍山,淮北,铜陵,安庆,黄山,滁州,宿州,池州,淮南,巢湖,阜阳,六安,宣城,亳州" 
arr[14 ]="福州,厦门,莆田,三明,泉州,漳州,南平,龙岩,宁德" 
arr[15 ]="南昌市,景德镇,九江,鹰潭,萍乡,新馀,赣州,吉安,宜春,抚州,上饶" 
arr[16 ]="济南,青岛,淄博,枣庄,东营,烟台,潍坊,济宁,泰安,威海,日照,莱芜,临沂,德州,聊城,滨州,菏泽" 
arr[17 ]="郑州,开封,洛阳,平顶山,安阳,鹤壁,新乡,焦作,濮阳,许昌,漯河,三门峡,南阳,商丘,信阳,周口,驻马店,济源" 
arr[18 ]="武汉,宜昌,荆州,襄樊,黄石,荆门,黄冈,十堰,恩施,潜江,天门,仙桃,随州,咸宁,孝感,鄂州" 
arr[19 ]="长沙,常德,株洲,湘潭,衡阳,岳阳,邵阳,益阳,娄底,怀化,郴州,永州,湘西,张家界" 
arr[20 ]="广州,深圳,珠海,汕头,东莞,中山,佛山,韶关,江门,湛江,茂名,肇庆,惠州,梅州,汕尾,河源,阳江,清远,潮州,揭阳,云浮" 
arr[21 ]="南宁,柳州,桂林,梧州,北海,防城港,钦州,贵港,玉林,南宁地区,柳州地区,贺州,百色,河池" 
arr[22 ]="海口,三亚" 
arr[23 ]="成都,绵阳,德阳,自贡,攀枝花,广元,内江,乐山,南充,宜宾,广安,达川,雅安,眉山,甘孜,凉山,泸州" 
arr[24 ]="贵阳,六盘水,遵义,安顺,铜仁,黔西南,毕节,黔东南,黔南" 
arr[25 ]="昆明,大理,曲靖,玉溪,昭通,楚雄,红河,文山,思茅,西双版纳,保山,德宏,丽江,怒江,迪庆,临沧" 
arr[26 ]="拉萨,日喀则,山南,林芝,昌都,阿里,那曲" 
arr[27 ]="西安,宝鸡,咸阳,铜川,渭南,延安,榆林,汉中,安康,商洛" 
arr[28 ]="兰州,嘉峪关,金昌,白银,天水,酒泉,张掖,武威,定西,陇南,平凉,庆阳,临夏,甘南" 
arr[29 ]="银川,石嘴山,吴忠,固原" 
arr[30 ]="西宁,海东,海南,海北,黄南,玉树,果洛,海西" 
arr[31 ]="乌鲁木齐,石河子,克拉玛依,伊犁,巴音郭勒,昌吉,克孜勒苏柯尔克孜,博 尔塔拉,吐鲁番,哈密,喀什,和田,阿克苏" 
arr[32 ]="香港" 
arr[33 ]="澳门" 
arr[34 ]="台北,高雄,台中,台南,屏东,南投,云林,新竹,彰化,苗栗,嘉义,花莲,桃园,宜兰,基隆,台东,金门,马祖,澎湖" 

function getCity(){    
var pro = document.getElementById("province");
var city = document.getElementById("city");
var index = pro.selectedIndex;
var cityArr = arr[index].split(",");   

city.length = 0;
//将城市数组中的值填充到城市下拉框中
for(var i=0;i<cityArr.length;i++)
{
         city[i]=new Option(cityArr[i],cityArr[i]);
     }
} 

</script>
    


</body>
</html>
