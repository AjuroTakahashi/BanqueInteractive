package western;

public interface Outlaw extends Paleface {
    public void arrests(Cowboy cowboy);

    public void kidnaps(Lady lady);

    public float getBounty();

    public String simpleIntroduction();

    public String getName();

    public void jailed();
}
