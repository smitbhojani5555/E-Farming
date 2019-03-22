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
@Table(name = "tbl_product")
public class TblProduct {

	
	@Id
	@GeneratedValue
	@Column(name = "product_id")
	private Long productid;
	
	@Column(name = "description")
	private String description;
	
	
	@Column(name = "price")
	private Long price;
	
	
	
	@Column(name = "status")
	private int status;
	
	@Column(name = "product_content")
	private String productcontent;
	
	@Column(name = "createdby")
	private Long createdby;
	



	public Long getCreatedby() {
		return createdby;
	}

	public void setCreatedby(Long createdby) {
		this.createdby = createdby;
	}

	public String getProductcontent() {
		return productcontent;
	}

	public void setProductcontent(String productcontent) {
		this.productcontent = productcontent;
	}

	@Column(name = "product_name")
	private String productname;

	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(name = "product_image")
	private byte[] productimage;
	
	public Long getProductid() {
		return productid;
	}

	public void setProductid(Long productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public byte[] getProductimage() {
		return productimage;
	}

	public void setProductimage(byte[] productimage) {
		this.productimage = productimage;
	}
	
	

}
