package com.zzti.outsourcing.dao;

import java.util.Date;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;


import com.zzti.outsourcing.entities.Boss;
import com.zzti.outsourcing.entities.CheckWork;
import com.zzti.outsourcing.entities.Employee;
import com.zzti.outsourcing.entities.Message;
import com.zzti.outsourcing.entities.OutEmployee;
import com.zzti.outsourcing.entities.OutManager;
import com.zzti.outsourcing.entities.OutProject;
import com.zzti.outsourcing.entities.ProjectAllocate;

public class OutManagerDaoImpl implements OutManagerDao {
private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	//根据管理员用户名查登陆信息
	public List<OutManager> managerLogin(String username) throws Exception {
		String hql = "from OutManager where manager_name=?";
		
	    List<OutManager> list = getSession().createQuery(hql).setString(0, username).list();
	    return list;
	}
	//修改密码
	public void updatePwd(String user, String pwd) throws Exception {
		
		String hql = "update OutManager set password=? where manager_name=?";
		Query query = getSession().createQuery(hql);
		query.setString(0, pwd);
		query.setString(1, user);
		query.executeUpdate();	
	}
	
	public List<Boss> bossList(int first, int max) throws Exception {
		String hql = "from Boss";
		Query query = getSession().createQuery(hql);
		query.setFirstResult(first);
		query.setMaxResults(max);
		List<Boss> list = query.list();
		return list;
	}
	public List<Boss> findBossSize() throws Exception {
		String hql = "from Boss";
		List<Boss> list = getSession().createQuery(hql).list();
		return list;
	}
	//根据id查发包方
	public List<Boss> selectBossById(int id) throws Exception {
		String hql = "from Boss where boss_id=?";
		List<Boss> list = getSession().createQuery(hql).setInteger(0, id).list();
		return list;
	}
	//根据名称查发包方
	public List<Boss> selectBossByName(String name) throws Exception {
		String hql = "from Boss where boss_name=?";
		List<Boss> list = getSession().createQuery(hql).setString(0, name).list();
		return list;
	}
	//根据id删除发包方
	public void deleteBoss(int id) throws Exception {
		String hql = "delete from Boss where boss_id=?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, id);
		query.executeUpdate();
	}
	//获取最大的id号
	public List<Boss> maxBossId() throws Exception {
		// TODO Auto-generated method stub
		String hql = "from Boss order by boss_id desc";
		Query query = getSession().createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(1);
		List<Boss> list = query.list();
		return list;
	}
	//增加一个发包方
	public void addBoss(Boss boss) throws Exception {
		// TODO Auto-generated method stub
		getSession().save(boss);
	}
	//删除发包方信息
	public void deleteBossAll(int[] ids) throws Exception {
		// TODO Auto-generated method stub
		
		for(int i=0;i<ids.length;i++){
			int id=ids[i];
			String hql = "delete from Boss where boss_id=?";
			Query query = getSession().createQuery(hql);
			query.setInteger(0, id);
			query.executeUpdate();
		}
	}
	
	public void editBoss(Boss boss) throws Exception {
		
		getSession().update(boss);
	}
	//根据id查询项目工程信息
	public List<OutProject> queryProject(int id) throws Exception {
	
		String hql = "from OutProject where project_id=?";
		List<OutProject> list = getSession().createQuery(hql).setInteger(0, id).list();
		return list;
		
	}
	//查一段时间内所有的项目工程
	public List<OutProject> queryProject(Date start, Date end) throws Exception {
		String hql = "from OutProject where enter_time between ? and ?";
		System.out.println(start+","+end);
		Query query = getSession().createQuery(hql);
		query.setDate(0, start);
		query.setDate(1, end);
		List<OutProject> list = query.list();
		return list;
	}
	//根据分配情况查询一段时间内的项目工程
	public List<OutProject> queryProject(Date start, Date end, int flage)
			throws Exception {
		
		String hql = "from OutProject where enter_time between ? and ? and project_flage=?";
		Query query = getSession().createQuery(hql);
		query.setDate(0, start);
		query.setDate(1, end);
		query.setInteger(2, flage);
		List<OutProject> list = query.list();
		return list;
	}
	//获取最大的外包项目id
	public List<OutProject> maxOutProjectId() throws Exception {
		String hql = "from OutProject order by project_id desc";
		Query query = getSession().createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(1);
		List<OutProject> list = query.list();
		return list;
	}
	//添加外包项目
	public void addOutProject(OutProject pro) throws Exception {
		getSession().save(pro);
		
	}
	//根据项目来源查外包项目
	public List<OutProject> queryProject(String name) throws Exception {
		String hql = "from OutProject where boss_name=?";
		List<OutProject> list = getSession().createQuery(hql).setString(0, name).list();
		return list;
	}
	//查询所有外派人员
	public List<OutEmployee> outEmpList(int first, int max) throws Exception {
		String hql = "from OutEmployee";
		Query query = getSession().createQuery(hql);
		query.setFirstResult(first);
		query.setMaxResults(max);
		List<OutEmployee> list = query.list();
		return list;
	}
	public List<OutEmployee> findOutEmpSize() throws Exception {
		String hql = "from OutEmployee";
		List<OutEmployee> list = getSession().createQuery(hql).list();
		return list;
	}
	//根据id查询员工信息
	public List<Employee> queryEmp(int id) throws Exception {
		String hql = "from Employee where employee_id=?";
		List<Employee> list = getSession().createQuery(hql).setInteger(0, id).list();
		return list;
		
	}
	//根据姓名查询员工信息
	public List<Employee> queryEmp(String name) throws Exception {
		String hql = "from Employee where employee_name=?";
		List<Employee> list = getSession().createQuery(hql).setString(0, name).list();
		return list;
		
	}
	//查询员工信息
	public List<Employee> queryEmp() throws Exception {
		String hql = "from Employee";
		List<Employee> list = getSession().createQuery(hql).list();
		return list;	
	}
	//分页查询员工信息
	public List<Employee> queryEmp(int first,int max) throws Exception{
		String hql = "from Employee";
		Query query = getSession().createQuery(hql);
		query.setFirstResult(first);
		query.setMaxResults(max);
		List<Employee> list = query.list();
		return list;
		
	}
	
	//发布一个消息通知
	public void sendMessage(Message message) throws Exception {
		getSession().save(message);
	}
	//记录分配情况
	public void sendEmp(ProjectAllocate projectAllocate) throws Exception {
		getSession().save(projectAllocate);
		
	}
	public List<ProjectAllocate> sendProjectQuery(int proid) throws Exception {
		String hql = "from ProjectAllocate where project_id=?";
		List<ProjectAllocate> list = getSession().createQuery(hql).setInteger(0, proid).list();
		return list;
	}
	public List<ProjectAllocate> sendProjectQuery(String proname)
			throws Exception {
		String hql = "from ProjectAllocate where project_name=?";
		List<ProjectAllocate> list = getSession().createQuery(hql).setString(0, proname).list();
		return list;
	}
	//查询所有分配的项目
	public List<ProjectAllocate> sendProjectList(int first, int max)
			throws Exception {
		String hql = "from ProjectAllocate";
		Query query = getSession().createQuery(hql);
		query.setFirstResult(first);
		query.setMaxResults(max);
		List<ProjectAllocate> list = query.list();
		return list;
	}
	public List<ProjectAllocate> findsendProjectSize() throws Exception {
		String hql = "from ProjectAllocate";
		List<ProjectAllocate> list = getSession().createQuery(hql).list();
		return list;
	}
	//上传面试成功的员工到外派员工表中
	public void upOutEmp(OutEmployee outEmp) throws Exception {
		getSession().save(outEmp);
		
	}
	//更新员工信息
	public void updateEmp(Employee emp) throws Exception {
		getSession().update(emp);
		
	}
	//更新分配信息
	public void updateProjectAllocate(ProjectAllocate pro) throws Exception {
		getSession().update(pro);
		
	}
	public List<ProjectAllocate> findsendProject(int empid) throws Exception {
		String hql = "from ProjectAllocate where employee_id=?";
		List<ProjectAllocate> list = getSession().createQuery(hql).setInteger(0, empid).list();
		return list;
		
	}
	//更新外包项目信息
	public void updateOutProject(OutProject outpro) throws Exception {
		// TODO Auto-generated method stub
		getSession().update(outpro);
	
	}
	public List<OutEmployee> outEmpQueryById(int id) throws Exception {
		String hql = "from OutEmployee where employee_id=?";
		List<OutEmployee> list = getSession().createQuery(hql).setInteger(0, id).list();
		return list;
	}
	public List<OutEmployee> outEmpQueryByName(String name) throws Exception {
		String hql = "from OutEmployee where employee_name=?";
		List<OutEmployee> list = getSession().createQuery(hql).setString(0, name).list();
		return list;	
	}
	public List<OutProject> projectSearch(String search) throws Exception {
		String hql = "from OutProject where project_name like:name";
		List<OutProject> list = getSession().createQuery(hql).setString("name",  "%" + search + "%").list();
		return list;
	}
	//查询所有考勤记录
	public List<CheckWork> checkWorkList(int first, int max) throws Exception {
		String hql = "from CheckWork";
		Query query = getSession().createQuery(hql);
		query.setFirstResult(first);
		query.setMaxResults(max);
		List<CheckWork> list = query.list();
		return list;
	}
	public List<CheckWork> checkWorkList() throws Exception {
		String hql = "from CheckWork";
		List<CheckWork> list = getSession().createQuery(hql).list();
		return list;
	}
	public List<CheckWork> checkWorkList(int id) throws Exception {
		String hql = "from CheckWork where employee_id=?";
		List<CheckWork> list = getSession().createQuery(hql).setInteger(0, id).list();
		return list;
	}
	public List<CheckWork> checkWorkList(String name) throws Exception {
		String hql = "from CheckWork where employee_name=?";
		List<CheckWork> list = getSession().createQuery(hql).setString(0, name).list();
		return list;	
	}
	//结束外包项目
	public void endProject(int proid) throws Exception {
		String hql = "update OutProject set project_flage=? where project_id=?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, 2);
		query.setInteger(1, proid);
		query.executeUpdate();
		
	}
	//根据外包项目id查外包员工记录
	public List<OutEmployee> outEmpQueryByProid(int id) throws Exception {
		String hql = "from OutEmployee where project_id=?";
		List<OutEmployee> list = getSession().createQuery(hql).setInteger(0, id).list();
		return list;
	}
	
	
	
	

}
