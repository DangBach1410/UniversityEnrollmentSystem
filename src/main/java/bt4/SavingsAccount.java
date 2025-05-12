package bt4;

class SavingsAccount extends BankAccount {
    private static final double interest_rate = 0.03;

    public SavingsAccount(String accountNumber, String ownerName, double balance) {
        super(accountNumber, ownerName, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * interest_rate;
    }

    @Override
    public void log(String message) {
        System.out.println("[Savings] " + message);
    }
}

