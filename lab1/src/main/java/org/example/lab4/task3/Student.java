package org.example.lab4.task3;

import java.util.HashMap;
import java.util.Map;

public class Student implements Cloneable {
    private String fullName;

    // Acest dicționar conține informații cu privire la notele
    // pe care un student le are la un curs. Intrările sunt de tip
    // numeCurs -> notăCurs
    private Map<String, Double> courseInformation;

    public Student(String fullName, Map<String, Double> courseInformation) {
        this.fullName = fullName;
        this.courseInformation = courseInformation;
    }

    @Override
    public Student clone() throws CloneNotSupportedException {
        Student cloneStudent = (Student) super.clone();
        cloneStudent.courseInformation = new HashMap<>(courseInformation);

        return cloneStudent;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", courseInformation=" + courseInformation +
                '}';
    }
}