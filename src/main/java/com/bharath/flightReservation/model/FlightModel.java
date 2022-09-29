package com.bharath.flightReservation.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class FlightModel {

	private String flightNumber;
	private String operationalAirlines;
	private String departureCity;
	private String arrivalCity;
	@Temporal(TemporalType.DATE)
	private Date dateOfDeparture;
	private Timestamp estimatedDepartureTime;
}
