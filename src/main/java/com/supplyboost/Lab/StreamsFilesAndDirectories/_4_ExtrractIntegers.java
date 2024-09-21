package com.supplyboost.Lab.StreamsFilesAndDirectories;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _4_ExtrractIntegers {

    public static void main(String[] args) throws FileNotFoundException {


        String path = "F:\\Documents\\SoftUni\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";


        Scanner scanner = new Scanner(new FileInputStream(path));

        while (scanner.hasNext()){
            if(scanner.hasNextInt()){
                System.out.println(scanner.nextInt());
            }
            scanner.next();
        }
    }
}
