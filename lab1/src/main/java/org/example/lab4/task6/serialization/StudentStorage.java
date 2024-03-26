package org.example.lab4.task6.serialization;

import org.example.lab4.task6.Student;
import org.example.lab4.task6.serialization.deserializer.StudentDeserializer;
import org.example.lab4.task6.serialization.serializer.StudentSerializer;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class StudentStorage {
    private final StudentSerializer serializer;
    private final StudentDeserializer deserializer;

    public StudentStorage(StudentSerializer serializer, StudentDeserializer deserializer) {
        this.serializer = serializer;
        this.deserializer = deserializer;
    }

    public List<Student> readAllStudents(InputStream inputStream) {
        // TODO 6: Cu ajutorul deserializatorului, cititi din sursa studentii
        List<Student> students = new ArrayList<>();
        try {
            while (inputStream.available() > 0) {
                students.add(deserializer.deserializer(inputStream));
            }
            return students;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void writeAllStudents(OutputStream outputStream, List<Student> students) {
        // TODO 5: Cu ajutorul serializatorului, scrieti in sursa studentii
        for (Student student : students) {
            serializer.serialize(outputStream, student);
        }
    }
}