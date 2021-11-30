package fr.cefim;

/**
 * Le commentaire de la fonction
 */
public class Launcher {
        public static void main(String[] args) {
                Compte compte = new Compte();
                System.out.println(compte.getSolde());

                Client nouveauClient = new Client("Alexandre");

        }
}
