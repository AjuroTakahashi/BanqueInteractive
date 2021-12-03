package western;

public class LadyBandit extends Lady implements Outlaw {

    private String dressColor = "white";
    private boolean isFree = true;
    private float bounty = 0;

    public LadyBandit (String name, String dressColor) {
        super(name, "milk");
        this.dressColor = dressColor;
    }

    public LadyBandit (String name, String dressColor, String favoriteDrink) {
        super(name, favoriteDrink);
        this.dressColor = dressColor;
    }

    @Override
    public void arrests(Cowboy cowboy) {
        cowboy.isFree = false;
        System.out.println("I got you now " + cowboy.getName());
    }

    @Override
    public void kidnaps(Lady lady) {
        lady.isKidnapped();
        System.out.println("Ha ! You're mine now " + lady.getName() + " !");
    }

    @Override
    public float getBounty() {
        return this.bounty;
    }

    @Override
    public void jailed() {
        this.isFree = false;
    }

    @Override
    public void scalp() {
        System.out.println("Ouch my head !");
    }
}
