package com.supplyboost.Exercises.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class _6_PredicateForNames {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s")).toList();
        Predicate<String> checkName = name -> name.length() <= length;
        Consumer<String> print = System.out::println;

        names.stream()
                .filter(checkName)
                .forEach(print);
    }
}
