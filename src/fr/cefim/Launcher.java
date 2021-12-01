package fr.cefim;

public class Launcher {
    public static void main(String[] args) {
        Compte compte = new Compte(1, 123);
        Compte quack = new Compte(2, 123);

        Client alexandre = new Client("Alexandre", 123);
        alexandre.ajouterCompte(compte);
        alexandre.ajouterCompte(quack);

        Banque bank = new Banque();
        bank.ajouterClient(alexandre);
        bank.interaction();

    }
}
