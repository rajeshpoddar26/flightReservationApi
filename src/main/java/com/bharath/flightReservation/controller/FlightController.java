package com.bharath.flightReservation.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bharath.flightReservation.entity.Flight;
import com.bharath.flightReservation.model.FlightModel;
import com.bharath.flightReservation.service.FlightService;

@RestController
@RequestMapping("/api/v1/flights")
public class FlightController {

	private static final Logger logger=LoggerFactory.getLogger(FlightController.class);
	
	@Autowired
	private FlightService flightService;

	@GetMapping("/findFlights")
	public List<Flight> findFlight(@RequestParam(value = "from") String from, @RequestParam(value = "to") String to,
			@RequestParam(value = "departure") @DateTimeFormat(pattern = "yyyy-MM-dd") Date departure) {
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//		Date dateOfDeparture = formatter.parse(departure);

		logger.info("Indise findFlights() "+"from: "+from+", to: "+to+", departure: "+departure);
		return flightService.findFlight(from, to, departure);

	}

	@PostMapping("/admin/showAddFlight")
	public Object saveFllight(@RequestBody FlightModel flightModel) {
		return flightService.saveFlight(flightModel);
	}

}
