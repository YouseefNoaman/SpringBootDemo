package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ROLES")
@NoArgsConstructor
@Data
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -319538529873418767L;

	@Id
	@Column(name = "ROLE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NAME")
	private String name;
}
