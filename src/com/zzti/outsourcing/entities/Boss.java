package com.zzti.outsourcing.entities;

public class Boss {
	private int boss_id;
	private String boss_name;
	private String linkman;
	private String phone_number;
	public int getBoss_id() {
		return boss_id;
	}
	public void setBoss_id(int boss_id) {
		this.boss_id = boss_id;
	}
	public String getBoss_name() {
		return boss_name;
	}
	public void setBoss_name(String boss_name) {
		this.boss_name = boss_name;
	}
	public String getLinkman() {
		return linkman;
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
}
