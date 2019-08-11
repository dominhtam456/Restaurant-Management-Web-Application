package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "loaimonan")
public class LoaiMonAn implements Serializable {
	
	private static final long serialVersionUID = 1L;
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "LOAIMONAN_ID")
	 private long id;
	
	 @Column(name = "LOAIMONAN_NAME")
	 private String LOAIMONAN_NAME;
	
	 @Column(name = "LOAIMONAN_DES")
	 private String LOAIMONAN_DES;
	 
	 protected LoaiMonAn() {
		  
	 }
	 
	 public LoaiMonAn(String LoaiMonAnName, String LoaiMonAnDes) {
		 this.LOAIMONAN_NAME = LoaiMonAnName;
		 this.LOAIMONAN_DES = LoaiMonAnDes;
	 }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLOAIMONAN_NAME() {
		return LOAIMONAN_NAME;
	}

	public void setLOAIMONAN_NAME(String lOAIMONAN_NAME) {
		LOAIMONAN_NAME = lOAIMONAN_NAME;
	}

	public String getLOAIMONAN_DES() {
		return LOAIMONAN_DES;
	}

	public void setLOAIMONAN_DES(String lOAIMONAN_DES) {
		LOAIMONAN_DES = lOAIMONAN_DES;
	}

		 
}
