package com.bharath.flightReservation.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bharath.flightReservation.entity.Reservation;
import com.bharath.flightReservation.model.ReservationUpdateRequest;
import com.bharath.flightReservation.repository.ReservationRepository;
import com.bharath.flightReservation.util.EmailUtil;

@Service
public class ReservationRestServiceImpl implements ReservationRestService {

	private static final Logger logger=LoggerFactory.getLogger(ReservationRestServiceImpl.class);

	@Autowired
	private ReservationService reservationService;

	@Autowired
	private ReservationRepository reservationRepository;

	@Override
	public Object findReservation(Long id) {
		return reservationService.getReservation(id);
	}

	@Override
	public Object updateReservation(ReservationUpdateRequest request) {
		Reservation reservation = (Reservation) reservationService.getReservation(request.getId());

		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(request.getCheckedIn());
		
		logger.info("saved reservation details: "+reservation);
		return reservationRepository.save(reservation);
	}

}
