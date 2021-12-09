package Country;

import java.util.ArrayList;
import java.util.Collections;

public class CountryCollection {

    public ArrayList<Country> countries = new ArrayList<>();

    protected void addCountry(Country country) {
        this.countries.add(country);
    }

    protected void getCountries() {
        if (countries.size() == 0) {
            System.out.println("Liste vide");
        } else {
            System.out.println("La collection créée contient " + countries.size() + " pays !");
            countries.forEach(country -> {
                System.out.println(country.name);
            });
        }
    }

    protected void editCountry (Country country, String countryName) {
        countries.forEach((c) -> {
            if (c == country) {
                c.name = countryName;
            }
        });
    }

    protected void sort() {
        Collections.sort(countries, new CountryComparator());
    }
}
