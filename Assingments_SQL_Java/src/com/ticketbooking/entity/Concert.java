package com.ticketbooking.entity;

import java.sql.Time;
import java.sql.Date;

public class Concert extends Event {
	
	private double silverPrice;
    private double goldPrice;
    private double diamondPrice;

    // Constructor to initialize all attributes, including ticket prices
    public Concert(int eventId, String eventName, Date eventDate, Time eventTime, int venueId, String venueName,
                   int totalSeats, int availableSeats, int bookingId, double silverPrice, double goldPrice, double diamondPrice) {
        super(eventId, eventName, eventDate, eventTime, venueId, venueName, totalSeats, availableSeats, "Concert", bookingId, silverPrice, goldPrice, diamondPrice);
        this.silverPrice = silverPrice;
        this.goldPrice = goldPrice;
        this.diamondPrice = diamondPrice;
    }

	public double getTicketPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

}
