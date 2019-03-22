package com.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_user_type")
public class TblUserType {
	
	@Id
	@GeneratedValue
	@Column(name = "user_type_id")
	private Long usertypeId;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "created_date")
	private String createddate;

	public Long getUsertypeId() {
		return usertypeId;
	}

	public void setUsertypeId(Long usertypeId) {
		this.usertypeId = usertypeId;
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
	
}
