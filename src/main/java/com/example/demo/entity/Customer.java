package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="CUSTOMER")
@NoArgsConstructor
@Data public class Customer {

	@Id
	@Column(name="ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="NAME", nullable = false)
	private String name;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="PHONE_NUMBER", nullable = false)
	private String phoneNumber;
	
	
}
