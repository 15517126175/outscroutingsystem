package com.zzti.outsourcing.entities;

import java.util.Date;

public class Employee {
	private int employee_id;
	private String employee_name;
	private String employee_sex;
	private int employee_age;
	private String employee_address;
	private String employee_pwd;
	private long employee_phone;
	private String employee_email;
	private double basicSalary;
	private Date enter_time;
	private String work_status; //u是有外派任务，e是无任务;
	private int employee_isin;//1：在职，2离职
	private String employee_skill;
	private String education;
	private String school;
	public String getEmployee_skill() {
		return employee_skill;
	}
	public void setEmployee_skill(String employee_skill) {
		this.employee_skill = employee_skill;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public int getEmployee_isin() {
		return employee_isin;
	}
	public void setEmployee_isin(int employee_isin) {
		this.employee_isin = employee_isin;
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
	public String getEmployee_sex() {
		return employee_sex;
	}
	public void setEmployee_sex(String employee_sex) {
		this.employee_sex = employee_sex;
	}
	public int getEmployee_age() {
		return employee_age;
	}
	public void setEmployee_age(int employee_age) {
		this.employee_age = employee_age;
	}
	public String getEmployee_pwd() {
		return employee_pwd;
	}
	public void setEmployee_pwd(String employee_pwd) {
		this.employee_pwd = employee_pwd;
	}
	public long getEmployee_phone() {
		return employee_phone;
	}
	public void setEmployee_phone(long employee_phone) {
		this.employee_phone = employee_phone;
	}
	public String getEmployee_email() {
		return employee_email;
	}
	public void setEmployee_email(String employee_email) {
		this.employee_email = employee_email;
	}
	public double getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}
	public Date getEnter_time() {
		return enter_time;
	}
	public void setEnter_time(Date enter_time) {
		this.enter_time = enter_time;
	}
	public String getWork_status() {
		return work_status;
	}
	public void setWork_status(String work_status) {
		this.work_status = work_status;
	}
	public String getEmployee_address() {
		return employee_address;
	}
	public void setEmployee_address(String employee_address) {
		this.employee_address = employee_address;
	}
	
	
}
