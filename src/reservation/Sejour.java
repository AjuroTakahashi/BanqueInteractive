package reservation;

import logement.Logement;
import java.util.Date;

public class Sejour {

    private Date dateArrivee;
    private int nbNuits;
    private Logement logement;
    private int nbVoyageurs;

    public Sejour (Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
        this.dateArrivee = dateArrivee;
        this.nbNuits = nbNuits;
        this.logement = logement;
        this.nbVoyageurs = nbVoyageurs;
    }

    public void afficher() {
        logement.afficher();
        System.out.println("La date d'arrivée est le " + this.dateArrivee + " pour " + this.nbNuits + " nuit(s).");
        System.out.println("Le prix de ce séjour est de " + this.logement.getTarifParNuit() * this.nbNuits + ".");
    }
}
