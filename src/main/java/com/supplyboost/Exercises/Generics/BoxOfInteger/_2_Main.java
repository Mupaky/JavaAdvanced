package com.supplyboost.Exercises.Generics.BoxOfInteger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _2_Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int lines = Integer.parseInt(scanner.nextLine());

        List<Box> boxes = new ArrayList<>();
        while (lines > 0){
            Box<Integer> box = new Box<>();
            box.setTypeData(scanner.nextInt());
            boxes.add(box);
            lines--;
        }

        boxes.forEach(box -> System.out.println(box.toString()));



    }
}
