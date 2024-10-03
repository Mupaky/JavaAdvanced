package com.supplyboost.Exercises.Generics.CustomList;

import java.util.Scanner;

public class _7_Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        CustomList<String> list = new CustomList<>();

        String[] commands = scanner.nextLine().split("\\s+");

        while (!commands[0].equals("END")){
            switch (commands[0]){
                case "Add":
                    list.add(commands[1]);
                    break;
                case "Remove":
                    list.remove(Integer.parseInt(commands[1]));
                    break;
                case "Contains":
                    System.out.println(list.contains(commands[1]));
                    break;
                case "Swap":
                    list.swap(Integer.parseInt(commands[1]), Integer.parseInt(commands[2]));
                    break;
                case "Greater":
                    System.out.println(list.count(commands[1]));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    for(int index = 0; index < list.size(); index++){
                        System.out.println(list.get(index));
                    }
                    break;
                default:
                    break;
            }
            commands = scanner.nextLine().split("\\s+");;
        }


    }
}
