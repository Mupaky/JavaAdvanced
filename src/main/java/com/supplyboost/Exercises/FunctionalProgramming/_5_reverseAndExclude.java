package com.supplyboost.Exercises.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class _5_reverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s"))
                .map(Integer::parseInt)
                .toList().reversed();

        int divisible = Integer.parseInt(scanner.nextLine());

        Predicate<Integer> isDivisible = number -> number % divisible != 0;
        Consumer<Integer> print = number -> System.out.printf("%d ", number);

        numbers.stream()
                .filter(isDivisible)
                .toList()
                .forEach(print);
    }


}
interface MyRredicate<T,R>{
    boolean check(T a, R b);
}