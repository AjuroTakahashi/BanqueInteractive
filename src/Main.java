import logement.Logement;
import reservation.Reservation;
import reservation.Sejour;
import utilisateur.Personne;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Personne p = new Personne("Alann", "Dupont", 21);
        Personne p1 = new Personne("Machin", "chose", 32);
//        p.afficher();
        Logement l = new Logement(p, 100, "5 rue Dupont", 120, 5);
//        l.afficher();
        Sejour s = new Sejour(new Date(), 5, l, 3);
//        s.afficher();
        Reservation r = new Reservation(12, s, p1, true, new Date());
        r.afficher();

    }
}
