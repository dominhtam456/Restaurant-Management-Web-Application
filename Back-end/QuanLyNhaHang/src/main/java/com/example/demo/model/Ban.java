package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
/*
 * @NamedStoredProcedureQueries({
 * 
 * @NamedStoredProcedureQuery(name = "firstProcedure", procedureName =
 * "SP_GETALLBANS", resultClasses = Ban.class), })
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "ban")

public class Ban implements Serializable {

	private static final long serialVersionUID = 1L;
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "BAN_ID")
	 private long BAN_ID;
	
	 @Column(name = "BAN_NO")
	 private String BAN_NO;
	
	 @Column(name = "BAN_STATUS")
	 private String BAN_STATUS;
	 
	 protected Ban() {
		  
	 }
	 
	 public Ban(String ban_No, String ban_Status) {
		 this.BAN_NO = ban_No;
		 this.BAN_STATUS = ban_Status;
	 }

	public long getBAN_ID() {
		return BAN_ID;
	}

	public void setBAN_ID(long bAN_ID) {
		BAN_ID = bAN_ID;
	}

	public String getBAN_NO() {
		return BAN_NO;
	}

	public void setBAN_NO(String bAN_NO) {
		BAN_NO = bAN_NO;
	}

	public String getBAN_STATUS() {
		return BAN_STATUS;
	}

	public void setBAN_STATUS(String bAN_STATUS) {
		BAN_STATUS = bAN_STATUS;
	}

	
}
