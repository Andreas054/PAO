package org.example.lab6.task2;

public interface ChatInterface {
    void sendMesaj(Listener listener, String mesaj, String topic);
    void subscribe(Listener listener, String topic);
}
