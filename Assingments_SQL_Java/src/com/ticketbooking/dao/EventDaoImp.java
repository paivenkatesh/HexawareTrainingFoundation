package com.ticketbooking.dao;

import com.ticketbooking.util.DBConnectionUtil;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import com.ticketbooking.entity.Event;

public class EventDaoImp implements IEventDao {
	
	private Connection connection;
	
	public EventDaoImp() {
		try {
		this.connection = DBConnectionUtil.getConnection();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Event getEventById(int eventId) {
		// TODO Auto-generated method stub
		Event event = null;
        String query = "SELECT * FROM Event WHERE event_id = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, eventId);
            ResultSet rs = statement.executeQuery();
            
            if (rs.next()) {
                	event = new Event(
                    rs.getInt("event_id"),
                    rs.getString("event_name"),
                    rs.getDate("event_date"),
                    rs.getTime("event_time"),
                    rs.getInt("venue_id"),
                    rs.getInt("total_seats"),
                    rs.getInt("available_seats"),
                    rs.getString("event_type"),
                    rs.getInt("booking_id"),
                    rs.getDouble("silver_price"),
                    rs.getDouble("gold_price"),
                    rs.getDouble("diamond_price")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return event;
	}

	@Override
	public List<Event> getAllEvents() {
		// TODO Auto-generated method stub
		List<Event> events = new ArrayList<>();
        String query = "SELECT * FROM Event";
        
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(query);
            
            while (rs.next()) {
                Event event = new Event(
                    rs.getInt("event_id"),
                    rs.getString("event_name"),
                    rs.getDate("event_date"),
                    rs.getTime("event_time"),
                    rs.getInt("venue_id"),
                    rs.getInt("total_seats"),
                    rs.getInt("available_seats"),
                    rs.getString("event_type"),
                    rs.getInt("booking_id"),
                    rs.getDouble("silver_price"),
                    rs.getDouble("gold_price"),
                    rs.getDouble("diamond_price")
                );
                events.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return events;
	}

	@Override
	public void saveEvent(Event event) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO Event (event_name, event_date, event_time, venue_id, total_seats, available_seats, event_type, booking_id, silver_price, gold_price, diamond_price) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, event.getEventName());
            statement.setDate(2, new java.sql.Date(event.getEventDate().getTime()));
            statement.setTime(3, event.getEventTime());
            statement.setInt(4, event.getVenueId());
            statement.setInt(5, event.getTotalSeats());
            statement.setInt(6, event.getAvailableSeats());
            statement.setString(7, event.getEventType());
            statement.setInt(8, event.getBookingId());
            statement.setDouble(9, event.getSilverPrice());
            statement.setDouble(10, event.getGoldPrice());
            statement.setDouble(11, event.getDiamondPrice());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		

	}

	@Override
	public void updateEvent(Event event) {
		// TODO Auto-generated method stub
String query = "UPDATE Event SET event_name = ?, event_date = ?, event_time = ?, venue_id = ?, total_seats = ?, available_seats = ?, event_type = ?, booking_id = ?, silver_price = ?, gold_price = ?, diamond_price = ? WHERE event_id = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, event.getEventName());
            statement.setDate(2, new java.sql.Date(event.getEventDate().getTime()));
            statement.setTime(3, event.getEventTime());
            statement.setInt(4, event.getVenueId());
            statement.setInt(5, event.getTotalSeats());
            statement.setInt(6, event.getAvailableSeats());
            statement.setString(7, event.getEventType());
            statement.setInt(8, event.getBookingId());
            statement.setDouble(9, event.getSilverPrice());
            statement.setDouble(10, event.getGoldPrice());
            statement.setDouble(11, event.getDiamondPrice());
            statement.setInt(12, event.getEventId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

	}

	@Override
	public void deleteEvent(int eventId) {
		// TODO Auto-generated method stub
String query = "DELETE FROM Event WHERE event_id = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, eventId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}


