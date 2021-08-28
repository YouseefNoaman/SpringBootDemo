package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;
//import lombok.NonNull;

@Entity
@Table(name = "ERROR_DETAIL")
@NoArgsConstructor
@Data
public class ErrorDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7656824799989584797L;

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "MESSAGE", nullable = false)
	@NotNull
	private String message;

	@Column(name = "DETAILS")
	private String details;

	@Column(name = "STATUS_CODE")
	private int statusCode;

	@Column(name = "Date", nullable = false)
	private Date date;

	public ErrorDetail(String message, int statusCode, String details, Date date) {
		super();
		this.message = message;
		this.statusCode = statusCode;
		this.details = details;
		this.date = date;
	}

}
