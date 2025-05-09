package bt4;

class CheckingAccount extends BankAccount {
    private static final double WITHDRAW_LIMIT = 1000.0;

    public CheckingAccount(String accountNumber, String ownerName, double balance) {
        super(accountNumber, ownerName, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= WITHDRAW_LIMIT && amount <= balance) {
            balance -= amount;
            log("Rút " + amount + " từ tài khoản " + accountNumber);
        } else {
            log("Rút tiền thất bại (vượt hạn mức hoặc không đủ tiền)");
        }
    }

    @Override
    public double calculateInterest() {
        return 0; // Không có lãi
    }

    @Override
    public void log(String message) {
        System.out.println("[Checking] " + message);
    }
}

