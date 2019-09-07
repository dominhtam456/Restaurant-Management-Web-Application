package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalIdCache;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "NguyenLieu")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "nguyenlieu")
@NaturalIdCache
@Cache(
    usage = CacheConcurrencyStrategy.READ_WRITE
)
public class NguyenLieu implements Serializable {

		private static final long serialVersionUID = 1L;
		 @Id
		 @GeneratedValue(strategy = GenerationType.IDENTITY)
		 @Column(name = "NGUYENLIEU_ID")
		 private long NGUYENLIEU_ID;
		 
		 @Column(name="NGUYENLIEU_NO")
		 private String NGUYENLIEU_NO;
		 
		
		 @Column(name = "NGUYENLIEU_NAME")
		 private String NGUYENLIEU_NAME;
		
		 @Column(name = "NGUYENLIEU_PRICE")
		 private String NGUYENLIEU_PRICE;
		 
		 @Column(name = "NGUYENLIEU_DATE")
		 private Date NGUYENLIEU_DATE;
		 
		 @Column(name="NGUYENLIEU_IMG")
		 private String NGUYENLIEU_IMG;
		 
		 @Column(name = "LOAINGUYENLIEU_LOAINGUYENLIEU_ID")
		 private int LOAINGUYENLIEU_LOAINGUYENLIEU_ID;
		 
		 
		 private String TENLOAI_NGUYENLIEU;
		 
		
		public String getTENLOAI_NGUYENLIEU() {
			return TENLOAI_NGUYENLIEU;
		}
		
		public void setTENLOAI_NGUYENLIEU(String tENLOAI_NGUYENLIEU) {
			TENLOAI_NGUYENLIEU = tENLOAI_NGUYENLIEU;
		}
		
		public NguyenLieu() {
			super();
		}

		public NguyenLieu(String nGUYENLIEU_NAME, String nGUYENLIEU_PRICE, Date nGUYENLIEU_DATE,
				int lOAINGUYENLIEU_LOAINGUYENLIEU_ID) {
			
			NGUYENLIEU_NAME = nGUYENLIEU_NAME;
			NGUYENLIEU_PRICE = nGUYENLIEU_PRICE;
			NGUYENLIEU_DATE = nGUYENLIEU_DATE;
			LOAINGUYENLIEU_LOAINGUYENLIEU_ID = lOAINGUYENLIEU_LOAINGUYENLIEU_ID;
		}
		
		public long getNGUYENLIEU_ID() {
			return NGUYENLIEU_ID;
		}
		
		public void setNGUYENLIEU_ID(long nGUYENLIEU_ID) {
			NGUYENLIEU_ID = nGUYENLIEU_ID;
		}
		
		public String getNGUYENLIEU_NAME() {
			return NGUYENLIEU_NAME;
		}
		
		public void setNGUYENLIEU_NAME(String nGUYENLIEU_NAME) {
			NGUYENLIEU_NAME = nGUYENLIEU_NAME;
		}
		
		public String getNGUYENLIEU_PRICE() {
			return NGUYENLIEU_PRICE;
		}
		
		public void setNGUYENLIEU_PRICE(String nGUYENLIEU_PRICE) {
			NGUYENLIEU_PRICE = nGUYENLIEU_PRICE;
		}
		
		public Date getNGUYENLIEU_DATE() {
			return NGUYENLIEU_DATE;
		}
		
		public void setNGUYENLIEU_DATE(Date nGUYENLIEU_DATE) {
			NGUYENLIEU_DATE = nGUYENLIEU_DATE;
		}
		
		public int getLOAINGUYENLIEU_LOAINGUYENLIEU_ID() {
			return LOAINGUYENLIEU_LOAINGUYENLIEU_ID;
		}
		
		public void setLOAINGUYENLIEU_LOAINGUYENLIEU_ID(int lOAINGUYENLIEU_LOAINGUYENLIEU_ID) {
			LOAINGUYENLIEU_LOAINGUYENLIEU_ID = lOAINGUYENLIEU_LOAINGUYENLIEU_ID;
		}
		
		public String getNGUYENLIEU_IMG() {
			return NGUYENLIEU_IMG;
		}
		
		public void setNGUYENLIEU_IMG(String nGUYENLIEU_IMG) {
			NGUYENLIEU_IMG = nGUYENLIEU_IMG;
		}
		
		public String getNGUYENLIEU_NO() {
			return NGUYENLIEU_NO;
		}
		
		public void setNGUYENLIEU_NO(String nGUYENLIEU_NO) {
			NGUYENLIEU_NO = nGUYENLIEU_NO;
		}
		

		@Override
		    public boolean equals(Object o) {
		        if (this == o) return true;
		        if (o == null || getClass() != o.getClass()) return false;
		        NguyenLieu nguyenlieu = (NguyenLieu) o;
		        return Objects.equals(NGUYENLIEU_NAME, nguyenlieu.NGUYENLIEU_NAME);
		    }
		 
		    @Override
		    public int hashCode() {
		        return Objects.hash(NGUYENLIEU_NAME);
		    }
}