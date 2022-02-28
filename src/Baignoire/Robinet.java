package Baignoire;

public class Robinet implements Runnable {

    public Baignoire baignoire;
    public int volumeDebite;

    public Robinet (Baignoire baignoire, int volumeDebite) {
        this.baignoire = baignoire;
        this.volumeDebite = volumeDebite;
    }

    public void debite() {
        while (true) {
            synchronized (baignoire) {
                int volumeOld = baignoire.volume;

                baignoire.volume += volumeDebite;
                if (baignoire.volume >= baignoire.capacite) {
                    baignoire.volume = baignoire.capacite;

                    System.out.println("Rempli");
                }

                System.out.println("Volume : " + volumeOld + " -> " + baignoire.volume + ((baignoire.volume < volumeOld) ? (" /!/") : ("")));
            }

            try {
                Thread.sleep(500);
            } catch(Exception e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void run() {
        debite();
    }
}
