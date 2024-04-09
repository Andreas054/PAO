package org.example.lab6.task1;

public class Student {
    private String nume;
    private double notaLaborator;
    private double notaPartial;
    private double notaExamen;

    private Student() { }

    @Override
    public String toString() {
        return nume + " " + notaLaborator + " " + notaPartial + " " + notaExamen;
    }

    public String getNume() {
        return nume;
    }

    public double getNotaLaborator() {
        return notaLaborator;
    }

    public double getNotaPartial() {
        return notaPartial;
    }

    public double getNotaExamen() {
        return notaExamen;
    }

    public double getNotaTotala() {
        return notaLaborator + notaPartial + notaExamen;
    }

    public double getNotaMedie() {
        return getNotaTotala() / 3;
    }

    public static class StudentBuilder {
        private String nume;
        private double notaLaborator;
        private double notaPartial;
        private double notaExamen;

        public void setNume(String nume) {
            this.nume = nume;
        }

        public void setNotaLaborator(double notaLaborator) {
            this.notaLaborator = notaLaborator;
        }

        public void setNotaPartial(double notaPartial) {
            this.notaPartial = notaPartial;
        }

        public void setNotaExamen(double notaExamen) {
            this.notaExamen = notaExamen;
        }

        public Student build() {
            Student student = new Student();
            student.nume = nume;
            student.notaLaborator = notaLaborator;
            student.notaPartial = notaPartial;
            student.notaExamen = notaExamen;
            return student;
        }
    }
}
