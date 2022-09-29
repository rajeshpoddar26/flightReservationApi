package com.bharath.flightReservation.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bharath.flightReservation.entity.Flight;
import com.bharath.flightReservation.model.FlightModel;
import com.bharath.flightReservation.repository.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightRepository flightRepository;

	@Override
	public List<Flight> findFlight(String from, String to, Date departure) {
		return flightRepository.findFlight(from, to, departure);
	}

	@Override
	public Object saveFlight(FlightModel flightModel) {

		Flight flight = new Flight();
		flight.setArrivalCity(flightModel.getArrivalCity());
		flight.setDepartureCity(flightModel.getDepartureCity());
		flight.setDateOfDeparture(flightModel.getDateOfDeparture());
		flight.setOperationalAirlines(flightModel.getOperationalAirlines());
		flight.setEstimatedDepartureTime(flightModel.getEstimatedDepartureTime());
		flight.setFlightNumber(flightModel.getFlightNumber());
		return flightRepository.save(flight);
	}

	@Override
	public Flight getFlight(Long id) {
		Optional<Flight> flightData = flightRepository.findById(id);
		if (flightData.isPresent()) {
			return flightData.get();
		}
		return null;
	}

}
