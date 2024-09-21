package com.supplyboost.Exercises.StreamsFilesAndDirectories;

import java.io.*;
import java.util.*;

public class _6_WordCount {

    public static String pathWords ="F:\\Documents\\SoftUni\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
    public static String pathText ="F:\\Documents\\SoftUni\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";

    public static String pathOutput = "F:\\Documents\\SoftUni\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\result.txt";

    public static void main(String[] args) {
        try {
            FileReader fileReaderWord = new FileReader(pathWords);
            BufferedReader bufferedReaderWords = new BufferedReader(fileReaderWord);

            FileReader fileReaderText = new FileReader(pathText);
            BufferedReader bufferedReaderText = new BufferedReader(fileReaderText);

            String lineWords = bufferedReaderWords.readLine();
            String lineText = bufferedReaderText.readLine();

            PrintWriter printWriter = new PrintWriter(pathOutput);

            Map<String, Integer> listOfWords = new TreeMap<>(Collections.reverseOrder());
            while (lineWords != null){
                List<String> tokens = Arrays.stream(lineWords.split("\\W+")).toList();
                for(String token : tokens){
                    if(!listOfWords.containsKey(token)){
                        listOfWords.put(token, 0);
                    }
                }
                lineWords = bufferedReaderWords.readLine();
            }
            while (lineText != null){
                List<String> tokens = Arrays.stream(lineText.split("\\W+")).toList();
                for(String token : tokens){
                    if(listOfWords.containsKey(token)){
                        listOfWords.put(token, listOfWords.get(token) + 1);

                    }
                    System.out.println(token);
                }
                lineText = bufferedReaderText.readLine();
            }

            List<Map.Entry<String, Integer>> list = new ArrayList<>(listOfWords.entrySet());
            list.sort(Map.Entry.comparingByValue(Collections.reverseOrder()));

            for(Map.Entry<String, Integer> word :list){
                printWriter.printf("%s - %d\n", word.getKey(), word.getValue());
            }

            printWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
