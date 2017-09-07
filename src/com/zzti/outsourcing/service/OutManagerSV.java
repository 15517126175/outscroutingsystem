package com.zzti.outsourcing.service;

import java.util.Date;
import java.util.List;

import com.zzti.outsourcing.dao.OutManagerDao;
import com.zzti.outsourcing.entities.Boss;
import com.zzti.outsourcing.entities.CheckWork;
import com.zzti.outsourcing.entities.Employee;
import com.zzti.outsourcing.entities.Message;
import com.zzti.outsourcing.entities.OutEmployee;
import com.zzti.outsourcing.entities.OutManager;
import com.zzti.outsourcing.entities.OutProject;
import com.zzti.outsourcing.entities.ProjectAllocate;

public class OutManagerSV {
	private OutManagerDao outManagerDao;
	
	

	public OutManagerDao getOutManagerDao() {
		return outManagerDao;
	}

	public void setOutManagerDao(OutManagerDao outManagerDao) {
		this.outManagerDao = outManagerDao;
	}

	public List<OutManager> managerLogin(String username) throws Exception {

		return outManagerDao.managerLogin(username);

	}

	public void updatePwd(String user, String pwd) {
		try {
			outManagerDao.updatePwd(user, pwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public List<Boss> findBossSize() throws Exception{
		return outManagerDao.findBossSize();
	}
	public List<Boss> bossList(int first,int max) throws Exception{
		return outManagerDao.bossList(first,max);
	}
	public List<Boss> selectBoss(String inport){
		try {
			int bossid = Integer.parseInt(inport);
			return outManagerDao.selectBossById(bossid);
			
			
		} catch (Exception e) {
			try {
				return outManagerDao.selectBossByName(inport);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
				
	}
	public void deleteBoss(String bossid) throws Exception{
		int id = Integer.parseInt(bossid);
		outManagerDao.deleteBoss(id);
	}
	public List<Boss> getMaxBossId() throws Exception{
		return outManagerDao.maxBossId();
	}
	public void addBoss(Boss boss) throws Exception{
		outManagerDao.addBoss(boss);
	}
	public void deleteBossAll(int[] ids) throws Exception{
		outManagerDao.deleteBossAll(ids);
	}
	public void editBoss(Boss boss) throws Exception{
		outManagerDao.editBoss(boss);
	}
	//查询员工信息
	public List<Employee> queryEmp() throws Exception{
		return outManagerDao.queryEmp();
	}
	
	public List<Employee> queryEmp(int first,int max) throws Exception{
		return outManagerDao.queryEmp(first,max);
	}
	//根据id查项目工程
	public List<OutProject> queryProject(String projectid){
		
		try {
			int proid = Integer.parseInt(projectid);
			return outManagerDao.queryProject(proid);
		} catch (Exception e) {
			try {
				return outManagerDao.queryProject(projectid);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	}
	//查一段时间内所有的项目工程
	public List<OutProject> queryProject(Date start,Date end) throws Exception{
		return outManagerDao.queryProject(start, end);
	}
	//根据分配情况查询一段时间内的项目工程
	public List<OutProject> queryProject(Date start,Date end,int flage) throws Exception{
		return outManagerDao.queryProject(start, end, flage);
	}
	//修改外包项目信息
	public void editOutPro(OutProject outpro) throws Exception{
		outManagerDao.updateOutProject(outpro);
	}
	//获取外包项目最大id号
	public List<OutProject> getMaxOutProjectId() throws Exception{
		return outManagerDao.maxOutProjectId();
	}
	//添加外包项目信息
	public void addOutProject(OutProject pro) throws Exception{
		outManagerDao.addOutProject(pro);
	}
	//查询外派人的人数
	public List<OutEmployee> findOutEmpSize() throws Exception{
		return outManagerDao.findOutEmpSize();
	}
	//查询所有外派人员
	public List<OutEmployee> outEmployeeList(int first,int max) throws Exception{
		return outManagerDao.outEmpList(first, max);
		
	}
	//根据员工id查询员工信息
	public List<Employee> queryEmp(int id) throws Exception{
		return outManagerDao.queryEmp(id);
	}
	//发布面试通知
	public void sendEmp(ProjectAllocate projectallocate) throws Exception{
		
		outManagerDao.sendEmp(projectallocate);
		
	}
	//根据id或名称查询分配过的的项目
	public List<ProjectAllocate> sendProjectQuery(String pro) throws Exception{
		try {
			int proid = Integer.parseInt(pro);
			return outManagerDao.sendProjectQuery(proid);
			
			
		} catch (Exception e) {
			try {
				return outManagerDao.sendProjectQuery(pro);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	}
	//查询所有分配的项目
	public List<ProjectAllocate> sendProjectList(int first,int max) throws Exception{
		return outManagerDao.sendProjectList(first, max);
	}
	//查询分配项目的数量
	public List<ProjectAllocate> sendProjectSize() throws Exception{
		return outManagerDao.findsendProjectSize();
	}
	public void toUpOutEmp(OutEmployee outEmp) throws Exception{
		outManagerDao.upOutEmp(outEmp);
	}
	//上传面试成功的员工到外派员工表中
	public void upOutEmp(OutEmployee outEmp) throws Exception{
		Employee emp = new Employee();
		ProjectAllocate proall = new ProjectAllocate();
		OutProject outpro = new OutProject();
		proall = outManagerDao.findsendProject(outEmp.getEmployee_id()).get(0);
		emp = outManagerDao.queryEmp(outEmp.getEmployee_id()).get(0);
		outpro = outManagerDao.queryProject(proall.getProject_id()).get(0);
		proall.setEnd(3);//修改分配情况
		emp.setWork_status("U");//修改员工状态
		outpro.setProject_flage(1);//设置项目分配情况
		outManagerDao.updateProjectAllocate(proall);
		outManagerDao.updateEmp(emp);
		outManagerDao.updateOutProject(outpro);
		outManagerDao.upOutEmp(outEmp);
	}
	//员工信息查询
	public List<Employee> queryEmp(String inport){
		try {
			int empid = Integer.parseInt(inport);
			return outManagerDao.queryEmp(empid) ;	
		} catch (Exception e) {
			try {
			  return outManagerDao.queryEmp(inport);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	}
	//外派人员信息查询
	public List<OutEmployee> outEmpQuery(String inport){
		try {
			int empid = Integer.parseInt(inport);
			return outManagerDao.outEmpQueryById(empid) ;	
		} catch (Exception e) {
			try {
			  return outManagerDao.outEmpQueryByName(inport);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	}
	//查询所有考勤记录
	public List<CheckWork> checkWorkList(int first, int max) throws Exception {
		return outManagerDao.checkWorkList(first, max);
	}
	public List<CheckWork> checkWorkList() throws Exception {
		return outManagerDao.checkWorkList();
	}
	//查询某个员工的考勤信息
	public List<CheckWork> checkWorkQuery(String inport ){
		try {
			int empid = Integer.parseInt(inport);
			return outManagerDao.checkWorkList(empid) ;	
		} catch (Exception e) {
			try {
			  return outManagerDao.checkWorkList(inport);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	}
	//结束外包项目
	public void endProject(int proid){
		try {
			outManagerDao.endProject(proid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//根据外包项目id查外包员工记录
	public List<OutEmployee> outEmpQueryByProid(int id) throws Exception {
		return outManagerDao.outEmpQueryByProid(id);
	}
	/*//输入信息提示
	public List<OutProject> projectSearch(String search){
		
		try {
			return outManagerDao.projectSearch(search);
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}
	*/
}
