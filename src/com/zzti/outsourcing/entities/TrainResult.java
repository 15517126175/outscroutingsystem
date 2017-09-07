package com.zzti.outsourcing.entities;

import java.util.Date;

public class TrainResult {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private int train_id;
	private String train_title;
	private String train_content;
	private Date train_time;
	private int train_proId;
	private int train_days;
	private String train_trainer;
	private String train_place;
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
	public int getTrain_proId() {
		return train_proId;
	}
	public void setTrain_proId(int train_proId) {
		this.train_proId = train_proId;
	}
	
}
