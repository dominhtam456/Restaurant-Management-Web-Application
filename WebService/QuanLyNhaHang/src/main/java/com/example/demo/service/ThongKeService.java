package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.HoaDon;
import com.example.demo.model.HoaDonChiTiet;

public interface ThongKeService extends JpaRepository<HoaDon, Long> {
   //THONG KE DOANH THU THEO NGAY
			
}
