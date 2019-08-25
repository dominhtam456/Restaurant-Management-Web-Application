package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;

import com.example.demo.model.Ban;
import com.example.demo.model.HoaDonChiTiet;
import com.example.demo.model.HoaDonChiTietID;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

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
	public default HoaDonChiTiet InSertHDCT(HoaDonChiTiet o) {
		/*
		 * o.setHOADON_HOADON_ID(10); o.setMONAN_MONAN_ID(1);
		 * o.setHOADONCHITIET_PRICE("100000"); o.setHOADONCHITIET_SOLUONG(3);
		 */
		if (o != null) {
			return save(o);
			
		} else {
			return null;
		}

	}
  
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


	// Delete CTHD
	public default boolean DeLeTeCTHD(HoaDonChiTietID hdctID) {
		if (hdctID != null) {
			this.deleteById(hdctID);
			return true;
		} else {
			return false;
		}

	}
	
	
	//GET CHI TIET HOA DON THEO ID_HOADON
	
		public default List<HoaDonChiTiet> GetHoaDonChiTietToHoaDonID(int hoadonID) {
			List<HoaDonChiTiet> list=new ArrayList<HoaDonChiTiet>();
			for (HoaDonChiTiet o : this.findAll()) {
				if(o.getHoadonchitietID().getHOADON_HOADON_ID()==hoadonID) {
					list.add(o);
				}
			}
			return list;
		}
	/*
	@Async
	@Query("SELECT h FROM Hoadonchitiet h WHERE h.HOADON_HOADON_ID = ?hoadonID")
	public  List<HoaDonChiTiet> GetHoaDonChiTietToHoaDonID(@Param("hoadonID") Integer hoadonID);
*/
		
	
}
