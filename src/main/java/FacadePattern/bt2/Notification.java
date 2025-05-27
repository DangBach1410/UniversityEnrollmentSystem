package FacadePattern.bt2;

class Notification {
    public void sendConfirmation(String email, String message) {
        System.out.println("Gửi email đến " + email + ": " + message);
    }
}
