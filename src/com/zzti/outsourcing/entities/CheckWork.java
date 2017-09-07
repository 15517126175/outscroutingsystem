package com.zzti.outsourcing.entities;

public class CheckWork {
	private int employee_id;
	private String employee_name;
	private String project_name;
	private int woker_time;
	private int normal_time;
	private int holiday_time;
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
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public int getWoker_time() {
		return woker_time;
	}
	public void setWoker_time(int woker_time) {
		this.woker_time = woker_time;
	}
	public int getNormal_time() {
		return normal_time;
	}
	public void setNormal_time(int normal_time) {
		this.normal_time = normal_time;
	}
	public int getHoliday_time() {
		return holiday_time;
	}
	public void setHoliday_time(int holiday_time) {
		this.holiday_time = holiday_time;
	}
	
}
