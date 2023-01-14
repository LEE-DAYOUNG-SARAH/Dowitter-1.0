package kr.ac.green.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Doc {
	//field
	private int d_num;
	private String d_content;
	private String u_id;
	private String d_date;
	
	//constructor
	public Doc() {}
	// insert
	public Doc(String d_content, String u_id) {
		super();
		this.d_content = d_content;
		this.u_id = u_id;
		this.d_date = getDate();
	}
	// select
	public Doc(int d_num, String d_content, String u_id, String d_date) {
		super();
		this.d_num = d_num;
		this.d_content = d_content;
		this.u_id = u_id;
		this.d_date = d_date;
	}
	//getDate
	private String getDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd-kk:mm");
		return sdf.format(new Date());
	}
	
	//getter & setter 
	public int getD_num() {
		return d_num;
	}
	public void setD_num(int d_num) {
		this.d_num = d_num;
	}
	public String getD_content() {
		return d_content;
	}
	public void setD_content(String d_content) {
		this.d_content = d_content;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getD_date() {
		return d_date;
	}
	public void setD_date(String d_date) {
		this.d_date = d_date;
	}
	
}
