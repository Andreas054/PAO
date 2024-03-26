package org.example.lab4.task6.serialization.serializer;

import org.example.lab4.task6.Student;

import java.io.OutputStream;

public interface StudentSerializer {
    void serialize(OutputStream outputStream, Student student);
}