package com.bharath.flightReservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bharath.flightReservation.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
