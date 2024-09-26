package com.supplyboost.Exercises.FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class _9_ListOfPredicates {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nNumbers = Integer.parseInt(scanner.nextLine());
        List<Integer> numbers = new ArrayList<>();
        for(int i = 1; i <= nNumbers ; i++) {
            numbers.add(i);
        }

        List<Integer> divisibleNumbers = new ArrayList<>(Arrays
                .stream(scanner.nextLine().split("\\s"))
                .map(Integer::parseInt)
                .toList());

        BiPredicate<Integer, List<Integer>> divisible = (integer, list) -> {
            for (int num : list){
                if (integer % num != 0) {
                    return false;
                }
            }
            return true;
        };

        Consumer<Integer> print = num -> System.out.printf("%d ", num);

        numbers.stream()
                .filter(number -> divisible.test(number, divisibleNumbers))
                .forEach(print);


    }
}
