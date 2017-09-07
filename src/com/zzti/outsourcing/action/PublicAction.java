package com.zzti.outsourcing.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;


import com.zzti.outsourcing.entities.Charts;
import com.zzti.outsourcing.entities.Message;
import com.zzti.outsourcing.service.PublicSV;

public class PublicAction extends BasicAction {
	private PublicSV publicSv ;
	private List<Message> message;
	private Message me;
	
	
	public Message getMe() {
		return me;
	}

	public void setMe(Message me) {
		this.me = me;
	}

	public PublicSV getPublicSv() {
		return publicSv;
	}

	public void setPublicSv(PublicSV publicSv) {
		this.publicSv = publicSv;
	}

	public List<Message> getMessage() {
		return message;
	}

	public void setMessage(List<Message> message) {
		this.message = message;
	}
	
	
	

	//新消息提醒
	public String queryMessage() {
		int id = (Integer) session.get("userid");
		int count;
		try {
			message = publicSv.queryMessage(id);
			count = message.size();
			StringBuffer json =new StringBuffer("{");
			if(count==0){
				json.append("'msg':'"+0+"'");
				json.append("}");// 构造json数据格式
			}else{
				
				json.append("'msg':'"+count+"'");
				json.append("}");// 构造json数据格式
			}
			 HttpServletResponse response = ServletActionContext.getResponse();
			 PrintWriter out = response.getWriter();
	         out.write(json.toString());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		 return null;
	}
	//外派管理员查看所有消息
		public String messageList(){
			int id = (Integer) session.get("userid");
			try {
				message = publicSv.messageList(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "messagelist";
		}
		//管理员查看所有消息
		public String manMessageList(){
			int id = (Integer) session.get("userid");
			try {
				message = publicSv.messageList(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "manmessagelist";
		}
		//员工发送消息
		public String sendEmpMessage() throws Exception{
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			PrintWriter outjs = response.getWriter();
			int receiveid = me.getReceive_id();
			System.out.println(receiveid); 
			if(publicSv.queryEmpName(receiveid).size()==0){
				outjs.print("<script>alert('没有此员工信息！');window.location.href='employee-viewInform';</script>");
			}
			
			me.setReceive_name(publicSv.queryEmpName(receiveid).get(0).getEmployee_name());
			me.setSend_id((Integer)session.get("userid"));
			me.setSend_name((String)session.get("user"));
			me.setFlag(0);
			me.setSend_date(new Date());
			publicSv.sendMessage(me);
			
			outjs.print("<script>alert('发送成功并返回消息页面！');window.location.href='employee-viewInform';</script>");
			return null;
		}
		//员工删除信息
		public String deleteMessage() throws Exception{
			int id = Integer.parseInt(httpServletrequest.getParameter("id"));
			publicSv.deleteMessage(id);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			PrintWriter outjs = response.getWriter();
			outjs.print("<script>alert('删除成功并返回消息页面！');window.location.href='employee-viewInform';</script>");
			return null;
			
		}
		//外派管理员发送消息
				public String sendAdminMessage() throws Exception{
					HttpServletResponse response = ServletActionContext.getResponse();
					response.setCharacterEncoding("utf-8");
					response.setContentType("text/html; charset=utf-8");
					PrintWriter outjs = response.getWriter();
					int receiveid = me.getReceive_id();
					System.out.println(receiveid); 
					if(publicSv.queryEmpName(receiveid).size()==0){
						outjs.print("<script>alert('没有此员工信息！');window.location.href='public-messageList';</script>");
					}
					
					me.setReceive_name(publicSv.queryEmpName(receiveid).get(0).getEmployee_name());
					me.setSend_id((Integer)session.get("userid"));
					me.setSend_name((String)session.get("user"));
					me.setFlag(0);
					me.setSend_date(new Date());
					publicSv.sendMessage(me);
					
					outjs.print("<script>alert('发送成功并返回消息页面！');window.location.href='public-messageList';</script>");
					return null;
				}
				//管理员删除消息
				public String deleteAdminMessage() throws Exception{
					int id = Integer.parseInt(httpServletrequest.getParameter("id"));
					publicSv.deleteMessage(id);
					HttpServletResponse response = ServletActionContext.getResponse();
					response.setCharacterEncoding("utf-8");
					response.setContentType("text/html; charset=utf-8");
					PrintWriter outjs = response.getWriter();
					outjs.print("<script>alert('删除成功并返回消息页面！');window.location.href='public-manMessageList';</script>");
					return null;
					
				}
				//管理员发送消息
				public String manSendAdminMessage() throws Exception{
					HttpServletResponse response = ServletActionContext.getResponse();
					response.setCharacterEncoding("utf-8");
					response.setContentType("text/html; charset=utf-8");
					PrintWriter outjs = response.getWriter();
					int receiveid = me.getReceive_id();
					System.out.println(receiveid); 
					if(publicSv.queryEmpName(receiveid).size()==0){
						outjs.print("<script>alert('没有此员工信息！');window.location.href='public-manMessageList';</script>");
					}
					
					me.setReceive_name(publicSv.queryEmpName(receiveid).get(0).getEmployee_name());
					me.setSend_id((Integer)session.get("userid"));
					me.setSend_name((String)session.get("user"));
					me.setFlag(0);
					me.setSend_date(new Date());
					publicSv.sendMessage(me);
					
					outjs.print("<script>alert('发送成功并返回消息页面！');window.location.href='public-manMessageList';</script>");
					return null;
				}
				//外派管理员删除消息
				public String manDeleteAdminMessage() throws Exception{
					int id = Integer.parseInt(httpServletrequest.getParameter("id"));
					publicSv.deleteMessage(id);
					HttpServletResponse response = ServletActionContext.getResponse();
					response.setCharacterEncoding("utf-8");
					response.setContentType("text/html; charset=utf-8");
					PrintWriter outjs = response.getWriter();
					outjs.print("<script>alert('删除成功并返回消息页面！');window.location.href='public-messageList';</script>");
					return null;
					
				}
				//统计报表
				public String chartsList() throws Exception{
					List<Charts> ch = new ArrayList<Charts>();
					JSONArray jsons = new JSONArray();
					
					ch = publicSv.chartList();
					  for(int j=0;j<ch.size();j++){  
				           JSONObject jsonObject = new JSONObject();  
				           jsonObject.put("user", ch.get(j));  
				           jsons.add(jsonObject);  
				       } 

						 HttpServletResponse response = ServletActionContext.getResponse();
						 response.setCharacterEncoding("UTF-8");
						 response.getWriter().print(jsons);  
					return null;
				}
				//领导信箱
				public String leaderMassage(){
					String receive = httpServletrequest.getParameter("receive");
					me.setSend_id((Integer)session.get("userid"));
					me.setSend_name((String)session.get("user"));
					me.setSend_date(new Date());
					if(receive.equals("outmanager")){
						me.setReceive_id(1);
						me.setReceive_name(receive);
						
					}else{
						me.setReceive_id(2);
						me.setReceive_name(receive);
					}
					try {
						publicSv.sendMessage(me);
						HttpServletResponse response = ServletActionContext.getResponse();
						response.setCharacterEncoding("utf-8");
						response.setContentType("text/html; charset=utf-8");
						PrintWriter outjs = response.getWriter();
						outjs.print("<script>alert('发送成功并返回页面！');window.location.href='employee/leaderMail.jsp';</script>");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return null;
				}
		
	
}
