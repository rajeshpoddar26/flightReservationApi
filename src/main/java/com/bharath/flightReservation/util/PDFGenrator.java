package com.bharath.flightReservation.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.bharath.flightReservation.entity.Reservation;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;



@Component
public class PDFGenrator {

	private static final Logger logger=LoggerFactory.getLogger(EmailUtil.class);

	public void generateItineraryReservation(Reservation reservation, String filePath) {
		logger.info("Inside the generateItineraryReservation()");
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(filePath));
			document.open();
//			document.add(new PdfPTable(2));
			document.add(genrateTable(reservation));
			document.close();
		} catch (FileNotFoundException | DocumentException e) {
			logger.error("Exception in generateItineraryReservation: "+e);
		}
	}

	private PdfPTable genrateTable(Reservation reservation) {
		PdfPTable table = new PdfPTable(2);
		PdfPCell cell;
		cell = new PdfPCell(new Phrase("Flight Itinerary"));
		cell.setColspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Flight Details"));
		cell.setColspan(2);
		table.addCell(cell);
		
		table.addCell("Airlinese");
		table.addCell(reservation.getFlight().getOperationalAirlines());

		table.addCell("Departure City");
		table.addCell(reservation.getFlight().getDepartureCity());

		table.addCell("Arrival City");
		table.addCell(reservation.getFlight().getArrivalCity());

		table.addCell("Flight Number");
		table.addCell(reservation.getFlight().getFlightNumber());

		table.addCell("Departure Date");
		table.addCell(reservation.getFlight().getDateOfDeparture().toString());

		table.addCell("Departure Time");
		table.addCell(reservation.getFlight().getEstimatedDepartureTime().toString());

		table.addCell("Departure City");
		table.addCell(reservation.getFlight().getDepartureCity());

		table.addCell("Departure City");
		table.addCell(reservation.getFlight().getDepartureCity());

		cell = new PdfPCell(new Phrase("Passenger Details"));
		cell.setColspan(2);
		table.addCell(cell);

		table.addCell("First Name");
		table.addCell(reservation.getPassenger().getFirstName());
		table.addCell("Middle Name");
		table.addCell(reservation.getPassenger().getMiddleName());
		table.addCell("Last Name");
		table.addCell(reservation.getPassenger().getLastName());

		table.addCell("Email");
		table.addCell(reservation.getPassenger().getEmail());

		table.addCell("Phone");
		table.addCell(reservation.getPassenger().getPhone());

		return table;
	}
}
