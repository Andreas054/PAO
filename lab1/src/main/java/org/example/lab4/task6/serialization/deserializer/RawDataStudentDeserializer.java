package org.example.lab4.task6.serialization.deserializer;

import org.example.lab4.task6.Student;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class RawDataStudentDeserializer implements StudentDeserializer{
    @Override
    public Student deserializer(InputStream inputStream) {
        // TODO 4:  Realizati deserializarea pentru un singur student
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            try {
                Student student = (Student) objectInputStream.readObject();
//                objectInputStream.close();
                return student;
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}