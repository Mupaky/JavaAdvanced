package com.supplyboost.Lab.SetsAndDictionaries;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _3_Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayerCards = new LinkedHashSet<>();
        Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).forEach(number -> firstPlayerCards.add(number));
        Set<Integer> secondPlayerCards = new LinkedHashSet<>();
        Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).forEach(number -> secondPlayerCards.add(number));

        int rounds = 50;
        while (rounds > 0 && !firstPlayerCards.isEmpty() && !secondPlayerCards.isEmpty()){

            int firstPlayerCard = firstPlayerCards.iterator().next();
            firstPlayerCards.remove(firstPlayerCard);

            int secondPlayerCard = firstPlayerCards.iterator().next();
            secondPlayerCards.remove(secondPlayerCard);
        }

    }


}
