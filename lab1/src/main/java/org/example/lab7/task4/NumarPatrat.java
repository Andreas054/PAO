package org.example.lab7.task4;

public class NumarPatrat {
    private int numar;
    private int numarPatrat;

    public NumarPatrat(int numar) {
        this.numar = numar;
        this.numarPatrat = numar * numar;
    }

    @Override
    public String toString() {
        return "NumarPatrat{" +
                "numar=" + numar +
                ", numarPatrat=" + numarPatrat +
                '}';
    }
}
