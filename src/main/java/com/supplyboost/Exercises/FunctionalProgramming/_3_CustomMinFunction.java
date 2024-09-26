package com.supplyboost.Exercises.FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class _3_CustomMinFunction {

    public static void main(String[] args) {

        System.out.println(Arrays
                .stream(new Scanner(System.in).nextLine().split("\\s"))
                .mapToInt(Integer::parseInt)
                .min().getAsInt());
    }
}
