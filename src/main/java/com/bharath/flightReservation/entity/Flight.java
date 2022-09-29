package com.bharath.flightReservation.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class Flight extends AbstractEntity {
	
	private String flightNumber;
	private String operationalAirlines;
	private String departureCity;
	private String arrivalCity;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfDeparture;
	private Timestamp estimatedDepartureTime;
	

}
