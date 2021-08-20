package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
//import lombok.NonNull;

@Entity
@Table(name="ERROR_DETAIL")
@NoArgsConstructor
@Data public class ErrorDetail {

	@Id
	@Column(name="ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="MESSAGE", nullable = false)
//	@NonNull
	private String message;
	
	@Column(name="DETAILS")
//	@NonNull	// this is added so that lombok can create a constructor with this variable in it, anything that doesn't have this annotation would be omitted 
	private String details;
	
	@Column(name="Date", nullable = false)
//	@NonNull
	private Date date;
	
	public ErrorDetail(String message, String details, Date date){
		super();
		this.message=message;
		this.details=details;
		this.date=date;
	}
	
}
