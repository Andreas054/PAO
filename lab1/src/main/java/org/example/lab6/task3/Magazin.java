package org.example.lab6.task3;

import java.util.*;

public class Magazin {
    private static Map<Client, List<TipPlataAbstract>> clientiSumePlatite = new LinkedHashMap<>();

    public static void cumpara(Client client, TipPlataAbstract tipPlataAbstract) {
        if (!clientiSumePlatite.containsKey(client)) {
            clientiSumePlatite.put(client, new LinkedList<>());
        }
        clientiSumePlatite.get(client).add(tipPlataAbstract);
    }

    public static void deconteazaPlati() {
        for (Map.Entry<Client, List<TipPlataAbstract>> entry : clientiSumePlatite.entrySet()) {
            Client client = entry.getKey();
            List<TipPlataAbstract> sumaDePlata = entry.getValue();

            for (TipPlataAbstract tipPlataAbstract : sumaDePlata) {
                client.scadeSumaPlatita(tipPlataAbstract.getSuma());
            }
        }
    }
}
