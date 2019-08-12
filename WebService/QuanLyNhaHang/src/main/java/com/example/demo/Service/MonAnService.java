package com.example.demo.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.MonAn;

@Repository
public interface MonAnService extends JpaRepository<MonAn, Long>{
	
}