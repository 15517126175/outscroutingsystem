package com.zzti.outsourcing.entities;

import java.util.Date;

public class Forum{
 private int forum_id;
 private String forum_title;
 private String forum_content;
 private int forum_peopleid;
 private String forum_peoname;
 private Date forum_puttime;
 private int forum_clinknum;
 private int forum_replynum;
 private String forum_name;
 private Date forum_newtime;
public int getForum_id() {
	return forum_id;
}
public void setForum_id(int forum_id) {
	this.forum_id = forum_id;
}
public String getForum_title() {
	return forum_title;
}
public void setForum_title(String forum_title) {
	this.forum_title = forum_title;
}
public String getForum_content() {
	return forum_content;
}
public void setForum_content(String forum_content) {
	this.forum_content = forum_content;
}

public int getForum_peopleid() {
	return forum_peopleid;
}
public void setForum_peopleid(int forum_peopleid) {
	this.forum_peopleid = forum_peopleid;
}
public String getForum_peoname() {
	return forum_peoname;
}
public void setForum_peoname(String forum_peoname) {
	this.forum_peoname = forum_peoname;
}
public Date getForum_puttime() {
	return forum_puttime;
}
public void setForum_puttime(Date forum_puttime) {
	this.forum_puttime = forum_puttime;
}
public int getForum_clinknum() {
	return forum_clinknum;
}
public void setForum_clinknum(int forum_clinknum) {
	this.forum_clinknum = forum_clinknum;
}
public int getForum_replynum() {
	return forum_replynum;
}
public void setForum_replynum(int forum_replynum) {
	this.forum_replynum = forum_replynum;
}
public String getForum_name() {
	return forum_name;
}
public void setForum_name(String forum_name) {
	this.forum_name = forum_name;
}
public Date getForum_newtime() {
	return forum_newtime;
}
public void setForum_newtime(Date forum_newtime) {
	this.forum_newtime = forum_newtime;
}


}
