package Country;

public class Launcher {
    public static void main(String[] args) throws java.lang.Exception {

        Country c1 = new Country("France");
        Country c2 = new Country("Allemagne");
        Country c3 = new Country("USA");
        Country c4 = new Country("Chine");

        CountryCollection cc = new CountryCollection();


        cc.addCountry(c1);
        cc.addCountry(c2);
        cc.addCountry(c3);
        cc.addCountry(c4);

        cc.sort();
        cc.getCountries();

        ExoException ex1 = new ExoException();
//        ex1.divide(1);
//        ex1.getAgeCap();
//        ex1.login();
//        ex1.quack();

//        ex1.machin();
//
//        ex1.AdresseIP(10, 200, 222, 212);
//        System.out.println(ex1);
        try {
            AdresseIp a = new AdresseIp(333, 2, 3, 4);
        } catch (ExceptionAdrIP e) {
            System.out.println(e);
        }
    }
}
