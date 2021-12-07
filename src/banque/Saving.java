package banque;

public class Saving extends Account{

    public double interest = 6;

    public Saving (double balance) {
        super(balance);
    }

    protected void calculateInterest() {
        this.balance = this.balance + (this.balance * interest / 100);
        System.out.println("Balance : " + this.balance);
    }
}
