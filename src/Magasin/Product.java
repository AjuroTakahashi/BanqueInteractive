package Magasin;

public class Product {

    public String name;
    public double priceBuy;
    public double priceSold;
    public int stock;
    public String description;
    public String ref;

    public Product(String name, double priceBuy, double priceSold) {
        this.name = name;
        this.priceBuy = priceBuy;
        this.priceSold = priceSold;
        this.description = "Pas de description";
        this.stock = 0;
    }

    public Product(String name, double priceBuy, double priceSold, String description, int stock, String ref) {
        this.name = name;
        this.priceBuy = priceBuy;
        this.priceSold = priceSold;
        this.description = description;
        this.stock = stock;
        this.ref = ref;
    }

    protected void getDescription() {
        System.out.println(this.description);
    }

    protected void setDescription(String description) {
        this.description = description;
    }

    protected void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", priceBuy=" + priceBuy +
                ", priceSold=" + priceSold +
                ", stock=" + stock +
                ", description='" + description + '\'' +
                ", ref='" + ref + '\'' +
                '}';
    }
}
