package western;

public class Lady extends Human implements Paleface {

    private String dressColor = "white";
    private boolean isFree = true;

    public Lady (String name, String dressColor) {
        super(name, "milk");
        this.dressColor = dressColor;
    }

    public Lady(String name, String dressColor, String favoriteDrink) {
        super(name, favoriteDrink);
        this.dressColor = dressColor;
    }

    @Override
    public void simpleIntroduction() {
        says("Miss " + this.getName());
    }

    protected String getDressColor() {
        return this.dressColor;
    }

    protected void isKidnapped() {
        this.isFree = false;
    }

    protected void isFreedBy(Cowboy cowboy) {
        this.isFree = true;
        System.out.println("Thanks " + cowboy.getName() + " for saving me !");
    }

    protected void changeDress(String color) {
        this.dressColor = color;
        System.out.println("Look at my new " + this.dressColor + " dress !");
    }

    @Override
    public void scalp() {
        System.out.println("Ouch my head !");
    }
}
