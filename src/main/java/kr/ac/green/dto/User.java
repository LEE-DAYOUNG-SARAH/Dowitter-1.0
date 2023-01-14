package kr.ac.green.dto;

public class User {
	//field
	private String u_id;
	private String u_pw;
	
	//constructor
	public User() {}
	public User(String u_id, String u_pw) {
		super();
		this.u_id = u_id;
		this.u_pw = u_pw;
	}
	
	//getter & setter
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getU_pw() {
		return u_pw;
	}
	public void setU_pw(String u_pw) {
		this.u_pw = u_pw;
	}
}
