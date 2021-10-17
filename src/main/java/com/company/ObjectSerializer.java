package com.company;

import java.io.*;

public class ObjectSerializer implements AutoCloseable {
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    File file;

    ObjectSerializer(File file) throws Exception {
        if(!file.isFile()) {
            throw new Exception("Current file path must be a file!");
        }
        this.file = file;
    }

    public void save(Object object) throws Exception {
        if(outputStream == null){
            outputStream = new ObjectOutputStream(new FileOutputStream(file));
        }

        outputStream.writeObject(object);
    }

    public Object load() throws Exception {
        if(inputStream == null){
            inputStream = new ObjectInputStream(new FileInputStream(file));
        }

        return inputStream.readObject();
    }

    @Override
    public void close() throws Exception {
        if(outputStream != null){
            outputStream.close();
            outputStream = null;
        }

        if(inputStream != null){
            inputStream.close();
            inputStream = null;
        }
    }
}
