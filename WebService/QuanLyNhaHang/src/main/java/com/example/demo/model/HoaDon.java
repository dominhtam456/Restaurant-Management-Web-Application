package com.example.demo.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "hoadon")
public class HoaDon implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "HOADON_ID")
	private long HOADON_ID;

	@Column(name = "HOADON_NO")
	private String HOADON_NO;

	@Column(name = "HOADON_DATE")
	private Date HOADON_DATE;

	@Column(name = "HOADON_STATUS")
	private String HOADON_STATUS;

	@Column(name = "HOADON_TAX")
	private String HOADON_TAX;

	@Column(name = "KHACHHANG_KHACHHANG_ID")
	private int KHACHHANG_KHACHHANG_ID;

	@Column(name = "BAN_BAN_ID")
	private int BAN_BAN_ID;

	@Column(name = "NHANVIEN_NHANVIEN_ID")
	private int NHANVIEN_NHANVIEN_ID;
	/*
	 * @Transient private String TENLOAI_MONAN;
	 */

	// KHOI TAO
	public HoaDon() {
		//super();
		// TODO Auto-generated constructor stub
	}

	public HoaDon(String hOADON_NO, Date hOADON_DATE, String hOADON_STATUS, String hOADON_TAX,
			int kHACHHANG_KHACHHANG_ID, int bAN_BAN_ID, int nHANVIEN_ID) {
		//super();
		HOADON_NO = hOADON_NO;
		HOADON_DATE = hOADON_DATE;
		HOADON_STATUS = hOADON_STATUS;
		HOADON_TAX = hOADON_TAX;
		KHACHHANG_KHACHHANG_ID = kHACHHANG_KHACHHANG_ID;
		BAN_BAN_ID = bAN_BAN_ID;
		NHANVIEN_NHANVIEN_ID = nHANVIEN_ID;
		
	}
	// GETTER

	public long getHOADON_ID() {
		return HOADON_ID;
	}

	public void setHOADON_ID(long hOADON_ID) {
		HOADON_ID = hOADON_ID;
	}

	public String getHOADON_NO() {
		return HOADON_NO;
	}

	public void setHOADON_NO(String hOADON_NO) {
		HOADON_NO = hOADON_NO;
	}

	public Date getHOADON_DATE() {
		return HOADON_DATE;
	}

	public void setHOADON_DATE(Date hOADON_DATE) {
		HOADON_DATE = hOADON_DATE;
	}

	public String getHOADON_STATUS() {
		return HOADON_STATUS;
	}

	public void setHOADON_STATUS(String hOADON_STATUS) {
		HOADON_STATUS = hOADON_STATUS;
	}

	public String getHOADON_TAX() {
		return HOADON_TAX;
	}

	public void setHOADON_TAX(String hOADON_TAX) {
		HOADON_TAX = hOADON_TAX;
	}

	public int getKHACHHANG_KHACHHANG_ID() {
		return KHACHHANG_KHACHHANG_ID;
	}

	public void setKHACHHANG_KHACHHANG_ID(int kHACHHANG_KHACHHANG_ID) {
		KHACHHANG_KHACHHANG_ID = kHACHHANG_KHACHHANG_ID;
	}

	public int getBAN_BAN_ID() {
		return BAN_BAN_ID;
	}

	public void setBAN_BAN_ID(int bAN_BAN_ID) {
		BAN_BAN_ID = bAN_BAN_ID;
	}

	public int getNHANVIEN_NHANVIEN_ID() {
		return NHANVIEN_NHANVIEN_ID;
	}

	public void setNHANVIEN_NHANVIEN_ID(int nHANVIEN_NHANVIEN_ID) {
		NHANVIEN_NHANVIEN_ID = nHANVIEN_NHANVIEN_ID;
	}

	

	// SETTER
}
