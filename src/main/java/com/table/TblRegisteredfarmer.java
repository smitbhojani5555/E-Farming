package com.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "tbl_registerdfarmer")
public class TblRegisteredfarmer {

	
	@Id
	@GeneratedValue
	@Column(name = "registeredfarmer_id")
	private Long registeredfarmerid;
	
	@Column(name="farmer_id")
	private Long farmerid;

	public Long getRegisteredfarmerid() {
		return registeredfarmerid;
	}

	public void setRegisteredfarmerid(Long registeredfarmerid) {
		this.registeredfarmerid = registeredfarmerid;
	}

	public Long getFarmerid() {
		return farmerid;
	}

	public void setFarmerid(Long userId) {
		this.farmerid = userId;
	}

}


