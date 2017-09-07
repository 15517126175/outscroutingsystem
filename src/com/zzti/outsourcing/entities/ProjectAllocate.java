package com.zzti.outsourcing.entities;

import java.util.Date;
public class ProjectAllocate {
	private int id;
	private int project_id;
	private String project_name;
	private Date star_time;
	private Date end_time;
	private Date interview_time;
	private String interview_site;
	private int employee_id;
	private String employee_name;
	private int end; //0：正在面试1：成功2：失败3外派中
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	
	public Date getStar_time() {
		return star_time;
	}
	public void setStar_time(Date star_time) {
		this.star_time = star_time;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	public Date getInterview_time() {
		return interview_time;
	}
	public void setInterview_time(Date interview_time) {
		this.interview_time = interview_time;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public String getInterview_site() {
		return interview_site;
	}
	public void setInterview_site(String interview_site) {
		this.interview_site = interview_site;
	}
	
	
	
	
}
