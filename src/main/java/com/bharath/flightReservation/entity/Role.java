package com.bharath.flightReservation.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Entity
@Data
public class Role extends AbstractEntity implements GrantedAuthority{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	@ManyToMany(mappedBy = "roles")
	private Set<User> users= new HashSet<>();
	
	@Override
	public String getAuthority() {
		return name;
	}
	
	
}
