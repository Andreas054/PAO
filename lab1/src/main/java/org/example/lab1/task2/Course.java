package org.example.lab1.task2;

import java.util.Random;

public class Course {
    private String name;
    private double minimumGrade;
    private Student[] students;

    public Course(String name, double minimumGrade, Student[] students) {
        this.name = name;
        this.minimumGrade = minimumGrade;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMinimumGrade() {
        return minimumGrade;
    }

    public void setMinimumGrade(double minimumGrade) {
        this.minimumGrade = minimumGrade;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public Student chooseStudentRandomly() {
        Random generator = new Random();
        return students[generator.nextInt(students.length)];
    }

    public Student[] showAllPassingStudents() {
        Student[] studentsTemporar = new Student[students.length];
        int j = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i].getGrade() >= minimumGrade) {
                studentsTemporar[j] = students[i];
                j++;
            }
        }
        return studentsTemporar;
    }

    public boolean isStudentPassing(int index) {
        if (index >= students.length) {
            return false;
        }

        if (students[index].getGrade() >= minimumGrade) {
            return true;
        }
        return false;
    }
    public boolean isStudentPassing(String nameArg) {
        for (Student student : students) {
            if (student.getName().equals(nameArg) && student.getGrade() >= minimumGrade) {
                return true;
            }
        }
        return false;
    }
}
