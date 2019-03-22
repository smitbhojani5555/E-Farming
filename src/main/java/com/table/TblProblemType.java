package com.table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_problem")
public class TblProblemType {
	
	@Id
	@GeneratedValue
	@Column(name = "problem_type_id")
	private Long problemtypeid;
	
	@Column(name = "problem_type")
	private String problemtype;
	
	@Column(name = "status")
	private int status;
	
	@Column(name = "created_date")
	private Long created_date;

	public Long getProblemtypeid() {
		return problemtypeid;
	}

	public void setProblemtypeid(Long problemtypeid) {
		this.problemtypeid = problemtypeid;
	}

	public String getProblemtype() {
		return problemtype;
	}

	public void setProblemtype(String problemtype) {
		this.problemtype = problemtype;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Long getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Long created_date) {
		this.created_date = created_date;
	}
	
}

