package com.supplyboost.Exercises.StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class _2_SumBytes {

    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader(_1_SumLines.path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            long sumASCIILine = 0;
            while (line != null){

                for(char c : line.toCharArray()) {
                    sumASCIILine += c;
                }
                line = bufferedReader.readLine();
            }
            System.out.println(sumASCIILine);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
