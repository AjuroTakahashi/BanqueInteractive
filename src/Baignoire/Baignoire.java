package Baignoire;

public class Baignoire implements Runnable {

    public final int capacite;
    public int volume;
    public int volumeFuite;

    public Baignoire(int capacite, int volume, int volumeFuite) {
        this.capacite = capacite;
        this.volume = volume;
        this.volumeFuite = volumeFuite;
    }

    public void fuite() {
        while(true) {
            synchronized (this) {
                int volumeOld = volume;

                if (volume <= volumeFuite) {
                    volume = 0;
                    volumeFuite -= 1;
                    if(volumeFuite < 0) { volumeFuite = 0; }
                } else {
                    volume -= volumeFuite;
                }

                System.out.println("Volume (ça fuit) : " + volumeOld + " -> " + volume + ((volume > volumeOld) ? (" /!/") : ("")));
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
        fuite();
    }
}
