package com.supplyboost.Exercises.FunctionalProgramming;

import java.util.*;
import java.util.function.Function;

public class Demo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //First Task
//      Predicate<String> isUppercase = (word -> Character.isUpperCase(word.charAt(0)));
//
//      List<String> listOfWords = Arrays.stream(scanner.nextLine().split("\\s")).toList();
//
//      List<String> results = new ArrayList<>();
//      for(String word : listOfWords){
//          if (isUppercase.test(word)){
//            results.add(word);
//          }
//      }

        //Second Task

        Arrays.stream(scanner.nextLine().split(", "))
                .mapToDouble(Double::parseDouble)
                .forEach(number -> System.out.printf("%.2f\n", number + number * 0.2));

//        List<Double> listNumbers = new ArrayList<>(Arrays.stream(scanner.nextLine().split(", "))
//                .mapToDouble()
//                .toList());
//
//        Function<Double,Double> addVAT = (number -> number + number * 0.2);
//        for(int index = 0; index < listNumbers.size(); index++){
//            listNumbers.add(index, addVAT.apply(listNumbers.get(index)));
//            listNumbers.remove(index + 1);
//    }
//        for(Double vatNumber : listNumbers){
//            System.out.printf("%.2f\n", vatNumber);
//        }
    }
}
