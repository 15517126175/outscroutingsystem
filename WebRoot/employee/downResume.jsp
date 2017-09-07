<%@ page language="java" import="java.util.*" contentType="application/msword; charset=utf8" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<% response.setHeader("Content-Disposition", "attachment;filename=myresume.doc");
%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
     <base href="<%=basePath%>">
     <title>我的简历</title>
    </head>
    <body>
     <h2 align="center">我的简历</h2></br></br>
                <form>
                <s:iterator value="resume1">	
                <table>
                    
                    <thead>
                        <tr>
                            <th>姓名:<s:property value="resume_name"/></th>
                            <th>性别:<s:property value="resume_sex"/></th>
                            <th>年龄:<s:property value="resume_age"/></th>
                        </tr>
                    </thead>
                </table>
                <table>
                
                    <thead>
                        <tr>
                            <th>联系号码:<s:property value="resume_phone"/></th>
                            <th>电子邮箱:<s:property value="resume_email" /></th>  
                        </tr>
                    </thead>
                </table> 
                <table>
                
                    <thead>
                        <tr>
                            <th>学习经历</th>  
                        </tr>
                    </thead>
                
                    <tbody>
                        <tr>
                            <td><s:property value="resume_study" /></td>   
                        </tr>
                    </tbody>
 
                </table> 
                <table>
     
                <colgroup>
                        <col class="con1" />
                </colgroup>
                    <thead>
                        <tr>
                            <th class="head0">外派项目名</th> 
                            <th class="head1">外派项目类型</th>
                            <th class="head0">个人负责内容</th>
                        </tr>
                    </thead>
                    <s:iterator value="oe">
                    <tbody>
                        <tr>
                            <td><s:property value="project_name" /></td>
                            <td><s:property value="project_type" /></td>
                            <td><s:property value="work_type" /></td>  
                        </tr>
                    </tbody>
                    </s:iterator> 
                </table>
                <table>
                
                    <thead>
                        <tr>
                            <th>其他工作经历</th>  
                        </tr>
                    </thead>
    
                    <tbody>
                        <tr>
                            <td><s:property value="resume_outhistory" /></td>  
                        </tr>
                    </tbody>
 
                </table>
                <table>
                
                    <thead>
                        <tr>
                            <th>第三方评价</th>  
                        </tr>
                    </thead>
        
                    <tbody>
                        <tr>
                            <td><s:property value="resume_assess" /></td>   
                        </tr>
                    </tbody>
                     
                </table>    
               
                </s:iterator>
                </form>
        <br clear="all" />

    </body>
</html>