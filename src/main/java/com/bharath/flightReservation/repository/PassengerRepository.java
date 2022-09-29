package com.bharath.flightReservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bharath.flightReservation.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
