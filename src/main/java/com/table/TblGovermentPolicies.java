package com.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_goverment_policies")
public class TblGovermentPolicies {

	@Id
	@GeneratedValue
	@Column(name = "policy_id")
	private int policyid;
	
	@Column(name="description")
	private String description;
	
	@Column(name="created_date")
	private String createddate;
	
	@Column(name="created_by")
	private String createdby;
	
	@Column(name="status")
	private int status;
	
	@Column(name="title")
	private String title;
	@Column(name="critearea")
	private String critearea;


	public String getCritearea() {
		return critearea;
	}

	public void setCritearea(String critearea) {
		this.critearea = critearea;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPolicyid() {
		return policyid;
	}

	public void setPolicyid(int policyid) {
		this.policyid = policyid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status2) {
		this.status = status2;
	}
}
