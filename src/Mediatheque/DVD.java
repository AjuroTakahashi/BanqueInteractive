package Mediatheque;

public class DVD extends Media {

    public int zone;

    public DVD(String title, String artist, int zone) {
        super(title, artist);
        this.zone = zone;
    }

    protected boolean readable(int[] zones) {
        boolean readable = false;

        for (int zone : zones) {
            if (zone == this.zone) {
                readable = true;
                break;
            }
        }

        return readable;
    }

}
