package org.example.lab4.task6.serialization.serializer;

import org.example.lab4.task6.Student;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class RawDataStudentSerializer implements StudentSerializer {
    @Override
    public void serialize(OutputStream outputStream, Student student) {
        // TODO 3:  Realizati serializarea pentru un singur student
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(student);
//            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}