package com.supplyboost.Lab.StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.IOException;

public class _1_ReadFile {

    public static void main(String[] args) throws IOException {


        String path = "F:\\Documents\\SoftUni\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";


        FileInputStream fileInputStream = new FileInputStream(path);


        int oneByte = fileInputStream.read();

        while (oneByte >= 0){
            System.out.print((char)(oneByte));
            oneByte = fileInputStream.read();
        }

        fileInputStream.close();
    }
}
