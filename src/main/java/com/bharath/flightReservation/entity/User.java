package com.bharath.flightReservation.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class User extends AbstractEntity {

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	@ManyToMany
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name ="user_id"), inverseJoinColumns = @JoinColumn(name = "role_id "))
	private Set<Role> roles= new HashSet<>();
	
	public void addRole(Role roles) {
		this.roles.add(roles);
	}
}
