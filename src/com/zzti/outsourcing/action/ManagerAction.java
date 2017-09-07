package com.zzti.outsourcing.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

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
import com.zzti.outsourcing.service.ManagerSV;
import com.zzti.outsourcing.service.PublicSV;

public class ManagerAction extends BasicAction{
	private PublicSV publicSv ;
	
	public PublicSV getPublicSv() {
		return publicSv;
	}

	public void setPublicSv(PublicSV publicSv) {
		this.publicSv = publicSv;
	}

	private ManagerSV managerSv;
	
	public ManagerSV getManagerSv() {
		return managerSv;
	}

	public void setManagerSv(ManagerSV managerSv) {
		this.managerSv = managerSv;
	}
	
	private String username;
	private String password;
	
	
	public String getUsername() {
		return username;
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

	private List<Employee> emplist;
	
	

		public List<Employee> getEmplist() {
		return emplist;
	}

	public void setEmplist(List<Employee> emplist) {
		this.emplist = emplist;
	}
	
	
	private Employee emp;
	
	
	

		public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

		// 管理员登陆
		public String mlogin() throws Exception {
			try {
				List<Manager> list = null;
				list = managerSv.managerLogin(username);

				if (username.equals(list.get(0).getUser_name())
						&& password.equals(list.get(0).getPassword())) {
				//	ActionContext ac = ActionContext.getContext();
					session.put("user", username);
					session.put("userid", list.get(0).getManager_id());
					return "mlogin";
				} else {
					HttpServletResponse response = ServletActionContext
							.getResponse();
					response.setCharacterEncoding("gbk");
					response.setContentType("text/html; charset=gbk");
					PrintWriter outjs = response.getWriter();
					outjs.print("<script>alert('用户名或密码错误');window.location.href='manager/mlogin.jsp';</script>");
					return null;
				}
			} catch (Exception e) {
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setCharacterEncoding("gbk");
				response.setContentType("text/html; charset=gbk");
				PrintWriter outjs = response.getWriter();
				outjs.print("<script>alert('用户名或密码错误');window.location.href='manager/mlogin.jsp';</script>");
				return null;
			}

		}
		
		// 修改密码
		public String updatePwd() throws Exception {
			String user = httpServletrequest.getParameter("user");
			String oldPwd = httpServletrequest.getParameter("oldPwd");
			String newPwd = httpServletrequest.getParameter("newPwd");
			List<Manager> list = null;

			list = managerSv.managerLogin(user);
			if (list != null && list.get(0).getPassword().equals(oldPwd)) {
				managerSv.updatePwd(user, newPwd);
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setCharacterEncoding("gbk");
				response.setContentType("text/html; charset=gbk");
				PrintWriter outjs = response.getWriter();
				outjs.print("<script>alert('修改成功返回登陆界面！');window.location.href='manager/mlogin.jsp';</script>");

			} else {
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setCharacterEncoding("gbk");
				response.setContentType("text/html; charset=gbk");
				PrintWriter outjs = response.getWriter();

				outjs.print("<script>alert('旧密码错误，请重新输入或联系管理员！');window.location.href='manager/updatePwd.jsp';</script>");

			}

			return null;
		}
		
		//员工列表
		public String empList() throws Exception {
			String el="empList";
			selemplist(el);
			return "empList";
		}
		
		
		
		private void selemplist(String actiongurl) throws Exception{
			int first = 1;
			int max = 4;

			if (httpServletrequest.getParameter("pagenum") != null) {
				first = Integer
						.parseInt(httpServletrequest.getParameter("pagenum"));
			}
			emplist = managerSv.employeeList((first - 1) * max, max);
			int total = managerSv.findEmpSize().size();
			httpServletrequest.setAttribute("pagerinfo", Pager.getPagerNormal(
					total, max, first, "manager-"+actiongurl+".action", "共有" + total
							+ "条记录"));
		}
		
		public String addemp() throws Exception {

			String province = httpServletrequest.getParameter("province");
			String city = httpServletrequest.getParameter("city");
			
			Date date= new Date();
			emp.setEmployee_pwd("0000");
			emp.setWork_status("E");
			emp.setEnter_time(date);
			emp.setBasicSalary(2000);
			emp.setEmployee_isin(1);
			emp.setEmployee_address(province+"/"+city);
			managerSv.addemp(emp);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");
			response.setContentType("text/html; charset=gbk");
			PrintWriter outjs = response.getWriter();
			outjs.print("<script>window.location.href='manager-empList';</script>");
			return null;
		}
		
		
		public String toaddemp(){
			emplist = managerSv.getMaxEmpId();
			int id=emplist.get(0).getEmployee_id()+1;
			System.out.println("--------------------------------"+id);
			httpServletrequest.setAttribute("employee_id", id);
			double basicSalary=emplist.get(0).getBasicSalary();
			System.out.println(basicSalary);
			httpServletrequest.setAttribute("basicSalary", basicSalary);
			httpServletrequest.setAttribute("Work_status", "未外派");
			
			return "toaddemp";
		}
		
		
		public String deleteEmp() throws Exception {
			String id = httpServletrequest.getParameter("id");
			managerSv.deleteEmp(id);
			return "deleteEmp";
		}
		//根据姓名，或者电话查询
		public String selectEmp() {
			String inport = httpServletrequest.getParameter("inport");
			this.emplist = managerSv.selectEmp(inport);

			return "selectEmp";
		}
		
		//员工详情
		public String showEmp(){
			String id = httpServletrequest.getParameter("id");
			emplist = managerSv.showEmp(id);
			String a = emplist.get(0).getWork_status();
			if(a.equals("U")){
				emplist.get(0).setWork_status("外派中");
			}else {
				emplist.get(0).setWork_status("未外派");
			}
			return "showEmp";
		}
		
		//修改雇员
		public String toEditEmp() throws Exception {
			
			String empid = httpServletrequest.getParameter("employee_id");
			
			
			this.emplist = managerSv.selectEmp(empid);
			this.emp = emplist.get(0);
			
			
			return "toEditEmp";
			
		}
		
		public String editEmp() throws Exception {
			managerSv.editEmp(emp);
			return "editEmp";
		}
		
		private List<Train> trainlist;
		
		private Train train;
		
		public Train getTrain() {
			return train;
		}

		public void setTrain(Train train) {
			this.train = train;
		}

		public List<Train> getTrainlist() {
			return trainlist;
		}

		public void setTrainlist(List<Train> trainlist) {
			this.trainlist = trainlist;
		}
		
		

		public String trainList() throws Exception {
			int first = 1;
			int max = 4;
			
			Date nowtime = new Date();
			
			List<Integer> arr= new ArrayList<Integer>();
			trainlist = managerSv.checkTrain();
			
			for (Train tl : trainlist) {
				if(tl.getEnd_time()!=null){
					
				boolean a = tl.getEnd_time().before(nowtime);
				if(a){
					arr.add(tl.getTrain_id());
				}
				}
			}
			managerSv.checkup(arr);

			if (httpServletrequest.getParameter("pagenum") != null) {
				first = Integer
						.parseInt(httpServletrequest.getParameter("pagenum"));
			}
			
		
			trainlist = managerSv.trainList((first - 1) * max, max);		
			int total = managerSv.findTrainSize().size();
			httpServletrequest.setAttribute("pagerinfo", Pager.getPagerNormal(
					total, max, first, "manager-trainList.action", "共有" + total
							+ "条记录"));

			return "trainList";
		}
		
		private int size;
		
		
		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}

		public String  totrain(){
			String id = httpServletrequest.getParameter("train_id");
			int tid = Integer.parseInt(id);
			trainlist  =  managerSv.selectTrainbyId(tid);
			size=managerSv.findTrainEmpSize(tid).size();
			
			return "TrainInform";
			
		}
		
		public String addtrain() throws IOException{
			
			Date date= new Date();	
			train.setStatus(1);
			train.setTrain_puttime(date);
			
			managerSv.addtrain(train);
			
			
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");
			response.setContentType("text/html; charset=gbk");
			PrintWriter outjs = response.getWriter();
			outjs.print("<script>window.location.href='manager-trainList';</script>");

			return null;
		}
		
		
		public String closetrain() throws IOException{
			String id = httpServletrequest.getParameter("train_id");
			managerSv.closetrain(id);
			
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");
			response.setContentType("text/html; charset=gbk");
			PrintWriter outjs = response.getWriter();
			outjs.print("<script>window.location.href='manager-trainList';</script>");
			
			return null;			
		}
		
		
		public String selectTrain() {
			String inport = httpServletrequest.getParameter("inport");
			this.trainlist = managerSv.selectTrain(inport);

			return "trainList";
		}
		
		private List<TrainPlan> trainplanlist;
		private TrainPlan trainplan;
		
		
		public TrainPlan getTrainplan() {
			return trainplan;
		}

		public void setTrainplan(TrainPlan trainplan) {
			this.trainplan = trainplan;
		}

		public List<TrainPlan> getTrainplanlist() {
			return trainplanlist;
		}

		public void setTrainplanlist(List<TrainPlan> trainplanlist) {
			this.trainplanlist = trainplanlist;
		}

		public String trainplanlist(){
			int first = 1;
			int max = 10;

			
			trainplanlist = managerSv.trainplanList((first - 1) * max, max);
			int total = managerSv.findtrainplanSize().size();
			httpServletrequest.setAttribute("pagerinfo", Pager.getPagerNormal(
					total, max, first, "manager-trainplanlist.action", "共有" + total
							+ "条记录"));
			
			return "trainplanlist";
		}
		
		public String selectResumeplan(){
			String id = httpServletrequest.getParameter("trainplan_id");
			trainplan =managerSv.selectTrainplane(id).get(0);
			return "trainplane";
		}
		
		public String addTrainplan() throws IOException{
			
             managerSv.addTrainplan(trainplan);
			
			
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");
			response.setContentType("text/html; charset=gbk");
			PrintWriter outjs = response.getWriter();
			outjs.print("<script>window.location.href='manager-trainplanlist';</script>");

			return null;
		}
		
		public String trainticklingList(){
			
			int first = 1;
			int max = 10;

			
			trainlist = managerSv.trainList((first - 1) * max, max);		
			int total = managerSv.findTrainSize().size();
			httpServletrequest.setAttribute("pagerinfo", Pager.getPagerNormal(
					total, max, first, "manager-trainticklingList.action", "共有" + total
							+ "条记录"));
	
			
			return "trainticklingList";
			
		}
		
		public String Traintickling(){
			String id = httpServletrequest.getParameter("train_id");
			int tid = Integer.parseInt(id);
			
			List<TrainEmp> telist = new ArrayList<TrainEmp>();
			telist=managerSv.findTrainEmpSize(tid);
			emplist = managerSv.findEmpByTrain(telist);
			
			httpServletrequest.setAttribute("telist", telist);
			httpServletrequest.setAttribute("emplist", emplist);
			
			for (Employee a : emplist) {
				System.out.println("++++"+a.getEmployee_name());
			}
			return "Traintickling";
			
		}
		
		
		
		
		private Notice notice;
		
		
		public Notice getNotice() {
			return notice;
		}

		public void setNotice(Notice notice) {
			this.notice = notice;
		}
		
		private List<Notice> noticelist;
		
		
		public List<Notice> getNoticelist() {
			return noticelist;
		}

		public void setNoticelist(List<Notice> noticelist) {
			this.noticelist = noticelist;
		}

		public String noticeList(){
			
			
			int first = 1;
			int max = 4;

			if (httpServletrequest.getParameter("pagenum") != null) {
				first = Integer
						.parseInt(httpServletrequest.getParameter("pagenum"));
			}
			noticelist = managerSv.noticeList((first - 1) * max, max);
			int total = managerSv.findNoticeSize().size();
			httpServletrequest.setAttribute("pagerinfo", Pager.getPagerNormal(
					total, max, first, "manager-noticeList.action", "共有" + total
							+ "条记录"));
			
			return "noticetList";
		}
		
		public String selectNotice(){
			String notice_id = httpServletrequest.getParameter("notice_id");
			
			this.notice = managerSv.selectNotice(notice_id).get(0);
			return "notice";			
		}

		private Synopsis synopsisn;
		
		public Synopsis getSynopsisn() {
			return synopsisn;
		}

		public void setSynopsisn(Synopsis synopsisn) {
			this.synopsisn = synopsisn;
		}

		public String synopsis(){
			
			synopsisn=managerSv.selectSynopsisn(1001).get(0);
			
			System.out.println(synopsisn.getFile_name());
			
			return "synopsis";
		}
		
		
		
		
		
		public String addcontent() throws IOException{
			
			
			File files = this.getFile();

			try {
				
					InputStream is = new FileInputStream(files);
					// 设置上传文件目录
					String uploadPath = ServletActionContext.getRequest()
							.getRealPath("/upload");
					File toFile = new File(uploadPath, fileFileName);
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
				
				
			notice.setPuttime(new Date());
			notice.setFile_name(fileFileName);
				managerSv.addNotice(notice);
			}catch(Exception e){
				notice.setPuttime(new Date());
				managerSv.addNotice(notice);
				
			}
			
			
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");
			response.setContentType("text/html; charset=gbk");
			PrintWriter outjs = response.getWriter();
			outjs.print("<script>window.location.href='manager-noticeList';</script>");
			return null;
			
		}
		private List<Notice> toupcontent;
		
		

		public List<Notice> getToupcontent() {
			return toupcontent;
		}

		public void setToupcontent(List<Notice> toupcontent) {
			this.toupcontent = toupcontent;
		}

		public String toupContent(){
			int first = 1;
			int max = 4;

			if (httpServletrequest.getParameter("pagenum") != null) {
				first = Integer
						.parseInt(httpServletrequest.getParameter("pagenum"));
			}
			toupcontent = managerSv.noticeList((first - 1) * max, max);
			int total = managerSv.findNoticeSize().size();
			httpServletrequest.setAttribute("pagerinfo", Pager.getPagerNormal(
					total, max, first, "manager-toupContent.action", "共有" + total
							+ "条记录"));
			
			return "toupContent";
			
					
		}
		public String upcontent(){
			
			return null;
		};
		
		private File file;
		
		private String file1ContentType;
		private String fileFileName;

		public File getFile() {
			return file;
		}

		public void setFile(File file) {
			this.file = file;
		}

		public String getFile1ContentType() {
			return file1ContentType;
		}

		public void setFile1ContentType(String file1ContentType) {
			this.file1ContentType = file1ContentType;
		}

		public String getFileFileName() {
			return fileFileName;
		}

		public void setFileFileName(String fileFileName) {
			this.fileFileName = fileFileName;
		}

		public String getDownloadFileName() {
			 fileName = httpServletrequest.getParameter("fileName");
			
			try {
				fileName = new String(fileName.getBytes("ISO-8859-1"),
						"UTF-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return fileName;
		}
		
		
		
		public String fileName;
		
		
		public String getFileName() {
			return fileName;
		}

		public void setFileName(String fileName) {
			this.fileName = fileName;
		}

		public InputStream getInputStream() throws Exception {
			
			
			ServletActionContext.getResponse().setHeader(
					"Content-Disposition",
					"attachment;fileName="
							+ java.net.URLEncoder.encode(fileName, "UTF-8"));

			
			System.out.println(fileName+"----**");
			this.fileName= new String(this.fileName.getBytes("ISO8859-1"),"UTF-8");
			String url = "/upload/" + fileName;
			System.out.println(fileName+"----**");
			InputStream in = ServletActionContext.getServletContext()
					.getResourceAsStream(url);
			return  in;

		}


		// 文件下载
		public String download() {
			return "success";
		}
		private List<Institution> institutionlist;
		
		
		public List<Institution> getInstitutionlist() {
			return institutionlist;
		}

		public void setInstitutionlist(List<Institution> institutionlist) {
			this.institutionlist = institutionlist;
		}
		
		private Institution institution;
		

		public Institution getInstitution() {
			return institution;
		}

		public void setInstitution(Institution institution) {
			this.institution = institution;
		}

		public String institutionList(){
			          
			
			int first = 1;
			int max = 8;

			
			institutionlist = managerSv.institutionList((first - 1) * max, max);
			int total = managerSv.findInstitutionSize().size();
			httpServletrequest.setAttribute("pagerinfo", Pager.getPagerNormal(
					total, max, first, "manager-institutionList.action", "共有" + total
							+ "条记录"));
			
			return "institutionList";
		}
		public String selectInstitution(){
			           
			
         String institution_id = httpServletrequest.getParameter("institution_id");
			
			this.institution = managerSv.selectInstitution(institution_id).get(0);
			System.out.println(institution.getInstitution_content());
			return "selectInstitution";
		}
		
		
		public String  addinstitution() throws IOException{
			
			File institution_files = this.getFile();

			try {
				
					InputStream is = new FileInputStream(institution_files);
					// 设置上传文件目录
					String uploadPath = ServletActionContext.getRequest()
							.getRealPath("/upload");
					File toFile = new File(uploadPath, fileFileName);
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
				
				
			
				institution.setFile_name(fileFileName);
				managerSv.addInstitution(institution);
			}catch(Exception e){
				
				managerSv.addInstitution(institution);
				
			}
			
			
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");
			response.setContentType("text/html; charset=gbk");
			PrintWriter outjs = response.getWriter();
			outjs.print("<script>window.location.href='manager-noticeList';</script>");
			
			return null;
		}
		
		private Resume resume ;
		private List<Resume> resumelist;
		

		public List<Resume> getResumelist() {
			return resumelist;
		}

		public void setResumelist(List<Resume> resumelist) {
			this.resumelist = resumelist;
		}

		public Resume getResume() {
			return resume;
		}

		public void setResume(Resume resume) {
			this.resume = resume;
		}
//简历列表
		public String resumeList() throws Exception{
			String rl="resumeList";
			selemplist(rl);
			return "resumeList";
		}
		
		private List<OutEmployee> oe;
		
		
		
		
		public List<OutEmployee> getOe() {
			return oe;
		}

		public void setOe(List<OutEmployee> oe) {
			this.oe = oe;
		}

		public String selectResume() throws IOException{
			String id = httpServletrequest.getParameter("resume_id");
			emp = managerSv.selectEmp(id).get(0);
			resumelist = managerSv.findResume(id);
			oe = managerSv.findAllTask(id);
			if(resumelist.size()==0){
				System.out.println("*************************");
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setCharacterEncoding("gbk");
				response.setContentType("text/html; charset=gbk");
				PrintWriter outjs = response.getWriter();
				outjs.print("<script>alert('该员工没有上传简历信息！');window.location.href='manager-resumeList';</script>");
				return null;
			}else{
			
			
			
			return "selectResume";		}	
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
		forumlist = managerSv.forumList((first - 1) * max, max);
		int total = managerSv.findForumSize().size();
		httpServletrequest.setAttribute("pagerinfo", Pager.getPagerNormal(
				total, max, first, "manager-forumList.action", "共有" + total
						+ "条记录"));
		
		
		return "forumList";
		
	}
	
	public String addForum(){
		
		forum.setForum_puttime(new Date());
		forum.setForum_peoname((String)session.get("user"));
		int id=(Integer) session.get("userid");
		forum.setForum_peopleid(id);
		managerSv.addForum(forum);
		
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
		replylist = managerSv.showReply(id);
		forum = managerSv.selectforumByid(id).get(0);
		
		int i = forum.getForum_clinknum();
		forum.setForum_clinknum(i+1);
		managerSv.updateclicknum(forum);
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
		managerSv.sendReply(reply);
		
		replylist = managerSv.showReply(id);
		forum = managerSv.selectforumByid(id).get(0);
		int size = replylist.size();
		Forum forums=new Forum();
		forums.setForum_id(id);
		forums.setForum_newtime(time);
		forums.setForum_name((String)session.get("user"));
		forums.setForum_replynum(size);
		managerSv.updateForum(forums);
		return "showReply";
	}
	
}
