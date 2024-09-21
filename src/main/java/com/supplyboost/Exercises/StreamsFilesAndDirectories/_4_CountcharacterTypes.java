package com.supplyboost.Exercises.StreamsFilesAndDirectories;

import java.io.*;

public class _4_CountcharacterTypes {

    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader(_1_SumLines.path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            int vowels = 0;
            int otherSymbols = 0;
            int punctuation = 0;

            PrintWriter printWriter = new PrintWriter(_1_SumLines.pathOutput);

            while (line != null){

                for(char c : line.toCharArray()){
                    switch (c) {
                        case 'a', 'e', 'i', 'o', 'u' -> vowels++;
                        case '!', ',', '.', '?' -> punctuation++;
                        default -> {
                            if (c != ' ') {
                                otherSymbols++;
                            }
                        }
                    }
                }

                line = bufferedReader.readLine();
            }
            System.out.println(vowels + " " + otherSymbols + " " + punctuation);
            printWriter.printf("Vowels: %d\n", vowels);
            printWriter.printf("Other symbols: %d\n", otherSymbols);
            printWriter.printf("Punctuation: %d", punctuation);
            printWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
