package com.supplyboost.Exercises.SetsAndMapsAdvanced;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _6_FixEmails {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> emailBook = new HashMap<>();

        String command = scanner.nextLine();

        while(!command.equals("stop")){

            String email = scanner.nextLine();
            if(email.equals("stop")){
                break;
            }

            int indexOfAt = email.lastIndexOf('@');
            String domain = email.substring(indexOfAt + 1); // Get domain part after '@'
            int indexOfLastDot = domain.lastIndexOf('.');
            String domainExtension = domain.substring(indexOfLastDot + 1); // Get extension after '.'

            if (!domainExtension.equalsIgnoreCase("us")
                    && !domainExtension.equalsIgnoreCase("uk")
                    && !domainExtension.equalsIgnoreCase("com")) {
                emailBook.put(command, email);
            }

            command = scanner.nextLine();
        }

        for(Map.Entry<String, String> entry : emailBook.entrySet()){
            System.out.printf("%s -> %s\n", entry.getKey(), entry.getValue());
        }

    }
}
