package com.example.demo.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.HoaDon;
import com.example.demo.model.HoaDonChiTiet;
import com.example.demo.model.HoaDonChiTietID;

public interface HoaDonChiTietService extends JpaRepository<HoaDonChiTiet, HoaDonChiTietID> {

	// GET DANH SACH Hoa Don Chi Tiet
	public default List<HoaDonChiTiet> GetAllHoaDonChiTiets() {
		return this.findAll();
	}

	// GET 1 Hoa Don CT
	public default HoaDonChiTiet GetHoaDonChiTiet(HoaDonChiTietID id) {
		return this.getOne(id);

	}

	
	// Them chi tiet hoa don
	public default boolean InSertHDCT(HoaDonChiTiet o) {
		/*
		 * o.setHOADON_HOADON_ID(10); o.setMONAN_MONAN_ID(1);
		 * o.setHOADONCHITIET_PRICE("100000"); o.setHOADONCHITIET_SOLUONG(3);
		 */
		if (o != null) {
			this.save(o);
			return true;
		} else {
			return false;
		}

	}
   /*
	public default HoaDonChiTiet getOnes(long hoadon_HOADON_ID, long monan_MONAN_ID) {
		for (HoaDonChiTiet o : this.findAll()) {
			if (o.getHOADON_HOADON_ID() == hoadon_HOADON_ID && o.getMONAN_MONAN_ID() == monan_MONAN_ID) {
				return o;
			}
		}
		return null;
	}
	*/
	// Update Hoa Don Chi Tiet
	public default boolean UpdateHoaDonChiTiet(HoaDonChiTiet o) {
		 HoaDonChiTiet temp = this.getOne(o.getHoadonchitietID());
		 if (temp!=null)
		 { 
			 temp.setHOADONCHITIET_PRICE(o.getHOADONCHITIET_PRICE());
			 temp.setHOADONCHITIET_SOLUONG(o.getHOADONCHITIET_SOLUONG());
			 this.save(temp); 
			 return true; 
	     }
		 else { 
			 return false; 
		 }
		 
	}
/*

	// Delete CTHD
	public default boolean DeLeTeCTHD(HoaDonChiTiet o) {
		if (o != null) {
			HoaDonChiTiet temp = this.getOnes(o.getHOADON_HOADON_ID(), o.getMONAN_MONAN_ID());
			this.delete(temp);
			return true;
		} else {
			return false;
		}

	}
	*/
}
