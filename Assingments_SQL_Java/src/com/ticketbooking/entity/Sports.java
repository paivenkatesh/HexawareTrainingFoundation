package com.ticketbooking.entity;

import java.sql.Time;
import java.sql.Date;

public class Sports extends Event {

	private double silverPrice;
    private double goldPrice;
    private double diamondPrice;

    // Constructor to initialize all attributes, including ticket prices
    public Sports(int eventId, String eventName, Date eventDate, Time eventTime, int venueId, String venueName,
                 int totalSeats, int availableSeats, int bookingId, double silverPrice, double goldPrice, double diamondPrice) {
        super(eventId, eventName, eventDate, eventTime, venueId, venueName, totalSeats, availableSeats, "Sport", bookingId, silverPrice, goldPrice, diamondPrice);
        this.silverPrice = silverPrice;
        this.goldPrice = goldPrice;
        this.diamondPrice = diamondPrice;
    }
	@Override
	public double getTicketPrice(String category) {
		switch (category.toLowerCase()){
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
	public double getTicketPrice() {
		// TODO Auto-generated method stub
		return 0;
	}
	

    

}
