package com.supplyboost.Exercises.SetsAndMapsAdvanced;

import java.util.*;

public class _7_HnadsOfCards {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, HashSet<String>> playerCards = new LinkedHashMap<>();

        String[] command = scanner.nextLine().split(": ");


        while (!command[0].equals("JOKER")){

            String playerName = command[0];
            List<String> drawnCards = Arrays.stream(command[1].split(", ")).toList();
            HashSet<String> handCards;
            if(playerCards.containsKey(playerName) && !playerCards.get(playerName).isEmpty()){
                handCards = playerCards.get(playerName);
                handCards.addAll(drawnCards);
            }else{
                handCards = new HashSet<>(drawnCards);
            }
            playerCards.put(playerName, handCards);


            command = scanner.nextLine().split(": ");
        }

        printResults(playerCards);
    }

    private static void printResults(Map<String, HashSet<String>> playerCards) {
        for (Map.Entry<String, HashSet<String>> player : playerCards.entrySet()){
            int handSum = 0;
            for (String playerCard : player.getValue()){
                handSum += giveCardValue(playerCard);
            }
            System.out.printf("%s: %d\n", player.getKey(), handSum);
        }
    }

    private static int giveCardValue(String playerCard){
        int value = 1;
        switch (playerCard.charAt(0)){
            case '1':
                if(playerCard.charAt(1) == '0'){
                    return 10 * giveMultiplierValue(playerCard.charAt(2));
                }
            case '2':
                value = 2;
                break;
            case '3':
                value = 3;
                break;
            case '4':
                value = 4;
                break;
            case '5':
                value = 5;
                break;
            case '6':
                value = 6;
                break;
            case '7':
                value = 7;
                break;
            case '8':
                value = 8;
                break;
            case '9':
                value = 9;
                break;
            case 'J':
                value = 11;
                break;
            case 'Q':
                value = 12;
                break;
            case 'K':
                value = 13;
                break;
            case 'A':
                value = 14;
                break;
        }
        return value * giveMultiplierValue(playerCard.charAt(1));
    }

    private static int giveMultiplierValue(char multiplier){
        return switch (multiplier) {
            case 'S' -> 4;
            case 'H' -> 3;
            case 'D' -> 2;
            case 'C' -> 1;
            default -> 1;
        };
    }


}
