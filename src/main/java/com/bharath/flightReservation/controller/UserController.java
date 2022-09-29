package com.bharath.flightReservation.controller;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bharath.flightReservation.model.RegisterModel;
import com.bharath.flightReservation.repository.RoleRepository;
import com.bharath.flightReservation.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

	private static final Logger logger= LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@PostMapping("/register")
	public Object registerUser(@RequestBody RegisterModel registerModel) {
		logger.info("Inside register()"+registerModel);
		return userService.registerUser(registerModel);
	}
	@GetMapping("role")
	public Object getRoleById(@RequestParam String role) {
		
		return roleRepository.findByName(role);
	}
	
	@GetMapping("/login")
	public String loginUser(@RequestParam(value = "email") String email, @RequestParam(value = "password") String password) {
		logger.info("Inside login(): Email:"+email+", Password: "+password);

		return userService.loginUser(email, password);
		
	}
}
