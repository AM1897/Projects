package bank;
public class Account {
    private double balance;
    public String accountNumber;

    public Account(double initialBalance, String accountNumber) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance must be non-negative");
        }
        this.balance = initialBalance;
        this.accountNumber = accountNumber;
    }
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdraw amount must be positive");}
        if (amount > this.balance) {
            throw new IllegalArgumentException("Insufficient funds");}
        this.balance -= amount;
    }
    public double getBalance() {
        return this.balance;
    }
    public String getAccountNumber() {
        return this.accountNumber;

    }

}