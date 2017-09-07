package com.zzti.outsourcing.dao;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
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

public interface ManagerDao {
	public List<Manager> managerLogin(String username) throws Exception;

	public List<Employee> findEmpSize();

	public List<Employee> empList(int first, int max);

	public void addemp(Employee emp);

	public void deleteEmp(int id);
	
	public List<Employee> selectEmpById (int id);

	public List<Employee> selectEmpByName(String id);

	public void editEmp(Employee emp);

	public List<Train> trainList(int first, int max);

	public List<Train> findTrainSize();

	public void addNotice(Notice notice);

	public List<Notice> findNoticeSize();

	public List<Notice> noticeList(int first, int max);

	public List<Notice> selectNoticeById(int noticeid);

	public void addtrain(Train train);

	public void closetrain(int id);

	public List<Train> selectTrainByName(String inport);

	public List<Train> selectTrainbyId(int tid);

	public List<TrainEmp> findTrainEmpSize(int tid);

	public void updatePwd(String user, String newPwd);

	public List<Synopsis> selectSynopsisbyId(int i);

	public List<Employee> maxEmpId();

	public List<Employee> showEmp(int sid);

	public List<Train> checkTrain();

	public void checkupTrain(List<Integer> arr);

	public List<Institution> institutionList(int first, int max);

	public List<Institution> findInstitutionSize();

	public List<Institution> selectInstitutionById(int id);

	public void addInstitution(Institution institution);

	public List<Resume> findResume(int employeeId);

	public List<OutEmployee> findAllTask(int employeeId);

	public List<TrainPlan> trainplanList(int first, int max);

	public List<TrainPlan> findtrainplanSize();

	public List<TrainPlan> selectTrainplanebyid(int tpid);

	public void addTrainplan(TrainPlan trainplan);

	public List<Forum> forumList(int first, int max);

	public List<Forum> findForumSize();

	public void addForum(Forum forum);

	public List<Reply> showReply(int id);

	public List<Forum> selectforumByid(int id);

	public void sendReply(Reply reply);

	public void updateForum(Forum forum);

	public void updateclicknum(Forum forum);

	public List<Employee> findEmpByTrain(List<TrainEmp> telist);

	
}
