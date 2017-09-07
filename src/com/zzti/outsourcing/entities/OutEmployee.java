package com.zzti.outsourcing.entities;

import java.util.Date;

public class OutEmployee {
	private int id;
	private int employee_id;
	private String employee_name;
	private long employee_phone;
	private String boss_name;
	private String project_name;
	private String city;
	private int salary;
	private Date enter_time;
	private int woker_time;
	private int worker_status;//1：正常2：离职 3:休假
	private String project_type;
	private String work_type;
	private Date star_time;
	private Date end_time;
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
	public String getProject_type() {
		return project_type;
	}
	public void setProject_type(String project_type) {
		this.project_type = project_type;
	}
	public String getWork_type() {
		return work_type;
	}
	public void setWork_type(String work_type) {
		this.work_type = work_type;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public long getEmployee_phone() {
		return employee_phone;
	}
	public void setEmployee_phone(long employee_phone) {
		this.employee_phone = employee_phone;
	}
	public String getBoss_name() {
		return boss_name;
	}
	public void setBoss_name(String boss_name) {
		this.boss_name = boss_name;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Date getEnter_time() {
		return enter_time;
	}
	public void setEnter_time(Date enter_time) {
		this.enter_time = enter_time;
	}
	
	public int getWoker_time() {
		return woker_time;
	}
	public void setWoker_time(int woker_time) {
		this.woker_time = woker_time;
	}
	public int getWorker_status() {
		return worker_status;
	}
	
	public void setWorker_status(int worker_status) {
		this.worker_status = worker_status;
	}
	
	
}
