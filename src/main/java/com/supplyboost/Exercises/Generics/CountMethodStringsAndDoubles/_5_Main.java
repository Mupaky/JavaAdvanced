package com.supplyboost.Exercises.Generics.CountMethodStringsAndDoubles;

import java.util.*;

public class _5_Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int lines = Integer.parseInt(scanner.nextLine());


        //Comparing Strings and counting them
//        List<Box<String>> boxes = new ArrayList<>();
//        while (lines > 0){
//            Box<String> box = new Box<>(scanner.nextLine());
//            boxes.add(box);
//            lines--;
//        }
//        Box<String> box = new Box<>(scanner.nextLine());
//
//        count(boxes, box);

        //Comparing Doubles and counting them
        List<Box<Double>> boxesDouble = new ArrayList<>();
        while (lines > 0){
            Box<Double> boxDouble = new Box<>(Double.parseDouble(scanner.nextLine()));
            boxesDouble.add(boxDouble);
            lines--;
        }
        Box<Double> boxDouble = new Box<>(Double.parseDouble(scanner.nextLine()));

        count(boxesDouble, boxDouble);
    }

    public static <T extends Comparable<T>> void count(List<Box<T>> list, Box<T> comparing){
        int count = 0;
        for(int index = 0; index < list.size(); index++){
            if(comparing.compareTo(list.get(index)) < 0){
                count++;
            }
        }
        System.out.println(count);
    }
}
