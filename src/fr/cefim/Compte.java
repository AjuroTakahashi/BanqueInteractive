package fr.cefim;

public class Compte {

    float solde = 200;
    int numero = 1;
    boolean courant = false;

    public Compte (int numero, float solde) {
        this.numero = numero;
        this.solde = solde;
    }

    void setCourant() {
        this.courant = true;
    }

    boolean isCourant() {
        return this.courant;
    }

    void depot(float valeur) {
        this.solde += valeur;
    }

    void retrait(float valeur) {
        this.solde -= valeur;
    }

    float getSolde() {
        return this.solde;
    }

    void afficherSolde() {
        System.out.println(this.solde);
    }

    int getNumero() {
        return this.numero;
    }

    void virer(float valeur, Compte destinataire) {
        this.solde = this.solde - valeur;
        destinataire.depot(valeur);
    }
}
