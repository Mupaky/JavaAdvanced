package com.supplyboost.Exercises.DefiningClasses.OpinionPoll;

import java.util.*;

public class _1_Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxReadLines = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();

        while (maxReadLines > 0){
            String[] personInfo = scanner.nextLine().split("\\s");
            people.add(new Person(personInfo[0], Integer.parseInt(personInfo[1])));
            maxReadLines--;
        }

        people.stream()
                .filter(person -> person.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(person -> System.out.printf("%s - %d\n", person.getName(), person.getAge()));
    }
}
