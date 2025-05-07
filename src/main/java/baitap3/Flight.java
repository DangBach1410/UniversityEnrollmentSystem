package baitap3;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Flight {
    private String flightId;
    private String origin;
    private String destination;
    private LocalDateTime departureTime;
    private int capacity;
    private List<Booking> bookings = new ArrayList<>();

    public Flight(String flightId, String origin, String destination, LocalDateTime departureTime, int capacity) {
        this.flightId = flightId;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.capacity = capacity;
    }

    public String getFlightId() { return flightId; }
    public String getOrigin() { return origin; }
    public String getDestination() { return destination; }
    public LocalDateTime getDepartureTime() { return departureTime; }
    public int getCapacity() { return capacity; }
    public List<Booking> getBookings() { return bookings; }

    public boolean isFull() {
        return bookings.size() >= capacity;
    }

    public boolean hasPassenger(Passenger p) {
        return bookings.stream().anyMatch(b -> b.getPassenger().getId().equals(p.getId()));
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    @Override
    public String toString() {
        return flightId + " from " + origin + " to " + destination + " at " + departureTime;
    }
}

