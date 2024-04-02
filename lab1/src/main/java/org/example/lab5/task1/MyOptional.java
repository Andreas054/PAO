package org.example.lab5.task1;

import java.util.NoSuchElementException;
import java.util.Optional;

public class MyOptional<T> {
    private T t;
    private MyOptional(T t) {
        this.t = t;
    }

    public static <T> MyOptional<T> of(T t) {
        return new MyOptional<T>(t);
    }

    public boolean isPresent() {
        if (this.t == null) {
            return false;
        }
        return true;
    }
    public T get() {
        if (this.t == null) {
            throw new NoSuchElementException();
        }
        return this.t;
    }
}
