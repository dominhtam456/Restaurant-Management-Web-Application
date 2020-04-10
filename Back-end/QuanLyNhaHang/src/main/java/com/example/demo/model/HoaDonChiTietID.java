package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class HoaDonChiTietID implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "HOADON_HOADON_ID")
	private Integer HOADON_HOADON_ID;
	
	@Column(name = "MONAN_MONAN_ID")
	private Integer MONAN_MONAN_ID;
	
	public HoaDonChiTietID() {
       super();
	}

	public HoaDonChiTietID(Integer hOADON_HOADON_ID, Integer mONAN_MONAN_ID) {
		super();
		HOADON_HOADON_ID = hOADON_HOADON_ID;
		MONAN_MONAN_ID = mONAN_MONAN_ID;
	}

	public Integer getHOADON_HOADON_ID() {
		return HOADON_HOADON_ID;
	}

	public void setHOADON_HOADON_ID(Integer hOADON_HOADON_ID) {
		HOADON_HOADON_ID = hOADON_HOADON_ID;
	}

	public Integer getMONAN_MONAN_ID() {
		return MONAN_MONAN_ID;
	}

	public void setMONAN_MONAN_ID(Integer mONAN_MONAN_ID) {
		MONAN_MONAN_ID = mONAN_MONAN_ID;
	}
	
	
	
 
}
