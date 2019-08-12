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
import com.example.demo.Service.LoaiMonAnService;
import com.example.demo.Service.MonAnService;


import com.example.demo.model.LoaiNguyenLieu;
import com.example.demo.model.NguyenLieu;
import com.example.demo.model.LoaiMonAn;
import com.example.demo.model.MonAn;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/api")
public class WebController {
	
	@Autowired
	LoaiNguyenLieuService repositoryLoaiNguyenLieu;
	@Autowired
	NguyenLieuService repositoryNguyenLieu;
	@Autowired
	MonAnService repositoryMonAn;
	@Autowired
	LoaiMonAnService repositoryLoaiMonAn;
	
	
	/////////////////////////////// LOAI NGUYEN LIEU /////////////////////////
	
	//LAY ALL LOAI NGUYEN LIEU
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
	
	
	
	
  /////////////////////////////// NGUYEN LIEU ///////////////////////////
	
	//LAY TEN LOAI NGUYEN LIEU CHO TABLE NGUYEN LIEU THONG QUA ID LOAI NGUYEN LIEU
	public String GetTenLoaiNguyenLieu(long idLoaiNguyenLieu) {
		if(repositoryLoaiNguyenLieu.getOne(idLoaiNguyenLieu)!=null) {
			return repositoryLoaiNguyenLieu.getOne(idLoaiNguyenLieu).getLOAINGUYENLIEU_NAME();
		}else {
			return "null";
		}
		 
	}
	
	//LAY ALL NGUYEN LIEU
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
		    //SET TEN LOAI NGUYEN LIEU
		    nguyenlieu.setTENLOAI_NGUYENLIEU(GetTenLoaiNguyenLieu(nguyenlieu.getLOAINGUYENLIEU_LOAINGUYENLIEU_ID()));
		    //RESULT
		return nguyenlieu;
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
	
	//CAP NHAT NGUYEN LIEU
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
	@RequestMapping(value = "/NguyenLieu/{id}", method = RequestMethod.POST)
	public ResponseEntity<NguyenLieu> deleteNguyenLieu1(@PathVariable(value = "id") Long id) {
		NguyenLieu nl = repositoryNguyenLieu.getOne(id);
	    if(nl == null) {
	        return ResponseEntity.notFound().build();
	    }
	    repositoryNguyenLieu.delete(nl);//delete trong database
	    return ResponseEntity.ok().build();
	}
	
	/////////////////////////////// LOAI MON AN /////////////////////////
	
		//LAY ALL LOAI MON AN
		@RequestMapping(value = "/GetAllLoaiMonAn", method = RequestMethod.GET)
		public ResponseEntity<List<LoaiMonAn>> listAllLoaiMonAn() {
			    List<LoaiMonAn> listLoaiMonAn = repositoryLoaiMonAn.findAll();
			if (listLoaiMonAn.isEmpty()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
			// return ResponseEntity<List<Contact>>(listContact, HttpStatus.OK);
			return new ResponseEntity<List<LoaiMonAn>>(listLoaiMonAn, HttpStatus.OK);
		}
	
		//LAY 1 LOAI MON AN
		@RequestMapping(value = "/LoaiMonAn/{id}", method = RequestMethod.GET)
		public LoaiMonAn findLoaiMonAnByID(@PathVariable("id") long id) {
			   LoaiMonAn loaimonan = repositoryLoaiMonAn.getOne(id);
			    if (loaimonan == null) {
				      ResponseEntity.notFound().build();
			    }
			    	    
			return loaimonan;
		}
		
		//THEM LOAI MON AN
		@RequestMapping(
				value = "/InsertLoaiMonAn", 
				method = RequestMethod.POST	
				)
		@ResponseBody
		public LoaiMonAn insertLoaiMonAn(@Valid @RequestBody LoaiMonAn loaimonanForm) {
			//@Valid: kiem tra xem co ton tai object trong body
			LoaiMonAn lma = repositoryLoaiMonAn.save(loaimonanForm);
			return lma;
		}
		
		//CAP NHAT LOAI MON AN
		@RequestMapping(value = "/UpdateLoaiMonAn", 
				method = RequestMethod.POST)
		public ResponseEntity<LoaiMonAn> updateLoaiMonAn(@Valid @RequestBody LoaiMonAn loaimonanForm) {
			LoaiMonAn lma = repositoryLoaiMonAn.getOne(loaimonanForm.getId());
		    if(lma == null) {
		        return ResponseEntity.notFound().build();
		    }
		    
		    lma.setLOAIMONAN_NAME(loaimonanForm.getLOAIMONAN_NAME());
		    lma.setLOAIMONAN_DES(loaimonanForm.getLOAIMONAN_DES());

		    LoaiMonAn updatedLoaiMonAn = repositoryLoaiMonAn.save(lma);//update trong database
		    return ResponseEntity.ok(updatedLoaiMonAn);
		}
		
		//XOA LOAI MON AN
		@RequestMapping(value = "/DeleteLoaiMonAn", method = RequestMethod.POST)
		public int deleteLoaiMonAn(@Valid @RequestBody LoaiMonAn loaimonan) {
			//@PathVariable(value=""): lay bien tu url
			//@RequestBody: lay object duoc gui trong body
			LoaiMonAn lma = repositoryLoaiMonAn.getOne(loaimonan.getId());
		    if(lma == null) {
		        return 0;
		    }
		    repositoryLoaiMonAn.delete(lma);//delete trong database
		    return 1;
		}
		
		
		/////////////////////////////// MON AN ///////////////////////////
		
		//LAY TEN LOAI MON AN cho TABLE MON AN THONG QUA ID LOAIMONAN
			public String GetTenLoaiMonAn(long idLoaiMonAn) {
				if(repositoryLoaiMonAn.getOne(idLoaiMonAn)!=null) {
					return repositoryLoaiMonAn.getOne(idLoaiMonAn).getLOAIMONAN_NAME();
				}
				else 
				{
					return "null";
				}		 
			}
		
		//LAY ALL MON AN
			@RequestMapping(path = "/GetAllMonAn", produces = MediaType.APPLICATION_JSON_VALUE)
			public java.util.List<MonAn> getAllMonAn() {
				// This returns a JSON or XML with the users
				  for (MonAn monan : repositoryMonAn.findAll()) {
					  //Set ten loai nguyen lieu
					 
					  monan.setTENLOAI_LOAIMONAN(GetTenLoaiMonAn(monan.getLOAIMONAN_LOAIMONAN_ID()));
				}
				return repositoryMonAn.findAll();
			}
			
		// LAY 1 MON AN
			@RequestMapping(value = "/MonAn/{id}", method = RequestMethod.GET)

			public MonAn findMonAnByID(@PathVariable("id") long id) {
				   MonAn monan = repositoryMonAn.getOne(id);
				    if (monan == null) {
					      ResponseEntity.notFound().build();
				    }
				    //SET TEN LOAI MON AN
				    monan.setTENLOAI_LOAIMONAN(GetTenLoaiMonAn(monan.getLOAIMONAN_LOAIMONAN_ID()));
				    //RESULT
				return monan;
			}
			
		//THEM MON AN
			@RequestMapping(
					value = "/InsertMonAn", 
					method = RequestMethod.POST,
					produces = { MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
		            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
					)
			@ResponseBody
			public MonAn insertMonAn(MonAn monanForm) {
				try 
				{
					return repositoryMonAn.save(monanForm);
				}
				catch (Exception e) 
				{
					// TODO: handle exception
					return null;
				}
				
			}
			
		//CAP NHAT MON AN
			@RequestMapping(value = "/UpdateMonAn", 
					method = RequestMethod.POST,
					consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
			public ResponseEntity<MonAn> updateMonAn(@Valid MonAn monanForm) {
				MonAn ma = repositoryMonAn.getOne(monanForm.getMONAN_ID());
			    if(ma == null) {
			        return ResponseEntity.notFound().build();
			    }
			    
			    ma.setMONAN_NAME(monanForm.getMONAN_NAME());
			    ma.setMONAN_PRICE(monanForm.getMONAN_PRICE());
		        ma.setMONAN_UNIT(monanForm.getMONAN_UNIT());
		        ma.setMONAN_STATUS(monanForm.getMONAN_STATUS());
		        
		       
			    MonAn updatedMonAn = repositoryMonAn.save(ma);//update trong database
			    return ResponseEntity.ok(updatedMonAn);
			}
			
		//XOA MON AN
			@RequestMapping(value = "/MonAn/{id}", method = RequestMethod.POST)
			public ResponseEntity<MonAn> deleteMonAn(@PathVariable(value = "id") Long id) {
				MonAn ma = repositoryMonAn.getOne(id);
			    if(ma == null) {
			        return ResponseEntity.notFound().build();
			    }
			    repositoryMonAn.delete(ma);//delete trong database
			    return ResponseEntity.ok().build();
			}
			
		
			
			
		
			
			
			
			
			
			
			
		
}