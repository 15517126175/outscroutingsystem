package com.zzti.outsourcing.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.zzti.outsourcing.entities.Boss;
import com.zzti.outsourcing.entities.CheckWork;
import com.zzti.outsourcing.entities.Employee;
import com.zzti.outsourcing.entities.Message;
import com.zzti.outsourcing.entities.OutEmployee;
import com.zzti.outsourcing.entities.OutManager;
import com.zzti.outsourcing.entities.OutProject;
import com.zzti.outsourcing.entities.ProjectAllocate;

public interface OutManagerDao {
	public List<OutManager> managerLogin(String username) throws Exception;
	public void updatePwd(String user,String pwd) throws Exception;
	public List<Boss> bossList(int first,int max ) throws Exception;
	public List<Boss> findBossSize() throws Exception;
	public List<Boss> selectBossById(int id) throws Exception;
	public List<Boss> selectBossByName(String name) throws Exception;
	public void deleteBoss(int id) throws Exception;
	public List<Boss> maxBossId() throws Exception;
	public void addBoss(Boss boss) throws Exception;
	public void deleteBossAll(int[] ids) throws Exception;
	public void editBoss(Boss boss) throws Exception;
	public List<OutProject> queryProject(int id) throws Exception;
	public List<OutProject> queryProject(String name) throws Exception;
	public List<OutProject> queryProject(Date start,Date end) throws Exception;
	public List<OutProject> queryProject(Date start,Date end,int flage) throws Exception;
	public List<OutProject> maxOutProjectId() throws Exception;
	public void endProject(int proid) throws Exception;
	public void addOutProject(OutProject pro) throws Exception;
	public void updateOutProject(OutProject outpro) throws Exception;
	public List<OutEmployee> findOutEmpSize() throws Exception;
	public List<OutEmployee> outEmpList(int first,int max) throws Exception;
	public List<Employee> queryEmp(int id) throws Exception;
	public List<Employee> queryEmp(String name) throws Exception;
	public List<Employee> queryEmp() throws Exception;
	public List<Employee> queryEmp(int first,int max) throws Exception;
	public void sendMessage(Message message) throws Exception;
	public void sendEmp(ProjectAllocate projectAllocate) throws Exception;
	public List<ProjectAllocate> sendProjectQuery(int proid) throws Exception;
	public List<ProjectAllocate> sendProjectQuery(String proname) throws Exception;
	public List<ProjectAllocate> sendProjectList(int first,int max) throws Exception;
	public List<ProjectAllocate> findsendProjectSize() throws Exception;
	public List<ProjectAllocate> findsendProject(int empid) throws Exception;
	public void updateProjectAllocate(ProjectAllocate pro) throws Exception;
	public void upOutEmp(OutEmployee outEmp) throws Exception;
	public void updateEmp(Employee emp) throws Exception;
	public List<OutEmployee> outEmpQueryById(int id) throws Exception;
	public List<OutEmployee> outEmpQueryByName(String name) throws Exception;
	public List<OutEmployee> outEmpQueryByProid(int id) throws Exception;
	public List<OutProject> projectSearch(String search) throws Exception;
	public List<CheckWork> checkWorkList(int first,int max) throws Exception;
	public List<CheckWork> checkWorkList() throws Exception;
	public List<CheckWork> checkWorkList(int id) throws Exception;
	public List<CheckWork> checkWorkList(String name) throws Exception;


 }
