package Magasin;

public class Launcher {
    public static void main(String[] args) {

        Store store = new Store();
        Product p = new Product("pomme", 1, 2, "desc", 10, "123");
        Product p2 = new Product("pomme", 1, 2, "desc truc chose", 10, "122");

        store.addProduct(p);
        store.addProduct(p2);
        store.buy("123", 10);
        store.sell("123", 21);
//        store.products.forEach((i, product) -> System.out.println(product.stock));
//        System.out.println(store.searchDescription("desc"));

        store.interactionProduct();
    }
}
