package western;

public class Story {

    public static void main(String[] args) {

        Cowboy cowboy = new Cowboy("Cowboy");
        Lady lady = new Lady("Lady", "red");
        Bandit bandit = new Bandit("Bandit");
        Barman barman = new Barman("Barman");
        Cowboy clint = new Sheriff("Clint");
        Ripoux ripoux = new Ripoux("rip");
        Indian indian = new Indian("Indian");

        cowboy.simpleIntroduction();
        barman.introduce();
        barman.simpleIntroduction();

//        bandit.kidnaps(lady);
//        indian.scalps(cowboy);
//        indian.scalps(lady);
//        indian.scalps(bandit);
//        indian.scalps(clint);
//        indian.scalps(ripoux);
//
//        System.out.println(indian.nbFeathers);
    }
}
