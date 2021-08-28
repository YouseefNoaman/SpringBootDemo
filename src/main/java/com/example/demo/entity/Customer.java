package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CUSTOMER")
@NoArgsConstructor
@Data
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5847653295942669546L;

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NAME", nullable = false)
	@NotBlank
	@Size(min = 3, max = 20)
	private String name;

	@NotBlank
	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "PHONE_NUMBER", nullable = false)
	private String phoneNumber;

}
