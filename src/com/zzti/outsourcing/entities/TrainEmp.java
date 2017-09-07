package com.zzti.outsourcing.entities;

public class TrainEmp {
	private int id;
	private int train_id;
	private int employee_id;
	private String feed_train;
	private String feed_trainer;
	public String getFeed_train() {
		return feed_train;
	}
	public void setFeed_train(String feed_train) {
		this.feed_train = feed_train;
	}
	public String getFeed_trainer() {
		return feed_trainer;
	}
	public void setFeed_trainer(String feed_trainer) {
		this.feed_trainer = feed_trainer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTrain_id() {
		return train_id;
	}
	public void setTrain_id(int train_id) {
		this.train_id = train_id;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

}
