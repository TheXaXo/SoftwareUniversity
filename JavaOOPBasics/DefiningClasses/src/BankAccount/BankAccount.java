package BankAccount;

public class BankAccount {
    private int id;
    private double balance;

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double sum) {
        this.balance += sum;
    }

    public void withdraw(double sum) {
        if (sum > this.balance) {
            throw new IllegalStateException("Insufficient amount!");
        }

        this.balance -= sum;
    }

    @Override
    public String toString() {
        return Integer.toString(this.id);
    }
}