package com.supplyboost.Exercises.FunctionalProgramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class _8_CustomComparator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Comparator<Integer> sortEvenToOdd = (num1, num2) -> {
            if(num1 % 2 == 0 && num2 % 2 != 0){
                return -1;
            }else if(num1 % 2 != 0 && num2 % 2 == 0){
                return 1;
            }
            return num1.compareTo(num2);
        };
        Consumer<Integer> print = num -> System.out.printf("%d ", num);

        List<Integer> listOfNumbers = new java.util.ArrayList<>(Arrays.stream(scanner.nextLine().trim().split("\\s"))
                .map(Integer::parseInt)
                .toList());

        listOfNumbers.sort(sortEvenToOdd);
        listOfNumbers.forEach(print);
    }
}
