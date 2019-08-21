package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.HoaDon;

@Repository
public interface HoaDonService extends JpaRepository<HoaDon,Long>{
	  // private default List<HoaDon> dshd=this.List<HoaDon> findByHOADON_STATUS(Boolean hOADON_STATUS);;
	    @Modifying
	    @Query(value = "insert into hoadon (HOADON_NO) VALUES (:id,:insertLink)", nativeQuery = true)
	    @Transactional
	    void TaoHoaDon(@Param("id") Long id,@Param("insertLink") String insertLink);
  
		//GET DANH SACH HoaDon
		public default List<HoaDon> GetAllHoaDons(){
			return this.findAll();
		}
		
		//GET 1 HoaDOn
		public default HoaDon GetHoaDon(long id) {
			return this.getOne(id);
			
		}
		//get hoa don theo ban va chua thanh toan
		public default List<HoaDon> GetHoaDonToStatus(Boolean status){
			List<HoaDon> list=new ArrayList<HoaDon>();
			for (HoaDon hoaDon : this.findAll()) {
				if(hoaDon.getHOADON_STATUS()==status) {
					list.add(hoaDon);
				}
			}
			return list;
		}
		
		//INSERT HoaDon
		@SuppressWarnings("unused")
		public default boolean InsertHoaDon(HoaDon o) {
			o.setHOADON_NO("HD00"+String.valueOf(this.count()+1));
			//mac dinh khahc hanng le=1
			o.setKHACHHANG_KHACHHANG_ID(1);
			if(o!=null) {
			   this.save(o);
				return true;
			}else {
				return false;
			}
		}
		
		//UPDATE HoaDon
		public default boolean UpdateHoaDon(HoaDon o) {
			HoaDon temp=this.getOne(o.getHOADON_ID());
			if(temp!=null) {
				this.save(temp);
				return true;
			}else {
				return false;
			}
		}
		
		//DELETE HoaDon
		public default boolean 	DeleteHoaDon(long id) {
			HoaDon temp=this.getOne(id);
			if(temp!=null) {
				this.delete(temp);
				return true;
			}else {
				return false;
			}
		}
		
}
