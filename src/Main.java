import Baignoire.Baignoire;
import Baignoire.Robinet;

public class Main{
    public static void main(String[] args) {
        Baignoire baignoire = new Baignoire(100, 5, 18);
        Robinet robinet = new Robinet(baignoire, 13);

        Thread threadBaignoire = new Thread(baignoire);
        Thread threadRobinet = new Thread(robinet);
        threadBaignoire.start();

        try {
            Thread.sleep(250);
        } catch(Exception e) {
            e.printStackTrace();
        }

        threadRobinet.start();
    }
}
