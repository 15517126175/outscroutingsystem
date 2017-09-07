package com.zzti.outsourcing.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zzti.outsourcing.entities.Charts;
import com.zzti.outsourcing.entities.Employee;
import com.zzti.outsourcing.entities.Forum;
import com.zzti.outsourcing.entities.Message;
import com.zzti.outsourcing.entities.Notice;
import com.zzti.outsourcing.entities.Reply;

public class PublicDaoImpl implements PublicDao {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	public List<Message> messageList(int id) throws Exception {
		String hql = "from Message where receive_id=? order by send_date desc";
		List<Message> list = getSession().createQuery(hql).setInteger(0, id).list();
		return list;
	}
	public List<Message> queryMesage(int id) throws Exception {
		String hql = "from Message where receive_id=? and flag=?";
		List<Message> list = getSession().createQuery(hql).setInteger(0, id).setInteger(1,0).list();
		return list;
	}
	public void setMessageFlag(int id) throws Exception {
		String hql = "update Message set flag=1 where receive_id=?";
		getSession().createQuery(hql).setInteger(0, id).executeUpdate();
	}
	public void addMessage(Message message) throws Exception {
		getSession().save(message);
		
	}
	public List<Message> messageList() throws Exception {
		String hql = "from Message order by id desc";
		List<Message> list = getSession().createQuery(hql).list();
		return list;
	}
	public List<Employee> queryEmpName(int id) throws Exception {
		String hql = "from Employee where employee_id=?";
		List<Employee> list = getSession().createQuery(hql).setInteger(0, id).list();
		return list;
	}
	public void deleteMessage(int id) throws Exception {
		String hql = "delete from Message where id=?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, id);
		query.executeUpdate();
		
	}
	public List<Notice> findNoticeSize() {
		// TODO Auto-generated method stub
		
		String hql = "from Notice";
		List<Notice> list = getSession().createQuery(hql).list();
		
		return list;
	}
	public List<Notice> noticeList(int first, int max) {
		// TODO Auto-generated method stub
		String hql = "from Notice ";
		Query query = getSession().createQuery(hql);
		query.setFirstResult(first);
		query.setMaxResults(max);
		List<Notice> list = query.list();
		
		return list;
	}
	public List<Notice> selectNoticeById(int noticeid) {
		// TODO Auto-generated method stub
		String hql = "from Notice where  notice_id=?";
		List<Notice> list = getSession().createQuery(hql).setInteger(0, noticeid).list();
		return list;
	}
	public List<Charts> chartList() throws Exception {
		String hql = "from Charts";
		List<Charts> list = getSession().createQuery(hql).list();
		
		return list;
	}
	public void addType(Charts ch) throws Exception {
		getSession().update(ch);
	}
	public List<Charts> queryChart(String type) throws Exception {
		String hql = "from Charts where type=?";
		List<Charts> list = getSession().createQuery(hql).setString(0, type).list();
		
		return list;
	}
	
	
	public List<Forum> forumList(int first, int max) {
		// TODO Auto-generated method stub
		String hql = "from Forum ";
		Query query = getSession().createQuery(hql);
		query.setFirstResult(first);
		query.setMaxResults(max);
		List<Forum> list = query.list();
		return list;
	}
	public List<Forum> findForumSize() {
		// TODO Auto-generated method stub
		String hql = "from Forum";
		List<Forum> list = getSession().createQuery(hql).list();
		return list;
	}
	public void addForum(Forum forum) {
		// TODO Auto-generated method stub
		getSession().save(forum);
	}
	public List<Reply> showReply(int id) {
		// TODO Auto-generated method stub
		String hql = "from Reply where forum_id=?";
		List<Reply> list = getSession().createQuery(hql).setInteger(0, id).list();
		return list;
	}
	public List<Forum> selectforumByid(int id) {
		// TODO Auto-generated method stub
		String hql = "from Forum where forum_id=?";
		List<Forum> list = getSession().createQuery(hql).setInteger(0, id).list();
		return list;
	}
	public void sendReply(Reply reply) {
		// TODO Auto-generated method stub
		getSession().save(reply);
	}
	public void updateForum(Forum forum) {
		// TODO Auto-generated method stub
		String hql = "update  Forum set forum_name=? ,forum_newtime=?   where forum_id=?";
		
		Query query = getSession().createQuery(hql);
		query.setString(0, forum.getForum_name());
		query.setDate(1, forum.getForum_newtime());
		query.setInteger(2, forum.getForum_id());
		
		query.executeUpdate();
	}
	public void updateclicknum(Forum forum) {
		// TODO Auto-generated method stub
      String hql = "update  Forum set forum_clinknum=?   where forum_id=?";
		
		Query query = getSession().createQuery(hql);
		query.setInteger(0, forum.getForum_clinknum());
		
		query.setInteger(1, forum.getForum_id());
		
		query.executeUpdate();
	}
}
