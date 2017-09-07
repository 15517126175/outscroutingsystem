package com.zzti.outsourcing.entities;

import java.util.Date;

public class OutProject {
	private int project_id;
	private String project_name;
	private String proiect_type;
	private String boss_name;
	private String city;
	private Date enter_time;
	private Date star_time;
	private Date end_time;
	private int woker_time;
	
	private String boss_contract;
	private String employee_contract;
	private int project_flage;//0：未分配，1：已分配2：已完成
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getWoker_time() {
		return woker_time;
	}
	public void setWoker_time(int woker_time) {
		this.woker_time = woker_time;
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
	public String getProiect_type() {
		return proiect_type;
	}
	public void setProiect_type(String proiect_type) {
		this.proiect_type = proiect_type;
	}
	public String getBoss_name() {
		return boss_name;
	}
	public void setBoss_name(String boss_name) {
		this.boss_name = boss_name;
	}
	public Date getEnter_time() {
		return enter_time;
	}
	public void setEnter_time(Date enter_time) {
		this.enter_time = enter_time;
	}
	
	public String getBoss_contract() {
		return boss_contract;
	}
	public void setBoss_contract(String boss_contract) {
		this.boss_contract = boss_contract;
	}
	public String getEmployee_contract() {
		return employee_contract;
	}
	public void setEmployee_contract(String employee_contract) {
		this.employee_contract = employee_contract;
	}
	public int getProject_flage() {
		return project_flage;
	}
	public void setProject_flage(int project_flage) {
		this.project_flage = project_flage;
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
	
	
	
	
	
}
