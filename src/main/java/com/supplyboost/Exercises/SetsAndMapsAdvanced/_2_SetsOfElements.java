package com.supplyboost.Exercises.SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _2_SetsOfElements {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> firstSet = new LinkedHashSet<>();
        Set<String> secondSet = new LinkedHashSet<>();
        Set<String> repeatingElements = new LinkedHashSet<>();

        String[] tokens = scanner.nextLine().split("\\s");
        int firstCounter = Integer.parseInt(tokens[0]);
        int secondCounter = Integer.parseInt(tokens[1]);


        while (firstCounter > 0) {
            firstSet.add(scanner.nextLine());
            firstCounter--;
        }

        while (secondCounter > 0) {
            secondSet.add(scanner.nextLine());
            secondCounter--;
        }
        checkForRepeating(firstSet, secondSet, repeatingElements);
        printElements(repeatingElements);
    }

    private static void checkForRepeating(Set<String> firstSet,
                                          Set<String> secondSet,
                                          Set<String> repeatingElements) {
        for (String element : firstSet){
            if(secondSet.contains(element)){
                repeatingElements.add(element);
            }
        }
    }

    private static void printElements(Set<String> repeatingElements){
        for (String element : repeatingElements){
            System.out.printf("%s ", element);
        }
    }
}
