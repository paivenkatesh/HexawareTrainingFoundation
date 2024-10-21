package com.ticketbooking.service;

import com.ticketbooking.dao.IEventDao;
import com.ticketbooking.dao.EventDaoImp;
import com.ticketbooking.entity.Event;
import java.sql.SQLException;


public class BookingServiceImp implements IBookingService {
	
	private IEventDao eventDao;
	public BookingServiceImp() {
		this.eventDao = new EventDaoImp();
	}
	
	@Override
	public boolean bookTickets(int eventId, int numTickets) throws SQLException {
		// TODO Auto-generated method stub
		Event event = eventDao.getEventById(eventId);
		
		if (event != null && numTickets <= event.getAvailableSeats()) {
			event.setAvailableSeats(event.getAvailableSeats()-numTickets);
			eventDao.updateEvent(event);
			return true;
		}else if (event != null) {
			System.out.println("Not enough available seats");
			return false;
		}else {
			System.out.println("Event not found.");
			return false;
		}
	}

	@Override
	public boolean bookTicketWithCategory(int eventId, int numTickets, String ticketCategory) throws SQLException {
		// TODO Auto-generated method stub
		Event event = eventDao.getEventById(eventId);

	    if (event != null) {
	        int availableSeats = event.getAvailableSeats();
	        double pricePerTicket = 0;

	        // Fetch price based on ticket category
	        if (ticketCategory.equalsIgnoreCase("Silver")) {
	            pricePerTicket = event.getSilverPrice();
	        } else if (ticketCategory.equalsIgnoreCase("Gold")) {
	            pricePerTicket = event.getGoldPrice();
	        } else if (ticketCategory.equalsIgnoreCase("Diamond")) {
	            pricePerTicket = event.getDiamondPrice();
	        } else {
	            System.out.println("Invalid ticket category. Please choose Silver, Gold, or Diamond.");
	            return false;
	        }

	        // Check if there are enough available seats
	        if (numTickets <= availableSeats) {
	            double totalCost = pricePerTicket * numTickets;
	            event.setAvailableSeats(availableSeats - numTickets); // Reduce available seats
	            eventDao.updateEvent(event);  // Update the event in the database
	            System.out.println("Booking successful! Total cost: $" + totalCost);
	            return true;
	        } else {
	            System.out.println("Not enough available seats.");
	            return false;
	        }
	    } else {
	        System.out.println("Event not found.");
	        return false;
	    }
	}

}
