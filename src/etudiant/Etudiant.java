package etudiant;

public class Etudiant extends Personne{

    protected float moyenne;

    public Etudiant(String prenom) {
        super(prenom);
    }

    protected void reviser() {
        System.out.println(super.prenom + " revise quelque chose.");
    }

}
