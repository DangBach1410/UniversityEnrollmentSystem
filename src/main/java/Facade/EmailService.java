package Facade;

public class EmailService {
    public void sendConfirmationEmail(String email) {
        System.out.println("Gửi email xác nhận tới: " + email);
    }
}
