package com.table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_problems")

public class TblProblems {


	
	@Id
	@GeneratedValue
	@Column(name = "problem_id")
	private Long problemid;
	
	@Column(name = "farmer_id")
	private Long farmerid;
	
	@Column(name = "subject")
	private String subject;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "status")
	private int status;
	
	@Column(name = "created_date")
	private String createddate;

	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	public Long getProblemid() {
		return problemid;
	}

	public void setProblemid(Long problemid) {
		this.problemid = problemid;
	}

	public Long getFarmerid() {
		return farmerid;
	}

	public void setFarmerid(Long farmerid) {
		this.farmerid = farmerid;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
