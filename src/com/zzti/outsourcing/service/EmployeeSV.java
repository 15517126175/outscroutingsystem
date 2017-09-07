package com.zzti.outsourcing.service;

import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.zzti.outsourcing.dao.EmployeeDao;
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

public class EmployeeSV {
	private EmployeeDao employeedao;

	
	public EmployeeDao getEmployeedao() {
		return employeedao;
	}

	public void setEmployeedao(EmployeeDao employeedao) {
		this.employeedao = employeedao;
	}
    
	//登录验证
	public List<Employee> employeeLogin(int employeeId)throws Exception{
		return employeedao.employeeLogin(employeeId);	
	}
	
	//修改密码
	public void updatePwd(int employeeId, String pwd)throws Exception {
			employeedao.updatePwd(employeeId, pwd);
	}
	
	//个人信息查看
	public List<Employee> selectInfo(int employeeId)throws Exception{
		return employeedao.selectInfo(employeeId);
	}
	
	//更新个人信息
	public void editInfo(Employee info)throws Exception{
		employeedao.editInfo(info);
	}
	
	//查看简历
	public List<Resume> findResume(int employeeId)throws Exception{
		return employeedao.findResume(employeeId);	
	}
	
	//删除简历
	public void deleteResume(int employeeId)throws Exception{
		employeedao.deleteResume(employeeId);
	}
	
	//修改简历
	public void editResume(Resume resume)throws Exception{
		employeedao.editResume(resume);
	}
	
	//添加简历
	public void addResume(Resume resume1)throws Exception{
		employeedao.addResume(resume1);
	}
	
	//上发简历
	public void hairResume(PublicResume pr)throws Exception{
		employeedao.hairResume(pr);
	}
	
	//公共表简历
	public List<PublicResume> findPResume(int employeeId)throws Exception{
		return employeedao.findPResume(employeeId);
	}
	
	//接收信息
	public List<Message> receinvInform(int employeeId)throws Exception{
		return employeedao.receinvInform(employeeId);
	}
	
	//查看外派项目
	public List<OutEmployee> selectTask(int first,int max,int employeeId)throws Exception{
		return employeedao.selectTask(first,max, employeeId);
	}
	public List<OutEmployee> findTaskSize(int employeeId) throws Exception{
		return employeedao.findTaskSize(employeeId);
	}
	
	//按项目名查询项目明细
	public List<OutProject> viewProject(String name)throws Exception{
		return employeedao.viewProject(name);
	}
	
	//查看信息
	public List<Message> viewInform(int employeeId)throws Exception{
		return employeedao.viewInform(employeeId);
	}
	
	//更新面试结果
	public void updateEnd(ProjectAllocate pa)throws Exception{
		employeedao.updateEnd(pa);
	}
	
	public List<ProjectAllocate> selectProject(int id, int mid1)throws Exception{
		return employeedao.selectProject(id,mid1);
	}
	
	//更新消息标识
	public void updateFlag(Message ma)throws Exception{
		employeedao.updateFlag(ma);
	}

	//查看参加的培训
	public List<TrainResult> viewTrain(int first, int max,int id)throws Exception{
		return employeedao.viewTrain(first,max,id);
	}
	public List<TrainResult> findTrainSize(int id)throws Exception{
		return employeedao.findTrainSize(id);
	}
	public List<TrainResult> findTrainResultSize(int tid, int empId)throws Exception{
		return employeedao.findTrainResultSize(tid,empId);
	}
	
	//检查是否满足报名培训的条件
	public List<OutEmployee> checkTask(int id)throws Exception{
		return employeedao.checkTask(id);
	}

	public List<Train> lookTrain()throws Exception{
		return employeedao.lookTrain();
	}

	//获取课题信息
	public List<Train> getAllById(int tid)throws Exception{
		return employeedao.getAllById(tid);
	}

	//查看全部已参与并且未开始的培训
	public List<Train> sureTrain(int empId)throws Exception{
		return employeedao.sureTrain(empId);
	}
    //查看本次报名
	public List<Train> choseTrain(int tid)throws Exception{
		return employeedao.choseTrain(tid);
	}

	public List<Message> choseInform(int mid)throws Exception{
		return employeedao.choseInform(mid);
	}

	public void insertTrainResult(TrainResult trainresult)throws Exception{
		employeedao.insertTrainResult(trainresult);
	}

	//薪资查看检测
	public List<OutEmployee> checkSalary(int empId)throws Exception{
		return employeedao.checkSalary(empId);
	}

	//删除培训结果数据
	public void deleteTrainResult(int id, int empId)throws Exception{
		employeedao.deleteTrainResult(id,empId);		
	}
    //取消后更新报名数据
	public void updateTrain(Train t)throws Exception{
		employeedao.updateTrain(t);		
	}

	//考勤查看
	public List<CheckWork> checkWork(int empId)throws Exception{
		return employeedao.checkWork(empId);
	}

	//单条培训明细查看
	public List<Train> lookTrain(int tid)throws Exception{
		return employeedao.lookTrain(tid);
	}

	//培训报名后插入中间表数据
	public void insertTrainEmp(TrainEmp te)throws Exception{
		employeedao.insertTrainEmp(te);
		
	}
	
	//单独上传本地简历
	public void upResume(int empId, String file1FileName)throws Exception{
		employeedao.upResume(empId,file1FileName);
	}

	//根据id查询指定培训信息
	public List<Train> selectTrainById(int id)throws Exception{
		return employeedao.selectTrainById(id);
	}
	
	//根据名称查询指定培训信息
	public List<Train> selectTrainByName(String inport)throws Exception{
		return employeedao.selectTrainByName(inport);
	}

	//取消报名后删除中间表数据
	public void deleteTrainEmp(int id, int empId)throws Exception{
		employeedao.deleteTrainEmp(id,empId);
	}

	//为简历查看项目经历
	public List<OutEmployee> findAllTask(int id)throws Exception{
		return employeedao.findAllTask(id);
	}
    
	//查询当前进行的外派任务
	public List<OutEmployee> findTasking(int empId)throws Exception{
		return employeedao.findTasking(empId);
	}

	//任务完成提交
	public void updateEmployeeStatus(int empId)throws Exception{
		employeedao.updateEmployeeStatus(empId);
	}
	public void updateProjectStatus(int empId, String pname)throws Exception{
		employeedao.updateProjectStatus(empId,pname);
	}
	
	//根据id和name查询面试通知
	public List<ProjectAllocate> interview(int id)throws Exception{
		return employeedao.interview(id);
	}
	public List<ProjectAllocate> selectInterview(int id,int empId)throws Exception{
		return employeedao.selectInterview(id,empId);
	}
	public List<ProjectAllocate> selectInterviewByName(String name,int empId)throws Exception{
		return employeedao.selectInterviewByName(name,empId);
	}

	//多条件查询外派项目
	public List<OutEmployee> selectProjectByName(String name, int empId)throws Exception{
		return employeedao.selectProjectByName(name,empId);
	}
	public List<OutEmployee> selectProjectByCity(String city, int empId)throws Exception{
		return employeedao.selectProjectByCity(city,empId);
	}
	public List<OutEmployee> selectProjectByType(String type, int empId)throws Exception{
		return employeedao.selectProjectByType(type,empId);
	}

	public void addholiday(Leave lee)throws Exception{
		employeedao.addholiday(lee);
	}

	public List<Leave> checkholiday(int empId)throws Exception{
		return employeedao.checkholiday(empId);
	}

	public List<Leave> viewholiday(int empId)throws Exception{
		return employeedao.viewholiday(empId);
	}

	public void stopholiday(int empId, String nowtime, long days)throws Exception{
		employeedao.stopholiday(empId,nowtime,days);
	}

	public void stopholidayById(int empId)throws Exception{
		employeedao.stopholidayById(empId);	
	}

	public List<Salary> findSalaryByName(String empName)throws Exception{
		return employeedao.findSalaryByName(empName);
	}

	public List<TrainEmp> checkTrainEmp(int empId, int tid)throws Exception{
		return employeedao.checkTrainEmp(empId, tid);
	}

	public void feedback(String feedtrain, String feedtrainer, int empId,int tid)throws Exception{
		employeedao.feedback(feedtrain, feedtrainer, empId, tid);
	}
	


}
