package com.supplyboost.Exercises.StreamsFilesAndDirectories;

import java.io.*;

public class _3_AllCapitals {

    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader(_1_SumLines.path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            StringBuffer toUpperCase = new StringBuffer();

            FileWriter fileWriter = new FileWriter(_1_SumLines.pathOutput);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            while (line != null){
                toUpperCase.append(line.toUpperCase() + "\n");
                bufferedWriter.append(line.toUpperCase() + "\n");
                line = bufferedReader.readLine();

            }
            System.out.println(toUpperCase);

            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
