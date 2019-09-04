package com.example.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Null;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "MonAn")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "monan")
public class MonAn implements Serializable{
	     
		 private static final long serialVersionUID = 1L;
		 @Id
		 @GeneratedValue(strategy = GenerationType.IDENTITY)
		
		 @Column(name = "MONAN_ID")
		 private long MONAN_ID;
		 
		 @Column(name="MONAN_NO")
		 private String MONAN_NO;
		 
		 @Column(name = "MONAN_NAME")
		 private String MONAN_NAME;
	
		 @Column(name = "MONAN_PRICE")
		 private String MONAN_PRICE;
		 
		 @Column(name = "MONAN_UNIT")
		 private String MONAN_UNIT;
		 
		 @Column(name = "MONAN_STATUS")
		 private String MONAN_STATUS;
		 
		 @Column(name="MONAN_IMG")
		 private String MONAN_IMG;
		 
		 @Column(name = "LOAIMONAN_LOAIMONAN_ID")
		 private int LOAIMONAN_LOAIMONAN_ID;
		 
		 @OneToMany(
			        mappedBy = "monan",
			        cascade = CascadeType.ALL,
			        orphanRemoval = true
			    )
		 
		 private List<MonAnChiTiet> nguyenlieus = new ArrayList<>();
		 
		 @Transient
		 private String TENLOAI_MONAN;
		  
		 
		// Constructor
		 public MonAn() {
		 	 super();
		 }
		 
		 public MonAn(String mONAN_NAME, String mONAN_PRICE, String mONAN_UNIT,
				 String mONAN_STATUS ,@Null int lOAIMONAN_LOAIMONAN_ID) {
			super( );
		 	MONAN_NAME = mONAN_NAME;
		 	MONAN_PRICE = mONAN_PRICE;
		 	MONAN_UNIT = mONAN_UNIT;
		 	MONAN_STATUS = mONAN_STATUS;
		 	LOAIMONAN_LOAIMONAN_ID = lOAIMONAN_LOAIMONAN_ID;
		 	
		 }
		 
		//GETTER AND SETTER 
		 public String getTENLOAI_LOAIMONAN() {
		 	return TENLOAI_MONAN;
		 }
	
		 public void setTENLOAI_LOAIMONAN(String tENLOAI_MONAN) {
		 	TENLOAI_MONAN = tENLOAI_MONAN;
		 }
		
		public long getMONAN_ID() {
			return MONAN_ID;
		}
	
		public void setMONAN_ID(long mONAN_ID) {
			MONAN_ID = mONAN_ID;
		}
	
		public String getMONAN_NO() {
			return MONAN_NO;
		}
	
		public void setMONAN_NO(String mONAN_NO) {
			MONAN_NO = mONAN_NO;
		}
	
		public String getMONAN_NAME() {
			return MONAN_NAME;
		}
	
		public void setMONAN_NAME(String mONAN_NAME) {
			MONAN_NAME = mONAN_NAME;
		}
	
		public String getMONAN_PRICE() {
			return MONAN_PRICE;
		}
	
		public void setMONAN_PRICE(String mONAN_PRICE) {
			MONAN_PRICE = mONAN_PRICE;
		}
	
		public String getMONAN_UNIT() {
			return MONAN_UNIT;
		}
	
		public void setMONAN_UNIT(String mONAN_UNIT) {
			MONAN_UNIT = mONAN_UNIT;
		}
	
		public String getMONAN_STATUS() {
			return MONAN_STATUS;
		}
	
		public void setMONAN_STATUS(String mONAN_STATUS) {
			MONAN_STATUS = mONAN_STATUS;
		}
	
		public String getMONAN_IMG() {
			return MONAN_IMG;
		}
	
		public void setMONAN_IMG(String mONAN_IMG) {
			MONAN_IMG = mONAN_IMG;
		}
	
		public int getLOAIMONAN_LOAIMONAN_ID() {
			return LOAIMONAN_LOAIMONAN_ID;
		}
	
		public void setLOAIMONAN_LOAIMONAN_ID(int lOAIMONAN_LOAIMONAN_ID) {
			LOAIMONAN_LOAIMONAN_ID = lOAIMONAN_LOAIMONAN_ID;
		}
		
		
		 @Override
		    public boolean equals(Object o) {
		        if (this == o) return true;
		 
		        if (o == null || getClass() != o.getClass())
		            return false;
		 
		        MonAn monan = (MonAn) o;
		        return Objects.equals(MONAN_NAME, monan.MONAN_NAME);
		    }
		 
		    @Override
		    public int hashCode() {
		        return Objects.hash(MONAN_NAME);
		    }
}
