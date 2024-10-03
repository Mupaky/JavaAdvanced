package com.supplyboost.Exercises.Generics.SwapMethodString;


import java.util.*;

public class _3_Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int lines = Integer.parseInt(scanner.nextLine());

        List<Box<String>> boxes = new ArrayList<>();
        while (lines > 0){
            Box<String> box = new Box<>();
            box.setTypeData(scanner.nextLine());
            boxes.add(box);
            lines--;
        }

        List<Integer> numbers = new ArrayList<>(Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toList());

        swapElements(boxes, numbers.get(0), numbers.get(1));

        boxes.forEach(box -> System.out.println(box.toString()));

    }

    public static  <T> void swapElements(List<T> list, int indexOne, int indexTwo){
        T obj = list.get(indexOne);
        list.set(indexOne, list.get(indexTwo));
        list.set(indexTwo, (obj));
    }

}
