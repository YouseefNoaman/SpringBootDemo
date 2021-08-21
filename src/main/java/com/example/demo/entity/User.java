package com.example.demo.entity;

import java.util.*;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USER")
@NoArgsConstructor
@Data
public class User {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "USERNAME", nullable = false)
	private String username;
	
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "USERS_ROLES",
            joinColumns = @JoinColumn(name = "ID"),	// USER ID
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID")		// ROLE ID
            )
    private Set<Role> roles = new HashSet<>();

	@Column(name = "IS_ENABLED", nullable = false)
	private boolean isEnabled;
}
