package fr.cefim;

public class Launcher {
    public static void main(String[] args) {
        Compte compte = new Compte(1, -140);
        Compte quack = new Compte(2, 130);
        quack.virer(10, compte);

        Client alexandre = new Client("Alexandre", 123);
        alexandre.ajouterCompte(compte);
        alexandre.ajouterCompte(quack);

        Banque bank = new Banque();
        bank.ajouterClient(alexandre);
        bank.renflouer(alexandre, compte);
//        bank.interaction();
    }
}
