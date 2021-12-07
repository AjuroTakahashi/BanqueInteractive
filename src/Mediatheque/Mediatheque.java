package Mediatheque;

import java.util.ArrayList;
import java.util.Objects;

public class Mediatheque {

    ArrayList<Media> media = new ArrayList<>();

    public Mediatheque() {
    }

    protected void add(Media media) {
        this.media.add(media);
    }

    protected ArrayList filter(String criteria, String value) {

        ArrayList<Media> result = new ArrayList<>();

        media.forEach((medium) -> {
            if (Objects.equals(medium.getCriteria(criteria), value)) {
                result.add(medium);
            }
        });

        return result;
    }

}
