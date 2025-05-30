package com.pranay.StudentSelfReflection.model;

import jakarta.persistence.*;


@MappedSuperclass
public class Users
{
	@Column(unique = true)
	private String username;
	
	@Column(unique = true)
	private String email;
	
	@Transient
	private String confirmEmail;
	
	private String pwd;
	
	@Transient
	private String confirmPwd;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "roles_id", referencedColumnName = "rolesId",unique = false)
	private Roles role;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Address address;
}
