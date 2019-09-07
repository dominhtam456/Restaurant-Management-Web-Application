package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "nhanvien")
public class NhanVien {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "NHANVIEN_ID")
	 private int id;
	 
	 @Column(name="NHANVIEN_NO")
	 private String no;
	 
	 @Column(name = "NHANVIEN_NAME")
	 private String fullname;
	
	 @Column(name = "NHANVIEN_PHONE")
	 private String phone;
	 
	 @Column(name = "NHANVIEN_EMAIL")
	 private String username;
	 
	 @Column(name="NHANVIEN_PASSWORD")
	 @JsonIgnore
	 private String password;
	 
	 @Column(name="NHANVIEN_LOAI")
	 private int loai;
	 
	 @Column(name="NHANVIEN_IMG")
	 private String img;
	 
	 public NhanVien() {
		 
	 }
			
	 public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getLoai() {
		return loai;
	}

	public void setLoai(int loai) {
		this.loai = loai;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	 
}
