package com.example.demo.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.LoaiNguyenLieuService;
import com.example.demo.Service.NguyenLieuService;
import com.example.demo.model.LoaiNguyenLieu;
import com.example.demo.model.NguyenLieu;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/api")
public class WebController {
	@Autowired
	LoaiNguyenLieuService repositoryLoaiNguyenLieu;
	@Autowired
	NguyenLieuService repositoryNguyenLieu;
	
	/////////////////////////////// LOAI NGUYEN LIEU/////////////////////////
	
	@RequestMapping(path = "/get_list_loainguyenlieu", produces = MediaType.APPLICATION_JSON_VALUE)
	public java.util.List<LoaiNguyenLieu> getAllLoaiMonAn() {
		// This returns a JSON or XML with the users
		return repositoryLoaiNguyenLieu.findAll();
	}

	@RequestMapping(value = "/GetAllLoaiNguyenLieu", method = RequestMethod.GET)
	public ResponseEntity<List<LoaiNguyenLieu>> listAllLoaiNguyenLieu() {
		    List<LoaiNguyenLieu> listLoaiNguyenLieu = repositoryLoaiNguyenLieu.findAll();
		if (listLoaiNguyenLieu.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		// return ResponseEntity<List<Contact>>(listContact, HttpStatus.OK);
		return new ResponseEntity<List<LoaiNguyenLieu>>(listLoaiNguyenLieu, HttpStatus.OK);
	}

	//LAY 1 LOAI NGUYEN LIEU
	@RequestMapping(value = "/LoaiNguyenLieu/{id}", method = RequestMethod.GET)

	public LoaiNguyenLieu findLoaiNguyenLieuByID(@PathVariable("id") long id) {
		   LoaiNguyenLieu loainguyenlieu = repositoryLoaiNguyenLieu.getOne(id);
		    if (loainguyenlieu == null) {
			      ResponseEntity.notFound().build();
		    }
		return loainguyenlieu;
	}
	
	//CAP NHAT LOAI NGUYEN LIEU
	@RequestMapping(value = "/UpdateLoaiNguyenLieu/", 
			method = RequestMethod.POST)
	public ResponseEntity<LoaiNguyenLieu> updateLoaiNguyenLieu(@Valid @RequestBody LoaiNguyenLieu loainguyenlieuForm) {
		LoaiNguyenLieu lnl = repositoryLoaiNguyenLieu.getOne(loainguyenlieuForm.getId());
	    if(lnl == null) {
	        return ResponseEntity.notFound().build();
	    }
	    
	    lnl.setLOAINGUYENLIEU_NAME(loainguyenlieuForm.getLOAINGUYENLIEU_NAME());
	    lnl.setLOAINGUYENLIEU_UNIT(loainguyenlieuForm.getLOAINGUYENLIEU_UNIT());

	    LoaiNguyenLieu updatedLoaiNguyenLieu = repositoryLoaiNguyenLieu.save(lnl);//update trong database
	    return ResponseEntity.ok(updatedLoaiNguyenLieu);
	}
	
	
    //XOA LOAI NGUYEN LIEU
	@RequestMapping(value = "/DeleteLoaiNguyenLieu", method = RequestMethod.POST)
	public int deleteLoaiNguyenLieu(@Valid @RequestBody LoaiNguyenLieu loainguyenlieu) {
		//@PathVariable(value=""): lay bien tu url
		//@RequestBody: lay object duoc gui trong body
		LoaiNguyenLieu lnl = repositoryLoaiNguyenLieu.getOne(loainguyenlieu.getId());
	    if(lnl == null) {
	        return 0;
	    }
	    repositoryLoaiNguyenLieu.delete(lnl);//delete trong database
	    return 1;
	}
	
	
	//THEM LOAI NGUYEN LIEU
	@RequestMapping(
			value = "/InsertLoaiNguyenLieu/", 
			method = RequestMethod.POST
			
			)
	@ResponseBody
	public LoaiNguyenLieu insertLoaiNguyenLieu(@Valid @RequestBody LoaiNguyenLieu loainguyenlieuForm) {
		//@Valid: kiem tra xem co ton tai object trong body
		LoaiNguyenLieu lnl=repositoryLoaiNguyenLieu.save(loainguyenlieuForm);
		return lnl;
	}
	
	
  /////////////////////////////// NGUYEN LIEU/ //////////////////////////
	
	//GET TEN LOAI NGUYEN LIEU
	public String GetTenLoaiNguyenLieu(long idLoaiNguyenLieu) {
		if(repositoryLoaiNguyenLieu.getOne(idLoaiNguyenLieu)!=null) {
			return repositoryLoaiNguyenLieu.getOne(idLoaiNguyenLieu).getLOAINGUYENLIEU_NAME();
		}else {
			return "null";
		}
		 
	}
	//DANH SACH TAC CA NGUYEN LIEU
	@RequestMapping(path = "/GetAllNguyenLieu", produces = MediaType.APPLICATION_JSON_VALUE)
	public java.util.List<NguyenLieu> getAllNguyenLieu() {
		// This returns a JSON or XML with the users
		  for (NguyenLieu nguyenLieu : repositoryNguyenLieu.findAll()) {
			  //Set ten loai nguyen lieu
			 
			 nguyenLieu.setTENLOAI_NGUYENLIEU(GetTenLoaiNguyenLieu(nguyenLieu.getLOAINGUYENLIEU_LOAINGUYENLIEU_ID()));
		}
		return repositoryNguyenLieu.findAll();
	}

	

	// LAY 1 NGUYEN LIEU
	@RequestMapping(value = "/NguyenLieu/{id}", method = RequestMethod.GET)

	public NguyenLieu findNguyenLieuByID(@PathVariable("id") long id) {
		   NguyenLieu nguyenlieu = repositoryNguyenLieu.getOne(id);
		    if (nguyenlieu == null) {
			      ResponseEntity.notFound().build();
		    }
		return nguyenlieu;
	}
	
	//UP DATE NGUYEN LIEU
	@RequestMapping(value = "/UpdateNguyenLieu", 
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<NguyenLieu> updateNguyenLieu(@Valid NguyenLieu nguyenlieuForm) {
		NguyenLieu nl = repositoryNguyenLieu.getOne(nguyenlieuForm.getNGUYENLIEU_ID());
	    if(nl == null) {
	        return ResponseEntity.notFound().build();
	    }
	    
	    nl.setNGUYENLIEU_NAME(nguyenlieuForm.getNGUYENLIEU_NAME());
	    nl.setNGUYENLIEU_PRICE(nguyenlieuForm.getNGUYENLIEU_PRICE());
        nl.setNGUYENLIEU_DATE(nguyenlieuForm.getNGUYENLIEU_DATE());
       
	    NguyenLieu updatedNguyenLieu = repositoryNguyenLieu.save(nl);//update trong database
	    return ResponseEntity.ok(updatedNguyenLieu);
	}
	
	
     //XOA NGUYEN LIEU
	//cach 1
	@RequestMapping(value = "/NguyenLieu/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<NguyenLieu> deleteNguyenLieu1(@PathVariable(value = "id") Long id) {
		NguyenLieu nl = repositoryNguyenLieu.getOne(id);
	    if(nl == null) {
	        return ResponseEntity.notFound().build();
	    }
	    repositoryNguyenLieu.delete(nl);//delete trong database
	    return ResponseEntity.ok().build();
	}
	
	//cach 2
	@RequestMapping(value = "/DeleteNguyenLieu", method = RequestMethod.POST)
	public int deleteNguyenLieu(@Valid @RequestBody  NguyenLieu nguyeLieu) {
		NguyenLieu nl = repositoryNguyenLieu.getOne(nguyeLieu.getNGUYENLIEU_ID());
	    if(nl == null) {
	        return 0;
	    }
	    repositoryNguyenLieu.delete(nl);//delete trong database
	    return 1;
	}
	
	
	//THEM NGUYEN LIEU
	@RequestMapping(
			value = "/InsertNguyenLieu", 
			method = RequestMethod.POST,
			produces = { MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
			)
	@ResponseBody
	public NguyenLieu insertNguyenLieu(NguyenLieu nguyenlieuForm) {
		/*
		 * if(nguyenlieuForm!=null) {
		 * 
		 * }else { return null; }
		 */
		try {
			return repositoryNguyenLieu.save(nguyenlieuForm);
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
}