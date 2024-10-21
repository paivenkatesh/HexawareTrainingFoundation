package com.ticketbooking.entity;

import java.sql.Time;
import java.sql.Date;
import java.util.*;


public abstract class Event {
	
	private int eventId;
	private String eventName;
	private Date eventDate;
	private Time eventTime;
	private String venueName;
	private int venueId;
	private int totalSeats;
	private int availableSeats;
	private String eventType;
	private int bookingId;
	protected double silverPrice;
	protected double goldPrice;
	protected double diamondPrice;
	
	
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Event(int eventId, String eventName, Date eventDate, Time eventTime, int venueId, String venueName, int totalSeats,
			int availableSeats, String eventType, int bookingId, double silverPrice, double goldPrice,
			double diamondPrice) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.eventTime = eventTime;
		this.venueId = venueId;
		this.venueName = venueName;
		this.totalSeats = totalSeats;
		this.availableSeats = availableSeats;
		this.eventType = eventType;
		this.bookingId = bookingId;
		this.silverPrice = silverPrice;
		this.goldPrice = goldPrice;
		this.diamondPrice = diamondPrice;
	}


	public int getEventId() {
		return eventId;
	}


	public void setEventId(int eventId) {
		this.eventId = eventId;
	}


	public String getEventName() {
		return eventName;
	}


	public void setEventName(String eventName) {
		this.eventName = eventName;
	}


	public Date getEventDate() {
		return eventDate;
	}


	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}


	public Time getEventTime() {
		return eventTime;
	}


	public void setEventTime(Time eventTime) {
		this.eventTime = eventTime;
	}


	public int getVenueId() {
		return venueId;
	}


	public void setVenueId(int venueId) {
		this.venueId = venueId;
	}
	
	


	public String getVenueName() {
		return venueName;
	}


	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}


	public int getTotalSeats() {
		return totalSeats;
	}


	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}


	public int getAvailableSeats() {
		return availableSeats;
	}


	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}


	public String getEventType() {
		return eventType;
	}


	public void setEventType(String eventType) {
		this.eventType = eventType;
	}


	public int getBookingId() {
		return bookingId;
	}


	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}


	public double getSilverPrice() {
		return silverPrice;
	}


	public void setSilverPrice(double silverPrice) {
		this.silverPrice = silverPrice;
	}


	public double getGoldPrice() {
		return goldPrice;
	}


	public void setGoldPrice(double goldPrice) {
		this.goldPrice = goldPrice;
	}


	public double getDiamondPrice() {
		return diamondPrice;
	}


	public void setDiamondPrice(double diamondPrice) {
		this.diamondPrice = diamondPrice;
	}
	
	public void displayEventDetails() {
        System.out.println("Event Name: " + eventName);
        System.out.println("Event Date: " + eventDate);
        System.out.println("Event Time: " + eventTime);
        System.out.println("Venue Name: " + venueName);
        System.out.println("Total Seats: " + totalSeats);
        System.out.println("Available Seats: " + availableSeats);
        System.out.println("Event Type: " + eventType);
        System.out.println("Silver Price: Rs" + silverPrice);
        System.out.println("Gold Price: Rs" + goldPrice);
        System.out.println("Diamond Price: Rs" + diamondPrice);
    }
	
	// Method to calculate total revenue based on the number of tickets sold
    public double calculateTotalRevenue(int ticketsSold) {
        return ticketsSold * silverPrice;  // Assume only silver for revenue calculation
    }

    // Method to return the number of booked tickets
    public int getBookedNoOfTickets() {
        return totalSeats - availableSeats;
    }

    // Method to book tickets for an event
    public boolean bookTickets(int numTickets) {
        if (numTickets <= availableSeats) {
            availableSeats -= numTickets;  // Reduce available seats
            return true;  // Booking successful
        } else {
            System.out.println("Not enough available seats.");
            return false;  // Booking failed
        }
    }

    // Method to cancel booking and update available seats
    public boolean cancelBooking(int numTickets) {
        availableSeats += numTickets;  // Increase available seats
        return true;  // Cancellation successful
    }

    // Additional methods to get prices based on category
    public double getTicketPrice(String category) {
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
