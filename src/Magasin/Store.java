package Magasin;

import com.sun.istack.internal.Nullable;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Store {

    public Map<Integer, Product> products = new HashMap<>();
    public Scanner scanner = new Scanner(System.in);
    private int id = 1;

    protected void addProduct(Product product) {
        if (products.containsValue(product)) {
            System.out.println("Ce produit est déjà dans le magasin");
        } else {
            products.put(id, product);
            this.id ++;
        }
    }

    protected void buy(String ref, int number) {
        products.forEach((i, p) -> {
            if (Objects.equals(p.ref, ref)) {
                p.setStock(p.stock + number);
                System.out.println("Produit acheté, stock : " + p.stock);
            }
        });
    }

    protected @Nullable ArrayList<Product> search(String name) {

        AtomicBoolean found = new AtomicBoolean(false);
        ArrayList<Integer> keys = new ArrayList<>();

        products.forEach((i, p) -> {
            if (Objects.equals(p.name, name)) {
                found.set(true);
                keys.add(i);
            }
        });

        if (found.get()) {
            ArrayList<Product> productList = new ArrayList<>();
            keys.forEach((key) -> {
                productList.add(this.products.get(key));
            });
            return productList;
        } else {
            return null;
        }
    }

    protected @Nullable ArrayList<Product> searchDescription(String word) {

        AtomicBoolean found = new AtomicBoolean(false);
        ArrayList<Integer> keys = new ArrayList<>();

        products.forEach((i, p) -> {
            if (p.description.contains(word)) {
                found.set(true);
                keys.add(i);
            }
        });

        if (found.get()) {
            ArrayList<Product> productList = new ArrayList<>();
            keys.forEach((key) -> {
                productList.add(this.products.get(key));
            });
            return productList;
        } else {
            return null;
        }
    }

    protected void sell(String ref, int number) {
        products.forEach((i, p) -> {
            if (Objects.equals(p.ref, ref)) {
                if (p.stock >= number) {
                    p.setStock(p.stock - number);
                    System.out.println("Produit vendu, stock : " + p.stock);
                } else {
                    System.out.println("Pas assez de stock, stock : " + p.stock);
                }
            }
        });
    }

    protected void interaction() {
        System.out.println("1) Ajouter un produit");
        System.out.println("2) Voir un produit");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                interactionAddProduct();
                break;
            case 2:
                interactionProduct();
                break;
            default:
                System.out.println("Numéro incorrect");
                interaction();
                break;
        }
    }

    protected void interactionProduct() {
        scanner.useDelimiter("\\n");
        System.out.println("Quel produit ?");

        products.forEach((id, product) -> {
            System.out.println(id + ") " + product.name);
        });
        int productId = scanner.nextInt();

        products.forEach((id, product) -> {
            if (productId == id) {
                System.out.println("Quelle opération voulez-vous effectuer sur le produit" + product.name);
                System.out.println("1) Acheter");
                System.out.println("2) Vendre");
                System.out.println("3) Voir la description");
                System.out.println("4) Editer la description");
                System.out.println("5) Bilan général");
                System.out.println("6) Retour");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Quel nombre ?");
                        int buying = scanner.nextInt();
                        buy(product.ref, buying);
                        interactionProduct();
                        break;
                    case 2:
                        System.out.println("Quel nombre ?");
                        int selling = scanner.nextInt();
                        sell(product.ref, selling);
                        interactionProduct();
                        break;
                    case 3:
                        System.out.println("Description : " + product.description);
                        interactionProduct();
                        break;
                    case 4:
                        System.out.println("Nouvelle description : ");
                        String description = "";
                        description += scanner.next();
                        product.description = description;
                        interactionProduct();
                        break;
                    case 5:
                        System.out.println(product);
                        interactionProduct();
                        break;
                    case 6:
                        interactionProduct();
                        break;
                    default:
                        System.out.println("Numéro incorrect");
                        interaction();
                        break;
                }
            }
        });
    }

    protected void interactionAddProduct() {
        scanner.useDelimiter("\\n");

        System.out.println("Quel type de produit ?");
        System.out.println("1) CD");
        System.out.println("2) Livre");
        System.out.println("3) Produit standard");
        System.out.println("4) Retour");

        int choice = scanner.nextInt();

        if (choice == 4) {
            interaction();
            return;
        }

        System.out.println("Nom");
        String name = scanner.next();

        System.out.println("Prix d'achat");
        double priceBuy = scanner.nextDouble();

        System.out.println("Prix de vente");
        double priceSold = scanner.nextDouble();

        System.out.println("Description");
        String description = "";
        description += scanner.next();

        System.out.println("Stock");
        int stock = scanner.nextInt();

        System.out.println("Référence");
        String ref = scanner.next();


        switch (choice) {
            case 1:
                System.out.println("Auteur");
                String authorCD = scanner.next();

                System.out.println("Interpréteur");
                String interpretor = scanner.next();

                String input = "";
                ArrayList<String> songs = new ArrayList<>();

                while(!(input = scanner.nextLine()).equals(".STOP")) {
                    System.out.println("Nom du titre : ");
                    songs.add(input);
                }

                CD cd = new CD(name, priceBuy, priceSold, description, stock, ref, authorCD, interpretor, songs);
                addProduct(cd);
                System.out.println("CD " + cd.name + " ajouté.");
                interactionAddProduct();
                break;
            case 2:
                System.out.println("Auteur");
                String author = scanner.next();

                System.out.println("Editeur");
                String editor = scanner.next();

                Book book = new Book(name, priceBuy, priceSold, description, stock, ref, author, editor);
                addProduct(book);
                System.out.println("Livre " + book.name + " ajouté.");
                interactionAddProduct();
                break;
            case 3:
                Product product = new Product(name, priceBuy, priceSold, description, stock, ref);
                addProduct(product);
                System.out.println("Produit " + product.name + " ajouté.");
                interactionAddProduct();
                break;
            default:
                System.out.println("Numéro incorrect");
                interactionAddProduct();
                break;
        }

    }
}
