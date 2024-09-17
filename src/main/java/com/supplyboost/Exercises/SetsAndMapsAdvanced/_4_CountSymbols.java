package com.supplyboost.Exercises.SetsAndMapsAdvanced;

import java.util.*;

public class _4_CountSymbols {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String token = scanner.nextLine();

        Map<Character, Integer> symbolsCounter = new TreeMap<>();

        for(int index = 0; index < token.length(); index++) {
            char symbol = token.charAt(index);
            if(!symbolsCounter.containsKey(symbol)){
                symbolsCounter.put(symbol, 1);
            }else{
                symbolsCounter.put(symbol, symbolsCounter.get(symbol) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : symbolsCounter.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue() + " time/s");
        }

    }

}
