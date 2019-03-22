package com.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_forgot_password")
public class TblForgotPassword {

	@Id
	@GeneratedValue
	@Column(name = "forgot_password_id")
      private int passwordid;
	
	@Column(name="user_type")
	 private int usertype;
	

	@Column(name="email")
	private String email;
	
	@Column(name="created_date")
	private String createddate;
	
	@Column(name="token")
	private String token;
	
	@Column(name="status")
	private int status;

	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getPasswordid() {
		return passwordid;
	}

	public void setPasswordid(int passwordid) {
		this.passwordid = passwordid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}	
	public int getUsertype() {
		return usertype;
	}

	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}
	
}
