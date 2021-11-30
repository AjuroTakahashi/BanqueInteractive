package fr.cefim;

import java.util.ArrayList;

public class Banque {
    private ArrayList<Client> clients = new ArrayList<>();

    void ajouterClient(Client client) {
        clients.add(client);
    }

}