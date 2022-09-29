package com.bharath.flightReservation.service;

import com.bharath.flightReservation.entity.Reservation;
import com.bharath.flightReservation.model.ReservationModel;

public interface ReservationService {
	
	Object showCompleteReservation(Long flightId);
	
	Reservation bookFlight(ReservationModel reservationModel);

	Object getReservation(Long reservationId);

}
