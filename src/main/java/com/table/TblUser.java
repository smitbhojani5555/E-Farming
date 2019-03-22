package com.table;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.swing.text.Position.Bias;

@Entity
@Table(name = "tbl_user")
public class TblUser {
	

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private Long id;
	
	@Column(name="first_name")
	private String firstname;
	
	@Column(name="last_name")
	private String lastname;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="user_type_id")
	private int usertype;
	
	@Column(name="status")
	private String status;
	
	@Column(name="mobile_no")
	private String mobileno;
	
	@Column(name="agronomist_type")
	private String agronomisttype;
	
	public String getAgronomisttype() {
		return agronomisttype;
	}

	public void setAgronomisttype(String agronomisttype2) {
		this.agronomisttype = agronomisttype2;
	}

	@Column(name="password")
	private String password;
	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(name="data")
	private byte[] data;
	
	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(name="userdocument")
	private byte[] userdocument;
	
	public byte[] getUserdocument() {
		return userdocument;
	}

	public void setUserdocument(byte[] userdocument) {
		this.userdocument = userdocument;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] file) {
		this.data = file;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public int getUsertype() {
		return usertype;
	}

	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

}
