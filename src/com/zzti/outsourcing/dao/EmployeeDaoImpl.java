package com.zzti.outsourcing.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import com.opensymphony.xwork2.ActionContext;
import com.zzti.outsourcing.entities.Boss;
import com.zzti.outsourcing.entities.CheckWork;
import com.zzti.outsourcing.entities.Employee;
import com.zzti.outsourcing.entities.Leave;
import com.zzti.outsourcing.entities.Message;
import com.zzti.outsourcing.entities.OutEmployee;
import com.zzti.outsourcing.entities.OutProject;
import com.zzti.outsourcing.entities.ProjectAllocate;
import com.zzti.outsourcing.entities.PublicResume;
import com.zzti.outsourcing.entities.Resume;
import com.zzti.outsourcing.entities.Salary;
import com.zzti.outsourcing.entities.Train;
import com.zzti.outsourcing.entities.TrainEmp;
import com.zzti.outsourcing.entities.TrainResult;


public class EmployeeDaoImpl implements EmployeeDao {
	
	private SessionFactory sessionFactory;
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

		//根据员工id匹对登陆信息
		public List<Employee> employeeLogin(int employeeId) throws Exception {
			String hql = "from Employee where employee_id=? and employee_isin=1"; 
		    List<Employee> list = getSession().createQuery(hql).setInteger(0, employeeId).list();
		    return list;
		}
	
		//修改密码
		public void updatePwd(int employeeId, String pwd) throws Exception {
			String hql = "update Employee set employee_pwd=? where employee_id=?";
			Query query = getSession().createQuery(hql);
			query.setString(0, pwd);
			query.setInteger(1, employeeId);
			query.executeUpdate();
			
		}
		
		//查询个人信息
		public List<Employee> selectInfo(int employeeId) throws Exception{
			String hql = "from Employee where employee_id=?";
			List<Employee> list = getSession().createQuery(hql).setInteger(0, employeeId).list();
			return list;
		}
		
		//修改个人信息
		public void editInfo(Employee info)throws Exception{
			getSession().update(info);	
		}
		
		//查看个人简历
		public List<Resume> findResume(int employeeId)throws Exception{
			String hql = "from Resume where employee_id=?";
			List<Resume> list = getSession().createQuery(hql).setInteger(0, employeeId).list();
			return list;
		}
		
		//删除当前简历
		public void deleteResume(int employeeId)throws Exception{
			String hql = "delete from Resume where employee_id=?";
			Query query = getSession().createQuery(hql);
			query.setInteger(0, employeeId);
			query.executeUpdate();
		}
		
		//修改当前简历
		public void editResume(Resume resume)throws Exception{
			getSession().update(resume);
		}
		
		//创建新的简历
		public void addResume(Resume resume1)throws Exception{
			getSession().save(resume1);
		}
		
		//上发简历至服务器
		public void hairResume(PublicResume pr)throws Exception{
			getSession().save(pr);
		}
		
		//检测简历是否已存在
		public List<PublicResume> findPResume(int employeeId)throws Exception{
			String hql = "from PublicResume where pr_id=?";
			List<PublicResume> list = getSession().createQuery(hql).setInteger(0, employeeId).list();
			return list;	
		}
		
		//新信息接收检测
		public List<Message> receinvInform(int employeeId)throws Exception{
			String hql = "from Message where receive_id=?";
			List<Message> message = getSession().createQuery(hql).setInteger(0, employeeId).list();
			return message;
		}
		
		//查看外派任务
		public List<OutEmployee> selectTask(int first,int max,int employeeId)throws Exception{
			String hql = "from OutEmployee where employee_id=?";
			Query query = getSession().createQuery(hql).setInteger(0, employeeId);
			query.setFirstResult(first);
			query.setMaxResults(max);
			List<OutEmployee> list = query.list();
			return list;
		}
		public List<OutEmployee> findTaskSize(int employeeId) throws Exception {
			String hql = "from OutEmployee where employee_id=?";
			List<OutEmployee> count = getSession().createQuery(hql).setInteger(0, employeeId).list();
			return count;
		}
		
		//根据项目名查询项目明细
		public List<OutProject> viewProject(String name)throws Exception{
			String hql ="from OutProject where project_name=?";
			List<OutProject> op = getSession().createQuery(hql).setString(0, name).list();
			return op;
		}
		
		//查看消息
		public List<Message> viewInform(int employeeId)throws Exception{
			String hql = "from Message where receive_id=? and flag=0";
			List<Message> message = getSession().createQuery(hql).setInteger(0, employeeId).list();
			return message;
		}
		
		//反馈前查询
		public List<ProjectAllocate> selectProject(int id,int mid1)throws Exception{
			String hql = "from ProjectAllocate where employee_id=? and project_id=?";
			List<ProjectAllocate> pa = getSession().createQuery(hql).setInteger(0, id).setInteger(1, mid1).list();
			return pa;
		}
		
		//反馈面试结果
		public void updateEnd(ProjectAllocate pa)throws Exception{
			getSession().update(pa);
		}
		
		//反馈结果后修改消息标识
		public void updateFlag(Message ma)throws Exception{
			getSession().update(ma);
		}

		//查看参加的培训
		public List<TrainResult> viewTrain(int first,int max,int id) throws Exception {
			String hql = "from TrainResult where train_proId=?";
			Query query = getSession().createQuery(hql).setInteger(0, id);
			query.setFirstResult(first);
			query.setMaxResults(max);
			List<TrainResult> tr = query.list();
			return tr;
		}
		public List<TrainResult> findTrainSize(int id) throws Exception {
			String hql = "from TrainResult where train_proId=?";
			List<TrainResult> count = getSession().createQuery(hql).setInteger(0, id).list();
			return count;
		}
		public List<TrainResult> findTrainResultSize(int tid,int empId) throws Exception {
			String hql = "from TrainResult where train_id=? and train_proId=?";
			Query query = getSession().createQuery(hql);
			query.setInteger(0,tid);
			query.setInteger(1, empId);
			List<TrainResult> tr = query.list();
			return tr;
		}
		
		//检查是否满足报名培训的条件
		public List<OutEmployee> checkTask(int id) throws Exception {
			String hql = "from OutEmployee where employee_id=? and worker_status=3";
			List<OutEmployee> count = getSession().createQuery(hql).setInteger(0, id).list();
			return count;
		}

		//遍历培训课题
		public List<Train> lookTrain() throws Exception {
			String hql = "from Train where 1=1";
			List<Train> t = getSession().createQuery(hql).list();
			return t;
		}
		//拉取单条课题信息
		public List<Train> getAllById(int tid)throws Exception{
			String hql = "from Train where train_id=?";
			List<Train> t = getSession().createQuery(hql).setInteger(0, tid).list();
			return t;
		}

		//查看全部已参与并且未开始的培训
		public List<Train> sureTrain(int empId) throws Exception {
			String hql = "from TrainResult where train_proId=? and flag=0";
			List<Train> t = getSession().createQuery(hql).setInteger(0, empId).list();
			return t;
		}
		//查看本次报名
		public List<Train> choseTrain(int tid)throws Exception{
			String hql = "from Train where train_id=?";
			List<Train> train = getSession().createQuery(hql).setInteger(0,tid).list();
			return train;
		}

		
		public List<Message> choseInform(int mid) throws Exception {
			String hql = "from Message where id=?";
			List<Message> message = getSession().createQuery(hql).setInteger(0,mid).list();
			return message;
		}

		
		public void insertTrainResult(TrainResult trainresult) throws Exception {
			getSession().save(trainresult);
		}

		//薪资查看检测
		public List<OutEmployee> checkSalary(int empId) throws Exception {
			String hql = "from OutEmployee where employee_id=?";
			List<OutEmployee> oe = getSession().createQuery(hql).setInteger(0, empId).list();
			return oe;
		}

		//删除培训结果数据
		public void deleteTrainResult(int id,int empId) throws Exception {
			String hql = "delete from TrainResult where train_id=? and train_proId=?";
			Query query = getSession().createQuery(hql);
			query.setInteger(0, id);
			query.setInteger(1, empId);
			query.executeUpdate();			
		}
        //取消后更新报名数据
		public void updateTrain(Train t) throws Exception {
			getSession().update(t);
			
		}

		//考勤查看
		public List<CheckWork> checkWork(int empId) throws Exception {
			String hql = "from CheckWork where employee_id=?";
			List<CheckWork> cw = getSession().createQuery(hql).setInteger(0, empId).list();
			return cw;
		}

		//单条培训信息查看
		public List<Train> lookTrain(int tid) throws Exception {
			String hql = "from Train where train_id=?";
			List<Train> t = getSession().createQuery(hql).setInteger(0, tid).list();
			return t;
		}
		
		//培训报名后插入中间表数据
		public void insertTrainEmp(TrainEmp te)throws Exception{
			getSession().save(te);
		}
		
		//单独上传本地简历
		public void upResume(int empId, String file1FileName) throws Exception {
			String hql = "update Resume set local_resume=? where employee_id=?";
			Query query = getSession().createQuery(hql);
			query.setString(0, file1FileName);
			query.setInteger(1, empId);
			query.executeUpdate();
		}

		//根据id查询指定培训信息
		public List<Train> selectTrainById(int id) throws Exception {
			String hql = "from Train where train_id=?";
			List<Train> list = getSession().createQuery(hql).setInteger(0, id).list();
			return list;
		}
		
		//根据名称查询指定培训信息
		public List<Train> selectTrainByName(String inport) throws Exception {
			String hql = "from Train where train_title=?";
			List<Train> list = getSession().createQuery(hql).setString(0, inport).list();
			return list;
		}

		//报名取消后删除中间表数据
		public void deleteTrainEmp(int id, int empId) throws Exception {
			String hql = "delete from TrainEmp where train_id=? and employee_id=?";
			Query query = getSession().createQuery(hql);
			query.setInteger(0, id);
			query.setInteger(1, empId);
			query.executeUpdate();	
			
		}

		//为简历添加项目经历
		public List<OutEmployee> findAllTask(int id) throws Exception {
			String hql = "from OutEmployee where employee_id=? and worker_status=2";
			List<OutEmployee> oe = getSession().createQuery(hql).setInteger(0, id).list();
			return oe;
		}

		public List<OutEmployee> findTasking(int empId) throws Exception {
			String hql = "from OutEmployee where employee_id=? and worker_status=1";
			List<OutEmployee> oe = getSession().createQuery(hql).setInteger(0, empId).list();
			return oe;
		}

		//任务完成提交
		public void updateEmployeeStatus(int empId)throws Exception {
			String hql = "update Employee set work_status='E' where employee_id=?";
			Query query = getSession().createQuery(hql);
			query.setInteger(0, empId);
			query.executeUpdate();
			
		}
		public void updateProjectStatus(int empId, String pname) throws Exception {
			String hql = "update OutEmployee set worker_status=2 where employee_id=? and project_name=?";
			Query query = getSession().createQuery(hql);
			query.setInteger(0, empId);
			query.setString(1, pname);
			query.executeUpdate();
			
		}

		//面试类消息查询
		public List<ProjectAllocate> interview(int id) throws Exception {
			String hql = "from ProjectAllocate where employee_id=?";
			List<ProjectAllocate> m = getSession().createQuery(hql).setInteger(0, id).list();
			return m;
		}
		public List<ProjectAllocate> selectInterview(int id,int empId) throws Exception {
			String hql = "from ProjectAllocate where project_id=? and employee_id=?";
			List<ProjectAllocate> m = getSession().createQuery(hql).setInteger(0, id).setInteger(1,empId).list();
			return m;
		}
		public List<ProjectAllocate> selectInterviewByName(String name,int empId)throws Exception {
			String hql = "from ProjectAllocate where project_name=? and employee_id=?";
			List<ProjectAllocate> m = getSession().createQuery(hql).setString(0, name).setInteger(1,empId).list();
			return m;
		}

		//多条件查询外派项目
		public List<OutEmployee> selectProjectByName(String name, int empId)throws Exception {
			String hql = "from OutEmployee where project_name=? and employee_id=?";
			List<OutEmployee> oe = getSession().createQuery(hql).setString(0, name).setInteger(1, empId).list();
			return oe;
		}
		public List<OutEmployee> selectProjectByCity(String city, int empId)throws Exception {
			String hql = "from OutEmployee where city=? and employee_id=?";
			List<OutEmployee> oe = getSession().createQuery(hql).setString(0, city).setInteger(1, empId).list();
			return oe;
		}
		public List<OutEmployee> selectProjectByType(String type, int empId)throws Exception {
			String hql = "from OutEmployee where project_type=? and employee_id=?";
			List<OutEmployee> oe = getSession().createQuery(hql).setString(0, type).setInteger(1, empId).list();
			return oe;
		}

		public void addholiday(Leave lee) throws Exception{
			getSession().save(lee);
		}

		public List<Leave> checkholiday(int empId) throws Exception {
			String hql = "from Leave where employee_id=? and flag=1";
			List<Leave> leave = getSession().createQuery(hql).setInteger(0, empId).list();
			return leave;
		}

		public List<Leave> viewholiday(int empId) throws Exception {
			String hql = "from Leave where employee_id=?";
			List<Leave> leave = getSession().createQuery(hql).setInteger(0, empId).list();
			return leave;
		}

		public void stopholiday(int empId,String nowtime, long days) throws Exception {
			String hql = "update Leave set end_time=?,days=?,flag=2 where employee_id=? and flag=1";
			Query query = getSession().createQuery(hql);
			query.setString(0, nowtime);
			query.setLong(1, days);
			query.setInteger(2, empId);
			query.executeUpdate();
		}
		public void stopholidayById(int empId)throws Exception{
			String hql = "update Leave flag=2 where employee_id=? and flag=1";
			Query query = getSession().createQuery(hql);
			query.setInteger(0, empId);
			query.executeUpdate();
		}

		//根据员工姓名薪资查询
		public List<Salary> findSalaryByName(String empName) throws Exception {
			String hql = "from Salary where employee_name=?";
			List<Salary> salary = getSession().createQuery(hql).setString(0, empName).list();
			return salary;
		}
		
		//培训反馈
		public List<TrainEmp> checkTrainEmp(int empId, int tid)throws Exception {
			String hql = "from TrainEmp where employee_id=? and train_id=?";
			List<TrainEmp> te = getSession().createQuery(hql).setInteger(0, empId).setInteger(1, tid).list();
			return te;
		}

		public List<TrainEmp> checkTrainEmpById(int id) throws Exception {
			String hql = "from TrainEmp where employee_id=?";
			List<TrainEmp> te = getSession().createQuery(hql).setInteger(0, id).list();
			return te;
		}

		public void feedback(String feedtrain, String feedtrainer, int empId,int tid)throws Exception{
			String hql = "update TrainEmp set feed_train=?,feed_trainer=? where employee_id=? and train_id=?";
			Query query = getSession().createQuery(hql);
			query.setString(0, feedtrain);
			query.setString(1, feedtrainer);
			query.setInteger(2, empId);
			query.setInteger(3, tid);
			query.executeUpdate();
		}

		
		
		
	
	
	

}
