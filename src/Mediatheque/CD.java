package Mediatheque;

public class CD extends Media{

    public String format;

    public CD(String title, String artist, String format) {
        super(title, artist);
        this.format = format;
    }

    @Override
    public String toString() {
        return "Media{" +
                "name = '" + title + '\'' +
                ", artist = '" + artist + '\'' +
                ", rating = " + getRating() +
                ", format = " + format +
                '}';
    }
}
