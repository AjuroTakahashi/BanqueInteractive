package fr.cefim;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Client {
    private String nom;
    private ArrayList<Compte> comptes = new ArrayList<>();
    private int nbComptes = comptes.size();
    float totalSolde;

    public Client() {
        nom = "Client";
    }

    public Client(String nomClient) {
        nom = nomClient;
    }

    String getNom() {
        return nom;
    }
    int getNbComptes() {
        return nbComptes;
    }

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
}
