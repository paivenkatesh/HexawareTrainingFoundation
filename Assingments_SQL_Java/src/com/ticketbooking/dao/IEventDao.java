package com.ticketbooking.dao;

import com.ticketbooking.entity.Event;
import java.util.List;

public interface IEventDao {
	
	Event getEventById(int eventId);
	List<Event> getAllEvents();
	void saveEvent(Event event);
	void updateEvent(Event event);
	void deleteEvent(int eventId);
}
