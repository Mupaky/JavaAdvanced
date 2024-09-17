package com.supplyboost.Exercises.SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _1_UniqueUsernames {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> usernames = new LinkedHashSet<>();

        int counter = Integer.parseInt(scanner.nextLine());

        while (counter > 0) {
            usernames.add(scanner.nextLine());
            counter--;
        }
        printUserNames(usernames);
    }

    public static void printUserNames(Set<String> usernames){
        for(String username : usernames){
            System.out.println(username);
        }
    }
}
