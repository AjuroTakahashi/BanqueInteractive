package western;

public class Indian extends Human {

    public int nbFeathers = 0;

    public Indian (String name) {
        super(name, "root juice");
    }

    public Indian (String name, String favoriteDrink) {
        super(name, favoriteDrink);
    }

    @Override
    public void simpleIntroduction() {
        String feathers = " feathers.";
        if (this.nbFeathers == 1 ) {
            feathers = " feather.";
        }
        super.simpleIntroduction();
        says(". And I have " + this.nbFeathers + feathers);
    }

    protected void scalps(Paleface paleface) {
        nbFeathers++;
        paleface.scalp();
    }
}
