package Magasin;

public class Book extends Product{

    public String author;
    public String editor;

    public Book (String name, double priceBuy, double priceSold, String description, int stock, String ref, String author, String editor){
        super(name, priceBuy, priceSold, description, stock, ref);
        this.author = author;
        this.editor = editor;
    }
}
