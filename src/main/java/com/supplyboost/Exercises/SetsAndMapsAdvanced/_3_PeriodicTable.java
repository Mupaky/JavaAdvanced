package com.supplyboost.Exercises.SetsAndMapsAdvanced;

import java.util.*;

public class _3_PeriodicTable {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> compounds = new TreeSet<>();

        int counter = Integer.parseInt(scanner.nextLine());
        List<String> compoundLines = new ArrayList<>();
        while (counter > 0){
            compoundLines.add(scanner.nextLine());
            counter--;
        }
        for(String element : compoundLines){
            compounds.addAll(Arrays.stream(element.split("\\s")).toList());
        }

        for(String element : compounds){
            System.out.printf("%s ", element);
        }
    }
}
