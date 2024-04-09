package org.example.lab6.task1;

import java.util.Comparator;
import java.util.List;

public class Sortari {
    public static void sortNotaTotala(List<Student> students) {
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student student1, Student student2) {
                return Double.compare(student2.getNotaTotala(), student1.getNotaTotala());
            }
        });
    }

    public static void sortNotaPartial(List<Student> students) {
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student student1, Student student2) {
                return Double.compare(student2.getNotaPartial(), student1.getNotaPartial());
            }
        });
    }

    public static List<Student> sortNotaMedie(List<Student> students) {
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student student1, Student student2) {
                return Double.compare(student2.getNotaMedie(), student1.getNotaMedie());
            }
        });
        return students;
    }
}
