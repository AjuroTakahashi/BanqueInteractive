package reservation;

import utilisateur.Personne;
import java.util.Date;

public class Reservation {

    private int identifiant;
    private Sejour sejour;
    private Personne voyageur;
    private boolean estValidee;
    private Date dateDeReservation;

    public Reservation (int identifiant, Sejour sejour, Personne voyageur, boolean estValidee, Date dateDeReservation) {
        this.identifiant = identifiant;
        this.sejour = sejour;
        this.voyageur = voyageur;
        this.estValidee = estValidee;
        this.dateDeReservation = dateDeReservation;
    }

    public void afficher() {
        System.out.println("Le voyageur :");
        voyageur.afficher();
        System.out.println("A fait une réservation chez : ");
        sejour.afficher();
    }
}
