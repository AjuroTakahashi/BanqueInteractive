package fr.cefim;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class Client {
    private String nom;
    private int numero;
    private ArrayList<Compte> comptes = new ArrayList<>();
    private int nbComptes = comptes.size();
    private int totalSolde;

    public Client() {
        nom = "Client";
    }

    public Client(String nomClient, int numeroClient) {
        nom = nomClient;
        numero = numeroClient;
    }

    String getNom() {
        return nom;
    }
    int getNbComptes() {
        return nbComptes;
    }
    int getNumero() { return numero; }

    float getSolde() {
        comptes.forEach((compte) -> totalSolde += compte.getSolde());
        return totalSolde;
    }
    void afficherSolde(Compte compte) {
        System.out.println(compte.getSolde());
    }
    void ajouterCompte(Compte compte) {
        comptes.add(compte);
    }

    Compte getCompte(int compteNb) {
        AtomicReference<Compte> result = new AtomicReference<Compte>();
        comptes.forEach((compte) -> {
            if (compteNb == compte.getNumero()) {
                result.set(compte);
            }
        });

        return result.get();
    }
}
