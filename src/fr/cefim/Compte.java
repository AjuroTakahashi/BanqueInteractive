package fr.cefim;

public class Compte {

    float solde = 200;
    int numero = 1;

    public Compte (int numero, float solde) {
        this.numero = numero;
        this.solde = solde;
    }

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

    int getNumero() {
        return this.numero;
    }

    void virer(float valeur, Compte destinataire) {
        solde =- valeur;
        destinataire.depot(valeur);
    }
}
