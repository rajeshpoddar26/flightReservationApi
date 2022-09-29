package com.bharath.flightReservation.service;

import com.bharath.flightReservation.model.ReservationUpdateRequest;

public interface ReservationRestService {

	Object findReservation(Long id);

	Object updateReservation(ReservationUpdateRequest request);
	
}
