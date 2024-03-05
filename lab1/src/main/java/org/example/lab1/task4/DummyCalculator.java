package org.example.lab1.task4;

public class DummyCalculator {
    public boolean calcul(boolean a, boolean b, String op) {
        if (op.equals("&")) {
            return a & b;
        }
        return a | b;
    }
    public int calcul(int a, int b, String op) {
        return switch (op) {
            case "+" -> a + b;
            case "*" -> a * b;
            default -> a / b;
        };
    }
    public double calcul(int a, int b) {
        return (double) a / b;
    }

    public double calcul(double a, double b, String op) {
        return switch (op) {
            case "+" -> a + b;
            case "*" -> a * b;
            default -> a / b;
        };
    }

    public double calcul(int a, double b, String op) {
        return switch (op) {
            case "+" -> a + b;
            case "*" -> a * b;
            default -> a / b;
        };
    }

    public double calcul(double a, int b, String op) {
        return switch (op) {
            case "+" -> a + b;
            case "*" -> a * b;
            default -> a / b;
        };
    }

    public void calculate(String[] args) {
        String a = args[0];
        String op = args[1];
        String b = args[2];
//        System.out.print(a + op + b + "\t");

        if (a.equals("true") | a.equals("false")) {
            boolean aParsed = Boolean.parseBoolean(a);
            boolean bParsed = Boolean.parseBoolean(b);
            System.out.println(calcul(aParsed, bParsed, op));
        }
        else {
            try {
                int aParsed = Integer.parseInt(a);
                try {
                    int bParsed = Integer.parseInt(b);
                    //                    Int op Int
                    if (op.equals("/")) {
                        System.out.println(calcul(aParsed, bParsed));
                    }
                    else {
                        System.out.println(calcul(aParsed, bParsed, op));
                    }
                } catch (Exception e) {
                    double bParsed = Double.parseDouble(b);
                    //                    Int op Double
                    System.out.println(calcul(aParsed, bParsed, op));
                }
            } catch (Exception e) {
                double aParsed = Double.parseDouble(a);
                try {
                    int bParsed = Integer.parseInt(b);
                    //                    Double op Int
                    System.out.println(calcul(aParsed, bParsed, op));
                } catch (Exception eee) {
                    double bParsed = Double.parseDouble(b);
                    //                    Double op Double
                    System.out.println(calcul(aParsed, bParsed, op));
                }
            }

        }
    }
}
