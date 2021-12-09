package Country;

public class Country {

    public String name;

    public Country(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
