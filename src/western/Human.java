package western;

public class Human {

    private String name;
    private String favoriteDrink = "water";

    public Human (String name, String favoriteDrink) {
        this.name = name;
        this.favoriteDrink = favoriteDrink;
    }

    public void says(String text) {
        System.out.println(this.name + " says : " + text);
    }

    public void introduce() {
        this.says("Hi, my name is " + this.name + " and my favorite drink is " + this.favoriteDrink);
    }

    public void drink() {
        this.says("What a nice glass of " + this.favoriteDrink + " ! *SLURP*");
    }

    public String getName() {
        return this.name;
    }

    public void simpleIntroduction() {
        says(this.name);
    }
}
