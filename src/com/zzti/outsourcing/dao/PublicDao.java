package com.zzti.outsourcing.dao;

import java.util.List;

import com.zzti.outsourcing.entities.Charts;
import com.zzti.outsourcing.entities.Employee;
import com.zzti.outsourcing.entities.Forum;
import com.zzti.outsourcing.entities.Message;
import com.zzti.outsourcing.entities.Notice;
import com.zzti.outsourcing.entities.Reply;

public interface PublicDao {
	public List<Message> messageList() throws Exception;
	public List<Message> messageList(int id) throws Exception;
	public List<Message> queryMesage(int id) throws Exception;
	public void setMessageFlag(int id) throws Exception;
	public void addMessage(Message message) throws Exception;
	public List<Employee> queryEmpName(int id) throws Exception;
	public void deleteMessage(int id) throws Exception;
	public List<Notice> findNoticeSize();
	public List<Notice> selectNoticeById(int noticeid);
	public List<Notice> noticeList(int first, int max);
	public List<Charts> chartList() throws Exception;
	public List<Charts> queryChart(String type) throws Exception;
	public void addType(Charts ch) throws Exception;
	
	public List<Forum> forumList(int first, int max);

	public List<Forum> findForumSize();

	public void addForum(Forum forum);

	public List<Reply> showReply(int id);

	public List<Forum> selectforumByid(int id);

	public void sendReply(Reply reply);

	public void updateForum(Forum forum);

	public void updateclicknum(Forum forum);

}
