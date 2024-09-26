package com.supplyboost.Exercises.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _7_FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> listOfNumbers = Arrays.stream(scanner.nextLine().trim().split("\\s"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        Function<List<Integer>, Integer> findSmallestNumber = numbers -> {
            int min = 0;
            for(int index = 1; index < numbers.size(); index++) {
                if(numbers.get(min) >= numbers.get(index)){
                    min = index;
                }
            }
            return min;
        };
        System.out.println(findSmallestNumber.apply(listOfNumbers));
    }
}
