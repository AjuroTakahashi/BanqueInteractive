package banque;

public class Paying extends Account {

    public Paying (double balance) {
        super(balance);
    }

    @Override
    protected void withdraw(float value) {
        super.withdraw(value);
        this.balance = this.balance - 5;
    }

    @Override
    protected void deposit(float value) {
        super.deposit(value);
        this.balance = this.balance - 5;
    }
}
