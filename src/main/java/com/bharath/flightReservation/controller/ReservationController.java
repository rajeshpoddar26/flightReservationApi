package com.bharath.flightReservation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bharath.flightReservation.entity.Reservation;
import com.bharath.flightReservation.model.ReservationModel;
import com.bharath.flightReservation.service.ReservationService;

@RestController
@RequestMapping("/api/v1/reservation")
public class ReservationController {

	private static final Logger logger=LoggerFactory.getLogger(ReservationController.class);

	@Autowired
	private ReservationService reservationService;

	@GetMapping("/showCompleteReservation")
	public Object showCompleteReservation(@RequestParam(value = "flightId") Long flightId) {
		
		logger.info("showCompleteReservation() invoked with the flightId: "+flightId);
		return reservationService.showCompleteReservation(flightId);
	}

	@PostMapping(value = "/completeReservaion")
	public String completeReservaion(@RequestBody ReservationModel reservationModel) {
		logger.info("showCompleteReservation() invoked input reservationDetails: "+reservationModel);
		Reservation reservation = reservationService.bookFlight(reservationModel);
		
		return "Reservation created Successfully with reservation Id: " + reservation.getId();
	}
}
