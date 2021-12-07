package banque;

import java.util.concurrent.atomic.AtomicInteger;

public class Account {

    public double balance;
    private static int number = 0;
    private int code = 0;

    public Account () {
        this.balance = 0;
        number++;
        code = number;
    }

    public Account (double balance) {
        this.balance = balance;
        number++;
        code = number;
    }

    protected void withdraw(float value) {
        this.balance = this.balance - value;
    }

    protected void deposit(float value) {
        this.balance = this.balance + value;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", code=" + code +
                '}';
    }
}
