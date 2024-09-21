package com.supplyboost.Exercises.StreamsFilesAndDirectories;


import java.io.*;

public class _5_LineNumbers {

    public static String path ="F:\\Documents\\SoftUni\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
    public static String pathOutput = "F:\\Documents\\SoftUni\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            StringBuffer toUpperCase = new StringBuffer();

            FileWriter fileWriter = new FileWriter(pathOutput);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            int counter = 1;
            while (line != null){
                toUpperCase.append(counter + ". "  + line + "\n");
                bufferedWriter.append(counter + ". " + line + "\n");
                line = bufferedReader.readLine();
                counter++;
            }
            System.out.println(toUpperCase);

            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }






    }
}
