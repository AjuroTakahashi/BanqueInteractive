package fr.cefim;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class Banque {
//    private ArrayList<Client> clients = new ArrayList<>();
    private Map<Integer, Client> listClient = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);
    private int id = 1;

    void ajouterClient(Client client) {
        listClient.put(id, client);
        id ++;
    }

    float bilanClient(int clientNumero) {
        AtomicReference<Float> bilan = new AtomicReference<>((float) 0);
        listClient.forEach((id, client) -> {
            if (client.getNumero() == clientNumero) {
                bilan.set(client.getSolde());
            }
        });
        return bilan.get();
    }

    void afficherBilan(int clientNumero) {
        System.out.println(bilanClient(clientNumero));
    }

    void interaction() {
        System.out.println("Quelle opération voulez-vous effectuer ?");
        System.out.println("1) Ajouter un client");
        System.out.println("2) Effectuer une operation sur un client");
        System.out.println("3) Afficher un bilan général");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                interactionAjoutClient();
                break;
            case 2:
                interactionOperationClient();
                break;
            case 3:
                interactionBilanGeneral();
                break;
            default:
                System.out.println("Numéro incorrect");
                interaction();
                break;
        }
    }

    void interactionAjoutClient() {
        System.out.println("Entrez le nom du client");
        String name = scanner.next();

        Random random = new Random();
        Client newClient = new Client(name, random.nextInt(1000));
        ajouterClient(newClient);
        System.out.println("Le client " + newClient.getNom() + " a été créé.");
        interaction();
    }

    void interactionOperationClient() {
        System.out.println("Quel client ?");

        listClient.forEach((id, client) -> {
            System.out.println(id + ") " + client.getNom());
        });
        int clientId = scanner.nextInt();

        listClient.forEach((id, client) -> {
            if (clientId == id) {
                System.out.println("Quelle opération voulez-vous effectuer sur le client" + client.getNom());
                System.out.println("1) Afficher un bilan");
                System.out.println("2) Faire un retrait");
                System.out.println("3) Faire un dépôt");
                System.out.println("4) Faire un virement");
                System.out.println("5) Créer un compte");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        afficherBilan(client.getNumero());
                        break;
                    case 2:
                        interactionArgent("retrait", client);
                        break;
                    case 3:
                        interactionArgent("depot", client);
                        break;
                    case 4:
                        interactionArgent("virement", client);
                        break;
                    case 5:
                        Random random = new Random();
                        Compte compte = new Compte(random.nextInt(1000), 100);
                        client.ajouterCompte(compte);
                        System.out.println("Numéro du nouveau compte : " + compte.getNumero());
                        interaction();
                        break;
                    default:
                        System.out.println("Numéro incorrect");
                        interaction();
                        break;
                }
            }
        });
    }


    void interactionArgent(String type, Client client) {
        System.out.println("Indiquez le montant");
        float value = scanner.nextFloat();
        System.out.println("Indiquez le numéro de compte");
        int compteNb = scanner.nextInt();
        Compte compte = client.getCompte(compteNb);

        switch(type) {
            case "retrait":
                compte.retrait(value);
                break;
            case "depot":
                compte.depot(value);
                break;
            case "virement":
                System.out.println("Indiquez le numéro du compte destinataire");
                int destinataire = scanner.nextInt();
                Compte compteDestinataire = client.getCompte(destinataire);
                compte.virer(value, compteDestinataire);
                break;
            default:
                System.out.println("Erreur");
        }
    }

    void interactionBilanGeneral() {
        AtomicReference<Float> bilanGeneral = new AtomicReference<>((float) 0);
        listClient.forEach((key, client) -> {
            bilanGeneral.updateAndGet(v -> (float) (v + client.getSolde()));
        });

        System.out.println(bilanGeneral.get());
    }

}