package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chucvu")
public class ChucVu {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "CHUCVU_ID")
	 private long id;
	
	 @Column(name = "CHUCVU_NAME")
	 private String CHUCVU_NAME;
	 
	 @Column(name = "CHUCVU_DES")
	 private String CHUCVU_DES;
	
	 protected ChucVu() {
		  
	 }
	 
	 public ChucVu(String cHUCVU_NAME, String cHUCVU_DES) {
		 CHUCVU_NAME = cHUCVU_NAME;
		 CHUCVU_DES = cHUCVU_DES;
	 }
	 
	 public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCHUCVU_NAME() {
		return CHUCVU_NAME;
	}

	public void setCHUCVU_NAME(String cHUCVU_NAME) {
		CHUCVU_NAME = cHUCVU_NAME;
	}

	public String getCHUCVU_DES() {
		return CHUCVU_DES;
	}

	public void setCHUCVU_DES(String cHUCVU_DES) {
		CHUCVU_DES = cHUCVU_DES;
	}
 
}
