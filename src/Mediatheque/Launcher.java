package Mediatheque;

import java.util.ArrayList;

public class Launcher {
    public static void main(String[] args) {

//        CD cd = new CD("quack", "za", "a");
//        cd.getRating();
        Mediatheque mediatheque = new Mediatheque();
        mediatheque.add(new CD("CD", "machin", "carton"));
        mediatheque.add(new DVD("DVD", "dvd", 1));
        mediatheque.add(new Book("Book", "livre"));

        System.out.println(mediatheque.filter("media", "CD"));

//        new CD("CD", "machin", "carton"));
//        new DVD("DVD", "dvd", 1));
//        new Book("Book", "livre");

    }
}
