package western;

public class Cowboy extends Human implements Paleface {

    public int popularity = 0;
    private String trait = "vaillant";
    public boolean isFree = true;

    public Cowboy (String name) {
        super(name, "whisky");
    }

    public Cowboy (String name, String favoriteDrink) {
        super(name, favoriteDrink);
    }

    protected void shootsAt(Bandit bandit) {
        System.out.println("The " + this.trait + " shoots at " + bandit.getName() + ". *BANG* Take this rascal !");
        bandit.incarceratedBy(this);
    }

    protected void frees(Lady lady) {
        lady.isFreedBy(this);
        this.popularity++;
        System.out.println("You're free now lady " + lady.getName() + " ! And what a nice " + lady.getDressColor() + " dress");
    }

    @Override
    public void scalp() {
        System.out.println("Ouch my head !");
    }
}
