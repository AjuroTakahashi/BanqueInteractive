package etudiant;

public class Personne {

    protected String prenom;
    protected String cin;

    protected Personne(String prenom) {
        this.prenom = prenom;
    }

    protected void lire() {
        System.out.println(prenom + " est en train de lire.");
    }

}
