package baitap3;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class FlightSystem {
    private HashMap<String, Flight> flights = new HashMap<>();
    private HashMap<String, Passenger> passengers = new HashMap<>();

    public static void main(String[] args) {
        FlightSystem system = new FlightSystem();

        // Thêm hành khách
        system.addPassenger(new Passenger("P1", "Alice"));
        system.addPassenger(new Passenger("P2", "Bob"));

        // Thêm chuyến bay
        system.addFlight(new Flight("F1", "Hà Nội", "TP.HCM", LocalDateTime.now().plusHours(12), 2));
        system.addFlight(new Flight("F2", "Hà Nội", "TP.HCM", LocalDateTime.now().plusDays(2), 2));
        system.addFlight(new Flight("F3", "Hà Nội", "Đà Nẵng", LocalDateTime.now().plusDays(1), 1));

        // Đặt vé
        system.bookFlight("P1", "F1");
        system.bookFlight("P1", "F2");
        system.bookFlight("P2", "F2");

        // In thông tin
        system.printFlightsOfPassenger("P1");
        system.printPassengersOnFlight("F2");

        System.out.println("Flight with most bookings: " + system.findMostBookedFlight());
        System.out.println("Passenger with most flights: " + system.findTopPassenger());

        system.printHanoiToHCMFlightsInNext3Days();
    }
    public void addFlight(Flight flight) {
        flights.put(flight.getFlightId(), flight);
    }

    public void addPassenger(Passenger passenger) {
        passengers.put(passenger.getId(), passenger);
    }

    public boolean bookFlight(String passengerId, String flightId) {
        Passenger p = passengers.get(passengerId);
        Flight f = flights.get(flightId);

        if (p != null && f != null && !f.isFull() && !f.hasPassenger(p)) {
            Booking booking = new Booking(p, f, LocalDateTime.now());
            f.addBooking(booking);
            return true;
        }
        return false;
    }

    public void printFlightsOfPassenger(String passengerId) {
        System.out.println("Flights for passenger " + passengerId + ":");
        flights.values().forEach(f -> {
            if (f.hasPassenger(passengers.get(passengerId))) {
                System.out.println(f);
            }
        });
    }

    public void printPassengersOnFlight(String flightId) {
        Flight f = flights.get(flightId);
        if (f != null) {
            System.out.println("Passengers on flight " + flightId + ":");
            f.getBookings().forEach(b -> System.out.println(b.getPassenger()));
        }
    }

    public Flight findMostBookedFlight() {
        return flights.values().stream()
                .max(Comparator.comparingInt(f -> f.getBookings().size()))
                .orElse(null);
    }

    public Passenger findTopPassenger() {
        HashMap<String, Integer> count = new HashMap<>();
        for (Flight f : flights.values()) {
            for (Booking b : f.getBookings()) {
                count.put(b.getPassenger().getId(), count.getOrDefault(b.getPassenger().getId(), 0) + 1);
            }
        }
        return count.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(e -> passengers.get(e.getKey()))
                .orElse(null);
    }

    public void printHanoiToHCMFlightsInNext3Days() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime threeDaysLater = now.plusDays(3);

        List<Flight> result = flights.values().stream()
                .filter(f -> f.getOrigin().equalsIgnoreCase("Hà Nội") &&
                        f.getDestination().equalsIgnoreCase("TP.HCM") &&
                        f.getDepartureTime().isAfter(now) &&
                        f.getDepartureTime().isBefore(threeDaysLater))
                .sorted(Comparator.comparing(Flight::getDepartureTime))
                .collect(Collectors.toList());

        System.out.println("Flights from Hà Nội to TP.HCM in next 3 days:");
        result.forEach(System.out::println);
    }
}

