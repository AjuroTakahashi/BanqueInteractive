package Country;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class ExoException {

    public Scanner scanner = new Scanner(System.in);
    public String id = "scott";
    public String password = "tiger";

    public void divide(int number) throws Exception {
        int qqch = 0;
        int zero = 0;
        try {
            qqch = number / zero;
            System.out.println(qqch);
        }
        catch (ArithmeticException e) {
            qqch = number;
            System.out.println("Division par zéro, par 1 effectuée : " + qqch);
        }
    }

    public void ageCapException(int age) throws Exception {
        if (age < 18) {
            System.out.println("Trop jeune. Age donné : " + age );
            throw new Exception();
        } else if (age > 65) {
            System.out.println("Trop vieux. Age donné : " + age);
            throw new Exception();
        }
    }

    public void getAgeCap() {
        System.out.println("Tapez l'âge :");
        int age = scanner.nextInt();
        try {
            ageCapException(age);
        } catch (Exception e) {
            getAgeCap();
        }
    };

    public void login() {
        System.out.println("Identifiant :");
        String id = scanner.next();

        System.out.println("Mot de passe :");
        String password = scanner.next();

        try {
            loginException(id, password);
//            WrongIdException(id);
//            WrongPasswordException(password);
            WrongInputLength(id, password);
            System.out.println("Connexion...");
        } catch (Exception e) {
            login();
        }
    }

    public void loginException(String id, String password) throws Exception {
        if (!Objects.equals(id, this.id) || !Objects.equals(password, this.password)) {
            System.out.println("Identifiant ou mot de passe erroné.");
            throw new Exception();
        }
    }

    public void WrongIdException(String id) throws Exception {
        if (!Objects.equals(id, this.id)) {
            System.out.println("Identifiant erroné");
            throw new Exception();
        }
    }

    public void WrongPasswordException(String password) throws Exception {
        if (!Objects.equals(password, this.password)) {
            System.out.println("Mot de passe erroné.");
            throw new Exception();
        }
    }

    public void WrongInputLength(String id, String password) throws Exception {
        if (id.length() > 10 || password.length() > 10) {
            System.out.println("L'identifiant ou le mot de passe fait plus de 10 caractères.");
            throw new Exception();
        }
    }


    public void quack() {
        int a, b, res;
        Scanner clavier = new Scanner(System.in);
        try {
            a = clavier.nextInt();
            b = clavier.nextInt();
            res = a / b;
            System.out.println("le résultat de " + a + " divisé par " + b + " est " + res);
        } catch (ArithmeticException e) {
            System.out.println("oop ! un problème dans la division ");
            System.out.println("le message officiel est " + e.getMessage());
        } catch (InputMismatchException i) {
            System.out.println("C'est pas un nombre ça.");
        } finally {
            System.out.println("le bloc finally sera toujours exécuté") ;
            System.out.println("et c'est là que l'on fermera par exemple les fichiers") ;
        }
        System.out.println("Fin du programme");
    }

    public void machin() {
        int[] tab = null;
        try {
            System.out.println(tab[2]);
        } catch (NullPointerException e) {
            System.out.println("Y'a rien dans l'tableau.");
        }
    }

//    public void bidule() {
//        int[] adr = new int[]{267, 277, 1929, 10)};
//    }
//
//    private int[] octet;
//
//    public void AdresseIP(int o1, int o2, int o3, int o4) {
//        octet = new int[]{o1, o2, o3, o4};
//    }

//    public String toString() {
//        return octet[0] + "." + octet[1] + "." + octet[2] + "." + octet[3];
//    }

    public class ExceptionAdrIP extends Exception {
        public ExceptionAdrIP(String s) {
            super(s);
        }
    }


    private int[] octet;

    public void AdresseIP(int o1, int o2, int o3, int o4) throws ExceptionAdrIP {

        if (o1 < 0 || o1 > 255) {
            throw new ExceptionAdrIP("valeur incorrecte pour le premier octet");
        }

        if (o2 < 0 || o2 > 255) {
            throw new ExceptionAdrIP("valeur incorrecte pour le deuxième octet");
        }

        if (o3 < 0 || o3 > 255) {
            throw new ExceptionAdrIP("valeur incorrecte pour le troisième octet");
        }

        if (o4 < 0 || o4 > 255) {
            throw new ExceptionAdrIP("valeur incorrecte pour le quatrième octet");
        }

        octet = new int[]{o1, o2, o3, o4};
    }

    public String toString() {
        return octet[0] + "." + octet[1] + "." + octet[2] + "." + octet[3];
    }

}
