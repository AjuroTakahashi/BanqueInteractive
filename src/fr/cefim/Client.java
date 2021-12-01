package fr.cefim;

import com.sun.istack.internal.Nullable;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class Client {
    private String nom;
    private int numero;
    private ArrayList<Compte> comptes = new ArrayList<>();
    private int nbComptes = 0;

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

    int getNumero() { return numero; }

    int getNbComptes() {
        return nbComptes;
    }

    float getTotalSolde() {
        AtomicReference<Float> totalSolde = new AtomicReference<>((float) 0);
        comptes.forEach((compte) -> totalSolde.set(totalSolde.get() + compte.getSolde()));
        return totalSolde.get();
    }

    void afficherTotalSolde() {
        System.out.println(this.getTotalSolde());
    }
    void afficherSolde(Compte compte) {
        System.out.println(compte.getSolde());
    }

    void ajouterCompte(Compte compte) {
        if (comptes.size() == 0) {
            compte.setCourant();
        }
        nbComptes ++;
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

    public @Nullable Compte getCompteCourant() {
        AtomicReference<Compte> compteCourant = null;
        comptes.forEach((Compte compte) -> {
            if (compte.isCourant()) {
                compteCourant.set(compte);
            }
        });
        return compteCourant.get();
    }

    public boolean hasCompteCourant() {
        AtomicBoolean compteCourant = new AtomicBoolean(false);
        comptes.forEach((Compte compte) -> {
            if (compte.isCourant()) {
                compteCourant.set(true);
            }
        });
        return compteCourant.get();
    }

    ArrayList<Compte> getComptes() {
        return this.comptes;
    }
}
