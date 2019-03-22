package com.table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_agronomist_type")
public class TblAgronomistType {
	
	@Id
	@GeneratedValue
	@Column(name = "tbl_agronomist_type_id")
	private Long tbl_agronomist_type_id;
	
	
	@Column(name = "agronomist_type")
	private String agronomist_type;
	
	@Column(name = "status")
	private int status;
	
	@Column(name = "created_date")
	private String createddate;

	public Long getTbl_agronomist_type_id() {
		return tbl_agronomist_type_id;
	}

	public void setTbl_agronomist_type_id(Long tbl_agronomist_type_id) {
		this.tbl_agronomist_type_id = tbl_agronomist_type_id;
	}

	public String getAgronomist_type() {
		return agronomist_type;
	}

	public void setAgronomist_type(String agronomist_type) {
		this.agronomist_type = agronomist_type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

}
