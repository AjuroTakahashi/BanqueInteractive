package western;

public class Human {

    private String name;
    private String favoriteDrink = "water";

    public Human (String name, String favoriteDrink) {
        this.name = name;
        this.favoriteDrink = favoriteDrink;
    }

    public void speak() {
        System.out.println(this.name + " is speaking.");
    }

    public void introduce() {
        System.out.println("Hi, my name is " + this.name + " and my favorite drink is " + this.favoriteDrink);
    }

    public void drink() {
        System.out.println("What a nice glass of " + this.favoriteDrink + " ! *SLURP*");
    }

    public String getName() {
        return this.name;
    }

    public String simpleIntroduction() {
        return this.name;
    }
}
