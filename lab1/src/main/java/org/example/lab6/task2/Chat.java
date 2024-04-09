package org.example.lab6.task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Chat implements ChatInterface {
    private Map<String, List<Listener>> topicSubscribersMap = new HashMap<>();

    @Override
    public void sendMesaj(Listener listenerSender, String mesaj, String topic) {
        for (Listener listener : topicSubscribersMap.get(topic)) {
            if (listener != listenerSender) {
                System.out.println("[" + listener.getNume() + "] " + listenerSender.getNume() + " @ " + topic + ": " + mesaj);
            }
        }
    }

    @Override
    public void subscribe(Listener listener, String topic) {
        if (topicSubscribersMap.get(topic) == null) {
            topicSubscribersMap.put(topic, new ArrayList<>());
        }
        topicSubscribersMap.get(topic).add(listener);
    }
}
