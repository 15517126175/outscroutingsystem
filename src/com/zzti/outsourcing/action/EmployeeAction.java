package com.zzti.outsourcing.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

import com.zzti.outsourcing.entities.Employee;
import com.zzti.outsourcing.entities.Forum;
import com.zzti.outsourcing.entities.Leave;
import com.zzti.outsourcing.entities.Message;
import com.zzti.outsourcing.entities.Notice;
import com.zzti.outsourcing.entities.OutEmployee;
import com.zzti.outsourcing.entities.OutProject;
import com.zzti.outsourcing.entities.ProjectAllocate;
import com.zzti.outsourcing.entities.PublicResume;
import com.zzti.outsourcing.entities.Reply;
import com.zzti.outsourcing.entities.Resume;
import com.zzti.outsourcing.entities.Salary;
import com.zzti.outsourcing.entities.Train;
import com.zzti.outsourcing.entities.TrainEmp;
import com.zzti.outsourcing.entities.TrainResult;
import com.zzti.outsourcing.entities.CheckWork;
import com.zzti.outsourcing.service.EmployeeSV;
import com.zzti.outsourcing.service.PublicSV;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import com.opensymphony.xwork2.ActionContext;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class EmployeeAction extends BasicAction {
	private EmployeeSV employeesv;
	private int employeeId;
	private String employeePwd;
	private List<Employee> list;
	private File file1;
	private String file1FileName;
	private String file1ContentType;
	private PublicSV publicSv ;
	private Notice notice;
	private List<Notice> noticelist;
	private TrainEmp trainemp;
	private List typelist;
	private Employee info;
	private List<Resume> resume;
	private Resume resume1;
	private PublicResume pr;
    private List<PublicResume> list1;
    private List<Message> message;
	private List<ProjectAllocate> pjac;
	private ProjectAllocate pjac1;
	private List<OutEmployee> oe;
	private OutEmployee outemployee;
	private List<OutProject> op;
	private OutProject opt;
	private List<TrainResult> tr;
	private List<Train> t;
	private Train train;
	private List<CheckWork> cw;
	private List<Leave> leave;
	private Leave lee;
	private List<Salary> salary;
	private Salary saly;
	private List<TrainEmp> te;
	public List<TrainEmp> getTe() {
		return te;
	}

	public void setTe(List<TrainEmp> te) {
		this.te = te;
	} Leave getLee() {
		return lee;
	}

	public void setLee(Leave lee) {
		this.lee = lee;
	}

	public List<Leave> getLeave() {
		return leave;
	}

	public void setLeave(List<Leave> leave) {
		this.leave = leave;
	}

	public EmployeeSV getEmployeesv() {
		return employeesv;
	}

	public void setEmployeesv(EmployeeSV employeesv) {
		this.employeesv = employeesv;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeePwd() {
		return employeePwd;
	}

	public void setEmployeePwd(String employeePwd) {
		this.employeePwd = employeePwd;
	}

	public List<Employee> getList() {
		return list;
	}

	public void setList(List<Employee> list) {
		this.list = list;
	}

	public File getFile1() {
		return file1;
	}

	public void setFile1(File file1) {
		this.file1 = file1;
	}

	public String getFile1FileName() {
		return file1FileName;
	}

	public void setFile1FileName(String file1FileName) {
		this.file1FileName = file1FileName;
	}

	public String getFile1ContentType() {
		return file1ContentType;
	}

	public void setFile1ContentType(String file1ContentType) {
		this.file1ContentType = file1ContentType;
	}

	public PublicSV getPublicSv() {
		return publicSv;
	}

	public void setPublicSv(PublicSV publicSv) {
		this.publicSv = publicSv;
	}

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	public List<Notice> getNoticelist() {
		return noticelist;
	}

	public void setNoticelist(List<Notice> noticelist) {
		this.noticelist = noticelist;
	}

	public TrainEmp getTrainemp() {
		return trainemp;
	}

	public void setTrainemp(TrainEmp trainemp) {
		this.trainemp = trainemp;
	}

	public List getTypelist() {
		return typelist;
	}

	public void setTypelist(List typelist) {
		this.typelist = typelist;
	}

	public Employee getInfo() {
		return info;
	}

	public void setInfo(Employee info) {
		this.info = info;
	}

	public List<Resume> getResume() {
		return resume;
	}

	public void setResume(List<Resume> resume) {
		this.resume = resume;
	}

	public Resume getResume1() {
		return resume1;
	}

	public void setResume1(Resume resume1) {
		this.resume1 = resume1;
	}

	public PublicResume getPr() {
		return pr;
	}

	public void setPr(PublicResume pr) {
		this.pr = pr;
	}

	public List<PublicResume> getList1() {
		return list1;
	}

	public void setList1(List<PublicResume> list1) {
		this.list1 = list1;
	}

	public List<Message> getMessage() {
		return message;
	}

	public void setMessage(List<Message> message) {
		this.message = message;
	}

	public List<ProjectAllocate> getPjac() {
		return pjac;
	}

	public void setPjac(List<ProjectAllocate> pjac) {
		this.pjac = pjac;
	}

	public ProjectAllocate getPjac1() {
		return pjac1;
	}

	public void setPjac1(ProjectAllocate pjac1) {
		this.pjac1 = pjac1;
	}

	public List<OutEmployee> getOe() {
		return oe;
	}

	public void setOe(List<OutEmployee> oe) {
		this.oe = oe;
	}

	public OutEmployee getOutemployee() {
		return outemployee;
	}

	public void setOutemployee(OutEmployee outemployee) {
		this.outemployee = outemployee;
	}

	public List<OutProject> getOp() {
		return op;
	}

	public void setOp(List<OutProject> op) {
		this.op = op;
	}

	public OutProject getOpt() {
		return opt;
	}

	public void setOpt(OutProject opt) {
		this.opt = opt;
	}

	public List<TrainResult> getTr() {
		return tr;
	}

	public void setTr(List<TrainResult> tr) {
		this.tr = tr;
	}

	public List<Train> getT() {
		return t;
	}

	public void setT(List<Train> t) {
		this.t = t;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public List<CheckWork> getCw() {
		return cw;
	}

	public void setCw(List<CheckWork> cw) {
		this.cw = cw;
	}

	public List<Salary> getSalary() {
		return salary;
	}

	public void setSalary(List<Salary> salary) {
		this.salary = salary;
	}

	public Salary getSaly() {
		return saly;
	}

	public void setSaly(Salary saly) {
		this.saly = saly;
	}

	public String login()throws Exception{
	    list = employeesv.employeeLogin(employeeId);
	    if(list.size()==0){
	    	HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");
			response.setContentType("text/html; charset=gbk");
			PrintWriter outjs = response.getWriter();
			outjs.print("<script>alert('用户名错误');window.location.href='employee/employee_login.jsp';</script>");
			return null;	
	    }else if(employeePwd.equals(list.get(0).getEmployee_pwd())){
			int employeeId = list.get(0).getEmployee_id();    
			String employeeName = list.get(0).getEmployee_name();
			long employeePhone = list.get(0).getEmployee_phone();
			String employeeEmail = list.get(0).getEmployee_email();
			String employeeSex = list.get(0).getEmployee_sex();
			Date enterTime = list.get(0).getEnter_time();
			double basicSalary = list.get(0).getBasicSalary();
			String workStatus = list.get(0).getWork_status();
			int employeeAge = list.get(0).getEmployee_age();
			session.put("userid", employeeId);
	        session.put("user", employeeName);
	        session.put("employeeAge", employeeAge);
	        session.put("employeePhone", employeePhone);
	        session.put("employeeEmail", employeeEmail);
	        session.put("employeeSex", employeeSex);
	        session.put("enterTime", enterTime);
	        session.put("basicSalary", basicSalary);
	        session.put("workStatus", workStatus);
	        noticeList();
			return "login";
			}else{
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setCharacterEncoding("gbk");
				response.setContentType("text/html; charset=gbk");
				PrintWriter outjs = response.getWriter();
				outjs.print("<script>alert('密码错误');window.location.href='employee/employee_login.jsp';</script>");
				return null;		
			}
	}
	
	//退出系统，清除session
	public String loginout()throws Exception{
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		session.clear();
		return "loginout";
	}
	
	public String  updatePwd()throws Exception{
		String employeeId = httpServletrequest.getParameter("employeeId");
		String oldEmployeePwd = httpServletrequest.getParameter("oldEmployeePwd");
		String newEmployeePwd = httpServletrequest.getParameter("newEmployeePwd");
		List<Employee> list = null;
		    int empId = Integer.parseInt(employeeId);
			list = employeesv.selectInfo(empId);
			if(list != null && list.get(0).getEmployee_pwd().equals(oldEmployeePwd)){
				employeesv.updatePwd(empId, newEmployeePwd);
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
				PrintWriter outjs = response.getWriter();
				outjs.print("<script>alert('修改成功返回登陆界面！');window.location.href='employee/employee_login.jsp';</script>");
				return null;
			}else{
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setCharacterEncoding("gbk");
				response.setContentType("text/html; charset=gbk");
				PrintWriter outjs = response.getWriter();
				outjs.print("<script>alert('旧密码填写错误');window.location.href='employee/update_pwd.jsp';</script>");
				return null;
			}
		}

	//根据employee_id查询个人信息
	public String selectInfo()throws Exception{
		int empId = (Integer) session.get("userid");
		list = employeesv.selectInfo(empId);
		info = list.get(0);
		String address = info.getEmployee_address();
		if("".equals(address)){
			httpServletrequest.setAttribute("province", "无信息");
			httpServletrequest.setAttribute("city", "无信息");
		}else{
		    String [] address1 = address.split("/");
		    System.out.println("11111111111111111111111111111111111" + address);
	        httpServletrequest.setAttribute("province", address1[0]);
		    httpServletrequest.setAttribute("city", address1[1]);
		    
		}
		if("U".equals(info.getWork_status())){
			httpServletrequest.setAttribute("workerstatus", "外派中");
		}else{
			httpServletrequest.setAttribute("workerstatus", "空闲中");
		}
		return "selectInfo";
		}


	public String toEditInfo()throws Exception{
		int empId = (Integer) session.get("userid"); 
		list = employeesv.selectInfo(empId);
		info = list.get(0);
		return "toEditInfo";
	}
	
	//修改个人信息
	public String editInfo()throws Exception{
		String province = httpServletrequest.getParameter("province");
		String city = httpServletrequest.getParameter("city");
		info.setEmployee_address(province + "/" + city);
		employeesv.editInfo(info);
		return "editInfo";
	}
	
	//查看个人简历
	public String findResume()throws Exception{
		int id = (Integer) session.get("userid");
		info = employeesv.selectInfo(id).get(0);
		resume = employeesv.findResume(id);
		oe = employeesv.findAllTask(id);
		System.out.println(oe.size());
		if(resume.size()==0){
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");
			response.setContentType("text/html; charset=gbk");
			PrintWriter outjs = response.getWriter();
			outjs.print("<script>alert('当前没有您的简历，请前往创建！');window.location.href='employee-toAddResume';</script>");
			return null;
		}else{
		return "findResume";
		}
	}
	
	//删除当前简历
	public String deleteResume()throws Exception{
		int id = (Integer) session.get("userid");
		employeesv.deleteResume(id);
		return "deleteResume";
		
	}
	
	//修改当前简历
	public String toEditResume()throws Exception{
		int empId = (Integer) session.get("userid");
		resume = employeesv.findResume(empId);
		resume1 = resume.get(0);
		return "toEditResume";
	}
	public String editResume()throws Exception{
		employeesv.editResume(resume1);
		return "editResume";
	}
	
	//创建简历
	public String toAddResume()throws Exception{
		int empId = (Integer) session.get("userid");
		info = employeesv.selectInfo(empId).get(0);
		String taskname = "";
		oe = employeesv.findTaskSize(empId);
		for(int i = 0;i<oe.size();i++){
			if(i>0 && i<oe.size()){
				taskname += ",";
			}
			taskname += oe.get(i).getProject_name();
		}
		System.out.println("--------------------"+info.getEmployee_age());
		httpServletrequest.setAttribute("resumename", info.getEmployee_name());
		httpServletrequest.setAttribute("resumeemail", info.getEmployee_email());
		httpServletrequest.setAttribute("resumeage", info.getEmployee_age());
		httpServletrequest.setAttribute("resumephone", info.getEmployee_phone());
		httpServletrequest.setAttribute("resumesex", info.getEmployee_sex());
		httpServletrequest.setAttribute("taskname", taskname);
		return "toAddResume";
	}
		public String addResume()throws Exception{
			File files = this.getFile1();

			try {
				InputStream is = new FileInputStream(files);
				// 设置上传文件目录
				String uploadPath = ServletActionContext.getRequest()
						.getRealPath("/upload");
				File toFile = new File(uploadPath, file1FileName);
				// 创建一个输出流
				OutputStream os = new FileOutputStream(toFile);
				byte[] buffer = new byte[5240];
				int length = 0;
				while ((length = is.read(buffer)) > 0) {
					os.write(buffer, 0, length);
				}
				// 关闭输入流
				is.close();

				// 关闭输出流
				os.close();
				resume1.setLocal_resume(file1FileName);	
				employeesv.addResume(resume1);
				String user = (String)session.get("user");
				/*String inPath = "E://Java//apache-tomcat-7.0.69-windows-x86//apache-tomcat-7.0.69//webapps//OutSourcingSystem//upload//" + user + "的简历.doc";
				String toPath = "D://QQ//1210776286//FileRecv//OutSourcingSystem//WebRoot//employee//MyHtml.html";
				ActiveXComponent axc = new ActiveXComponent("Word.Application");
				try{
					axc.setProperty("Visible",new Variant(false));
					Dispatch docs = axc.getProperty("Documents").toDispatch();
					Dispatch doc = Dispatch.invoke(docs, "Open", Dispatch.Method, new Object[]{inPath,new Variant(false),new Variant(true)},new int[1]).toDispatch();
					Dispatch.invoke(doc, "SaveAs", Dispatch.Method, new Object[]{toPath,new Variant(8)},new int[1]);
					Variant f = new Variant(false);
					Dispatch.call(doc, "Close",f);
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					axc.invoke("Quit",new Variant[]{});
			
				}*/
			
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setCharacterEncoding("gbk");
				response.setContentType("text/html; charset=gbk");
				PrintWriter outjs = response.getWriter();
				outjs.print("<script>alert('个人简历创建成功！');window.location.href='employee-findResume';</script>");
			}catch (Exception e) {
				employeesv.addResume(resume1);
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setCharacterEncoding("gbk");
				response.setContentType("text/html; charset=gbk");
				PrintWriter outjs = response.getWriter();
				outjs.print("<script>alert('个人简历创建成功！');window.location.href='employee-findResume';</script>");
			}
			return null;
					
		}
		
		//单独上传简历
		public void upResume()throws Exception{
			int empId = (Integer) session.get("userid");
			File files = this.getFile1();

			try {
				InputStream is = new FileInputStream(files);
				// 设置上传文件目录
				String uploadPath = ServletActionContext.getRequest()
						.getRealPath("/upload");
				File toFile = new File(uploadPath, file1FileName);
				// 创建一个输出流
				OutputStream os = new FileOutputStream(toFile);
				byte[] buffer = new byte[5240];
				int length = 0;
				while ((length = is.read(buffer)) > 0) {
					os.write(buffer, 0, length);
				}
				// 关闭输入流
				is.close();

				// 关闭输出流
				os.close();
				employeesv.upResume(empId,file1FileName);
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setCharacterEncoding("gbk");
				response.setContentType("text/html; charset=gbk");
				PrintWriter outjs = response.getWriter();
				outjs.print("<script>alert('上传成功！'); window.close();</script>");
			}catch (Exception e) {
				
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setCharacterEncoding("gbk");
				response.setContentType("text/html; charset=gbk");
				PrintWriter outjs = response.getWriter();
				outjs.print("<script>alert('上传失败！'); window.close();</script>");
			}
		}

	//下载简历
	public String downResume()throws Exception{
		int id = (Integer) session.get("userid");
		resume1 = employeesv.findResume(id).get(0);
		oe = employeesv.findAllTask(id);
		return "downResume";
	}
	
	//上发简历至服务器
	public String hairResume()throws Exception{
		PublicResume pr = new PublicResume();
		int id = (Integer) session.get("userid");
		list1 = employeesv.findPResume(id);
		info = employeesv.selectInfo(id).get(0);
		String projectname = "";
		String projecttype = "";
		String worktype = "";
		if(list1.size() == 0){
			resume1 = employeesv.findResume(id).get(0);
			oe = employeesv.findAllTask(id);
		    for(int i=0;i<oe.size();i++){
		    	if(i>0 && i<oe.size()){
		    		projectname += ",";
		    		projecttype += ",";
		    		worktype += ",";
				}
		    	projectname += oe.get(i).getProject_name();
		    	projecttype += oe.get(i).getProject_type();
		    	worktype += oe.get(i).getWork_type();
		    }
			pr.setProject_name(projectname);
			pr.setProject_type(projecttype);
			pr.setWork_type(worktype);
			String Pname = resume1.getResume_name();
			String Psex = resume1.getResume_sex();
			int Page = resume1.getResume_age();
			long Pphone = resume1.getResume_phone();
			String Pemail = resume1.getResume_email();
			String Pstudy = resume1.getResume_study();
			String Pouthistory = resume1.getResume_outhistory();
			String Passess = resume1.getResume_assess();
			pr.setPr_id(id);
			pr.setPr_name(Pname);
			pr.setPr_sex(Psex);
			pr.setPr_age(Page);
			pr.setPr_phone(Pphone);
			pr.setPr_email(Pemail);
			pr.setPr_study(Pstudy);
			pr.setPr_outhistory(Pouthistory);
			pr.setPr_assess(Passess);
			pr.setEducation(info.getEducation());
			pr.setEmployee_skill(info.getEmployee_skill());
			pr.setSchool(info.getSchool());
			employeesv.hairResume(pr);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");
			response.setContentType("text/html; charset=gbk");
			PrintWriter outjs = response.getWriter();
			outjs.print("<script>alert('简历已经成功上传至服务器！');window.location.href='employee/employeeHome.jsp';</script>");
			return null;
		}else{
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");
			response.setContentType("text/html; charset=gbk");
			PrintWriter outjs = response.getWriter();
			outjs.print("<script>alert('服务器已经有您的简历，想要删除原简历请联系管理员！');window.location.href='employee-findResume';</script>");
			return null;
		
		}
	}
	
	//查看普通消息
	public String viewInform()throws Exception{
		int id = (Integer) session.get("userid");
		message = employeesv.viewInform(id);
		return "viewInform";
	}
	public String interview()throws Exception{
		int id = (Integer) session.get("userid");
		pjac = employeesv.interview(id);
		return "interview";
	}
	public String selectInterview()throws Exception{
		int empId = (Integer) session.get("userid");
		String inport = httpServletrequest.getParameter("inport");
		try{
			int id = Integer.parseInt(inport);
			pjac = employeesv.selectInterview(id,empId);
		}catch(Exception e){
			pjac = employeesv.selectInterviewByName(inport,empId);
		}
		if(pjac.size() == 0){
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");
			response.setContentType("text/html; charset=gbk");
		    PrintWriter outjs = response.getWriter();
			outjs.print("<script>alert('未查询到指定信息');window.location.href='employee-interview';</script>");
			return null;
	    }else{
	    	return "interview";
	    }
	}
	
	//反馈面试结果--面试通过
	public String success()throws Exception{
		String mid = httpServletrequest.getParameter("id");
		int mid1 = Integer.parseInt(mid);
		System.out.println("================="+mid1);
		int id = (Integer) session.get("userid");
		ProjectAllocate pa = new ProjectAllocate();
		Message ma = new Message();
		pa = employeesv.selectProject(id,mid1).get(0);
		pa.setEnd(1);
		employeesv.updateEnd(pa);
		HttpServletResponse response = ServletActionContext.getResponse();
	    response.setCharacterEncoding("gbk");
	    response.setContentType("text/html; charset=gbk");
	    PrintWriter outjs = response.getWriter();
	    outjs.print("<script>alert('已完成反馈！');window.location.href='employee-interview';</script>");
	    return null;
	}
	//反馈面试结果--面试未通过
	public String lose()throws Exception{
		String mid = httpServletrequest.getParameter("id");
		int mid1 = Integer.parseInt(mid);
		int id = (Integer) session.get("userid");
		ProjectAllocate pa = new ProjectAllocate();
		Message ma = new Message();
		pa = employeesv.selectProject(id,mid1).get(0);
		pa.setEnd(2);
		employeesv.updateEnd(pa);
		HttpServletResponse response = ServletActionContext.getResponse();
	    response.setCharacterEncoding("gbk");
	    response.setContentType("text/html; charset=gbk");
	    PrintWriter outjs = response.getWriter();
	    outjs.print("<script>alert('已完成反馈！');window.location.href='employee-interview';</script>");
	    return null;
	}
	
	//查看所有外派任务
	public String selectTask()throws Exception{
		int first = 1;
		int max = 4;
		if (httpServletrequest.getParameter("pagenum") != null) {
			first = Integer.parseInt(httpServletrequest.getParameter("pagenum"));
		}
		int id = (Integer) session.get("userid");
		oe = employeesv.selectTask((first - 1) * max, max,id);
		int total = employeesv.findTaskSize(id).size();
		httpServletrequest.setAttribute("pagerinfo", Pager.getPagerNormal(
				total, max, first, "employee-selectTask.action", "共有" + total
						+ "条记录"));
			return "selectTask";		
	}
	public String selectProject()throws Exception{
		int empId = (Integer) session.get("userid");
		String name = httpServletrequest.getParameter("name");
		String city = httpServletrequest.getParameter("city");
		String type = httpServletrequest.getParameter("type");
		if(name != ""){
			oe = employeesv.selectProjectByName(name,empId);
		}else if(city != ""){
		    oe = employeesv.selectProjectByCity(city,empId);
		}else{
			oe = employeesv.selectProjectByType(type,empId);
		}
		if(oe.size() == 0){
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");
			response.setContentType("text/html; charset=gbk");
		    PrintWriter outjs = response.getWriter();
			outjs.print("<script>alert('未查询到指定信息');window.location.href='employee-selectTask';</script>");
			return null;
	    }else{
	    	return "selectTask";
	    }
	}
	
	//根据项目名查询项目明细
	public String viewProject()throws Exception{
		String pname = httpServletrequest.getParameter("proname");
		String name = new String(pname.getBytes("ISO8859-1"),"UTF-8");
		System.out.println(name);
		op = employeesv.viewProject(name);
		System.out.println("========================"+op.size());
		if(op.size() == 0){
			HttpServletResponse response = ServletActionContext.getResponse();
		    response.setCharacterEncoding("gbk");
		    response.setContentType("text/html; charset=gbk");
		    PrintWriter outjs = response.getWriter();
		    outjs.print("<script>alert('数据出错！请联系管理员。');window.location.href='employee-selectTask';</script>");
		    return null;
		}else{
			return "viewProject";
		}
	}
	
	//培训情况查看
	public String viewTrain()throws Exception{
		int id = (Integer) session.get("userid");
		int first = 1;
		int max = 4;
		if (httpServletrequest.getParameter("pagenum") != null) {
			first = Integer.parseInt(httpServletrequest.getParameter("pagenum"));
		}
		tr = employeesv.viewTrain((first - 1) * max, max,id);
		SimpleDateFormat now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		int total = employeesv.findTrainSize(id).size();
		if(total == 0){
			HttpServletResponse response = ServletActionContext.getResponse();
		    response.setCharacterEncoding("gbk");
		    response.setContentType("text/html; charset=gbk");
		    PrintWriter outjs = response.getWriter();
		    outjs.print("<script>alert('您尚未参加任何培训。现在报名？');window.location.href='employee-joinTrain';</script>");
		    return null;
		}else{
		    httpServletrequest.setAttribute("pagerinfo", Pager.getPagerNormal(
				    total, max, first, "employee-viewTrain.action", "共有" + total
						    + "条记录"));
	        }
		return "viewTrain";
	}
	
	//内部培训报名
	public String joinTrain()throws Exception{
		t = employeesv.lookTrain();
		return "joinTrain";
		
	}
	public String selectTrain()throws Exception{
		String inport = httpServletrequest.getParameter("inport");
		try{
			int id = Integer.parseInt(inport);
			t = employeesv.selectTrainById(id);
		}catch(Exception e){
			t = employeesv.selectTrainByName(inport);		
		}
		if(t.size() == 0){
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");
			response.setContentType("text/html; charset=gbk");
			PrintWriter outjs = response.getWriter();
			outjs.print("<script>alert('未查询到指定信息');window.location.href='employee-joinTrain';</script>");
			return null;
		}
		return "joinTrain";	
	}
	public void choseTitle()throws Exception{
		int empId = (Integer)session.get("userid");
		String id = httpServletrequest.getParameter("id");
		int tid = Integer.parseInt(id);
		System.out.println("111111111111111111111111111111111"+tid);
		int total = employeesv.findTrainResultSize(tid,empId).size();
		if(total == 0){
			train = employeesv.choseTrain(tid).get(0);//查看本次申请的培训
			Date endtime  = train.getEnd_time();
			if(endtime == null){
				if(train.getStatus() == 2){
					HttpServletResponse response = ServletActionContext.getResponse();
				    response.setCharacterEncoding("gbk");
				    response.setContentType("text/html; charset=gbk");
					PrintWriter outjs = response.getWriter();
				    outjs.print("<script>alert('报名失败，报名已关闭！');window.location.href='employee-viewTrain';</script>");
				}else{
					TrainResult trainresult = new TrainResult();
					trainresult.setTrain_id(tid);
					System.out.println("222222222222222222222222222222222222222222222222"+tid);
					trainresult.setTrain_proId(empId);
					trainresult.setTrain_content(train.getTrain_content());
					trainresult.setTrain_time(train.getTrain_time());
					trainresult.setTrain_title(train.getTrain_title());
					trainresult.setTrain_days(train.getTrain_days());
					trainresult.setTrain_place(train.getTrain_place());
					trainresult.setTrain_trainer(train.getTrain_trainer());
					employeesv.insertTrainResult(trainresult);
					System.out.println("3333333333333333333333333333333333333333333333"+tid);
					TrainEmp tep = new TrainEmp();
					tep.setTrain_id(tid);
					System.out.println("444444444444444444444444444444444444444444444"+tid);
					tep.setEmployee_id(empId);
					employeesv.insertTrainEmp(tep);
					HttpServletResponse response = ServletActionContext.getResponse();
				    response.setCharacterEncoding("gbk");
				    response.setContentType("text/html; charset=gbk");
					PrintWriter outjs = response.getWriter();
				    outjs.print("<script>alert('已成功报名。');window.location.href='employee-viewTrain';</script>");
			    }
				}else{
					if(train.getStatus() == 2){
						HttpServletResponse response = ServletActionContext.getResponse();
					    response.setCharacterEncoding("gbk");
					    response.setContentType("text/html; charset=gbk");
						PrintWriter outjs = response.getWriter();
					    outjs.print("<script>alert('报名失败，报名已关闭！');window.location.href='employee-viewTrain';</script>");
					}else{
						Date nowtime = new Date();
						int i = endtime.compareTo(nowtime);
						if(i<1){
							HttpServletResponse response = ServletActionContext.getResponse();
						    response.setCharacterEncoding("gbk");
						    response.setContentType("text/html; charset=gbk");
							PrintWriter outjs = response.getWriter();
						    outjs.print("<script>alert('报名失败，报名已截止！');window.location.href='employee-viewTrain';</script>");
						}else{
							TrainResult trainresult = new TrainResult();
							trainresult.setTrain_id(tid);
							System.out.println("222222222222222222222222222222222222222222222222"+tid);
							trainresult.setTrain_proId(empId);
							trainresult.setTrain_content(train.getTrain_content());
							trainresult.setTrain_time(train.getTrain_time());
							trainresult.setTrain_title(train.getTrain_title());
							trainresult.setTrain_days(train.getTrain_days());
							trainresult.setTrain_place(train.getTrain_place());
							trainresult.setTrain_trainer(train.getTrain_trainer());
							employeesv.insertTrainResult(trainresult);
							System.out.println("3333333333333333333333333333333333333333333333"+tid);
							TrainEmp tep = new TrainEmp();
							tep.setTrain_id(tid);
							System.out.println("444444444444444444444444444444444444444444444"+tid);
							tep.setEmployee_id(empId);
							employeesv.insertTrainEmp(tep);
							HttpServletResponse response = ServletActionContext.getResponse();
						    response.setCharacterEncoding("gbk");
						    response.setContentType("text/html; charset=gbk");
							PrintWriter outjs = response.getWriter();
						    outjs.print("<script>alert('已成功报名。');window.location.href='employee-viewTrain';</script>");
			            }
			}	
			}
		}else{
			HttpServletResponse response = ServletActionContext.getResponse();
		    response.setCharacterEncoding("gbk");
		    response.setContentType("text/html; charset=gbk");
			PrintWriter outjs = response.getWriter();
		    outjs.print("<script>alert('报名失败，请勿重复报名！');window.location.href='employee-viewTrain';</script>");
		}
		}
	
	//反馈面试结果传值
	public String result()throws Exception{
		String pid = httpServletrequest.getParameter("pid");
		httpServletrequest.setAttribute("pid", pid);
		return "result";
	}

	//薪资查看
	public String viewSalary()throws Exception{
		int empId = (Integer)session.get("userid");
		oe = employeesv.checkSalary(empId);
		info = employeesv.selectInfo(empId).get(0);
		for(int i=0;i<oe.size();i++){
			oe.get(i).setCity("30/天");
			oe.get(i).setProject_type("10/天");
		}
		return "viewSalary";
	}
	
	//取消培训
	public void remove()throws Exception{
		String tid = httpServletrequest.getParameter("id");
		int id = Integer.parseInt(tid);
		int empId = (Integer)session.get("userid");
		train = employeesv.choseTrain(id).get(0);
		Date endtime = train.getTrain_time();
		Date date = new Date();
		int i = endtime.compareTo(date);
		if(i>0){
			employeesv.deleteTrainResult(id,empId);
			employeesv.deleteTrainEmp(id,empId);
			HttpServletResponse response = ServletActionContext.getResponse();
		    response.setCharacterEncoding("gbk");
		    response.setContentType("text/html; charset=gbk");
			PrintWriter outjs = response.getWriter();
		    outjs.print("<script>alert('你已成功取消本次培训。');window.location.href='employee-viewTrain';</script>");
		}else{
			HttpServletResponse response = ServletActionContext.getResponse();
		    response.setCharacterEncoding("gbk");
		    response.setContentType("text/html; charset=gbk");
			PrintWriter outjs = response.getWriter();
		    outjs.print("<script>alert('取消培训失败！该培训已经开始。');window.location.href='employee-viewTrain';</script>");
		}
		
	}
	
	//考勤查看
	public String CheckWork()throws Exception{
		int empId = (Integer)session.get("userid");
		leave = employeesv.viewholiday(empId);
		return "checkWork";
	}
	
	//查看单条培训明细
		public String lookTrain()throws Exception{
			String id = httpServletrequest.getParameter("id");
			int tid = Integer.parseInt(id);
			t = employeesv.lookTrain(tid);
			if(t == null){
				HttpServletResponse response = ServletActionContext.getResponse();
			    response.setCharacterEncoding("gbk");
			    response.setContentType("text/html; charset=gbk");
				PrintWriter outjs = response.getWriter();
			    outjs.print("<script>alert('没有查询到相关明细。');window.location.href='employee/employeeHome.jsp';</script>");
			    return null;
			}else{
				return "lookTrain";
			}
			
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
		public String firstPage(){
			noticeList();
			return "firstpage";
		}
		//公告详情
		public String selectNotice(){
			String notice_id = httpServletrequest.getParameter("notice_id");
			
			this.notice = publicSv.selectNotice(notice_id).get(0);
			return "empnotice";			
		}
		
		//外派任务完成后提交
		public String toCloseTask()throws Exception{
			int empId = (Integer)session.get("userid");
			oe = employeesv.findTasking(empId);
			if(oe.size() == 0){
				HttpServletResponse response = ServletActionContext.getResponse();
			    response.setCharacterEncoding("gbk");
			    response.setContentType("text/html; charset=gbk");
				PrintWriter outjs = response.getWriter();
			    outjs.print("<script>alert('当前没有进行中的任务。');window.location.href='employee-selectTask';</script>");
			    return null;
			}else{
				Date time = new Date();
				String nowtime = (new SimpleDateFormat("yyyy/MM/dd")).format(time);
				httpServletrequest.setAttribute("nowtime", nowtime);
				return "toCloseTask";
			}
			
		}
		public void closeTask()throws Exception{
			int empId = (Integer)session.get("userid");
			oe = employeesv.findTasking(empId);
			String pname = oe.get(0).getProject_name();
			String employeestatus = "E";
			int projectstatus = 2;
			employeesv.updateEmployeeStatus(empId);
			employeesv.updateProjectStatus(empId,pname);
			HttpServletResponse response = ServletActionContext.getResponse();
		    response.setCharacterEncoding("gbk");
		    response.setContentType("text/html; charset=gbk");
			PrintWriter outjs = response.getWriter();
		    outjs.print("<script>alert('你已成功提交！');window.location.href='employee/employeeHome.jsp';</script>");
		}
		
		//请假
		public String Task()throws Exception{
			int empId = (Integer)session.get("userid");
			oe = employeesv.findTasking(empId);
			if(oe.size() == 0){
				HttpServletResponse response = ServletActionContext.getResponse();
			    response.setCharacterEncoding("gbk");
			    response.setContentType("text/html; charset=gbk");
				PrintWriter outjs = response.getWriter();
			    outjs.print("<script>alert('当前没有进行中的任务。');window.location.href='employee-selectTask';</script>");
			    return null;
			}else{
				Date time = new Date();
				String nowtime = (new SimpleDateFormat("yyyy/MM/dd")).format(time);
				httpServletrequest.setAttribute("nowtime", nowtime);
				return "addholiday";
			}
			
		}
		public void addholiday()throws Exception{
			String time1 = httpServletrequest.getParameter("datepickfrom");
			String time2 = httpServletrequest.getParameter("datepickto");
			String bossname = httpServletrequest.getParameter("bossname");
			String projectname = httpServletrequest.getParameter("projectname");
			String employeeid = httpServletrequest.getParameter("employeeid");
			String employeename = httpServletrequest.getParameter("employeename");
			int empId = Integer.parseInt(employeeid);
			leave = employeesv.checkholiday(empId);
			if(leave.size() == 0){
				String [] starttime = time1.split("/");
				String m = starttime[0];
				String d = starttime[1];
				String y = starttime[2];
				String [] endtime = time2.split("/");
				String mm = endtime[0];
				String dd= endtime[1];
				String yy = endtime[2];
				int y1 = Integer.parseInt(y);
				int m1 = Integer.parseInt(m);
				int d1 = Integer.parseInt(d);
				int y2 = Integer.parseInt(yy);
				int m2 = Integer.parseInt(mm);
				int d2 = Integer.parseInt(dd);
				Leave le = new Leave();
				le.setFlag(1);
				le.setEmployee_id(empId);
				le.setEmployee_name(employeename);
				le.setBoss_name(bossname);
				le.setProject_name(projectname);
				le.setStart_time(time1);
				le.setEnd_time(time2);
				Calendar c1 = Calendar.getInstance();
				Calendar c2 = Calendar.getInstance();
				c1.set(y1, m1, d1);
				c2.set(y2, m2, d2);
				long l1 = c1.getTimeInMillis();  
				long l2 = c2.getTimeInMillis();
				long days = (l2 - l1) / (24 * 60 * 60 * 1000);
				le.setDays(days);
				employeesv.addholiday(le);
				HttpServletResponse response = ServletActionContext.getResponse();
			    response.setCharacterEncoding("gbk");
			    response.setContentType("text/html; charset=gbk");
				PrintWriter outjs = response.getWriter();
			    outjs.print("<script>alert('提交成功');window.location.href='employee/employeeHome.jsp';</script>");
			}else{
				HttpServletResponse response = ServletActionContext.getResponse();
			    response.setCharacterEncoding("gbk");
			    response.setContentType("text/html; charset=gbk");
				PrintWriter outjs = response.getWriter();
			    outjs.print("<script>alert('提交失败，存在未销假的记录！');window.location.href='employee/employeeHome.jsp';</script>");
			}
			
		}
		//销假
		public void stopHoliday()throws Exception{
			int empId = (Integer)session.get("userid");
			Date time = new Date();
			String nowtime = (new SimpleDateFormat("MM/dd/yyyy")).format(time);
			leave = employeesv.checkholiday(empId);
			try{
				if(!"nowtime".equals(leave.get(0).getEnd_time())){
					String [] starttime = leave.get(0).getStart_time().split("/");
					String m = starttime[0];
					String d = starttime[1];
					String y = starttime[2];
					String [] endtime = nowtime.split("/");
					String mm = endtime[0];
					String dd= endtime[1];
					String yy = endtime[2];
					int y1 = Integer.parseInt(y);
					int m1 = Integer.parseInt(m);
					int d1 = Integer.parseInt(d);
					int y2 = Integer.parseInt(yy);
					int m2 = Integer.parseInt(mm);
					int d2 = Integer.parseInt(dd);
					Calendar c1 = Calendar.getInstance();
					Calendar c2 = Calendar.getInstance();
					c1.set(y1, m1, d1);
					c2.set(y2, m2, d2);
					long l1 = c1.getTimeInMillis();  
					long l2 = c2.getTimeInMillis();
					long days = (l2 - l1) / (24 * 60 * 60 * 1000);
					employeesv.stopholiday(empId,nowtime,days);
				}else{
					employeesv.stopholidayById(empId);
				}
				HttpServletResponse response = ServletActionContext.getResponse();
			    response.setCharacterEncoding("gbk");
			    response.setContentType("text/html; charset=gbk");
				PrintWriter outjs = response.getWriter();
			    outjs.print("<script>alert('已成功销假！');window.location.href='employee/employeeHome.jsp';</script>");
		}catch (Exception e){
			HttpServletResponse response = ServletActionContext.getResponse();
		    response.setCharacterEncoding("gbk");
		    response.setContentType("text/html; charset=gbk");
			PrintWriter outjs = response.getWriter();
		    outjs.print("<script>alert('无法销假。原因：未检测到进行中的休假。');window.location.href='employee/employeeHome.jsp';</script>");
		}
		}
	
	
		//分类统计
		public String findandcount()throws Exception{
			//入职时间
			int empId = (Integer)session.get("userid");
			info = employeesv.selectInfo(empId).get(0);
			Date time = new Date();
			String nowtime = (new SimpleDateFormat("MM/dd/yyyy")).format(time);
			Date entertime = info.getEnter_time();
			String thetime = (new SimpleDateFormat("MM/dd/yyyy")).format(entertime);
			String [] starttime = thetime.split("/");
			String m = starttime[0];
			String d = starttime[1];
			String y = starttime[2];
			String [] endtime = nowtime.split("/");
			String mm = endtime[0];
			String dd= endtime[1];
			String yy = endtime[2];
			int y1 = Integer.parseInt(y);
			int m1 = Integer.parseInt(m);
			int d1 = Integer.parseInt(d);
			int y2 = Integer.parseInt(yy);
			int m2 = Integer.parseInt(mm);
			int d2 = Integer.parseInt(dd);
			Calendar c1 = Calendar.getInstance();
			Calendar c2 = Calendar.getInstance();
			c1.set(y1, m1, d1);
			c2.set(y2, m2, d2);
			long l1 = c1.getTimeInMillis();  
			long l2 = c2.getTimeInMillis();
			long days = (l2 - l1) / (24 * 60 * 60 * 1000);
			httpServletrequest.setAttribute("workday", days);
			oe = employeesv.findTaskSize(empId);
			int worktotal = oe.size();
			httpServletrequest.setAttribute("worktotal", worktotal);
			String workcity = oe.get(0).getCity();
			String workcitylist = oe.get(0).getCity();
			for(int i=1;i<oe.size();i++){
				if(!workcity.equals(oe.get(i).getCity())){
					workcity = oe.get(i).getCity();
					workcitylist = workcitylist + "," + workcity;
				}
			}
			httpServletrequest.setAttribute("workcitylist", workcitylist);
			String worktype = oe.get(0).getProject_type();
			String worktypelist = oe.get(0).getProject_type();
			int workdays = 0;
			for(int j=1;j<oe.size();j++){
				workdays += oe.get(j).getWoker_time();
				if(!worktype.equals(oe.get(j).getProject_type())){
					worktype = oe.get(j).getProject_type();
					worktypelist = worktypelist + "," + worktype;
				}
			}
			httpServletrequest.setAttribute("worktypelist", worktypelist);
			httpServletrequest.setAttribute("workdays", workdays);
			leave = employeesv.viewholiday(empId);
			int holiday = 0;
			for(int a=0;a<leave.size();a++){
				holiday += leave.get(a).getDays();
			}
			if(holiday<0){
				httpServletrequest.setAttribute("holiday", 0);
			}else{
				httpServletrequest.setAttribute("holiday", holiday);
			}
			return "findandcount";
		}
		
		
		
		
		private List<Forum> forumlist;
		private Forum forum;
		
		
	

		public List<Forum> getForumlist() {
			return forumlist;
		}

		public void setForumlist(List<Forum> forumlist) {
			this.forumlist = forumlist;
		}

		public Forum getForum() {
			return forum;
		}

		public void setForum(Forum forum) {
			this.forum = forum;
		}

	public String forumList(){
		
		

		int first = 1;
		int max =10;

		if (httpServletrequest.getParameter("pagenum") != null) {
			first = Integer
					.parseInt(httpServletrequest.getParameter("pagenum"));
		}
		forumlist = publicSv.forumList((first - 1) * max, max);
		int total = publicSv.findForumSize().size();
		httpServletrequest.setAttribute("pagerinfo", Pager.getPagerNormal(
				total, max, first, "employee-forumList.action", "共有" + total
						+ "条记录"));
		
		
		return "forumList";
		
	}
	
	public String addForum(){
		
		forum.setForum_puttime(new Date());
		forum.setForum_peoname((String)session.get("user"));
		int id=(Integer) session.get("userid");
		forum.setForum_peopleid(id);
		publicSv.addForum(forum);
		
		return "addForum";
	}
	
	private List<Reply> replylist;
	
	private Reply reply;
	
	
	
	public Reply getReply() {
		return reply;
	}

	public void setReply(Reply reply) {
		this.reply = reply;
	}

	public List<Reply> getReplylist() {
		return replylist;
	}

	public void setReplylist(List<Reply> replylist) {
		this.replylist = replylist;
	}

	public String showReply(){
		int id = Integer.parseInt(httpServletrequest.getParameter("forum_id")) ;
		replylist = publicSv.showReply(id);
		forum = publicSv.selectforumByid(id).get(0);
		
		int i = forum.getForum_clinknum();
		forum.setForum_clinknum(i+1);
		publicSv.updateclicknum(forum);
		return "showReply";
	};
	
	public  String sendReply() throws IOException{
		int id = Integer.parseInt(httpServletrequest.getParameter("forum_id"));
		reply.setForum_id(id);
		Date time = new Date();
		reply.setReply_time(time);
		System.out.println(reply.getReply_content()+"-------------");
		int eid = (Integer) session.get("userid");
		reply.setReply_empid(eid);
		reply.setReply_empname((String)session.get("user"));
		publicSv.sendReply(reply);
		
		replylist = publicSv.showReply(id);
		forum = publicSv.selectforumByid(id).get(0);
		int size = replylist.size();
		Forum forums=new Forum();
		forums.setForum_id(id);
		forums.setForum_newtime(time);
		forums.setForum_name((String)session.get("user"));
		forums.setForum_replynum(size);
		publicSv.updateForum(forums);
		return "showReply";
	}
	//培训反馈
			public String tofeedback()throws Exception{
				int empId = (Integer)session.get("userid");
				String id = httpServletrequest.getParameter("id");
				int tid = Integer.parseInt(id);
				te = employeesv.checkTrainEmp(empId,tid);
				t = employeesv.choseTrain(tid);
				Date date = new Date();
				Date traintime = t.get(0).getTrain_time();
				String nowtime = (new SimpleDateFormat("yyyy/MM/dd")).format(date);
				String trainendtime = (new SimpleDateFormat("yyyy/MM/dd")).format(traintime);
				String[] nowtime1 = nowtime.split("/");
				String[] trainendtime1 = trainendtime.split("/");
				int y1 = Integer.parseInt(nowtime1[0]);
				int m1 = Integer.parseInt(nowtime1[1]);
				int d1 = Integer.parseInt(nowtime1[2]);
				int y2 = Integer.parseInt(trainendtime1[0]);
				int m2 = Integer.parseInt(trainendtime1[1]);
				int d2 = Integer.parseInt(trainendtime1[2]);
				int days = t.get(0).getTrain_days();
				if(days+d2 > 30){
					d2 += (days+d2)%30;
					if(m2+(days+d2)/30 > 12){
						y2 += m2/12;
						m2 += m2%12;
					}else{
						m2 += (days+d2)/30;
					}
				}else{
					d2 += days;
				}
				if(t.get(0).getEnd_time() == null){
					if(!"".equals(te.get(0).getFeed_train()) && !"".equals(te.get(0).getFeed_trainer())){
						HttpServletResponse response = ServletActionContext.getResponse();
					    response.setCharacterEncoding("gbk");
					    response.setContentType("text/html; charset=gbk");
						PrintWriter outjs = response.getWriter();
					    outjs.print("<script>alert('已评价，请勿重复评价！');window.location.href='employee/employeeHome.jsp';</script>");
					}else{
						return "feedback";
					}
				}else{
					if(!"".equals(te.get(0).getFeed_train()) && !"".equals(te.get(0).getFeed_trainer())){
						HttpServletResponse response = ServletActionContext.getResponse();
					    response.setCharacterEncoding("gbk");
					    response.setContentType("text/html; charset=gbk");
						PrintWriter outjs = response.getWriter();
					    outjs.print("<script>alert('已评价，请勿重复评价！');window.location.href='employee/employeeHome.jsp';</script>");
					    System.out.println("======================="+te.get(0).getFeed_train()+"============="+te.get(0).getFeed_trainer());
					}else if(y1>y2){
						return "feedback";
					}else if(m1>m2){
						return "feedback";
					}else if(d1>d2){
						return "feedback";
					}else{
						System.out.println("--------------------------"+y2+"----------"+m2+"-------"+d2);
						HttpServletResponse response = ServletActionContext.getResponse();
					    response.setCharacterEncoding("gbk");
					    response.setContentType("text/html; charset=gbk");
						PrintWriter outjs = response.getWriter();
					    outjs.print("<script>alert('该培训尚未结束！');window.location.href='employee/employeeHome.jsp';</script>");
					}
				}
				
				return null;
			}
			public void feedback()throws Exception{
				int empId = (Integer)session.get("userid");
				String id = httpServletrequest.getParameter("id");
				String feedtrain = httpServletrequest.getParameter("feedtrain");
				String feedtrainer = httpServletrequest.getParameter("feedtrainer");
				int tid = Integer.parseInt(id);
				try{
					employeesv.feedback(feedtrain,feedtrainer,empId,tid);
					HttpServletResponse response = ServletActionContext.getResponse();
				    response.setCharacterEncoding("gbk");
				    response.setContentType("text/html; charset=gbk");
					PrintWriter outjs = response.getWriter();
				    outjs.print("<script>alert('感谢您的评价！');window.location.href='employee/employeeHome.jsp';</script>");
				}catch(Exception e){
					HttpServletResponse response = ServletActionContext.getResponse();
				    response.setCharacterEncoding("gbk");
				    response.setContentType("text/html; charset=gbk");
					PrintWriter outjs = response.getWriter();
				    outjs.print("<script>alert('评价失败，请重试！');window.location.href='employee/employeeHome.jsp';</script>");
				}
				
			}
	
}
	
