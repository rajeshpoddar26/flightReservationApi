package com.bharath.flightReservation.service;

import com.bharath.flightReservation.model.RegisterModel;

public interface UserService {
	
	Object registerUser(RegisterModel registerModel);

	String loginUser(String email, String password);
	

}
