package com.bharath.flightReservation.service;

import java.util.Date;
import java.util.List;

import com.bharath.flightReservation.entity.Flight;
import com.bharath.flightReservation.model.FlightModel;

public interface FlightService {

	Object saveFlight(FlightModel flightModel);
	
	List<Flight> findFlight(String from, String to, Date departure);

	Flight getFlight(Long id);
	

}
