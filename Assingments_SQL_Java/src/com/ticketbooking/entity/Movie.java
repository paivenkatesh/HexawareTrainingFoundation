package com.ticketbooking.entity;

import java.sql.Time;
import java.sql.Date;


public class Movie extends Event {
	private double silverPrice;
	private double goldPrice;
	private double diamondPrice;
	
	public Movie(int eventId, String eventName, Date eventDate, Time eventTime, int venueId, String venueName,
            int totalSeats, int availableSeats, int bookingId, double silverPrice, double goldPrice, double diamondPrice ) {
		super(eventId, eventName, eventDate, eventTime, venueId, venueName, totalSeats, availableSeats, "Movie", bookingId, silverPrice, goldPrice, diamondPrice);
        this.silverPrice = silverPrice;
        this.goldPrice = goldPrice;
        this.diamondPrice = diamondPrice;
        
	}
	@Override
	public double getTicketPrice(String category) {
		// TODO Auto-generated method stub
		switch (category.toLowerCase()) {
        case "silver":
            return silverPrice;
        case "gold":
            return goldPrice;
        case "diamond":
            return diamondPrice;
        default:
            throw new IllegalArgumentException("Invalid ticket category");
		}
	}
	
}
