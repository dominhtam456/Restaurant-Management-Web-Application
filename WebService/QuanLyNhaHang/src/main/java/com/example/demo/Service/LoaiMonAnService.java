package com.example.demo.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.LoaiMonAn;

@Repository
public interface LoaiMonAnService extends JpaRepository<LoaiMonAn, Long> {
	
}
