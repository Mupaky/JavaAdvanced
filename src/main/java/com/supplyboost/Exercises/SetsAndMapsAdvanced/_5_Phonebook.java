package com.supplyboost.Exercises.SetsAndMapsAdvanced;

import java.util.*;

public class _5_Phonebook {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phoneBook = new HashMap<>();

        String command = scanner.nextLine();

        while (!command.equals("search")){
            String[] tokens = command.split("-");
            phoneBook.put(tokens[0], tokens[1]);

            command = scanner.nextLine();
        }

        while (true){
            command = scanner.nextLine();

            if(command.equals("stop")){
                return;
            }

            if(phoneBook.containsKey(command)){
                System.out.println(command + " -> " + phoneBook.get(command));
            }else{
                System.out.printf("Contact %s does not exist.\n", command);
            }

        }


    }
}
