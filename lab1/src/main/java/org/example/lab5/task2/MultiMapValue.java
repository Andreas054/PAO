package org.example.lab5.task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MultiMapValue<K, V> {
    private HashMap<K, ArrayList<V>> hashMap;

    public MultiMapValue() {
        this.hashMap = new HashMap<K, ArrayList<V>>();
    }

    public void add(K key, V value) {
        if (this.hashMap != null) {
            if (hashMap.containsKey(key)) {
                hashMap.get(key).add(value);
            } else {
                ArrayList<V> arrayList = new ArrayList<>();
                arrayList.add(value);
                hashMap.put(key, arrayList);
            }
        }
    }

    public void addAll(K key, List<V> values) {
        if (hashMap.containsKey(key)) {
            hashMap.get(key).addAll(values);
        } else {
            ArrayList<V> arrayList = new ArrayList<>(values);
            hashMap.put(key, arrayList);
        }
    }

    public void addAll(MultiMapValue<K, V> map) {
        for (K it : hashMap.keySet()) {
            this.addAll(it, hashMap.get(it));
        }
    }

    public V getFirst(K key) {
        if (this.hashMap != null && hashMap.containsKey(key) && !hashMap.get(key).isEmpty()) {
            return hashMap.get(key).get(0);
        }
        return null;
    }

    public List<V> getValues(K key) {
        if (this.hashMap != null && hashMap.containsKey(key)) {
            return hashMap.get(key);
        }
        return new ArrayList<>();
    }

    public boolean containsKey(K key) {
        if (this.hashMap != null) {
            return hashMap.containsKey(key);
        }
        return false;
    }

    public boolean isEmpty() {
        if (this.hashMap != null) {
            return hashMap.isEmpty();
        }
        return true;
    }

    public List<V> remove(K key) {
        if (hashMap.containsKey(key)) {
            ArrayList<V> arrayList = hashMap.get(key);
            hashMap.remove(key);
            return arrayList;
        }
        return new ArrayList<>();
    }

    public int size() {
        if (this.hashMap != null) {
            return hashMap.size();
        }
        return 0;
    }

}
