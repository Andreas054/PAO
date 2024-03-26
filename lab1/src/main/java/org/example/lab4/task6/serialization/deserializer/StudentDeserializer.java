package org.example.lab4.task6.serialization.deserializer;

import org.example.lab4.task6.Student;

import java.io.InputStream;

public interface StudentDeserializer {
    Student deserializer(InputStream inputStream);
}