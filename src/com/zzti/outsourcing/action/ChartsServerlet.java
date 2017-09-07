package com.zzti.outsourcing.action;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


import com.zzti.outsourcing.entities.Charts;
import com.zzti.outsourcing.entities.OutProject;
import com.zzti.outsourcing.service.OutManagerSV;

public class ChartsServerlet extends HttpServlet {
	private OutManagerSV sv;
	

	public OutManagerSV getSv() {
		return sv;
	}

	public void setSv(OutManagerSV sv) {
		this.sv = sv;
	}

	/**
	 * Constructor of the object.
	 */
	public ChartsServerlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
	}
	
	public void init() throws ServletException {
		// Put your code here
	}

}
