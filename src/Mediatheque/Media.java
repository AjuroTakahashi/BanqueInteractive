package Mediatheque;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Media {

    public String title;
    public String artist;
    public ArrayList<Integer> ratings = new ArrayList<>();

    public Media(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    protected void rate(int rating) {
        ratings.add(rating);
    }

    protected int getRating() {
        if (ratings.size() > 0) {

            AtomicInteger total = new AtomicInteger();
            AtomicInteger i = new AtomicInteger();
            ratings.forEach((rating) -> {
                total.addAndGet(rating);
                i.getAndIncrement();
            });

            return total.get() / i.get();
        } else {
            return 0;
        }
    }

    protected String getCriteria(String criteria) {

        switch (criteria) {
            case ("artist") :
                return this.artist;
            case ("title") :
                return this.title;
            case ("media") :
                return this.getClass().getSimpleName();
            default:
                return "raté";
        }
    }

    @Override
    public String toString() {
        return "Media{" +
                "title = '" + title + '\'' +
                ", artist = '" + artist + '\'' +
                ", rating = " + getRating() +
                '}';
    }
}
