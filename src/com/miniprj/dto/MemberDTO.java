package com.miniprj.dto;

import java.util.Date;

public class MemberDTO {

	private int memberno;
	private String id;
	private String pwd;
	private String name;
	private String email;
	private Date mdate;
	
	public MemberDTO(int memberno, String id, String pwd, String name, String email, Date mdate) {
		super();
		this.memberno = memberno;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.mdate = mdate;
	}

	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getMemberno() {
		return memberno;
	}

	public void setMemberno(int memberno) {
		this.memberno = memberno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getMdate() {
		return mdate;
	}

	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}

	@Override
	public String toString() {
		return "MemberDTO [memberno=" + memberno + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email
				+ ", mdate=" + mdate + "]";
	}
	
	
	
	
}
