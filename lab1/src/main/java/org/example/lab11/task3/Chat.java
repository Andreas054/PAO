package org.example.lab11.task3;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Chat implements ChatInterface {
    private List<Listener> listenerList;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private DataOutputStream dataOutputStream;

    public Chat(int port) {
        try {
            this.listenerList = new LinkedList<>();
            this.serverSocket = new ServerSocket(port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendMesaj(Listener listenerSender, String mesaj) {
        for (Listener listener : listenerList) {
            if (listener != listenerSender) {
                try {
                    clientSocket = serverSocket.accept();
                    dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
                    dataOutputStream.writeUTF("[" + listener.getNume() + "] " + listenerSender.getNume() + ": " + mesaj);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public void addListener(Listener listener) {
        listenerList.add(listener);
    }
}
