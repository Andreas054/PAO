package org.example.lab6.task3;

public class Client {
    private String nume;
    private String metodaPlataPreferata;
    private TipPlataAbstract tipPlataAbstract;
    private Double sumaDisponibila;

    public Client(String nume, Double sumaDisponibila) {
        this.nume = nume;
        this.sumaDisponibila = sumaDisponibila;
    }

    public Client(String nume, String metodaPlataPreferata, Double sumaDisponibila) {
        this.nume = nume;
        this.metodaPlataPreferata = metodaPlataPreferata;
        this.sumaDisponibila = sumaDisponibila;
    }

    public void cumparaDinMagazin(double sumaDePlata) {
        if (metodaPlataPreferata == "cash") {
            tipPlataAbstract = new TipPlataCash(sumaDePlata);
        } else if (metodaPlataPreferata == "transferbancar") {
            tipPlataAbstract = new TipPlataTransferBancar(sumaDePlata);
        } else if (metodaPlataPreferata == "card") {
            tipPlataAbstract = new TipPlataCard(sumaDePlata);
        } else {
            tipPlataAbstract = new TipPlataCash(sumaDePlata);
        }
        Magazin.cumpara(this, tipPlataAbstract);
    }

    public void scadeSumaPlatita(double sumaPlatita) {
        sumaDisponibila -= sumaPlatita;
        System.out.println("# " + nume + " - a fost facuta o plata de " + sumaPlatita
                + " RON. Suma disponibila ramasa: " + sumaDisponibila + " RON. "
                + tipPlataAbstract);
    }
}
