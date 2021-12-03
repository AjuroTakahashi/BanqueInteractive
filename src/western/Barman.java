package western;

public class Barman extends Human {

    private String barName = "Chez " + this.getName();

    public Barman (String name) {
        super(name, "wine");
    }

    public Barman (String name, String barName) {
        super(name, "wine");
        this.barName = barName;
    }

    public Barman (String name, String barName, String favoriteDrink) {
        super(name, favoriteDrink);
        this.barName = barName;
    }

    @Override
    public void says (String sentence) {
        System.out.println(this.getName() + " says : " + sentence + " Coco.");
    }

    @Override
    public void introduce() {
        super.introduce();
        says("And my bar is " + this.barName + " !");
    }
}
