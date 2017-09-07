package com.zzti.outsourcing.service;

import java.util.List;

import com.zzti.outsourcing.dao.PublicDao;
import com.zzti.outsourcing.entities.Charts;
import com.zzti.outsourcing.entities.Employee;
import com.zzti.outsourcing.entities.Forum;
import com.zzti.outsourcing.entities.Message;
import com.zzti.outsourcing.entities.Notice;
import com.zzti.outsourcing.entities.Reply;

public class PublicSV {
	private PublicDao publicDao;
	private List<Message> message;
	

	public List<Message> getMessage() {
		return message;
	}

	public void setMessage(List<Message> message) {
		this.message = message;
	}
	
	
	public PublicDao getPublicDao() {
		return publicDao;
	}

	public void setPublicDao(PublicDao publicDao) {
		this.publicDao = publicDao;
	}
		public List<Message> messageList() throws Exception{
			List<Message> list = publicDao.messageList();
			return list;
		}
	//新消息提醒
		public List<Message> queryMessage(int id) throws Exception{
			List<Message> list = publicDao.queryMesage(id);
			return list;
		}
		//查看所有消息
		public List<Message> messageList(int id) throws Exception{
			publicDao.setMessageFlag(id);
			return publicDao.messageList(id);
		}
		//发送消息
		public void sendMessage(Message message) throws Exception{
			publicDao.addMessage(message);
		}
		//删除消息
		public void deleteMessage(int id) throws Exception{
			publicDao.deleteMessage(id);
		}
		//根据id查员工名
		public List<Employee> queryEmpName(int id) throws Exception{
			return publicDao.queryEmpName(id);
		}
		public List<Notice> noticeList(int first, int max) {
			// TODO Auto-generated method stub
			return publicDao.noticeList(first, max);
		}

		public List<Notice> findNoticeSize() {
			// TODO Auto-generated method stub
			return publicDao.findNoticeSize();
		}
		public List<Notice> selectNotice(String notice_id) {
			// TODO Auto-generated method stub
			int noticeid = Integer.parseInt(notice_id);
			return publicDao.selectNoticeById(noticeid);
		}
		public List<Charts> chartList() throws Exception{
			
				return publicDao.chartList();
			
		}
		public void addType(Charts ch){
			try {
				publicDao.addType(ch);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public List<Charts> queryChart(String type){
			try {
				return publicDao.queryChart(type);
			} catch (Exception e) {
				
				e.printStackTrace();
				return null;
			}
			
		}
		
		public List<Forum> forumList(int first, int max) {
			// TODO Auto-generated method stub
			return publicDao.forumList(first, max);
		}

		public List<Forum> findForumSize() {
			// TODO Auto-generated method stub
			return publicDao.findForumSize();
		}

		public void addForum(Forum forum) {
			// TODO Auto-generated method stub
			publicDao.addForum(forum);
		}

		public List<Reply> showReply(int id) {
			// TODO Auto-generated method stub
			return publicDao.showReply(id);
		}

		public List<Forum> selectforumByid(int id) {
			// TODO Auto-generated method stub
			return publicDao.selectforumByid(id);
		}

		public void sendReply(Reply reply) {
			// TODO Auto-generated method stub
			publicDao.sendReply(reply);
		}

		public void updateForum(Forum forum) {
			// TODO Auto-generated method stub
			publicDao.updateForum(forum);
		}

		public void updateclicknum(Forum forum) {
			// TODO Auto-generated method stub
			publicDao.updateclicknum(forum);
		}


}
