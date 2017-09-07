package com.zzti.outsourcing.entities;

import java.util.Date;

public class Synopsis {
	
	private int synopsis_id;
	private String synopsis_title;
	private String synopsis_content;
	private Date puttime;
    private String file_name;
	public int getSynopsis_id() {
		return synopsis_id;
	}
	public void setSynopsis_id(int synopsis_id) {
		this.synopsis_id = synopsis_id;
	}
	public String getSynopsis_title() {
		return synopsis_title;
	}
	public void setSynopsis_title(String synopsis_title) {
		this.synopsis_title = synopsis_title;
	}
	public String getSynopsis_content() {
		return synopsis_content;
	}
	public void setSynopsis_content(String synopsis_content) {
		this.synopsis_content = synopsis_content;
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
