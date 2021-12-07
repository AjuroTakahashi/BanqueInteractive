package banque;

public class Launcher {

    public static void main (String[] args) {

        Account account = new Account(100);
        Saving saving = new Saving(200);
        Paying paying = new Paying(50);
        System.out.println(account);
        System.out.println(saving);

//        account.deposit(10);
//        saving.deposit(10);
//        paying.deposit(10);
//
//        account.withdraw(10);
//        saving.withdraw(10);
//        paying.withdraw(10);
//
//        saving.calculateInterest();
//
//        System.out.println(account.balance);
//        System.out.println(saving.balance);
//        System.out.println(paying.balance);

    }
}
