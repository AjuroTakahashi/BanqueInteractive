package western;

public class Ripoux extends Sheriff implements Outlaw {

    private int bounty = 0;

    public Ripoux (String name) {
        super(name, "whisky");
    }

    public Ripoux (String name, String favoriteDrink) {
        super(name, favoriteDrink);
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
}
