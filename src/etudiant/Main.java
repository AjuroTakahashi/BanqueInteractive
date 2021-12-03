package etudiant;

public class Main {

    public static void main (String[] args) {
        Personne personne1 = new Etudiant("moi");
        Personne personne2 = new EtudiantTelecom("pasmoi");

        Personne[] personnes = new Personne[2];
        personnes[0] = personne1;
        personnes[1] = personne2;

        for (int i = 0; i < personnes.length; i++){
            personnes[i].lire();
        }

        Etudiant etudiant = (Etudiant)personne1;
        etudiant.reviser();

        EtudiantTelecom tele = (EtudiantTelecom) personne2;
        tele.reviserOption();

    }
}
