package com.bharath.flightReservation.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bharath.flightReservation.entity.Flight;
import com.bharath.flightReservation.entity.Passenger;
import com.bharath.flightReservation.entity.Reservation;
import com.bharath.flightReservation.model.ReservationModel;
import com.bharath.flightReservation.repository.PassengerRepository;
import com.bharath.flightReservation.repository.ReservationRepository;
import com.bharath.flightReservation.util.EmailUtil;
import com.bharath.flightReservation.util.PDFGenrator;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Value("${com.bharath.flightReservation.itinerary.dirpath}")
	private String ITINERARY_DIR;

	private static final Logger logger=LoggerFactory.getLogger(ReservationServiceImpl.class);

	@Autowired
	private PDFGenrator pdfGenrator;

	@Autowired
	private EmailUtil emailUtil;

	@Autowired
	private FlightService flightService;
	@Autowired
	private PassengerRepository passengerRepository;
	@Autowired
	private ReservationRepository reservationRepository;

	@Override
	public Object showCompleteReservation(Long flightId) {

		Flight flightData = flightService.getFlight(flightId);
		return flightData;
	}

	@Override
	@Transactional
	public Reservation bookFlight(ReservationModel reservationModel) {
		
		logger.info("InSide the bookFlight()");
		
		Flight flightData = flightService.getFlight(reservationModel.getFlightId());
		
		logger.info("reservation Flight Id: "+reservationModel.getFlightId());
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(reservationModel.getPassengerFirstName());
		passenger.setMiddleName(reservationModel.getPassengerMiddletName());
		passenger.setLastName(reservationModel.getPassengerLastName());
		passenger.setPhone(reservationModel.getPassengerPhone());
		passenger.setEmail(reservationModel.getPassengerEmail());
		
		logger.info("Saving the passenger: "+passenger);
		Passenger savedPassenger = passengerRepository.save(passenger);

		Reservation reservation = new Reservation();
		reservation.setFlight(flightData);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		logger.info("Saving the reservation: "+reservation);

		Reservation savedReservation = reservationRepository.save(reservation);
		String filePath = ITINERARY_DIR + savedReservation.getId() + ".pdf";
		
		logger.info("Genrating the itinerary");
		pdfGenrator.generateItineraryReservation(savedReservation, filePath);
		logger.info("Emaling the itinerary");
		emailUtil.sendItinerary(passenger.getEmail(), filePath);

		return savedReservation;
	}

	@Override
	public Object getReservation(Long reservationId) {
		Optional<Reservation> reservationData = reservationRepository.findById(reservationId);
		if (reservationData.isPresent()) {
			return reservationData.get();
		}
		return null;
	}

}
