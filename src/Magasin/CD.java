package Magasin;

import java.util.ArrayList;
import java.util.Collections;

public class CD extends Product {

    public String author;
    public String interpreter;
    public ArrayList<String> songs = new ArrayList<>();

    public CD (String name, double priceBuy, double priceSold, String author, String interpreter, ArrayList<String> songs) {
        super(name, priceBuy, priceSold);
        this.author = author;
        this.interpreter = interpreter;
        this.songs.addAll(songs);
    }

    public CD (String name, double priceBuy, double priceSold, String description, int stock, String ref, String author, String interpreter, ArrayList<String> songs) {
        super(name, priceBuy, priceSold, description, stock, ref);
        this.author = author;
        this.interpreter = interpreter;
        this.songs.addAll(songs);
    }
}
