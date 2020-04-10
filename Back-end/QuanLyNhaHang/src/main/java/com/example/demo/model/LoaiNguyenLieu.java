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
@Table(name = "loainguyenlieu")
public class LoaiNguyenLieu implements Serializable {

	private static final long serialVersionUID = 1L;
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "LOAINGUYENLIEU_ID")
	 private long id;
	
	 @Column(name = "LOAINGUYENLIEU_NAME")
	 private String LOAINGUYENLIEU_NAME;
	
	 @Column(name = "LOAINGUYENLIEU_UNIT")
	 private String LOAINGUYENLIEU_UNIT;
	
	 protected LoaiNguyenLieu() {
		  
	 }
	
	 public LoaiNguyenLieu(String LoaiNguyenLieuName, String LoaiNguyenLieuDVT) {
		 this.LOAINGUYENLIEU_NAME = LoaiNguyenLieuName;
		 this.LOAINGUYENLIEU_UNIT = LoaiNguyenLieuDVT;
	 }
	 
	 public long getId() {
		return id;
	 }

	 public void setId(long id) {
		this.id = id;
	 }

	 public String getLOAINGUYENLIEU_NAME() {
		return LOAINGUYENLIEU_NAME;
	 }

	 public void setLOAINGUYENLIEU_NAME(String lOAINGUYENLIEU_NAME) {
		LOAINGUYENLIEU_NAME = lOAINGUYENLIEU_NAME;
	 }

	 public String getLOAINGUYENLIEU_UNIT() {
		return LOAINGUYENLIEU_UNIT;
	 }

	 public void setLOAINGUYENLIEU_UNIT(String lOAINGUYENLIEU_UNIT) {
		LOAINGUYENLIEU_UNIT = lOAINGUYENLIEU_UNIT;
	 }

}