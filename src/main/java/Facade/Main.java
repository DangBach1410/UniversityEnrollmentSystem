package Facade;

public class Main {
    public static void main(String[] args) {
        TicketBookingFacade bookingFacade = new TicketBookingFacade();

        bookingFacade.bookTicket(
                "Avengers: Endgame",
                "A12",
                120_000,
                "user@example.com"
        );
    }
}
