package org.example.lab2.task6;

public class Romb extends Paralelogram {
    public double diag1, diag2;
    public Romb(int latura1, int latura2, double unghi1, double unghi2, double diag1, double diag2) {
        super(latura1, latura2, unghi1, unghi2);
        this.diag1 = diag1;
        this.diag2 = diag2;
    }

    @Override
    public double arie() {
        return diag1 * diag2 / 2;
    }
}
