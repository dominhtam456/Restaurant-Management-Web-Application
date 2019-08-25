package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.HoaDon;
import com.example.demo.model.HoaDonChiTiet;

public interface ThongKeService extends JpaRepository<HoaDon, Long> {
   //THONG KE DOANH THU THEO NGAY
			public default List<HoaDon> GetHoaDonChiTietToHoaDonID(int hoadonID) {
				List<HoaDonChiTiet> list=new ArrayList<HoaDonChiTiet>();
				for (HoaDonChiTiet o : this.findAll()) {
					if(o.getHoadonchitietID().getHOADON_HOADON_ID()==hoadonID) {
						list.add(o);
					}
				}
				return list;
			}
}
