package com.bharath.flightReservation.model;

import lombok.Data;

@Data
public class ReservationModel {

	private Long flightId;
	private String passengerFirstName;
	private String passengerMiddletName;
	private String passengerLastName;
	private String passengerEmail;
	private String passengerPhone;
	private String nameOfTheCard;
	private String cardNumber;
	private String expirationDate;
	private String security;
	
}
