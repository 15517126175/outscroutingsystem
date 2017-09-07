package com.zzti.outsourcing.entities;

import java.util.Date;

public class Reply {
	private int reply_id;
	private int forum_id;
	private int reply_empid;
	private String reply_empname;
	private String reply_content;
	private Date reply_time;
	public int getReply_id() {
		return reply_id;
	}
	public void setReply_id(int reply_id) {
		this.reply_id = reply_id;
	}
	public int getForum_id() {
		return forum_id;
	}
	public void setForum_id(int forum_id) {
		this.forum_id = forum_id;
	}
	public int getReply_empid() {
		return reply_empid;
	}
	public void setReply_empid(int reply_empid) {
		this.reply_empid = reply_empid;
	}
	public String getReply_empname() {
		return reply_empname;
	}
	public void setReply_empname(String reply_empname) {
		this.reply_empname = reply_empname;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public Date getReply_time() {
		return reply_time;
	}
	public void setReply_time(Date reply_time) {
		this.reply_time = reply_time;
	}
	
	
	
	

}
