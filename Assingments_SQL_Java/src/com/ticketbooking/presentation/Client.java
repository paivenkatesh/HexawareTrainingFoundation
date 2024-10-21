package com.ticketbooking.presentation;

import com.ticketbooking.service.IBookingService;
import com.ticketbooking.service.BookingServiceImp;
import java.sql.SQLException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        IBookingService bookingService = new BookingServiceImp();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter Event ID to book tickets for (or type 'Exit' to quit):");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("Exit")) {
                System.out.println("Exiting the program. Thank you!");
                break;
            }

            int eventId;
            try {
                eventId = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid Event ID.");
                continue; // Restart the loop
            }

            System.out.println("Enter the number of tickets you want to book:");
            int numTickets;
            try {
                numTickets = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number of tickets.");
                continue; // Restart the loop
            }

            System.out.println("Select booking type:");
            System.out.println("1. Standard Booking (without category)");
            System.out.println("2. Booking with Category (Silver, Gold, Diamond)");
            String bookingType = scanner.nextLine();

            // Execute the appropriate booking method
            try {
                if (bookingType.equals("1")) {
                    if (bookingService.bookTickets(eventId, numTickets)) {
                        System.out.println("Booking successful!");
                    } else {
                        System.out.println("Booking failed.");
                    }
                } else if (bookingType.equals("2")) {
                    System.out.println("Select ticket category (Silver, Gold, Diamond):");
                    String ticketCategory = scanner.nextLine();
                    if (bookingService.bookTicketWithCategory(eventId, numTickets, ticketCategory)) {
                        System.out.println("Booking successful!");
                    } else {
                        System.out.println("Booking failed.");
                    }
                } else {
                    System.out.println("Invalid booking type selected.");
                }
            } catch (SQLException e) {
                System.out.println("Error accessing the database: " + e.getMessage());
            }
        }

        // Close the scanner
        scanner.close();
    }
}
