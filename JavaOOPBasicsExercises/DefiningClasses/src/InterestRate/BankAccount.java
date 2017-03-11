package InterestRate;

public class BankAccount {
    private int id;
    private double balance;
    private static double interestRate = 0.02;

    public static void setInterestRate(double rate) {
        interestRate = rate;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public double getBalance() {
        return this.balance;
    }
}