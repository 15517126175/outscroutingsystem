package com.zzti.outsourcing.service;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.zzti.outsourcing.dao.ManagerDao;
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

public class ManagerSV {
	
	private ManagerDao managerDao;

	public ManagerDao getManagerDao() {
		return managerDao;
	}

	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}

	public List<Manager> managerLogin(String username) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("***");
		return managerDao.managerLogin(username);
	}
	
	//查询雇员人数
		public List<Employee> findEmpSize() throws Exception{
			return managerDao.findEmpSize();
		}
		//查询所有人员
		public List<Employee> employeeList(int first,int max) throws Exception{
			return managerDao.empList(first, max);
			
		}

		public void addemp(Employee emp) {
			// TODO Auto-generated method stub
			managerDao.addemp(emp);
		}

		public void deleteEmp(String empid) {
			// TODO Auto-generated method stub
			int id = Integer.parseInt(empid);
			managerDao.deleteEmp(id);
		}
		
		public List<Employee> selectEmp(String id){
			try {
				int empid = Integer.parseInt(id);
				return managerDao.selectEmpById(empid);
				
				
			} catch (Exception e) {
				try {
					return managerDao.selectEmpByName(id);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			return null;
			
		}

		public void editEmp(Employee emp) {
			// TODO Auto-generated method stub
			managerDao.editEmp(emp);
		}

		public List<Train> trainList(int first, int max) {
			// TODO Auto-generated method stub
			return managerDao.trainList(first, max);
		}

		public List<Train> findTrainSize() {
			// TODO Auto-generated method stub
			return  managerDao.findTrainSize();
		}

		public void addNotice(Notice notice) {
			// TODO Auto-generated method stub
			managerDao.addNotice(notice);
		}

		public List<Notice> noticeList(int first, int max) {
			// TODO Auto-generated method stub
			return managerDao.noticeList(first, max);
		}

		public List<Notice> findNoticeSize() {
			// TODO Auto-generated method stub
			return managerDao.findNoticeSize();
		}

		public List<Notice> selectNotice(String notice_id) {
			// TODO Auto-generated method stub
			int noticeid = Integer.parseInt(notice_id);
			return managerDao.selectNoticeById(noticeid);
		}

		public void addtrain(Train train) {
			// TODO Auto-generated metrainthod stub
			managerDao.addtrain(train);
		
		}

		public void closetrain(String id) {
			// TODO Auto-generated method stub
			
			int trainid = Integer.parseInt(id);
			managerDao.closetrain(trainid);
		}

		public List<Train> selectTrain(String inport) {
			// TODO Auto-generated method stub
			return managerDao.selectTrainByName(inport);
		}

		public List<Train> selectTrainbyId(int tid) {
			// TODO Auto-generated method stub
			return managerDao.selectTrainbyId(tid);
		}

		public List<TrainEmp> findTrainEmpSize(int tid) {
			// TODO Auto-generated method stub
			return managerDao.findTrainEmpSize(tid);
			
		}

		public void updatePwd(String user, String newPwd) {
			// TODO Auto-generated method stub
			try {
				managerDao.updatePwd(user, newPwd);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}

		public List<Synopsis> selectSynopsisn(int i) {
			// TODO Auto-generated method stub
			return managerDao.selectSynopsisbyId(i);
		}

		public List<Employee> getMaxEmpId() {
			// TODO Auto-generated method stub
			return managerDao.maxEmpId();
		}

		public List<Employee> showEmp(String id) {
			// TODO Auto-generated method stub
			int sid = Integer.parseInt(id);
			return managerDao.showEmp(sid);
		}

		public List<Train> checkTrain() {
			// TODO Auto-generated method stub
			return managerDao.checkTrain();
		}

		public void checkup(List<Integer> arr) {
			// TODO Auto-generated method stub
			managerDao.checkupTrain(arr);
		}

		public List<Institution> institutionList(int first, int max) {
			// TODO Auto-generated method stub
			return managerDao.institutionList(first, max);
		}

		public List<Institution> findInstitutionSize() {
			// TODO Auto-generated method stub
			return managerDao.findInstitutionSize();
		}

		public List<Institution> selectInstitution(String institution_id) {
			// TODO Auto-generated method stub
			int id = Integer.parseInt(institution_id);
			return managerDao.selectInstitutionById(id);

		}

		public void addInstitution(Institution institution) {
			// TODO Auto-generated method stub
			managerDao.addInstitution(institution);
		}

		public List<Resume> findResume(String id) {
			// TODO Auto-generated method stub
			int employeeId= Integer.parseInt(id);
			return managerDao.findResume(employeeId);
		}

		public List<OutEmployee> findAllTask(String id) {
			// TODO Auto-generated method stub
			int employeeId = Integer.parseInt(id);
			return managerDao.findAllTask(employeeId);
		}

		public List<TrainPlan> trainplanList(int first, int max) {
			// TODO Auto-generated method stub
			return  managerDao.trainplanList(first, max);
		}

		public List<TrainPlan> findtrainplanSize() {
			// TODO Auto-generated method stub
			return managerDao.findtrainplanSize();
		}

		public List<TrainPlan> selectTrainplane(String id) {
			// TODO Auto-generated method stub
			int tpid=Integer.parseInt(id);
			return managerDao.selectTrainplanebyid(tpid);
		}

		public void addTrainplan(TrainPlan trainplan) {
			// TODO Auto-generated method stub
			managerDao.addTrainplan(trainplan);
		}

		public List<Forum> forumList(int first, int max) {
			// TODO Auto-generated method stub
			return managerDao.forumList(first, max);
		}

		public List<Forum> findForumSize() {
			// TODO Auto-generated method stub
			return managerDao.findForumSize();
		}

		public void addForum(Forum forum) {
			// TODO Auto-generated method stub
			managerDao.addForum(forum);
		}

		public List<Reply> showReply(int id) {
			// TODO Auto-generated method stub
			return managerDao.showReply(id);
		}

		public List<Forum> selectforumByid(int id) {
			// TODO Auto-generated method stub
			return managerDao.selectforumByid(id);
		}

		public void sendReply(Reply reply) {
			// TODO Auto-generated method stub
			managerDao.sendReply(reply);
		}

		public void updateForum(Forum forum) {
			// TODO Auto-generated method stub
			managerDao.updateForum(forum);
		}

		public void updateclicknum(Forum forum) {
			// TODO Auto-generated method stub
			managerDao.updateclicknum(forum);
		}

		public List<Employee> findEmpByTrain(List<TrainEmp> telist) {
			// TODO Auto-generated method stub
			return managerDao.findEmpByTrain(telist);
		}

		

		

		
}
