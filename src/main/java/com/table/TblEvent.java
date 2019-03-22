package com.table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_event")
public class TblEvent {
	
	@Id
	@GeneratedValue
	@Column(name = "event_id")
	private int eventid;
	
	@Column(name = "subject")
	private String subject;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "place")
	private String place;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "status")
	private int status;
	
	@Column(name = "time")
	private String time;
	
	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(name = "event_image")
	private byte[] eventimage;

	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getEventid() {
		return eventid;
	}

	public void setEventid(int eventid) {
		this.eventid = eventid;
	}

	public byte[] getEventimage() {
		return eventimage;
	}

	public void setEventimage(byte[] eventimage) {
		this.eventimage = eventimage;
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

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	
	
}
