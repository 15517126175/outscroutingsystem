package com.zzti.outsourcing.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import com.zzti.outsourcing.dao.OutManagerDao;
import com.zzti.outsourcing.entities.Boss;
import com.zzti.outsourcing.entities.Charts;
import com.zzti.outsourcing.entities.CheckWork;
import com.zzti.outsourcing.entities.Employee;
import com.zzti.outsourcing.entities.Message;
import com.zzti.outsourcing.entities.Notice;
import com.zzti.outsourcing.entities.OutEmployee;
import com.zzti.outsourcing.entities.OutManager;
import com.zzti.outsourcing.entities.OutProject;
import com.zzti.outsourcing.entities.ProjectAllocate;
import com.zzti.outsourcing.service.OutManagerSV;
import com.zzti.outsourcing.service.PublicSV;

public class OutManagerAction extends BasicAction {
	private OutManagerSV outManagerSv;

	private String username;
	private String password;
	
	private List<OutProject> project;
	private OutProject pro;
	private File[] file1;
	private String[] file1FileName;
	private String[] file1ContentType;
	private String fileName;
	private List<Employee> salarylist;
	private List<OutEmployee> outemplist;
	private List<ProjectAllocate> procatelist;
	private OutEmployee outEmp;
	private List<Message> message;
	private List<CheckWork> checklist;
	private List<Notice> noticelist;
	private PublicSV publicSv ;
	private Notice notice;
	
	
	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}
	
	public PublicSV getPublicSv() {
		return publicSv;
	}

	public void setPublicSv(PublicSV publicSv) {
		this.publicSv = publicSv;
	}

	public List<Notice> getNoticelist() {
		return noticelist;
	}

	public void setNoticelist(List<Notice> noticelist) {
		this.noticelist = noticelist;
	}
	

	public List<CheckWork> getChecklist() {
		return checklist;
	}

	public void setChecklist(List<CheckWork> checklist) {
		this.checklist = checklist;
	}

	public List<Employee> getSalarylist() {
		return salarylist;
	}

	public void setSalarylist(List<Employee> salarylist) {
		this.salarylist = salarylist;
	}

	public List<Message> getMessage() {
		return message;
	}

	public void setMessage(List<Message> message) {
		this.message = message;
	}

	public OutEmployee getOutEmp() {
		return outEmp;
	}

	public void setOutEmp(OutEmployee outEmp) {
		this.outEmp = outEmp;
	}

	public List<ProjectAllocate> getProcatelist() {
		return procatelist;
	}

	public void setProcatelist(List<ProjectAllocate> procatelist) {
		this.procatelist = procatelist;
	}

	public List<OutEmployee> getOutemplist() {
		return outemplist;
	}

	public void setOutemplist(List<OutEmployee> outemplist) {
		this.outemplist = outemplist;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDownloadFileName() {
		String fileName = httpServletrequest.getParameter("fileName");
		String downFileName = fileName;
		try {
			
			downFileName = new String(fileName.getBytes(), "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return downFileName;
	}

	public File[] getFile1() {
		return file1;
	}

	public void setFile1(File[] file1) {
		this.file1 = file1;
	}

	public String[] getFile1FileName() {
		return file1FileName;
	}

	public void setFile1FileName(String[] file1FileName) {
		this.file1FileName = file1FileName;
	}

	public String[] getFile1ContentType() {
		return file1ContentType;
	}

	public void setFile1ContentType(String[] file1ContentType) {
		this.file1ContentType = file1ContentType;
	}

	public OutProject getPro() {
		return pro;
	}

	public void setPro(OutProject pro) {
		this.pro = pro;
	}

	public List<OutProject> getProject() {
		return project;
	}

	public void setProject(List<OutProject> project) {
		this.project = project;
	}

	public String getUsername() {
		return username;
	}

	public OutManagerSV getOutManagerSv() {
		return outManagerSv;
	}

	public void setOutManagerSv(OutManagerSV outManagerSv) {
		this.outManagerSv = outManagerSv;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// 外派管理员登陆
	public String login() throws Exception {
		try {
			List<OutManager> list = null;
			list = outManagerSv.managerLogin(username);

			if (username.equals(list.get(0).getManager_name())
					&& password.equals(list.get(0).getPassword())) {
				ActionContext ac = ActionContext.getContext();
				session.put("user", username);
				session.put("userid", list.get(0).getManager_id());
				noticeList();
				
				return "login";
			} else {
				HttpServletResponse response = ServletActionContext
						.getResponse();
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html; charset=utf-8");
				PrintWriter outjs = response.getWriter();
				outjs.print("<script>alert('用户名或密码错误');window.location.href='outmanager/login.jsp';</script>");
				return null;
			}
		} catch (Exception e) {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			PrintWriter outjs = response.getWriter();
			outjs.print("<script>alert('用户名或密码错误');window.location.href='outmanager/login.jsp';</script>");
			return null;
		}

	}

	// 修改密码
	public String updatePwd() throws Exception {
		String user = httpServletrequest.getParameter("user");
		String oldPwd = httpServletrequest.getParameter("oldPwd");
		String newPwd = httpServletrequest.getParameter("newPwd");
		List<OutManager> list = null;

		list = outManagerSv.managerLogin(user);
		if (list != null && list.get(0).getPassword().equals(oldPwd)) {
			outManagerSv.updatePwd(user, newPwd);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");
			response.setContentType("text/html; charset=gbk");
			PrintWriter outjs = response.getWriter();
			outjs.print("<script>alert('修改成功返回登陆界面！');window.location.href='outmanager/login.jsp';</script>");

		} else {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			PrintWriter outjs = response.getWriter();

			outjs.print("<script>alert('旧密码错误，请重新输入或联系管理员！');window.location.href='outmanager/updatePwd.jsp';</script>");

		}

		return null;
	}

	// 查询所有法包方信息
	private List<Boss> boss;

	public List<Boss> getBoss() {
		return boss;
	}

	public void setBoss(List<Boss> boss) {
		this.boss = boss;
	}

	public String bossList() throws Exception {
		int first = 1;
		int max = 4;

		if (httpServletrequest.getParameter("pagenum") != null) {
			first = Integer
					.parseInt(httpServletrequest.getParameter("pagenum"));
		}
		boss = outManagerSv.bossList((first - 1) * max, max);
		int total = outManagerSv.findBossSize().size();
		httpServletrequest.setAttribute("pagerinfo", Pager.getPagerNormal(
				total, max, first, "outmanager-bossList.action", "共有" + total
						+ "条记录"));

		return "bossList";

	}

	// 根据id或名称查询发包方信息
	public String selectBoss() {
		String inport = httpServletrequest.getParameter("inport");
		this.boss = outManagerSv.selectBoss(inport);

		return "bossList";
	}

	// 根据id删除发包方信息
	public String deleteBoss() throws Exception {
		String id = httpServletrequest.getParameter("id");
		outManagerSv.deleteBoss(id);
		return "deleteboss";
	}

	private Boss boss1;

	public Boss getBoss1() {
		return boss1;
	}

	public void setBoss1(Boss boss1) {
		this.boss1 = boss1;
	}

	// 添加一条发包方信息
	public String addBoss() throws Exception {

		boss = outManagerSv.getMaxBossId();
		int bossid = boss.get(0).getBoss_id() + 1;
		boss1.setBoss_id(bossid);
		outManagerSv.addBoss(boss1);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter outjs = response.getWriter();
		outjs.print("<script>alert('添加成功并返回添加页面！');window.location.href='outmanager/addBoss.jsp';</script>");
		return null;
	}

	// 批量删除发包方
	private int[] ids;

	public int[] getIds() {
		return ids;
	}

	public void setIds(int[] ids) {
		this.ids = ids;
	}

	public String deleteAll() throws Exception {
		outManagerSv.deleteBossAll(ids);

		return "deleteAll";
	}

	// 从数据库获取数据到修改界面

	public String toEditBoss() throws Exception {
		String bossid = httpServletrequest.getParameter("bossid");
		this.boss = outManagerSv.selectBoss(bossid);
		this.boss1 = boss.get(0);
		return "toEditBoss";
	}

	// 修改boss信息
	public String editBoss() throws Exception {
		outManagerSv.editBoss(boss1);
		return "editBoss";
	}

	// 查询外包项目信息
	public String queryProject() throws Exception {
		String projectid = httpServletrequest.getParameter("proid");
		String start = httpServletrequest.getParameter("datepickfrom");
		String end = httpServletrequest.getParameter("datepickto");
		String flage = httpServletrequest.getParameter("select");
		System.out.println(start + ";" + end);
		int fla;
		if (!projectid.equals("")) {
			this.project = outManagerSv.queryProject(projectid);

		} else {
			Date startDate = strToDate(start);
			Date endDate = strToDate(end);
			if (flage.equals("all")) {
				this.project = outManagerSv.queryProject(startDate, endDate);
			} else {
				if (flage.equals("yes")) {
					fla = 1;
				} else {
					fla = 0;
				}
				this.project = outManagerSv.queryProject(startDate, endDate,
						fla);
			}
		}
		return "outproject";
	}

	// 添加外包项目信息
	public String addOutProject() throws Exception {
		File[] files = this.getFile1();
		String province = httpServletrequest.getParameter("province");
		String city = httpServletrequest.getParameter("city");
		String start = httpServletrequest.getParameter("datepickfrom");
		String end = httpServletrequest.getParameter("datepickto");
		Date startDate = strToDate(start);
		Date endDate = strToDate(end);
		try {
			for (int i = 0; i < files.length; i++) {
				InputStream is = new FileInputStream(files[i]);
				// 设置上传文件目录
				String uploadPath = ServletActionContext.getRequest()
						.getRealPath("/upload");
				File toFile = new File(uploadPath, file1FileName[i]);
				// 创建一个输出流
				OutputStream os = new FileOutputStream(toFile);
				byte[] buffer = new byte[1048];
				int length = 0;
				while ((length = is.read(buffer)) > 0) {
					os.write(buffer, 0, length);
				}
				// 关闭输入流
				is.close();

				// 关闭输出流
				os.close();
			}
			project = outManagerSv.getMaxOutProjectId();
			pro.setProject_id(project.get(0).getProject_id() + 1);
			pro.setProject_flage(0);
			pro.setEnter_time(new Date());
			pro.setStar_time(startDate);
			pro.setEnd_time(endDate);
			pro.setCity(province + "/" + city);
			pro.setBoss_contract(file1FileName[0]);
			pro.setEmployee_contract(file1FileName[1]);
			Charts ch = new Charts();
			ch = publicSv.queryChart(pro.getProiect_type()).get(0);
			ch.setCount(ch.getCount()+1);
		
			publicSv.addType(ch);
			outManagerSv.addOutProject(pro);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");
			response.setContentType("text/html; charset=gbk");
			PrintWriter outjs = response.getWriter();
			outjs.print("<script>alert('添加成功并返回添加页面！');window.location.href='outmanager/addproject.jsp';</script>");
		} catch (Exception e) {

			project = outManagerSv.getMaxOutProjectId();
			pro.setProject_id(project.get(0).getProject_id() + 1);
			pro.setProject_flage(0);
			pro.setEnter_time(new Date());
			pro.setStar_time(startDate);
			pro.setEnd_time(endDate);
			pro.setCity(province + "/" + city);
			Charts ch = new Charts();
			ch = publicSv.queryChart(pro.getProiect_type()).get(0);
			ch.setCount(ch.getCount()+1);
		
			publicSv.addType(ch);
			outManagerSv.addOutProject(pro);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			PrintWriter outjs = response.getWriter();
			outjs.print("<script>alert('添加成功并返回添加页面！');window.location.href='outmanager/addproject.jsp';</script>");
		}
		return null;
	}
	//结束外包项目
	public String endProject() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter outjs = response.getWriter();
		
		String proid = httpServletrequest.getParameter("proid");
		int id = Integer.parseInt(proid);
		outemplist = outManagerSv.outEmpQueryByProid(id);
		for(int i=0;i<outemplist.size();i++){
			if(outemplist.get(0).getWorker_status()!=2){
				outjs.print("<script>alert('该项目还有员工在进行工作！无法结束！');window.location.href='outmanager/projectManage.jsp';</script>");
			}else{
				outManagerSv.endProject(id);
				outjs.print("<script>alert('结束项目成功！');window.location.href='outmanager/projectManage.jsp';</script>");
			}
		}
		
		
		return null;
	}

	// 跳转到修改外包项目信息界面
	public String toEditOutPro() {
		String proid = httpServletrequest.getParameter("proid");
		pro = outManagerSv.queryProject(proid).get(0);
		return "toEditProject";

	}

	// 修改外包项目信息
	public String editOutPro() throws Exception {

		outManagerSv.editOutPro(pro);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter outjs = response.getWriter();
		outjs.print("<script>alert('修改成功！');window.location.href='outmanager/projectManage.jsp';</script>");
		return null;
	}

	// 查询所有外派人员
	public String outEmpList() throws Exception {
		int first = 1;
		int max = 4;

		if (httpServletrequest.getParameter("pagenum") != null) {
			first = Integer
					.parseInt(httpServletrequest.getParameter("pagenum"));
		}
		outemplist = outManagerSv.outEmployeeList((first - 1) * max, max);
		int total = outManagerSv.findOutEmpSize().size();
		httpServletrequest.setAttribute("pagerinfo", Pager.getPagerNormal(
				total, max, first, "outmanager-outEmpList.action", "共有" + total
						+ "条记录"));

		return "outemplist";
	}

	// 发布面试通知获取相关信息
	public String sendEmp() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter outjs = response.getWriter();
			

			String projectid = httpServletrequest.getParameter("project_id");

			int empid = Integer.parseInt(httpServletrequest
					.getParameter("emp_id"));
			project = outManagerSv.queryProject(projectid);
			salarylist = outManagerSv.queryEmp(empid);
			
			if (project.size() == 0
					|| salarylist.size() == 0) {
				System.out.println("-----------");
				outjs.print("<script>alert('没有该项目或员工！');window.location.href='outmanager/send.jsp';</script>");
			} else if (project.get(0).getProject_flage()==2) {
				outjs.print("<script>alert('该项目已结束！');window.location.href='outmanager/send.jsp';</script>");
			} else if (salarylist.get(0).getWork_status().equals("U")) {
				outjs.print("<script>alert('该员工已有外派任务！');window.location.href='outmanager/send.jsp';</script>");
			} else {
				
				httpServletrequest.setAttribute("proid", projectid);
				httpServletrequest.setAttribute("empid", empid);
				return "sendlist";
		} 

		return null;
	}
	
	
	//确认信息后给员工发面试通知
	public String sendEmpOk() throws Exception{
		String interviewtime = httpServletrequest.getParameter("datepickfrom");
		String site = httpServletrequest.getParameter("site");
		Date viewtime = strToDate(interviewtime);
		
		Employee emp = new Employee();
		ProjectAllocate proca = new ProjectAllocate();
		Message message = new Message();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter outjs;
		outjs = response.getWriter();
		String projectid = httpServletrequest.getParameter("project_id");
		int empid = Integer.parseInt(httpServletrequest
				.getParameter("emp_id"));
		
		pro = outManagerSv.queryProject(projectid).get(0);
		System.out.println(pro.getProject_id());

		emp = outManagerSv.queryEmp(empid).get(0);
		System.out.println(emp.getEmployee_id());
		proca.setProject_id(pro.getProject_id());
		proca.setProject_name(pro.getProject_name());
		proca.setEmployee_id(emp.getEmployee_id());
		proca.setEmployee_name(emp.getEmployee_name());
		proca.setStar_time(pro.getStar_time());
		proca.setEnd_time(pro.getEnd_time());
		proca.setInterview_time(viewtime);
		proca.setInterview_site(site);
		
		
		outManagerSv.sendEmp(proca);
		outjs.print("<script>alert('发布成功并返回发布页面！');window.location.href='outmanager/send.jsp';</script>");
		return null;
	}

	// 根据id或名称查询分配过的的项目
	public String sendProjectQuery() throws Exception {
		String pro = httpServletrequest.getParameter("inport");
		procatelist = outManagerSv.sendProjectQuery(pro);
		return "sendprolist";
	}

	// 查询所有分配的项目
	public String sendProjectList() throws Exception {
		int first = 1;
		int max = 4;

		if (httpServletrequest.getParameter("pagenum") != null) {
			first = Integer
					.parseInt(httpServletrequest.getParameter("pagenum"));
		}
		procatelist = outManagerSv.sendProjectList((first - 1) * max, max);
		int total = outManagerSv.sendProjectSize().size();
		httpServletrequest.setAttribute("pagerinfo", Pager.getPagerNormal(
				total, max, first, "outmanager-sendProjectList.action", "共有"
						+ total + "条记录"));

		return "sendprolist";
	}

	// 跳传到上传外派员工页面
	public String toUpOutEmp() throws Exception {
		OutEmployee outEmp = new OutEmployee();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter outjs;
		outjs = response.getWriter();
		String pro_id = httpServletrequest.getParameter("pro_id");
		String emp_id = httpServletrequest.getParameter("emp_id");
		outEmp.setEmployee_id(Integer.parseInt(emp_id));
		List<Employee> list = outManagerSv.queryEmp(Integer.parseInt(emp_id));
		if (list.size() == 0) {
			outjs.print("<script>alert('没有查询到该员工信息！');window.location.href='outmanager-sendProjectList';</script>");
		}
		outEmp.setEmployee_name(list.get(0).getEmployee_name());
		outEmp.setEmployee_phone(list.get(0).getEmployee_phone());
		List<OutProject> list1 = outManagerSv.queryProject(pro_id);
		if (list1.size() == 0) {
			outjs.print("<script>alert('没有查询到该项目信息！');window.location.href='outmanager-sendProjectList';</script>");
		}
		outEmp.setProject_name(list1.get(0).getProject_name());
		outEmp.setBoss_name(list1.get(0).getBoss_name());
		outEmp.setCity(list1.get(0).getCity());
		outEmp.setWoker_time(list1.get(0).getWoker_time());
		outEmp.setStar_time(list1.get(0).getStar_time());
		outEmp.setEnd_time(list1.get(0).getEnd_time());
		outEmp.setProject_type(list1.get(0).getProiect_type());
		this.outEmp = outEmp;
		return "toupoutemp";

	}

	// 上传面试成功的员工到外派员工表中
	public String upOutEmp() throws Exception {

		outEmp.setEnter_time(new Date());
		outEmp.setWorker_status(1);
		String name = outEmp.getBoss_name();
		outEmp.setBoss_name(name);

		outManagerSv.upOutEmp(outEmp);
		return "upoutemp";
	}

	// 外派人员信息查询
	public String outEmpQuery() throws Exception {
		String inport = httpServletrequest.getParameter("inport");
		outemplist = outManagerSv.outEmpQuery(inport);
		return "outempquery";
	}
	//员工薪资列表
	public String salaryQuery() throws Exception{
		int first = 1;
		int max = 4;
		
		List<OutEmployee> outemplist = new ArrayList<OutEmployee>();
		if (httpServletrequest.getParameter("pagenum") != null) {
			first = Integer
					.parseInt(httpServletrequest.getParameter("pagenum"));
		}
		salarylist = outManagerSv.queryEmp((first - 1) * max, max);
		int total = outManagerSv.queryEmp().size();
		for(int i=0;i<salarylist.size();i++){
			int empid = salarylist.get(i).getEmployee_id();
			String id = String.valueOf(empid);
			outemplist = outManagerSv.outEmpQuery(id);
			if(outemplist.size()==0){
				salarylist.get(i).setEmployee_sex("无");
				salarylist.get(i).setEmployee_email("无");
			}else{
				int outsalary = outemplist.get(0).getSalary();
				String salary = String.valueOf(outsalary);
				salarylist.get(i).setEmployee_sex(salary);
				salarylist.get(i).setEmployee_email(outemplist.get(0).getProject_name());
			}
		}
		
		httpServletrequest.setAttribute("pagerinfo", Pager.getPagerNormal(
				total, max, first, "outmanager-salaryQuery.action", "共有" + total
						+ "条记录"));
		return "salarymanage";
	}
	//查询某一员工工资信息
	public String queryEmpSalary() throws Exception{
		String search = httpServletrequest.getParameter("inport");
		salarylist = outManagerSv.queryEmp(search);
		List<OutEmployee> outemplist = new ArrayList<OutEmployee>();
		int empid = salarylist.get(0).getEmployee_id();
		String id = String.valueOf(empid);
		outemplist = outManagerSv.outEmpQuery(id);
		if(outemplist.size()==0){
			salarylist.get(0).setEmployee_sex("无");
			salarylist.get(0).setEmployee_email("无");
		}else{
			int outsalary = outemplist.get(0).getSalary();
			String salary = String.valueOf(outsalary);
			salarylist.get(0).setEmployee_sex(salary);
			salarylist.get(0).setEmployee_email(outemplist.get(0).getProject_name());
		}
		return "salarymanage";
		
	}
	//查询所有考勤记录
	public String checkWorkList() throws Exception{
		int first = 1;
		int max = 4;

		if (httpServletrequest.getParameter("pagenum") != null) {
			first = Integer
					.parseInt(httpServletrequest.getParameter("pagenum"));
		}
		checklist = outManagerSv.checkWorkList((first - 1) * max, max);
		int total = outManagerSv.checkWorkList().size();
		httpServletrequest.setAttribute("pagerinfo", Pager.getPagerNormal(
				total, max, first, "", "共有"
						+ total + "条记录"));

		return "checkworklist";
	}
	//根据输入信息查询员工考勤记录
	public String checkWorkQuery() throws Exception{
		String search = httpServletrequest.getParameter("inport");
		checklist = outManagerSv.checkWorkQuery(search);
		return "checkworklist";
	}
	/*//输入信息提示
	public String projectSearch(){
		String search = httpServletrequest.getParameter("search-text");
		List<OutProject> list = outManagerSv.projectSearch(search);
		String[] str = new String[list.size()];
		for(int i=0;i<list.size();i++){
			str[i]=list.get(i).getProject_name();
		}
		String json="["; 
		for(int i = 0; i < str.length; i++) { 
		
		json += "\""+ str[i] + "\"" + ","; 
		}
		json = json.substring(0,json.length()-1>0?json.length()-1:1); 
		json += "]"; 
		System.out.println("json:" + json); 
		
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			PrintWriter out = response.getWriter();
			out.println(json); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
		return null;
		
		
	}*/
	
	// String装Date
	public Date strToDate(String str) throws Exception {
		String[] str1 = str.split("/");
		String i;
		i = str1[0];
		str1[0] = str1[2];
		str1[2] = str1[1];
		str1[1] = i;
		String date = StringUtils.join(str1, "-");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date datetime = sdf.parse(date);
		System.out.println(datetime);
		return datetime;
	}

	public InputStream getInputStream() throws Exception {

		HttpServletResponse response1 = ServletActionContext.getResponse();
		response1.setHeader("Content-Disposition", "attachment;fileName="
                + java.net.URLEncoder.encode(fileName,"UTF-8"));

		String name = this.getDownloadFileName();
		System.out.println(name);

		String url = "/upload/" + name;
		InputStream in = ServletActionContext.getServletContext()
				.getResourceAsStream(url);
		return in;

	}

	// 文件下载
	public String download() {
		return "success";
	}

	// 统计图表
	public String charts() throws Exception {
		System.out.println("开始执行。。。。");
		String start = "2000/01/01";
		String end = "2099/12/31";
		
		
	
			Date startDate = strToDate(start);
			Date endDate = strToDate(end);
			List<OutProject> list = outManagerSv.queryProject(startDate, endDate);
			JSONArray jsons = new JSONArray();  
			List c = new ArrayList();
			Charts ch = new Charts();
			
			for (int n = 0; n < list.size(); n++) {
				
				
				c.add(ch);
			}
			   for(int n=0;n<c.size();n++){  
		           JSONObject jsonObject = new JSONObject();  
		           jsonObject.put("chart", c.get(n));  
		           jsons.add(jsonObject);  
		       } 
			   HttpServletResponse response = ServletActionContext.getResponse();
			   response.getWriter().print(jsons);  
		return null;
	}
	public String firstPage(){
		noticeList();
		return "firstpage";
	}
	//公告信息
	public void noticeList(){
		
		
		int first = 1;
		int max = 4;

		if (httpServletrequest.getParameter("pagenum") != null) {
			first = Integer
					.parseInt(httpServletrequest.getParameter("pagenum"));
		}
		noticelist = publicSv.noticeList((first - 1) * max, max);
		int total = publicSv.findNoticeSize().size();
		httpServletrequest.setAttribute("pagerinfo", Pager.getPagerNormal(
				total, max, first, "outlogin-login.action", "共有" + total
						+ "条记录"));
		
	}
	//公告详情
	public String selectNotice(){
		String notice_id = httpServletrequest.getParameter("notice_id");
		
		this.notice = publicSv.selectNotice(notice_id).get(0);
		return "outnotice";			
	}
}
