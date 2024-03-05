package org.example.lab1.task2;

public class StudentAllocator {
    public static Student[] createStudents() {
        return new Student[] {
                new Student("Marian", 5),
                new Student("Mihai", 4),
                new Student("Elena", 10),
                new Student("Bianca", 2)
        };
    }
}
