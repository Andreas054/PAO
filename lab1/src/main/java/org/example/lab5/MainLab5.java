package org.example.lab5;

import org.example.lab5.task1.MyOptional;

import java.io.Serializable;
import java.util.List;

public class MainLab5 {
    public static void main(String[] args) {
//        TASK 1
        MyOptional<String> o1 = MyOptional.of(new String("asd"));
        System.out.println(o1.isPresent()); // true
        System.out.println(o1.get()); // "asd"

        MyOptional<Object> o2 = MyOptional.of(List.of("1", "2"));
        System.out.println(o2.isPresent()); // true
        System.out.println(o2.get()); // ["1", "2"]

        MyOptional<Serializable> o3 = MyOptional.of(null);
        System.out.println(o3.isPresent()); // false
//        System.out.println(o3.get()); // NoSuchElementException

//        MyOptional<Integer> o4 = MyOptional.of("3"); // eroare de compilare
    }
}
