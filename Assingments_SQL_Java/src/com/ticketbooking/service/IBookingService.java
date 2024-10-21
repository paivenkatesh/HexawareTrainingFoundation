package com.ticketbooking.service;

import java.sql.SQLException;

public interface IBookingService {
	
	boolean bookTickets(int eventId, int numTickets) throws SQLException;
	
	boolean bookTicketWithCategory(int eventId, int numTickets, String ticketCategory) throws SQLException;
}
