package com.bharath.flightReservation.model;

import lombok.Data;

@Data
public class RegisterModel {
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String roles;
}

