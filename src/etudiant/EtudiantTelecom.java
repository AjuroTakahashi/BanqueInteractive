package etudiant;

public class EtudiantTelecom extends Etudiant{

    protected String option;

    public EtudiantTelecom(String prenom) {
        super(prenom);
    }

    protected void reviserOption() {
        System.out.println(super.prenom + " revise ça : " + this.option);
    }

}
