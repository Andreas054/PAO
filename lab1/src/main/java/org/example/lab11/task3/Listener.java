package org.example.lab11.task3;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Listener {
    private String nume;
    private Socket socket;
    private DataInputStream dataInputStream;

    public Listener(String nume, String serverAddress, int serverPort) {
        this.nume = nume;
        try {
            this.socket = new Socket(serverAddress, serverPort);
            this.dataInputStream = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void listen() {
        try {
            while (true) {
                System.out.println(dataInputStream.readUTF());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getNume() {
        return nume;
    }
}
