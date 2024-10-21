package com.ticketbooking.entity;

public class Venue {
	
	private int venueId;
	private String venueName;
	private String address;
	
	
	public Venue() {
		// TODO Auto-generated constructor stub
	}


	public Venue(int venueId, String venueName, String address) {
		super();
		this.venueId = venueId;
		this.venueName = venueName;
		this.address = address;
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


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	
	//Method to display venue details
	public void displayVenueDetails() {
		System.out.println("Venue Name: " + venueName);
		System.out.println("Address: " + address);
	}
	
}
