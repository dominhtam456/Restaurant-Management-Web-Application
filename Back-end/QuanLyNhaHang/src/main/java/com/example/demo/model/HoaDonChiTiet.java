package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "hoadonchitiet")

public class HoaDonChiTiet implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@Id
    private HoaDonChiTietID hoadonchitietID;

	@Column(name = "HOADONCHITIET_PRICE")
	private String HOADONCHITIET_PRICE;

	@Column(name = "HOADONCHITIET_SOLUONG")
	private Integer HOADONCHITIET_SOLUONG;
    
	@Transient
	private String thanhTien;
	
	@Transient
	private String tenMonAn;
	
	//HAM TAO
	public HoaDonChiTiet(HoaDonChiTietID hoadonchitietID, String hOADONCHITIET_PRICE,
			int hOADONCHITIET_SOLUONG) {
		super();
		this.hoadonchitietID=hoadonchitietID;
		HOADONCHITIET_PRICE = hOADONCHITIET_PRICE;
		HOADONCHITIET_SOLUONG = hOADONCHITIET_SOLUONG;
	}

	public HoaDonChiTiet() {
		super();
		// TODO Auto-generated constructor stub
	}

	
    //HAM GET SET
	public String getHOADONCHITIET_PRICE() {
		return HOADONCHITIET_PRICE;
	}

	public void setHOADONCHITIET_PRICE(String hOADONCHITIET_PRICE) {
		HOADONCHITIET_PRICE = hOADONCHITIET_PRICE;
	}

	public Integer getHOADONCHITIET_SOLUONG() {
		return HOADONCHITIET_SOLUONG;
	}

	public void setHOADONCHITIET_SOLUONG(Integer hOADONCHITIET_SOLUONG) {
		HOADONCHITIET_SOLUONG = hOADONCHITIET_SOLUONG;
	}

	public HoaDonChiTietID getHoadonchitietID() {
		return hoadonchitietID;
	}

	public void setHoadonchitietID(HoaDonChiTietID hoadonchitietID) {
		this.hoadonchitietID = hoadonchitietID;
	}


	//GET TIEN*SOLUONG
	public String getThanhTien() {
		return String.valueOf(Integer.valueOf(this.HOADONCHITIET_PRICE)*this.HOADONCHITIET_SOLUONG);
	}

	public String getTenMonAn() {
		return tenMonAn;
	}

	public void setTenMonAn(String tenMonAn) {
		this.tenMonAn = tenMonAn;
	}


	
}
