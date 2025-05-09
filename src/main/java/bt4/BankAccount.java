package bt4;

abstract class BankAccount implements Loggable {
    protected String accountNumber;
    protected String ownerName;
    protected double balance;

    public BankAccount(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            log("Nạp " + amount + " vào tài khoản " + accountNumber);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            log("Rút " + amount + " từ tài khoản " + accountNumber);
        } else {
            log("Rút tiền thất bại (không đủ tiền hoặc số tiền không hợp lệ)");
        }
    }

    public double getBalance() {
        return balance;
    }

    public abstract double calculateInterest();

    @Override
    public String toString() {
        return String.format(" %s | %s | Số dư: %.2f | Tiền lãi: %.2f\n",
                accountNumber, ownerName, balance, calculateInterest());
    }
}

