package com.bharath.flightReservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bharath.flightReservation.entity.Role;
import com.bharath.flightReservation.entity.User;
import com.bharath.flightReservation.model.LoginModel;
import com.bharath.flightReservation.model.RegisterModel;
import com.bharath.flightReservation.repository.RoleRepository;
import com.bharath.flightReservation.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private SecurityService securityService;

	@Override
	public Object registerUser(RegisterModel registerModel) {

		User user = new User();
		User userData = userRepository.findByEmail(registerModel.getEmail());
		if (userData != null) {
			return "Email Must be Unique";
		}
		user.setEmail(registerModel.getEmail());
		user.setFirstName(registerModel.getFirstName());
		user.setLastName(registerModel.getLastName());
		user.setPassword(encoder.encode(registerModel.getPassword()));
		
		Role roleData=roleRepository.findByName(registerModel.getRoles());
		user.addRole(roleData);
		
		userRepository.save(user);

		return "Register sucessfully";

	}

	@Override
	public String loginUser(String email, String password) {

//		User loginResponse=userRepository.getByEmailAndPassword(email, password);

		boolean loginResponse = securityService.login(email, password);

		if (loginResponse) {
			return "Logged In Successfully";
		} else {
			return "Email Id Or password is in correct";
		}

//		user !=null? return "Logged in";: new CredentialNotFoundException("check Email Id or Password again.");

	}

}
