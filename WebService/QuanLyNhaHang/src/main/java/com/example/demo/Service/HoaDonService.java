package com.example.demo.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Ban;
import com.example.demo.model.HoaDon;

public interface HoaDonService extends JpaRepository<HoaDon,Long>{
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
		
		//INSERT HoaDon
		public default boolean InsertHoaDon(HoaDon o) {
			HoaDon kq=this.getOne(o.getHOADON_ID());
			if(kq!=null) {
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
