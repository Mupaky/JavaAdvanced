package com.supplyboost.Exercises.FunctionalProgramming;

import java.util.*;
import java.util.function.BiPredicate;

public class _10_PredicateParty {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> peopleComing = new ArrayList<>(Arrays
                                    .stream(scanner.nextLine().split("\\s"))
                                    .toList());

        Map<String, BiPredicate<String, String>> operations = new HashMap<>();
        operations.put("StartsWith", String::startsWith);
        operations.put("EndsWith", String::endsWith);
        operations.put("Length", (word, length) -> word.length() == Integer.parseInt(length));


        String command = scanner.nextLine();
        while (!command.equals("Party!")){
            List<String> commands = new ArrayList<>(Arrays.stream(command.split("\\s")).toList());
            if(commands.get(1).equals("Length") && Integer.parseInt(commands.get(2)) < 0){
                continue;
            }
            switch (commands.getFirst()){
                case "Remove":
                    peopleComing.removeIf(word -> operations.get(commands.get(1)).test(word, commands.get(2)));
                    break;
                case "Double":
                    List<String> doubled = new ArrayList<>(peopleComing.stream()
                            .takeWhile(word -> operations.get(commands.get(1)).test(word, commands.get(2)))
                            .toList());
                    peopleComing.addAll(doubled);
                    break;
                default:
                    break;
            }

            command = scanner.nextLine();
        }

        //For the sake of the submission in SoftUni
        Collections.sort(peopleComing);

        if(peopleComing.isEmpty()){
            System.out.println("Nobody is going to the party!");
        }else{
            String peopleList = peopleComing.toString().substring(1, peopleComing.toString().length()-1);
            System.out.printf("%s are going to the party!", peopleList);
        }
    }
}
