package org.example.lab11;

import org.example.lab11.task2.Task2;
import org.example.lab11.task3.Chat;
import org.example.lab11.task3.Listener;

public class MainLab11 {
    public static void main(String[] args) {
//        Task2.Task2();

//        TASK 3
        String serverAddress = "127.0.0.1";
        int serverPort = 8080;
        Chat chat = new Chat(8080);


        Listener listener1 = new Listener("Ion", serverAddress, serverPort);
        Listener listener2 = new Listener("Adrian", serverAddress, serverPort);
        Listener listener3 = new Listener("Maria", serverAddress, serverPort);
        Listener listener4 = new Listener("Matei", serverAddress, serverPort);

        chat.addListener(listener1);
        chat.addListener(listener2);
        chat.addListener(listener3);
        chat.addListener(listener4);

        new Thread(listener1::listen).start();
        new Thread(listener2::listen).start();
        new Thread(listener3::listen).start();
        new Thread(listener4::listen).start();

        chat.sendMesaj(listener1, "Salut!");
        chat.sendMesaj(listener2, "Omlet!");
    }
}
