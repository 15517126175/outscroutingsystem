package com.zzti.outsourcing.entities;

import java.util.Date;

public class Train {
	private int train_id;
	private String train_title;
	private String train_content;
	private Date train_time;
	private Date end_time;
	private int train_days;
	private String train_trainer;
	private String train_place;
	private Date train_puttime;
	private int status;//1:可以报名2:未开通
	
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	public int getTrain_id() {
		return train_id;
	}
	public void setTrain_id(int train_id) {
		this.train_id = train_id;
	}
	public String getTrain_title() {
		return train_title;
	}
	public void setTrain_title(String train_title) {
		this.train_title = train_title;
	}
	public String getTrain_content() {
		return train_content;
	}
	public void setTrain_content(String train_content) {
		this.train_content = train_content;
	}
	public Date getTrain_time() {
		return train_time;
	}
	public void setTrain_time(Date train_time) {
		this.train_time = train_time;
	}
	public int getTrain_days() {
		return train_days;
	}
	public void setTrain_days(int train_days) {
		this.train_days = train_days;
	}
	public String getTrain_trainer() {
		return train_trainer;
	}
	public void setTrain_trainer(String train_trainer) {
		this.train_trainer = train_trainer;
	}
	public String getTrain_place() {
		return train_place;
	}
	public void setTrain_place(String train_place) {
		this.train_place = train_place;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getTrain_puttime() {
		return train_puttime;
	}
	public void setTrain_puttime(Date train_puttime) {
		this.train_puttime = train_puttime;
	}
	
	
	

}
