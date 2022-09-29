package com.bharath.flightReservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bharath.flightReservation.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User getByEmailAndPassword(String email, String password);

	User findByEmail(String username);

}
