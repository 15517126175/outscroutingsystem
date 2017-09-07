package com.zzti.outsourcing.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.opensymphony.xwork2.ActionContext;
import com.zzti.outsourcing.entities.Boss;
import com.zzti.outsourcing.entities.Employee;
import com.zzti.outsourcing.entities.Forum;
import com.zzti.outsourcing.entities.Institution;
import com.zzti.outsourcing.entities.Manager;
import com.zzti.outsourcing.entities.Notice;
import com.zzti.outsourcing.entities.OutEmployee;
import com.zzti.outsourcing.entities.Reply;
import com.zzti.outsourcing.entities.Resume;
import com.zzti.outsourcing.entities.Synopsis;
import com.zzti.outsourcing.entities.Train;
import com.zzti.outsourcing.entities.TrainEmp;
import com.zzti.outsourcing.entities.TrainPlan;

public class ManagerDaoImpl implements ManagerDao{
	
private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}



	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public List<Manager> managerLogin(String username) throws Exception {
  		// TODO Auto-generated method stub
        String hql = "from Manager where user_name=?";
		
	    List<Manager> anminlist = getSession().createQuery(hql).setString(0, username).list();
	    
	    return anminlist;	
	}
	public List<Employee> findEmpSize() {
		// TODO Auto-generated method stub
		String hql = "from Employee where employee_isin=1";
		List<Employee> list = getSession().createQuery(hql).list();
		return list;
	}
	public List<Employee> empList(int first, int max) {
		// TODO Auto-generated method stub
		String hql = "from Employee where  employee_isin=1";
		Query query = getSession().createQuery(hql);
		query.setFirstResult(first);
		query.setMaxResults(max);
		List<Employee> list = query.list();
		return list;
	}
	public void addemp(Employee emp) {
		// TODO Auto-generated method stub
		int a = (Integer) getSession().save(emp);
		
		System.out.println(a);
	}
	public void deleteEmp(int id) {
		// TODO Auto-generated method stub
		String hql = "update  Employee set employee_isin=2 where employee_id=?";
		
		
		Query query = getSession().createQuery(hql);
		
		query.setInteger(0, id);
	    query.executeUpdate();
	}
	public List<Employee> selectEmpById(int id) {
		// TODO Auto-generated method stub
		String hql = "from Employee where employee_isin=1 and employee_id=?";
		List<Employee> list = getSession().createQuery(hql).setInteger(0, id).list();
		return list;
	}
	public List<Employee> selectEmpByName(String name) {
		String hql = "from Employee where employee_isin=1 and employee_name like ?";
		List<Employee> list = getSession().createQuery(hql).setString(0, '%' +name+ '%' ).list();
		return list;
	}
	public void editEmp(Employee emp) {
		// TODO Auto-generated method stub
     String hql = " update  Employee set employee_name = ?,employee_phone=?,employee_email=?,employee_pwd=?  where employee_id=?";
    
						
		Query query = getSession().createQuery(hql);
		query.setString(0, emp.getEmployee_name());
		query.setLong(1, emp.getEmployee_phone());
		query.setString(2, emp.getEmployee_email());
		query.setString(3, emp.getEmployee_pwd());
		query.setInteger(4, emp.getEmployee_id());
	    query.executeUpdate();
	}
	

	public List<Employee> showEmp(int id) {
		// TODO Auto-generated method stub
		String hql = "from Employee where employee_id=?";
		List<Employee> list = getSession().createQuery(hql).setInteger(0, id).list();
		return list;
	}
	
	public List<Train> trainList(int first, int max) {
		String hql = "from Train ";
		Query query = getSession().createQuery(hql);
		query.setFirstResult(first);
		query.setMaxResults(max);
		List<Train> list = query.list();
		
		return list;
		
	}
	public List<Train> findTrainSize() {
		// TODO Auto-generated method stub
		String hql = "from Train";
		List<Train> list = getSession().createQuery(hql).list();
		
		return list;
	}
	
	public void closetrain(int id) {
		// TODO Auto-generated method stub
     String hql = "update  Train set status=2 where train_id=?";
		
		
		Query query = getSession().createQuery(hql);
		
		query.setInteger(0, id);
	    query.executeUpdate();
	}
	

	public List<Train> checkTrain() {
		// TODO Auto-generated method stub
		String hql = "from Train where status=1 ";
		List<Train> list = getSession().createQuery(hql).list();
		return list;
	}
	

	public void checkupTrain(List<Integer> arr) {
		// TODO Auto-generated method stub
		 String hql = "update  Train set status=2 where train_id=?";
		 Query query = getSession().createQuery(hql);
		 
		for(int a = 0 ; a<arr.size();a++){
			System.out.println(arr.get(a)+"---");
			query.setInteger(0, arr.get(a));
		    query.executeUpdate();
		}
		
	}
	
	
	public List<Train> selectTrainByName(String inport) {
		// TODO Auto-generated method stub
		String hql = "from Train where   train_title=? or train_trainer=?";
		Query query=getSession().createQuery(hql);
		query.setString(0, inport);
		query.setString(1, inport);
		
		List<Train> list = query.list();
		return list;
	}
	
	public List<Train> selectTrainbyId(int tid) {
		// TODO Auto-generated method stub
		String hql = "from Train where  train_id=? ";
		List<Train> list = getSession().createQuery(hql).setInteger(0, tid).list();
		return list;
	}
	
	public List<TrainEmp> findTrainEmpSize(int tid) {
		String hql = "from TrainEmp where  train_id=?";
		List<TrainEmp> list = getSession().createQuery(hql).setInteger(0, tid).list();
		
		return list;
	}
	
	public List<Employee> findEmpByTrain(List<TrainEmp> telist) {
		// TODO Auto-generated method stub
		
		List<Employee> list = new ArrayList<Employee>() ;
		String hql = "from Employee where  employee_id=?";
        Query query = getSession().createQuery(hql);
		for (TrainEmp tl : telist) {
			query.setInteger(0, tl.getEmployee_id());
			list.add((Employee) query.list().get(0));
			
		}
		
	    
		return list;
	}
	
	
	public void addNotice(Notice notice) {
		// TODO Auto-generated method stub
		int a = (Integer) getSession().save(notice);
		System.out.println(a);
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
	public void addtrain(Train train) {
		// TODO Auto-generated method stub
		int a = (Integer) getSession().save(train);
		System.out.println(a);
		
	}
	public void updatePwd(String user, String newPwd) {
		// TODO Auto-generated method stub
		String hql = "update  Manager set password=? where user_name=?";
		System.out.println(user+newPwd+"------");
		Query query = getSession().createQuery(hql);
		query.setString(0, newPwd);
		query.setString(1, user);
		query.executeUpdate();
	}
	
	public List<Synopsis> selectSynopsisbyId(int synopsis_id) {
		// TODO Auto-generated method stub
		String hql = "from Synopsis where  synopsis_id=?";
		List<Synopsis> list = getSession().createQuery(hql).setInteger(0, synopsis_id).list();
		return list;
	}
	
	public List<Employee> maxEmpId() {
		// TODO Auto-generated method stub
		String hql = "from Employee order by employee_id desc";
		Query query = getSession().createQuery(hql);
		
		List<Employee> list = query.list();
		return list;
	}

	public List<Institution> institutionList(int first, int max) {
		// TODO Auto-generated method stub
		String hql = "from Institution ";
		Query query = getSession().createQuery(hql);
		query.setFirstResult(first);
		query.setMaxResults(max);
		List<Institution> list = query.list();
		
		return list;

	}

	public List<Institution> findInstitutionSize() {
		// TODO Auto-generated method stub
		String hql = "from Institution";
		List<Institution> list = getSession().createQuery(hql).list();
		
		return list;
	}

	public List<Institution> selectInstitutionById(int id) {
		// TODO Auto-generated method stub
		String hql = "from Institution where  institution_id=?";
		List<Institution> list = getSession().createQuery(hql).setInteger(0, id).list();
		return list;
	}
	public void addInstitution(Institution institution) {
		// TODO Auto-generated method stub
		int a = (Integer) getSession().save(institution);
		System.out.println(a);
	}
	public List<Resume> findResume(int employeeId) {
		// TODO Auto-generated method stub
		String hql = "from Resume where employee_id=?";
		List<Resume> list = getSession().createQuery(hql).setInteger(0, employeeId).list();
		return list;
	}
	public List<OutEmployee> findAllTask(int employeeId) {
		// TODO Auto-generated method stub
		String hql = "from OutEmployee where employee_id=? and worker_status=2";
		List<OutEmployee> oe = getSession().createQuery(hql).setInteger(0, employeeId).list();
		return oe;
	}
	public List<TrainPlan> trainplanList(int first, int max) {
		// TODO Auto-generated method stub
		String hql = "from TrainPlan ";
		Query query = getSession().createQuery(hql);
		query.setFirstResult(first);
		query.setMaxResults(max);
		List<TrainPlan> list = query.list();
		
		return list;
	}
	public List<TrainPlan> findtrainplanSize() {
		// TODO Auto-generated method stub
		String hql = "from TrainPlan";
		List<TrainPlan> list = getSession().createQuery(hql).list();
		return list;
	}
	public List<TrainPlan> selectTrainplanebyid(int tpid) {
		// TODO Auto-generated method stub
		String hql = "from TrainPlan where  trainplan_id=?";
		List<TrainPlan> list = getSession().createQuery(hql).setInteger(0, tpid).list();
		return list;
	}
	public void addTrainplan(TrainPlan trainplan) {
		// TODO Auto-generated method stub
		getSession().save(trainplan);
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
