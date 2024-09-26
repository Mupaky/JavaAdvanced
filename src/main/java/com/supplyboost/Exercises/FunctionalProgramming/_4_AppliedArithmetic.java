package com.supplyboost.Exercises.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class _4_AppliedArithmetic {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> numbers = Arrays
                .stream(scanner.nextLine().split("\\s"))
                .map(Double::parseDouble).toList();

        Function<Double, Double> add = number -> ++number;
        Function<Double, Double> multiply = number -> number * 2;
        Function<Double, Double> subtract = number -> --number;

        String command = scanner.nextLine();
        while (!command.equals("end")){
            switch (command){
                case "add": numbers = numbers.stream().map(add).toList(); break;
                case "multiply": numbers = numbers.stream().map(multiply).toList(); break;
                case "subtract": numbers = numbers.stream().map(subtract).toList(); break;
                case "print":
                    numbers.forEach(num -> System.out.printf("%.0f ", num));
                    System.out.println();
                    break;
                default: break;
            }
            command = scanner.nextLine();
        }
    }

}
