package org.example.lab4.task6.utils;

import java.io.*;

public final class FileUtils {


    public static OutputStream openFileForWriting(String path) throws IOException {
        // TODO 1: Deschideti fisierul pentru scriere
        return new FileOutputStream(path);
    }

    public static InputStream openFileForReading(String path) throws FileNotFoundException {
        // TODO 2: Deschideti fisierul pentru citire
        return new FileInputStream(path);
    }
}