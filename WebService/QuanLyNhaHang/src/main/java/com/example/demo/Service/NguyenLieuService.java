package com.example.demo.Service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.NguyenLieu;
 
 
@Repository
public interface NguyenLieuService extends JpaRepository<NguyenLieu, Long>{
	//todo
}
