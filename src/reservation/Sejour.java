package reservation;

import logement.Logement;

import java.text.DateFormat;
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

    public String dateFormat() {
        DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
                DateFormat.SHORT,
                DateFormat.SHORT);
        return shortDateFormat.format(this.dateArrivee);
    }

    public void afficher() {
        logement.afficher();
        System.out.println("La date d'arrivée est le " + dateFormat() + " pour " + this.nbNuits + " nuit(s).");
        System.out.println("Le prix de ce séjour est de " + this.logement.getTarifParNuit() * this.nbNuits + ".");
    }
}
