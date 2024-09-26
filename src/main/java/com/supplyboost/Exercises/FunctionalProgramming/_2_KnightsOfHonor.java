package com.supplyboost.Exercises.FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class _2_KnightsOfHonor {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Arrays.stream(scanner.nextLine().split("\\s"))
                .forEach(name -> System.out.printf("Sir %s\n", name));
    }
}
