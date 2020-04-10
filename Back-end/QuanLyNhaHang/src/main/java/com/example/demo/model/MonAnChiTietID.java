package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MonAnChiTietID implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	 @Column(name = "MONAN_MONAN_ID")
	 private Long monan_Id;
	 
	 @Column(name = "NGUYENLIEU_NGUYENLIEU_ID")
	 private Long nguyenlieu_Id;
	 
	public MonAnChiTietID() {
		super();
	}

	public MonAnChiTietID(Long monan_Id, Long nguyenlieu_Id) {
		super();
		this.monan_Id = monan_Id;
		this.nguyenlieu_Id = nguyenlieu_Id;
	}

	public Long getMonan_Id() {
		return monan_Id;
	}

	public void setMonan_Id(Long monan_Id) {
		this.monan_Id = monan_Id;
	}

	public Long getNguyenlieu_Id() {
		return nguyenlieu_Id;
	}

	public void setNguyenlieu_Id(Long nguyenlieu_Id) {
		this.nguyenlieu_Id = nguyenlieu_Id;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        MonAnChiTietID that = (MonAnChiTietID) o;
        return Objects.equals(monan_Id, that.monan_Id) &&
               Objects.equals(nguyenlieu_Id, that.nguyenlieu_Id);
    }
	
	@Override
    public int hashCode() {
        return Objects.hash(monan_Id, nguyenlieu_Id);
    }
}
