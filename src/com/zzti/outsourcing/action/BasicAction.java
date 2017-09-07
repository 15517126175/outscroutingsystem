package com.zzti.outsourcing.action;

import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

public class BasicAction implements SessionAware,RequestAware,ServletRequestAware{
	protected Map<String,Object> session;
	protected Map<String,Object> request;
	protected HttpServletRequest httpServletrequest;
	protected HttpServletResponse httpServletResponse;
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

	public void setRequest(Map<String, Object> request) {
		this.request=request;
	}

	public void setServletRequest(HttpServletRequest httpServletRequest) {
		this.httpServletrequest=httpServletRequest;
	}
	public void setServletRequest(HttpServletResponse httpServletResponse) {
		this.httpServletResponse=httpServletResponse;
	}
	
}
