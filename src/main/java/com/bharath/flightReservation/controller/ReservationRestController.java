package com.bharath.flightReservation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bharath.flightReservation.model.ReservationUpdateRequest;
import com.bharath.flightReservation.service.ReservationRestService;
import com.bharath.flightReservation.util.EmailUtil;

@RestController
@RequestMapping("/api/v1/reservationRest")
public class ReservationRestController {

	private static final Logger logger=LoggerFactory.getLogger(EmailUtil.class);

	@Autowired
	private ReservationRestService reservationRestService;

	@GetMapping("/reservation/{id}")
	public Object findReservation(@PathVariable(value = "id") Long id) {
		logger.info("Inside the findReservation() invoked wih id: "+id);
		return reservationRestService.findReservation(id);
	}
	
	@PostMapping("/reservation")
	public Object updateReservation(@RequestBody ReservationUpdateRequest request) {
		logger.info("Inside the updateReservation() for "+request);

		return reservationRestService.updateReservation(request);
	}

}
