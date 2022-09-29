package com.bharath.flightReservation.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class Reservation extends AbstractEntity {

	private Boolean checkedIn;
	private int numberOfBags;
	@OneToOne
	private Passenger passenger;
	@OneToOne
	private Flight flight;
	@CreationTimestamp
	private Date createdDate;
	@UpdateTimestamp
	private Date updatedDate;

}
