package org.example.lab10;

import org.example.lab10.task1.Task1;
import org.example.lab10.task1.exceptions.CannotProvideInstance;

import java.util.HashMap;
import java.util.Map;

public class MainLab10 {
    public static void main(String[] args) {
        Task1 container = new Task1();

        container.addInstance("test Instance", "key1");

        System.out.println(container.getInstance(String.class, "key1"));
    }
}