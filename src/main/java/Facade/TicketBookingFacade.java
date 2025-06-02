package Facade;

public class TicketBookingFacade {
    private MovieSelector movieSelector;
    private SeatSelector seatSelector;
    private PaymentSystem paymentSystem;
    private EmailService emailService;

    public TicketBookingFacade() {
        this.movieSelector = new MovieSelector();
        this.seatSelector = new SeatSelector();
        this.paymentSystem = new PaymentSystem();
        this.emailService = new EmailService();
    }

    public void bookTicket(String movie, String seat, double amount, String email) {
        System.out.println("=== Bắt đầu quy trình đặt vé ===");
        movieSelector.selectMovie(movie);
        seatSelector.selectSeat(seat);
        paymentSystem.makePayment(amount);
        emailService.sendConfirmationEmail(email);
        System.out.println("=== Đặt vé thành công ===");
    }
}

