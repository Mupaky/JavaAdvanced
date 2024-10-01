package com.supplyboost.Exercises.DefiningClasses.Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _7_Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> people = new HashMap<>();


        String[] line = scanner.nextLine().split("\\s+");


        while (!line[0].equals("End")) {

            // Skip empty lines or lines with insufficient data
            if (line.length < 2) {
                line = scanner.nextLine().split("\\s+");
                continue;
            }
            String personName = line[0];

            if (!people.containsKey(personName)) {
                people.put(personName, new Person(personName));
            }
            people.get(personName).addInfo(line);

            line = scanner.nextLine().split("\\s");
        }

        String name = scanner.nextLine();

        if (people.containsKey(name)) {
            System.out.println(people.get(name).toString());
        }
    }
}
