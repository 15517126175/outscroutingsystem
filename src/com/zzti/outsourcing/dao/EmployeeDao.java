package com.zzti.outsourcing.dao;

import java.util.List;

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

public interface EmployeeDao {

	public List<Employee> employeeLogin(int employeeId)throws Exception;

	public void updatePwd(int employeeId, String pwd)throws Exception;
	
	public List<Employee> selectInfo(int employeeId)throws Exception;
	
	public void editInfo(Employee info)throws Exception;
	
	public List<Resume> findResume(int employeeId)throws Exception;
	
	public void deleteResume(int employeeId)throws Exception;
	
	public void editResume(Resume resume1)throws Exception;
	
	public void addResume(Resume resume1)throws Exception;

	public void hairResume(PublicResume pr)throws Exception;

	public List<PublicResume> findPResume(int employeeId)throws Exception;
	
	public List<Message> receinvInform(int employeeId)throws Exception;
	
	public List<OutEmployee> selectTask(int first,int max,int employeeId)throws Exception;
	
	public List<OutEmployee> findTaskSize(int employeeId) throws Exception;
	
	public List<OutProject> viewProject(String name)throws Exception;
	
	public List<Message> viewInform(int employeeId)throws Exception;
	
	public void updateEnd(ProjectAllocate pa)throws Exception;
	
	public List<ProjectAllocate> selectProject(int id, int mid1)throws Exception;
	
	public void updateFlag(Message ma)throws Exception;

	public List<TrainResult> viewTrain(int id,int start,int max)throws Exception;

	public List<TrainResult> findTrainSize(int id)throws Exception;

	public List<TrainResult> findTrainResultSize(int tid, int empId)throws Exception;
	
	public List<OutEmployee> checkTask(int id)throws Exception;

	public List<Train> lookTrain()throws Exception;

	public List<Train> getAllById(int tid)throws Exception;

	public List<Train> sureTrain(int empId)throws Exception;

	public List<Train> choseTrain(int tid)throws Exception;

	public List<Message> choseInform(int mid)throws Exception;

	public void insertTrainResult(TrainResult trainresult)throws Exception;

	public List<OutEmployee> checkSalary(int empId)throws Exception;

	public void deleteTrainResult(int id, int empId)throws Exception;

	public void updateTrain(Train t)throws Exception;

	public List<CheckWork> checkWork(int empId)throws Exception;

	public List<Train> lookTrain(int tid)throws Exception;

	public void insertTrainEmp(TrainEmp te)throws Exception;
	
	public void upResume(int empId, String file1FileName)throws Exception;

	public List<Train> selectTrainById(int id)throws Exception;

	public List<Train> selectTrainByName(String inport)throws Exception;

	public void deleteTrainEmp(int id, int empId)throws Exception;

	public List<OutEmployee> findAllTask(int id)throws Exception;

	public List<OutEmployee> findTasking(int empId)throws Exception;

	public void updateEmployeeStatus(int empId)throws Exception;

	public void updateProjectStatus(int empId, String pname)throws Exception;

	public List<ProjectAllocate> interview(int id)throws Exception;

	public List<ProjectAllocate> selectInterview(int id, int empId)throws Exception;

	public List<ProjectAllocate> selectInterviewByName(String name, int empId)throws Exception;

	public List<OutEmployee> selectProjectByName(String name, int empId)throws Exception;

	public List<OutEmployee> selectProjectByCity(String city, int empId)throws Exception;

	public List<OutEmployee> selectProjectByType(String type, int empId)throws Exception;

	public void addholiday(Leave lee)throws Exception;

	public List<Leave> checkholiday(int empId)throws Exception;

	public List<Leave> viewholiday(int empId)throws Exception;

	public void stopholiday(int empId, String nowtime, long days)throws Exception;

	public void stopholidayById(int empId)throws Exception;

	public List<Salary> findSalaryByName(String empName)throws Exception;

	public List<TrainEmp> checkTrainEmp(int empId, int tid)throws Exception;

	public List<TrainEmp> checkTrainEmpById(int id)throws Exception;

	public void feedback(String feedtrain, String feedtrainer, int empId,int tid)throws Exception;
	

}
