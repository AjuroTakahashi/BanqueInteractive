package western;

public class Sheriff extends Cowboy {

    public int nbArrested = 0;

    public Sheriff (String name) {
        super(name, "wine");
    }

    public Sheriff (String name, String favoriteDrink) {
        super(name, favoriteDrink);
    }

    @Override
    public void introduce() {
        super.introduce();
        String bandit = " bandits.";
        if (nbArrested == 1) {
            bandit = " bandit.";
        }
        System.out.println("And I arrested " + nbArrested + bandit);
    }

    @Override
    public void simpleIntroduction() {
        says("Sheriff" + this.getName());
    }

    protected void arrests(Outlaw outlaw) {
        System.out.println("In the name of the law I arrest you !");
        outlaw.jailed();
    }

    protected void putBounty(Outlaw outlaw) {
        System.out.println(outlaw.getBounty() + " $ for whoever brings " + outlaw.getName() + " dead or alive !");
    }
}
