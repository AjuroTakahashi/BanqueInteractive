package utilisateur;

public class Personne {

    private String prenom;
    private String nom;
    private int age;

    public Personne (String prenom, String nom, int age) {
        this.prenom = prenom;
        this.nom = nom;
        this.age = age;
    }

    public void afficher() {
        System.out.println(this.prenom + " " +  this.nom + " (" + this.age + " ans)");
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }
}
