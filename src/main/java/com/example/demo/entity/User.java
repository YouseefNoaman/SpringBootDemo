package com.example.demo.entity;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USER", uniqueConstraints = { @UniqueConstraint(columnNames = "USERNAME"),
		@UniqueConstraint(columnNames = "EMAIL") })
@NoArgsConstructor
@Data
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2990994139938950156L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(name = "USERNAME", nullable = false)
	private String username;

	@NotBlank
	@Size(min = 8, max = 120, message = "{NotNull.name}")
	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@Email
	@NotNull
	@Column(name = "EMAIL", nullable = false)
	private String email;

	@Transient
	private String passwordConfirm;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	@JoinTable(name = "USERS_ROLES", joinColumns = @JoinColumn(name = "ID"), // USER ID
			inverseJoinColumns = @JoinColumn(name = "ROLE_ID") // ROLE ID
	)
	private Set<Role> roles = new HashSet<>();

	@Column(name = "IS_ENABLED", nullable = false)
	private boolean isEnabled;

	public User(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}

}
