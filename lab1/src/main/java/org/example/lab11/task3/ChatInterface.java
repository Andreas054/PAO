package org.example.lab11.task3;

public interface ChatInterface {
    void sendMesaj(Listener listener, String mesaj);
    void addListener(Listener listener);
}
