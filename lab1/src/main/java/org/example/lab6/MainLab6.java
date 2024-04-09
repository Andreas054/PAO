package org.example.lab6;

import org.example.lab6.task1.Sortari;
import org.example.lab6.task1.Student;
import org.example.lab6.task2.Chat;
import org.example.lab6.task2.Listener;
import org.example.lab6.task3.Client;
import org.example.lab6.task3.Magazin;

import java.util.ArrayList;
import java.util.List;

public class MainLab6 {
    public static void main(String[] args) {
//        TASK 1
        Student.StudentBuilder studentBuilder = new Student.StudentBuilder();

        studentBuilder.setNume("Aurel Vlaicu");
        studentBuilder.setNotaPartial(5);
        studentBuilder.setNotaLaborator(6);
        studentBuilder.setNotaExamen(7);
        Student student1 = studentBuilder.build();

        studentBuilder.setNume("Liviu Teodorescu");
        studentBuilder.setNotaPartial(4);
        studentBuilder.setNotaLaborator(10);
        studentBuilder.setNotaExamen(9);
        Student student2 = studentBuilder.build();

        studentBuilder.setNume("Mihai Bravu");
        studentBuilder.setNotaPartial(3);
        studentBuilder.setNotaLaborator(5);
        studentBuilder.setNotaExamen(6);
        Student student3 = studentBuilder.build();

        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        Sortari.sortNotaTotala(studentList);
        System.out.println("Sortare dupa cea mai mare nota totala");
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println((i + 1) + ". " + studentList.get(i).toString());
        }

        Sortari.sortNotaPartial(studentList);
        System.out.println("Sortare dupa cea mai mare nota la partial");
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println((i + 1) + ". " + studentList.get(i).toString());
        }

        Sortari.sortNotaMedie(studentList);
        System.out.println("Sortare dupa media notelor");
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println((i + 1) + ". " + studentList.get(i).toString());
        }


//        TASK 2
        Chat chat = new Chat();

        Listener listener1 = new Listener("Ion");
        Listener listener2 = new Listener("Adrian");
        Listener listener3 = new Listener("Maria");
        Listener listener4 = new Listener("Matei");

        chat.subscribe(listener1, "programare");
        chat.subscribe(listener2, "programare");
        chat.subscribe(listener3, "programare");
        chat.subscribe(listener4, "programare");

        chat.subscribe(listener2, "gatit");
        chat.subscribe(listener3, "gatit");

        chat.sendMesaj(listener1, "Salut!", "programare");
        chat.sendMesaj(listener2, "Omlet!", "gatit");


//        TASK 3
        Client client1 = new Client("Marian", 5.0);
        Client client2 = new Client("Mihai", "card", 10.0);
        Client client3 = new Client("Raluca", "transferbancar", 100.0);
        Client client4 = new Client("Eugen", "cash", 23.25);

        client1.cumparaDinMagazin(2.0);
        client2.cumparaDinMagazin(5.0);
        client1.cumparaDinMagazin(3.0);
        client3.cumparaDinMagazin(50.99);
        client2.cumparaDinMagazin(3.0);
        client4.cumparaDinMagazin(23.0);
        client3.cumparaDinMagazin(16.5);

        Magazin.deconteazaPlati();
    }
}
