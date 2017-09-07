package com.zzti.outsourcing.entities;

import java.util.Date;

public class Notice {
	
	private int notice_id;
	private String title;
    private String content;
    private Date puttime;
    private String file_name;
    
	public int getNotice_id() {
		return notice_id;
	}
	public void setNotice_id(int notice_id) {
		this.notice_id = notice_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPuttime() {
		return puttime;
	}
	public void setPuttime(Date puttime) {
		this.puttime = puttime;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	
    
}
