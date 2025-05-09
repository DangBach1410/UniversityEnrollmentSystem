package bt4;

import java.util.HashMap;

class Bank {
    private static HashMap<String, BankAccount> accounts = new HashMap<>();

    public static void main(String[] args) {
        Bank bank = new Bank();

        addAccount(new SavingsAccount("SA001", "Nguyen Van A", 5000));
        addAccount(new CheckingAccount("CA001", "Le Thi B", 3000));
        addAccount(new SavingsAccount("SA002", "Tran Van C", 10000));
        addAccount(new CheckingAccount("CA002", "Pham Thi D", 800));

        deposit("CA001", 1000);
        withdraw("SA001", 2000);
        withdraw("CA002", 1500); // vượt hạn mức

        System.out.println("\nThông tin tài khoản:");
        showAllAccounts();

        System.out.println("\nTính lãi tất cả tài khoản:");
        showAllInterests();

        System.out.printf("\nTổng tiền hệ thống: %.2f\n", bank.getTotalBalance());
    }

    public static void addAccount(BankAccount account) {
        accounts.put(account.accountNumber, account);
        account.log("Tài khoản đã được thêm vào hệ thống.");
    }

    public static void deposit(String accountNumber, double amount) {
        BankAccount acc = accounts.get(accountNumber);
        if (acc != null) acc.deposit(amount);
        else System.out.println("Không tìm thấy tài khoản.");
    }

    public static void withdraw(String accountNumber, double amount) {
        BankAccount acc = accounts.get(accountNumber);
        if (acc != null) acc.withdraw(amount);
        else System.out.println("Không tìm thấy tài khoản.");
    }

    public double getTotalBalance() {
        double total = 0;
        for (BankAccount acc : accounts.values()) {
            total += acc.getBalance();
        }
        return total;
    }

    public static void showAllAccounts() {
        for (BankAccount acc : accounts.values()) {
            System.out.println(acc);;
        }
    }

    public static void showAllInterests() {
        for (BankAccount acc : accounts.values()) {
            System.out.printf("Tài khoản %s nhận lãi: %.2f\n",
                    acc.accountNumber, acc.calculateInterest());
        }
    }
}
