package com.supplyboost.Exercises.StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class _7_MergeTwoFiles {

    public static String pathWords ="F:\\Documents\\SoftUni\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
    public static String pathText ="F:\\Documents\\SoftUni\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";

    public static String pathOutput = "F:\\Documents\\SoftUni\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";



    public static void main(String[] args) {

        try {
            FileReader fileReaderOne = new FileReader(pathWords);
            BufferedReader bufferedReaderOne = new BufferedReader(fileReaderOne);

            FileReader fileReaderTwo = new FileReader(pathText);
            BufferedReader bufferedReaderTwo = new BufferedReader(fileReaderTwo);

            String lineFileOne = bufferedReaderOne.readLine();
            String lineFileTwo = bufferedReaderTwo.readLine();

            PrintWriter printWriter = new PrintWriter(pathOutput);

            while (lineFileOne != null){
                printWriter.println(lineFileOne);
                lineFileOne = bufferedReaderOne.readLine();
            }
            while (lineFileTwo != null){
                printWriter.println(lineFileTwo);
                lineFileTwo = bufferedReaderTwo.readLine();
            }
            printWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
