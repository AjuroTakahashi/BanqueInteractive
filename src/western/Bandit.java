package western;

public class Bandit extends Human implements Outlaw {

    private String look = "mean";
    public int nbKidnapped = 0;
    public float bounty = 100;
    private boolean inJail = false;

    public Bandit(String name) {
        super(name, "Tord-Boyaux");
    }

    public Bandit(String name, String favoriteDrink) {
        super(name, favoriteDrink);
    }

    @Override
    public void simpleIntroduction() {
        says(this.getName() + " the " + this.look);
    }

    protected void extendedIntroduction() {
        this.introduce();
        String lady = " ladies.";
        if (this.nbKidnapped == 1 ) {
            lady = " lady.";
        }
        System.out.println("I look " + this.look + " and I already abducted " + this.nbKidnapped + lady);
        System.out.println("My bounty is at " + this.bounty + " dollars !");
    }

    @Override
    public void arrests(Cowboy cowboy) {
        cowboy.isFree = false;
        System.out.println("I got you now " + cowboy.getName());
    }

    @Override
    public void kidnaps(Lady lady) {
        lady.isKidnapped();
        this.nbKidnapped++;
        System.out.println("Ha ! You're mine now " + lady.getName() + " !");
    }

    @Override
    public float getBounty() {
        return this.bounty;
    }

    protected void incarceratedBy(Cowboy cowboy) {
        this.inJail = true;
        System.out.println("Damn, I'm caught. You got me " + cowboy.getName() + ".");
        System.out.println(this.getName() + " had a " + this.bounty + " dollars bounty.");
    }

    @Override
    public void jailed() {
        this.inJail = true;
    }

    @Override
    public void scalp() {
        System.out.println("Ouch my head !");
    }
}
