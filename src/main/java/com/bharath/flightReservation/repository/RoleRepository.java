package com.bharath.flightReservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bharath.flightReservation.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByName(String roles);

}
