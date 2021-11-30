package fr.cefim;

public class Compte {

    float solde = 200;


    void depot(float valeur) {
        solde += valeur;
    }
    void retrait(float valeur) {
        solde -= valeur;
    }
    float getSolde() {
        return solde;
    }
    void afficherSolde() {
        System.out.println(solde);
    }
    void virer(float valeur, Compte destinataire) {

    }
}
